package com.naver.kiosk.store;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// @Primary , @ConditionalOnMissingBean
@Configuration
public class StoreConfig {
    @Bean
    public StoreService storeService() {
        return new StoreServiceImpl();
    }
}
