package cn.yjp.springbootconsumer.feign;

import cn.yjp.springbootconsumer.fallback.GatewayFallbackFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Map;

//熔断之后的降级处理策略是指定一个类
//@FeignClient(value = "spring-boot-provider", fallback = GatewayFallback.class)
//熔断之后的降级处理策略是指定一个类，且可以捕获异常信息
@FeignClient(value = "spring-boot-provider", fallbackFactory = GatewayFallbackFactory.class)
public interface GatewayFeignClient {

    @PostMapping(value = "/springbootprovider/users")
    Map<String, String> users(Map<String, String> request) throws Exception;
}
