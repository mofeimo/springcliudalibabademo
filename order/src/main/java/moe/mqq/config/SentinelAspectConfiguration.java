package moe.mqq.config;

import com.alibaba.csp.sentinel.annotation.aspectj.SentinelResourceAspect;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SentinelAspectConfiguration {
    @Bean
    SentinelResourceAspect sentinelResourceAspect() {
        return new SentinelResourceAspect();
    }
}
