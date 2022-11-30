package com.trimble.poc.service;

import com.trimble.poc.core.MapStorage;

import java.util.HashMap;

public class ObjectStorageServiceImpl implements ObjectStorageService {

    private final MapStorage<String, Object> storage = new MapStorage<>(10);

    @Override
    public Object get(String key) {
        return storage.get(key);
    }

    @Override
    public void put(String key, Object value) {
        storage.put(key, value);
    }

    public static void main(String[] args) {
        MapStorage<String,Object> objectStorageService = new MapStorage<>(10);
        objectStorageService.put("key1", "value1");
        System.out.println("#######" + objectStorageService.size());
        System.out.println(objectStorageService.get("key1"));
    }
}
