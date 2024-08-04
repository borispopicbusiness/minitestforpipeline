package com.example.modules.configuration.impl;

import com.example.modules.configuration.BaseConfiguration;
import com.example.modules.db.impl.InMemoryDatabase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class InMemoryDatabaseConfiguration implements BaseConfiguration {

    @Bean
    public InMemoryDatabase inMemoryDatabase() {
        return new InMemoryDatabase<String, String>();
    }
}
