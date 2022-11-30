package com.trimble.poc.service;

public interface ObjectStorageService {

    public Object get(String key);

    public void put(String key, Object value);
}
