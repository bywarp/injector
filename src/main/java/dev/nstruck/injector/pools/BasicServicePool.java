package dev.nstruck.injector.pools;

import dev.nstruck.injector.ServicePool;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BasicServicePool implements ServicePool {

    private List<Class<?>> services;

    public BasicServicePool() {
        this.services = new ArrayList<>();
    }

    @Override
    public <I> ServicePool add(Class<? extends I> clazz) {
        this.services.add(clazz);
        return this;
    }
}
