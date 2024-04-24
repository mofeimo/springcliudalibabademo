package moe.mqq.feign;

import org.springframework.stereotype.Component;

@Component
public class StockFeignServiceFallback implements StockFeignService{
    @Override
    public String reduct() {
        return "降级了！";
    }
}
