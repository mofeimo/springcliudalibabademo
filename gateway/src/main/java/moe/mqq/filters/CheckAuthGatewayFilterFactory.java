package moe.mqq.filters;

import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

//@Slf4j
@Component
public class CheckAuthGatewayFilterFactory extends AbstractGatewayFilterFactory<CheckAuthGatewayFilterFactory.Config> {

    public CheckAuthGatewayFilterFactory() {
        super(Config.class);
    }
    @Override
    public GatewayFilter apply(CheckAuthGatewayFilterFactory.Config config) {
        return (exchange, chain) -> {
            String name = exchange.getRequest().getQueryParams().getFirst("name");
//            log.info("CheckAuthGatewayFilterFactory=="+config.name);
            if(!config.getName().equals(name)) {
                return chain.filter(exchange);
            } else {
                exchange.getResponse().setStatusCode(HttpStatus.NOT_FOUND);
                return exchange.getResponse().setComplete();
            }
        };
    }

    @Override
    public List<String> shortcutFieldOrder() {
        return Arrays.asList("");
    }

    public static class Config {
        private String name;
        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
