package com.itmuch.cloud.config;

import com.itmuch.cloud.annotation.ExcludeComponent;
import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.ribbon.ZonePreferenceServerListFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 自定义ribbon策略可以覆盖RibbonClientConfiguration中的默认配置。
 * RibbonClientConfiguration每个方法都可以被覆盖
 * 自定义的Ribbon配置不能放在SpringApplication的同级或下级目录中会覆盖所有的Ribbon客户端配置,所有的客户端都使用了相同的配置。
 * 自定义的Ribbon配置不能放在ComponentScan的目录中否则次配置会覆盖所有的Ribbon客户端配置,所有的客户端都使用了相同的配置。
 */
@Configuration
@ExcludeComponent
public class RibbonConfiguration {

    public static final int DEFAULT_CONNECT_TIMEOUT = 1000;
    public static final int DEFAULT_READ_TIMEOUT = 1000;

    @Bean
    public IRule ribbonRule(){
        return new RandomRule();
    }

}
