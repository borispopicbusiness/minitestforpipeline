package com.example.modules.component.impl.resources;

import com.example.modules.component.BaseComponent;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.util.Random;

@Setter
@Getter
@Component
public class Seed implements BaseComponent {

    private long seed;

    public Seed() {
        var seed = new Random(System.currentTimeMillis());
        this.seed = seed.nextLong();
    }

    @Override
    public void info() {
        //BaseComponent.super.info();
        System.out.println("""
                    This is Seed component bean. It sets the seed used by the random number generator bean.
                """);
    }
}
