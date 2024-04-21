package moe.mqq.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name = "stock-service", path = "/stock")
public interface StockFeignService {

    @RequestMapping("/reduct")
    String reduct();
}
