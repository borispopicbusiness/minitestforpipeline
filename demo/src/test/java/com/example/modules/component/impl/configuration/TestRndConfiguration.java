package com.example.modules.component.impl.configuration;

import com.example.modules.component.impl.resources.Seed;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TestRndConfiguration {

    @Bean
    public Seed testSeed() {
        return (Seed) new TestSeed();
    }
}
