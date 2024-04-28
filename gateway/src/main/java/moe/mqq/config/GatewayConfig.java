package moe.mqq.config;

import com.alibaba.csp.sentinel.adapter.gateway.sc.callback.BlockRequestHandler;
import com.alibaba.csp.sentinel.adapter.gateway.sc.callback.GatewayCallbackManager;
import jakarta.annotation.PostConstruct;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerResponse;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class GatewayConfig {

    @PostConstruct
    public void init() {
        BlockRequestHandler blockRequestHandler = (serverWebExchange, throwable) -> {
            System.err.println(throwable);
            Map<String, String> map = new HashMap<>();
            map.put("code", HttpStatus.TOO_MANY_REQUESTS.toString());
            map.put("message", "限流");
            return ServerResponse.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON).body(BodyInserters.fromValue(map));
        };
        GatewayCallbackManager.setBlockHandler(blockRequestHandler);
    }
}
