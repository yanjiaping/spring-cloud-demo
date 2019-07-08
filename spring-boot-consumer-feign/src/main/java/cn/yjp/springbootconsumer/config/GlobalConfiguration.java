package cn.yjp.springbootconsumer.config;

import feign.Contract;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScanExclude
public class GlobalConfiguration {

    /**
     * Contract 表示契约，就是一个注解解释器。Contract 可以帮助我们将这些注解解释成Feign能够理解的Http请求
     * Feign一开始默认使用的契约是Spring MVC，Contract.Default()默认使用的契约是Feign，所以我们也对应的要修改成Feign注解。
     * @return
     */
    @Bean
    public Contract GlobalContract() {
        return new Contract.Default();
    }
}
