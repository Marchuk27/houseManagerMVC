package ru.house.manager.repository;

import java.util.List;

import ru.house.manager.domain.Order;

public interface OrderRepository {

    void save(Order order);

    void delete(Order order);

    List<Order> getAll();

    Order getById(Integer id);
}