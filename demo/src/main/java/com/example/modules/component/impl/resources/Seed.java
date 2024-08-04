package com.example.modules.component.impl.resources;

import com.example.modules.component.BaseComponent;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class Seed implements BaseComponent {

    private long seed;

    public Seed() {
        var seed = new Random(System.currentTimeMillis());
        this.seed = seed.nextLong();
    }

    public long getSeed() {
        return seed;
    }

    public void setSeed(long seed) {
        this.seed = seed;
    }

    @Override
    public void info() {
        //BaseComponent.super.info();
        System.out.println("""
                    This is Seed component bean. It sets the seed used by the radnom number generator bean.
                """);
    }
}
