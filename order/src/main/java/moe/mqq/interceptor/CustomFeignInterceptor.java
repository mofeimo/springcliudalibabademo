package moe.mqq.interceptor;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CustomFeignInterceptor implements RequestInterceptor {

    @Override
    public void apply(RequestTemplate requestTemplate) {
        requestTemplate.header("custom-header", "custom-value");
        requestTemplate.query("id", "123");
//        requestTemplate.uri("/9");
        log.info("CustomFeignInterceptor!");
    }
}
