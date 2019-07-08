package cn.yjp.springcloudzuul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableEurekaClient
@EnableZuulProxy//开启Zuul功能
public class SpringCloudZuulApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudZuulApplication.class, args);
    }
}
