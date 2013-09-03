package com.ociweb.training.tdd.lesson1;

import com.ociweb.training.tdd.lesson1.ObjectLoader;

public class TimedCache {
    ObjectLoader objectLoader;

    public TimedCache(ObjectLoader objectLoader) {
        this.objectLoader = objectLoader;
    }

    public Object lookUp(Object key) {
        return objectLoader.load(key);
    }
}
