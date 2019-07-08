package cn.yjp.springbootconsumer.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@RestController
@Scope("prototype")
public class GatewayController {

    @Autowired
    private RestTemplate restTemplate;

    @PostMapping(value = "/users")
    @HystrixCommand(fallbackMethod = "usersFallback")//该方法开启断路器功能，指定了熔断方法是usersFallback
    public Map<String, String> users(@RequestBody Map<String, String> request) throws Exception {
        Thread.sleep(2000);
        ResponseEntity<Map> responseEntity = restTemplate.postForEntity("http://spring-boot-provider/springbootprovider/users", request, Map.class);
        return responseEntity.getBody();
    }

    public Map<String, String> usersFallback(Map<String, String> request) throws Exception {
        request.put("fallback", "spring-boot-consumer-hystrix");
        return request;
    }
}
