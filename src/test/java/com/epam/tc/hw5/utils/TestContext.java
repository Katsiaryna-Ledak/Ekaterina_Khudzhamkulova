package com.epam.tc.hw5.utils;

import java.util.HashMap;
import java.util.Map;

public final class TestContext {

    private static TestContext instance;
    public static final String WEB_DRIVER = "driver";

    private Map<String, Object> context = new HashMap<>();

    private TestContext() {
    }

    public void addTestObject(String key, Object value) {
        context.put(key, value);
    }

    public <T> T getTestObject(String key) {
        return (T) context.get(key);
    }

    public void cleanContext() {
        context.clear();
    }

    public static TestContext getInstance() {
        if (instance == null) {
            instance = new TestContext();
        }
        return instance;
    }
}
