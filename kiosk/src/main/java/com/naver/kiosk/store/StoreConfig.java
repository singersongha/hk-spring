package com.naver.kiosk.store;

import org.springframework.context.annotation.Bean;

public class StoreConfig {
    @Bean
    public StoreService storeService() {
        return new StoreServiceImpl();
    }
}
