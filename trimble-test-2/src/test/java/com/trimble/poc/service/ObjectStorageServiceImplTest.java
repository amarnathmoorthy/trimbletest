package com.trimble.poc.service;


import org.junit.Assert;
import org.junit.Test;

public class ObjectStorageServiceImplTest {

    @Test
    public void testPutAndGet() {
        ObjectStorageService objectStorageService = new ObjectStorageServiceImpl();
        objectStorageService.put("key1", "value1");
        Assert.assertEquals(objectStorageService.get("key1"), "value1");
    }

}