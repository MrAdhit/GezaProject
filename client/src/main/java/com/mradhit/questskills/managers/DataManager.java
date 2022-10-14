package com.mradhit.questskills.managers;

public class DataManager {
    public DataManager() {

    }

    public <E> E get(String key, Class<E> as) {
        return as.cast("ret");
    }

    public <T> void set(String key, T value) {

    }
}
