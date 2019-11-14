package ru.house.manager.controller;

import java.io.UnsupportedEncodingException;
import java.sql.SQLException;

import ru.house.manager.EntityDB.Users;
import ru.house.manager.EntityDB.Accounts;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import ru.house.manager.serviceDB.AccountsService;
import ru.house.manager.serviceDB.UsersService;
import ru.house.manager.Hash.*;

@Controller
public class PageController {

    @RequestMapping(value="/", method=RequestMethod.GET)
    public String getLoginPage(Model model) {
        return "loginForm";
    }

    @RequestMapping(value="/", method = RequestMethod.POST)
    public String postLoginPage(@RequestParam(value="eMail") String eMail, @RequestParam(value="password") String password) throws UnsupportedEncodingException, SQLException {

        AccountsService accountsService = new AccountsService();
        Accounts account = new Accounts();
        try {
            account = accountsService.getByEmail(new String(eMail.getBytes("ISO-8859-1"), "UTF-8"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (HashFunction.getHash(new String(password.getBytes("ISO-8859-1"), "UTF-8"), account.getSalt(), HashFunction.getSalt2()).equals(account.getHashPassword())) {
            return "userMainForm";
        } else {
            return "loginForm";
        }
    }

    @RequestMapping(value = "/user-registration", method=RequestMethod.GET)
    public String getNewUserPage() {
        return "userRegistrationForm";
    }

    @RequestMapping(value="/user-registration", method=RequestMethod.POST)
    public String postNewUserPage(@RequestParam(value="firstName") String firstName, @RequestParam(value="lastName") String lastName, @RequestParam(value="fatherName") String fatherName,
                                  @RequestParam(value="phoneNumb") String phoneNumber, @RequestParam(value="eMail") String eMail, @RequestParam(value="roomNumb") String roomNumber,
                                  @RequestParam(value="login") String login, @RequestParam(value="password") String password,
                                  @RequestParam(value="password2") String password2 ) throws UnsupportedEncodingException, SQLException {

        if (!password.equals(password2)) {
            return "passwordNotEquals";
        } else {
            UsersService usersService = new UsersService();
            Users user = new Users();
            user.setFirstName(new String(firstName.getBytes("ISO-8859-1"), "UTF-8"));
            user.setLastName(new String(lastName.getBytes("ISO-8859-1"), "UTF-8"));
            user.setFatherName(new String(fatherName.getBytes("ISO-8859-1"), "UTF-8"));
            user.setPhoneNumber(new String(phoneNumber.getBytes("ISO-8859-1"), "UTF-8"));
            user.seteMail(new String(eMail.getBytes("ISO-8859-1"), "UTF-8"));
            user.setRoomNumber(new String(roomNumber.getBytes("ISO-8859-1"), "UTF-8"));

            try {
                usersService.add(user);
                UsersService idService = new UsersService();
                int newId = idService.getLastId();
                if (newId == -1) {
                    return "sqlDoesntCompilePage";
                } else {
                    String salt1 = HashFunction.getSalt1();
                    AccountsService accountsService = new AccountsService();
                    Accounts account = new Accounts();
                    account.setId(newId);
                    account.seteMail(new String(login.getBytes("ISO-8859-1"), "UTF-8"));
                    account.setHashPassword(HashFunction.getHash(new String(password.getBytes("ISO-8859-1"), "UTF-8"), salt1, HashFunction.getSalt2()));
                    account.setResidentFlag(1);
                    account.setSalt(salt1);
                    accountsService.add(account);
                }

            } catch (SQLException e) {
                e.printStackTrace();
            }
            return "redirect:/";
        }
    }

}