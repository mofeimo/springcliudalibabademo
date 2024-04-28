package moe.mqq.service;

import moe.mqq.pojo.Order;

import java.util.List;

public interface OrderService {
    Order create(Order order);
    List<Order> all() throws InterruptedException;
    Order get(String id);
}
