package moe.mqq.listener;

import moe.mqq.pojo.Order;
import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class RabbitMQListener {

    @RabbitListener(queues = "沫柒柒")
    public void receive(Order message) {
        System.err.println("RabbitMQ 收到消息：【" + message.toString() + "】");
    }
    @RabbitListener(
            bindings = @QueueBinding(
                    value = @Queue(name = "生成队列"),
                    exchange = @Exchange(name = "生成交换机", type = ExchangeTypes.DIRECT),
                    key = {"red", "yellow"}
            )
    )
    public void init(String message) {
        System.err.println("RabbitMQ 收到消息：【" + message + "】");
    }
}
