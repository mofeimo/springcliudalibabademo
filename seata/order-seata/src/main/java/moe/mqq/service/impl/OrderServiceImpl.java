package moe.mqq.service.impl;

import io.seata.spring.annotation.GlobalTransactional;
import jakarta.annotation.Resource;
import moe.mqq.api.StockService;
import moe.mqq.mapper.OrderMapper;
import moe.mqq.pojo.Order;
import moe.mqq.service.OrderService;
import org.apache.skywalking.apm.toolkit.trace.Tag;
import org.apache.skywalking.apm.toolkit.trace.Tags;
import org.apache.skywalking.apm.toolkit.trace.Trace;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.TimeUnit;

@Service
public class OrderServiceImpl implements OrderService {

    @Resource
    StockService stockService;
    @Autowired
    OrderMapper mapper;
    @Autowired
    RabbitTemplate rabbitTemplate;

    @Override
    @GlobalTransactional
    public Order create(Order order) {
//        mapper.insert(order);
//        MultiValueMap<String, Object> map = new LinkedMultiValueMap<>();
//        map.add("productId", order.getProductId());
//        var msg = restTemplate.postForObject("http://localhost:7071/stock/reduct", map, String.class);
        stockService.reduct(order.getProductId());
        rabbitTemplate.convertAndSend("沫柒柒", order);
//        int a=1/0;
        return order;
    }

    @Override
    @Trace
    @Tag(key = "all", value = "returnedObj")
    public List<Order> all() throws InterruptedException {
        TimeUnit.SECONDS.sleep(2);
        return mapper.all();
    }

    @Override
    @Trace
    @Tags({@Tag(key = "param", value = "arg[0]"), @Tag(key = "order", value = "returnedObj")})
    public Order get(String id){
        return mapper.selectbyid(id);
    }
}
