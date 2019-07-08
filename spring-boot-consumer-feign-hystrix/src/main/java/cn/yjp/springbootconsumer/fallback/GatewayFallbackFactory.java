package cn.yjp.springbootconsumer.fallback;

import cn.yjp.springbootconsumer.feign.GatewayFeignClient;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

@Component
public class GatewayFallbackFactory implements FallbackFactory<GatewayFeignClient> {

    @Override
    public GatewayFeignClient create(Throwable throwable) {
        return (request) -> {
            request.put("fallback", "spring-boot-consumer-feign-hystrix by GatewayFallbackFactory");
            request.put("throwable", throwable.toString());
            return request;
        };
    }
}
