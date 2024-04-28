package moe.mqq.controller;

import moe.mqq.pojo.Order;
import moe.mqq.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    OrderService service;

    @RequestMapping("/add")
    public String add(){
        var order = new Order();
        order.setId("123");
        order.setProductId("9");
        order.setStatus(0);
        order.setCount(100);
        service.create(order);
        return "下单成功！";
    }
    @RequestMapping("/all")
    public List<Order> all() throws InterruptedException {
        return service.all();
    }
    @RequestMapping("/get")
    public Order get(@RequestParam("id") String id){
        return service.get(id);
    }
}
