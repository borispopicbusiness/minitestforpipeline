package com.example.modules.configuration;

import com.example.modules.configuration.impl.InMemoryDatabaseConfiguration;
import com.example.modules.db.impl.InMemoryDatabase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = {InMemoryDatabaseConfiguration.class})
public class InMemoryDataBaseConfigurationTest {

    @Autowired
    private InMemoryDatabase inMemoryDatabase;

    @BeforeEach
    public void setUp() {
    }

    @Test
    void shouldInitializeAccessAndEraseDatabase() {
        Assertions.assertNotNull(inMemoryDatabase);

        Assertions.assertTrue(inMemoryDatabase.getKeys().isEmpty());

        inMemoryDatabase.addObject("name", "Boris");
        Assertions.assertEquals(1, inMemoryDatabase.getKeys().size());
        Assertions.assertEquals("name", inMemoryDatabase.getKeys().get(0));

        inMemoryDatabase.eraseDatabase();
        Assertions.assertEquals(0, inMemoryDatabase.getKeys().size());
    }
}
