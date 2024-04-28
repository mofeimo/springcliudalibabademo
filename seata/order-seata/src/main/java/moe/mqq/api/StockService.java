package moe.mqq.api;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "stock-seata", path = "/stock")
public interface StockService {
    @RequestMapping("/reduct")
    String reduct(@RequestParam("productId") String productId);
}
