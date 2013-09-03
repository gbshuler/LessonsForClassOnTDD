package com.ociweb.training.tdd.lesson1;

public class MeasuredCache {
    ObjectCollection objectCollection;

    public MeasuredCache(ObjectCollection objectCollection) {
        this.objectCollection = objectCollection;
    }

    public Object lookUp(Object key) {
        return objectCollection.load(key);
    }
}
