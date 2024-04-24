package moe.mqq.predicates;

import org.springframework.cloud.gateway.handler.predicate.AbstractRoutePredicateFactory;
import org.springframework.cloud.gateway.handler.predicate.GatewayPredicate;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.server.ServerWebExchange;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

@Component
public class CheckAuthRoutePredicateFactory extends AbstractRoutePredicateFactory<CheckAuthRoutePredicateFactory.Config> {
    public CheckAuthRoutePredicateFactory() {
        super(Config.class);
    }

    @Override
    public List<String> shortcutFieldOrder() {
        return Arrays.asList("");
    }

    @Override
    public Predicate<ServerWebExchange> apply(CheckAuthRoutePredicateFactory.Config config) {
        return (GatewayPredicate) serverWebExchange -> {
            System.err.println(config.getName());
            if (config.getName().equals("mqq")){
                return true;
            } else {
                return false;
            }
        };
    }

    // 接收配置文件中断言信息
    @Validated
    public static class Config {
        private String name;
        public Config() {
        }
        public String getName() {
            return name;
        }

        public Config setName(String name) {
            this.name = name;
            return this;
        }
    }
}
