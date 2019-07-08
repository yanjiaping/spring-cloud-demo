package cn.yjp.springbootconsumer.controller;

import cn.yjp.springbootconsumer.feign.GatewayFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@Scope("prototype")
public class GatewayController {

    @Autowired
    private GatewayFeignClient gatewayFeignClient;

    @PostMapping(value = "/users")
    public Map<String, String> users(@RequestBody Map<String, String> request) throws Exception {
        Thread.sleep(2000);
        return gatewayFeignClient.users(request);
    }
}
