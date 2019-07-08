package cn.yjp.springbootconsumer;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableEurekaClient//表示此项目是Eureka客户端
//表示spring-boot-provider服务使用cn.wbnull.config.LoadBalanced提供的负载均衡策略。
@RibbonClient(name = "spring-boot-provider", configuration = cn.yjp.springbootconsumer.config.LoadBalanced.class)
public class SpringBootConsumerApplication {

    @Bean
    @LoadBalanced//表示开启负载均衡
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringBootConsumerApplication.class, args);
    }
}
