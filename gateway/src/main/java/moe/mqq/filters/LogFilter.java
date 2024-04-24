package moe.mqq.filters;

import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

//@Slf4j
public class LogFilter implements GlobalFilter {
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
//        log.info("GlobalFilter==="+exchange.getRequest().getPath());
        System.err.println("全局过滤器");
        return chain.filter(exchange);
    }
}
