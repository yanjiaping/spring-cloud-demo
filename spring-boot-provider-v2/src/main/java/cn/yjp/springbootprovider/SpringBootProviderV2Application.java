package cn.yjp.springbootprovider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient//表示此项目是Eureka客户端
public class SpringBootProviderV2Application {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootProviderV2Application.class, args);
    }
}
