package moe.mqq.controller;

import moe.mqq.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/stock")
public class StockController {
    @Autowired
    StockService service;

    @RequestMapping("/reduct")
    public String reduct(@RequestParam("productId") String productId){
        service.reduct(productId);
        return "扣减库存！";
    }
}
