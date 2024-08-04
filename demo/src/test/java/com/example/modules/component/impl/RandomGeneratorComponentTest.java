package com.example.modules.component.impl;

import com.example.modules.component.impl.resources.Seed;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.lang.reflect.Field;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest(classes = {RandomGeneratorComponent.class})
class RandomGeneratorComponentTest {

    @Autowired
    private RandomGeneratorComponent randomGeneratorComponent;

    @Test
    void shouldReproduceRandomNumber() throws NoSuchFieldException, IllegalAccessException {
        Assertions.assertNotNull(this.randomGeneratorComponent);
        var randomNumber = randomGeneratorComponent.nextRandomInteger();
        assertNotNull(this.randomGeneratorComponent);

        // Access the private 'seed' field from RandomGeneratorComponent
        Field seedField = randomGeneratorComponent.getClass().getDeclaredField("seed");
        seedField.setAccessible(true); // Allow access to private fields

        // Get the Seed instance from the 'seed' field
        Seed seedInstance = (Seed) seedField.get(randomGeneratorComponent);

        // Access the private 'seed' field from Seed
        Field seedValueField = seedInstance.getClass().getDeclaredField("seed");
        seedValueField.setAccessible(true); // Allow access to private fields

        // Get the value of the 'seed' field from the Seed instance
        long seedValue = (long) seedValueField.get(seedInstance);

        Random rand = new Random();
        rand.setSeed(seedValue);
        var recreatedRandomNumber = rand.nextLong();

        Assertions.assertEquals(0, randomNumber - recreatedRandomNumber);
    }
}