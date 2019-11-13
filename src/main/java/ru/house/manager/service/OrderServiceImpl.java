package ru.house.manager.service;

import java.util.List;

import ru.house.manager.domain.Order;
import ru.house.manager.repository.OrderRepository;
import ru.house.manager.repository.OrderRepositoryImpl;

public class OrderServiceImpl implements OrderService {

    private OrderRepository orderRepository = new OrderRepositoryImpl();

    public void save(Order order) {
        if(order!=null) {
            List<Order> orders = orderRepository.getAll();
            if(!orders.isEmpty()) {
                Order lastOrder = orders.get(orders.size() - 1);
                order.setId(lastOrder.getId()+1);
                orderRepository.save(order);
            }
        }
    }

    public void delete(Order order) {
        if(order!=null) {
            orderRepository.delete(order);
        }
    }

    public List<Order> getAll() {
        return orderRepository.getAll();
    }

    public Order getById(Integer id) {
        if(id!=null) {
            return orderRepository.getById(id);
        }
        return null;
    }

}