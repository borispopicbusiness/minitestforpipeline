package com.example.modules.db.impl;

import com.example.modules.db.DbInterface;

import java.util.*;

public class InMemoryDatabase<K, V> implements DbInterface<K, V> {

    private final Map<K, V> map = new HashMap<>();

    @Override
    public Optional<K> addObject(K key, V value) {
        if (map.containsKey(key)) {
            return Optional.empty();
        }
        map.put(key, value);
        return Optional.of(key);
    }

    @Override
    public V getValue(K key) {
        return map.get(key);
    }

    @Override
    public List<K> getKeys() {
        return map.keySet()
                .stream()
                .toList();
    }

    @Override
    public List<V> getValues() {
        return map.values()
                .stream()
                .toList();
    }

    @Override
    public V deleteObject(K key) {
        return map.remove(key);
    }

    @Override
    public Optional<K> updateObject(K key, V value) {
        map.put(key, value);
        return Optional.of(key);
    }

    @Override
    public List<K> searchObject(V value) {
        List<K> result = new ArrayList<>();

        map.forEach((k, v) -> {
            if (v.equals(value))
                result.add(k);
        });

        return !result.isEmpty() ? result : null;
    }

    @Override
    public void eraseDatabase() {
        map.clear();
    }
}
