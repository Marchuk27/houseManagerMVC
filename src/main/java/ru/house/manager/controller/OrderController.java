package ru.house.manager.controller;

import java.io.UnsupportedEncodingException;
import java.sql.SQLException;
import java.util.List;

import EntityDB.Users;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import ru.house.manager.domain.Order;
import ru.house.manager.service.OrderService;
import ru.house.manager.service.OrderServiceImpl;
import serviceDB.UsersService;

@Controller
public class OrderController {

    private OrderService orderService = new OrderServiceImpl();

    @RequestMapping(value="/", method=RequestMethod.GET)
    public String getOrderPage(Model model) {
        List<Order> orders = orderService.getAll();
        model.addAttribute("orderList", orders);
        return "loginForm";
    }

    @RequestMapping(value = "/user-registration", method=RequestMethod.GET)
    public String addNewOrderPage() {
        return "userRegistraionForm";
    }

    @RequestMapping(value="/user-registration", method=RequestMethod.POST)
    public String addNewOrder(@RequestParam(value="firstName") String firstName, @RequestParam(value="lastName") String lastName, @RequestParam(value="fatherName") String fatherName, @RequestParam(value="phoneNumb") String phoneNumber, @RequestParam(value="eMail") String eMail, @RequestParam(value="roomNumb") String roomNumber) throws UnsupportedEncodingException, SQLException {

        UsersService userTestService = new UsersService();
        Users users = new Users();
        users.setFirstName(new String(firstName.getBytes("ISO-8859-1"), "UTF-8"));
        users.setLastName(new String(lastName.getBytes("ISO-8859-1"), "UTF-8"));
        users.setFatherName(new String(fatherName.getBytes("ISO-8859-1"), "UTF-8"));
        users.setPhoneNumber(new String(phoneNumber.getBytes("ISO-8859-1"), "UTF-8"));
        users.seteMail(new String(eMail.getBytes("ISO-8859-1"), "UTF-8"));
        users.setRoomNumber(new String(roomNumber.getBytes("ISO-8859-1"), "UTF-8"));

        try {
            userTestService.add(users);
        } catch (SQLException e ) {
            e.printStackTrace();
        }
        return "redirect:/";
    }

    @RequestMapping(value="/delete/{id}", method=RequestMethod.GET)
    public String deleteItem(@PathVariable Integer id) {
        Order order = orderService.getById(id-1);
        orderService.delete(order);
        return "redirect:/";
    }
}