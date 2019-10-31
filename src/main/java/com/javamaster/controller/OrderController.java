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
    public String addNewOrder(@RequestParam(value="id") int id, @RequestParam(value="fullName") String fullName, @RequestParam(value="birthDate") String birthDate) throws UnsupportedEncodingException, SQLException {

        UserTestService userTestService = new UserTestService();
        TestUsers testUsers = new TestUsers();
        testUsers.setId(id);
        String UTFfullName = new String(fullName.getBytes("ISO-8859-1"), "UTF-8");
        testUsers.setFullName(UTFfullName);
        String UTFbirthDate = new String(birthDate.getBytes("ISO-8859-1"), "UTF-8");
        testUsers.setBirthDate(UTFbirthDate);

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