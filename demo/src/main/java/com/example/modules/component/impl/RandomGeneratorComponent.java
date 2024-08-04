package com.example.modules.component.impl;

import com.example.modules.component.BaseComponent;
import com.example.modules.component.impl.resources.Seed;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
@ComponentScan(basePackageClasses = {Seed.class})
public class RandomGeneratorComponent implements BaseComponent {

    private final Seed seed;

    private Random random;

    @Autowired
    private RandomGeneratorComponent(Seed seed) {
        this.seed = seed;
        random = new Random();
        random.setSeed(this.seed.getSeed());
    }

    public long nextRandomInteger() {
        return random.nextLong();
    }
}
