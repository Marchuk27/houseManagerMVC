package ru.house.manager.controller;

import java.io.UnsupportedEncodingException;
import java.sql.SQLException;

import ru.house.manager.EntityDB.Users;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


import ru.house.manager.serviceDB.UsersService;

@Controller
public class PageController {



    @RequestMapping(value="/", method=RequestMethod.GET)
    public String getLoginPage(Model model) {
        return "loginForm";
    }

    @RequestMapping(value = "/user-registration", method=RequestMethod.GET)
    public String getNewUserPage() {
        return "userRegistraionForm";
    }

    @RequestMapping(value="/user-registration", method=RequestMethod.POST)
    public String postNewUserPage(@RequestParam(value="firstName") String firstName, @RequestParam(value="lastName") String lastName, @RequestParam(value="fatherName") String fatherName, @RequestParam(value="phoneNumb") String phoneNumber, @RequestParam(value="eMail") String eMail, @RequestParam(value="roomNumb") String roomNumber) throws UnsupportedEncodingException, SQLException {

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
        } catch (SQLException e ) {
            e.printStackTrace();
        }
        return "redirect:/";
    }

}