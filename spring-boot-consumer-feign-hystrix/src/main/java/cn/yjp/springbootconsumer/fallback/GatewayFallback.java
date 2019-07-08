package cn.yjp.springbootconsumer.fallback;

import cn.yjp.springbootconsumer.feign.GatewayFeignClient;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * 熔断处理类GatewayFallback
 */
@Component
public class GatewayFallback implements GatewayFeignClient {

    @Override
    public Map<String, String> users(Map<String, String> request) throws Exception {
        request.put("fallback", "spring-boot-consumer-feign-hystrix");
        return request;
    }
}
