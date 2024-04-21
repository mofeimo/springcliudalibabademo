package moe.mqq.controller;

import jakarta.annotation.Resource;
import lombok.var;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/order")
@RefreshScope
public class OrderController {

    @Resource
    RestTemplate restTemplate;

    @Value("${user.name}")
    String name;

    @RequestMapping("/add")
    String add(){
        System.out.println("下单成功！"+name);
        var result = restTemplate.getForObject("http://stock-service/stock/reduct", String.class);
        System.out.println("result:"+result);
        return "Hello World!";
    }
}
