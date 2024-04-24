package moe.mqq.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import lombok.extern.slf4j.Slf4j;
import lombok.var;
import moe.mqq.feign.StockFeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order2")
@Slf4j
public class OrderController2 {

    @Autowired
    StockFeignService service;

    @RequestMapping("/add")
    @SentinelResource(value = "add", blockHandler = "blockHandler", fallback = "fallback")
    public String add(){
//        var a = 1/0;
        System.out.println("下单成功！");
        var result = service.reduct();
        System.out.println("result:"+result);
        return "Hello World!";
    }

    public String blockHandler(BlockException ex){
        ex.printStackTrace();
        log.info(ex.getMessage());
        return "流控！";
    }

    public String fallback(Throwable ex){
        return "异常！";
    }
}
