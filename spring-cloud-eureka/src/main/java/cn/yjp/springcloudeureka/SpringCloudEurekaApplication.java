package cn.yjp.springcloudeureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer//表示此项目是Eureka服务端
public class SpringCloudEurekaApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudEurekaApplication.class, args);
    }
}
