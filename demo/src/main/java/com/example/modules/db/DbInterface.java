package com.example.modules.db;

import java.util.List;
import java.util.Optional;

public interface DbInterface<K, V> {
    Optional<K> addObject(K key, V value);

    V getValue(K key);

    List<K> getKeys();

    List<V> getValues();

    V deleteObject(K key);

    Optional<K> updateObject(K key, V value);

    List<K> searchObject(V value);

    void eraseDatabase();
}
