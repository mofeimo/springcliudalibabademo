package moe.mqq.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/stock")
public class StockController {

    @RequestMapping("/reduct")
    String reduct(){
        System.out.println("扣减库存！");
        return "扣减库存！";
    }
}
