package cn.yjp.springbootconsumer.config;

import cn.yjp.springbootconsumer.config.loadbalancer.GlobalRule;
import com.netflix.loadbalancer.IRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LoadBalanced {

    /**
     * 注册一个新的IRule来替换Eureka，实现自定义负载均衡
     *
     * @return
     */
    @Bean
    public IRule iRule() {
        return new GlobalRule();
    }
}
