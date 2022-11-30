package com.trimble.poc.core;

import io.vavr.control.Try;
import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.commons.lang3.tuple.Pair;

import java.util.Collection;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Stream;



public class MapStorage<K,V> {

    private final int DEFAULT_CAPACITY = 500;
    private int currentCapacity = 0;
    private final Pair[] keyValuePair;

    public MapStorage() {
        keyValuePair = new Pair[DEFAULT_CAPACITY];
    }

    public MapStorage(final int capacity) {
        keyValuePair = new Pair[capacity];
    }

    public int size() {
        return keyValuePair.length;
    }

    public boolean isEmpty() {
        return keyValuePair.length == 0;
    }

    public boolean containsKey(K key) {
        return Stream.of(keyValuePair)
                .filter(Objects::nonNull)
                .anyMatch(f -> f.getLeft().equals(key));
    }

    public boolean containsValue(V value) {
        return Stream.of(keyValuePair)
                .filter(Objects::nonNull)
                .anyMatch(f -> f.getRight().equals(value));
    }

    public V get(K key) {
        return Try.of(() -> (V)Stream.of(keyValuePair)
                        .filter(Objects::nonNull)
                .filter(f -> f.getLeft().equals(key)).findFirst().get().getRight())
                .getOrNull();
    }

    public synchronized  V put(K key, V value) {
        if(keyValuePair.length < currentCapacity) {
            throw new UnsupportedOperationException("Storage Limit exceeded");
        }
        if(!containsKey(key)) {
            keyValuePair[currentCapacity] = new ImmutablePair(key, value);
            currentCapacity++;
            return value;
        }else{
            throw new UnsupportedOperationException("Key Already Exists");
        }
    }

}
