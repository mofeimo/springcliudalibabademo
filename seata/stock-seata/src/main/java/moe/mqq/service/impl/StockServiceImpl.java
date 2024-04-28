package moe.mqq.service.impl;

import io.seata.spring.annotation.GlobalTransactional;
import jakarta.annotation.Resource;
import moe.mqq.mapper.StockMapper;
import moe.mqq.service.StockService;
import org.springframework.stereotype.Service;

@Service
public class StockServiceImpl implements StockService {
    @Resource
    StockMapper mapper;

    @Override
    @GlobalTransactional
    public String reduct(String productId) {
        System.err.println("更新商品："+productId);
        mapper.reduct(productId);
        return "更新商品："+productId;
    }
}
