package com.example.modules.db.impl;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class InMemoryDatabaseTest {

    private InMemoryDatabase<String, String> database;

    @BeforeEach
    void setUp() {
        database = new InMemoryDatabase<>();
    }

    @Test
    void shouldAddObject() {
        database.addObject("name", "Boris");
        Assertions.assertEquals(1, database.getKeys().size());
        Assertions.assertEquals("name", database.getKeys().get(0));
    }

    @Test
    void shouldReturnValue() {
        database.addObject("name", "Boris");
        Assertions.assertEquals(1, database.getKeys().size());
        Assertions.assertEquals("name", database.getKeys().get(0));
    }

    @Test
    void shouldReturnKeys() {
        database.addObject("name", "Boris");
        database.addObject("surname", "Popic");
        database.addObject("name", "Stefan");
        database.addObject("surname", "Popic");
        database.addObject("address", "Street X, Vozdovac, Belgrade");
        database.addObject("phone number", "00381-xx-xx-xx-x12");
        Assertions.assertEquals(4, database.getKeys().size());
    }

    @Test
    void shouldReturnValues() {
        database.addObject("name", "Boris");
        database.addObject("surname", "Popic");
        database.addObject("name", "Stefan");
        database.addObject("surname", "Popic");
        database.addObject("phone number", "00381-xx-xx-xx-x12");
        Assertions.assertEquals(3, database.getValues().size());
    }

    @Test
    void ShouldDeleteObjectAndReturnExpectedState() {
        database.addObject("name", "Boris");
        database.addObject("surname", "Popic");
        database.addObject("name", "Stefan");
        database.addObject("surname", "Popic");
        database.addObject("address", "Street X, Vozdovac, Belgrade");
        database.addObject("phone number", "00381-xx-xx-xx-x12");
        database.deleteObject("name");
        Assertions.assertEquals(3, database.getKeys().size());
        Assertions.assertEquals(3, database.getValues().size());
    }

    @Test
    void shouldUpdateObjectandValidateNewState() {
        database.addObject("name", "Boris");
        database.addObject("surname", "Popic");
        database.addObject("name", "Stefan");
        database.addObject("surname", "Popic");
        database.addObject("address", "Street X, Vozdovac, Belgrade");
        database.addObject("phone number", "00381-xx-xx-xx-x12");

        Assertions.assertEquals(4, database.getKeys().size());
        Assertions.assertEquals(4, database.getValues().size());

        Assertions.assertEquals("Boris", database.getValue("name"));

        Assertions.assertEquals(4, database.getKeys().size());
        Assertions.assertEquals(4, database.getValues().size());

        database.updateObject("name", "Updated Name");

        Assertions.assertEquals(4, database.getKeys().size());
        Assertions.assertEquals(4, database.getValues().size());

        Assertions.assertEquals("Updated Name", database.getValue("name"));
    }

    @Test
    void shouldFindObject() {
        database.addObject("name", "Boris");
        database.addObject("surname", "Popic");
        database.addObject("name", "Stefan");
        database.addObject("surname", "Popic");
        database.addObject("address", "Street X, Vozdovac, Belgrade");
        database.addObject("phone number", "00381-xx-xx-xx-x12");

        var found = database.searchObject("Stefan");
        Assertions.assertNull(found);

        database.addObject("test", "Boris");

        found = database.searchObject("Boris");

        Assertions.assertEquals(2, found.size());
    }

    @Test
    void shouldEraseDatabase() {
        database.addObject("name", "Boris");
        database.addObject("surname", "Popic");
        database.addObject("name", "Stefan");
        database.addObject("surname", "Popic");
        database.addObject("address", "Street X, Vozdovac, Belgrade");
        database.addObject("phone number", "00381-xx-xx-xx-x12");

        Assertions.assertEquals(4, database.getKeys().size());

        database.eraseDatabase();

        Assertions.assertEquals(0, database.getKeys().size());
    }
}