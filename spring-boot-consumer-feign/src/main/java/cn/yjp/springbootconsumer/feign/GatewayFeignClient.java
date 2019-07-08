package cn.yjp.springbootconsumer.feign;

import cn.yjp.springbootconsumer.config.GlobalConfiguration;
import feign.Headers;
import feign.Param;
import feign.RequestLine;
import org.springframework.cloud.openfeign.FeignClient;

import java.util.Map;

//@FeignClient("spring-boot-provider")
@FeignClient(value = "spring-boot-provider", configuration = GlobalConfiguration.class)//使用自定义feign
public interface GatewayFeignClient {

    //@GetMapping(value = "/springbootprovider/gateway")
    @RequestLine("GET /springbootprovider/gateway")//使用feign注解
    String gateway() throws Exception;

    //@PostMapping(value = "/springbootprovider/user")
    //String user(@RequestParam(value = "name") String name) throws Exception;
    @RequestLine("POST /springbootprovider/user?name={name}")
    String user(@Param("name") String name) throws Exception;

    @RequestLine("POST /springbootprovider/users")
    @Headers("Content-Type: application/json")//application/json方式传参
    Map<String, String> users(Map<String, String> request) throws Exception;

}
