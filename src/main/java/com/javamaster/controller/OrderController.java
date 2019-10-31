package com.javamaster.controller;

import java.io.UnsupportedEncodingException;
import java.sql.SQLException;
import java.util.List;

import EntityDB.TestUsers;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.javamaster.domain.Order;
import com.javamaster.service.OrderService;
import com.javamaster.service.OrderServiceImpl;
import serviceDB.UserTestService;

@Controller
public class OrderController {

    private OrderService orderService = new OrderServiceImpl();

    @RequestMapping(value="/", method=RequestMethod.GET)
    public String getOrderPage(Model model) {
        List<Order> orders = orderService.getAll();
        model.addAttribute("orderList", orders);
        return "order";
    }

    @RequestMapping(value = "/add-new-order", method=RequestMethod.GET)
    public String addNewOrderPage() {
        return "addNewOrder";
    }

    @RequestMapping(value="/add-new-order", method=RequestMethod.POST)
    public String addNewOrder(@RequestParam(value="firstName") String firstName, @RequestParam(value="lastName") String lastName, @RequestParam(value="fatherName") String fatherName, @RequestParam(value="phoneNumb") String phoneNumber, @RequestParam(value="eMail") String eMail, @RequestParam(value="roomNumb") String roomNumber) throws UnsupportedEncodingException, SQLException {

        UserTestService userTestService = new UserTestService();
        TestUsers testUsers = new TestUsers();
        String UTFfirstName = new String(firstName.getBytes("ISO-8859-1"), "UTF-8");
        String UTFlastName = new String(lastName.getBytes("ISO-8859-1"), "UTF-8");
        String UTFfatherName = new String(fatherName.getBytes("ISO-8859-1"), "UTF-8");
        String UTFphoneNumber = new String(phoneNumber.getBytes("ISO-8859-1"), "UTF-8");
        String UTFeMail = new String(eMail.getBytes("ISO-8859-1"), "UTF-8");
        String UTFroomNumber = new String(roomNumber.getBytes("ISO-8859-1"), "UTF-8");
        testUsers.setFirstName(UTFfirstName);
        testUsers.setLastName(UTFlastName);
        testUsers.setFatherName(UTFfatherName);
        testUsers.setPhoneNumber(UTFphoneNumber);
        testUsers.seteMail(UTFeMail);
        testUsers.setRoomNumber(UTFroomNumber);

        try {
            userTestService.add(testUsers);
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