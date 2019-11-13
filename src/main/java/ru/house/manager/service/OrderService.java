package ru.house.manager.service;

import java.util.List;

import ru.house.manager.domain.Order;

public interface OrderService {

    void save(Order order);

    void delete(Order order);

    List<Order> getAll();

    Order getById(Integer id);
}