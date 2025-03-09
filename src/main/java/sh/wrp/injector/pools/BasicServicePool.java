package sh.wrp.injector.pools;

import sh.wrp.injector.ServicePool;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.*;
import java.util.stream.Stream;

public class BasicServicePool implements ServicePool<BasicServicePool> {

    private List<Class<?>> services;
    private Map<Class<?>, Object> instances;

    public BasicServicePool() {
        this.services = new ArrayList<>();
        this.instances = new HashMap<>();
    }

    @Override
    public <I> BasicServicePool addScoped(Class<? extends I> clazz) {
        this.services.add(clazz);
        return this;
    }

    @Override
    public <I> BasicServicePool addSingleton(I instance) {
        Class<? extends Object> clazz = instance.getClass();
        this.services.add(clazz);
        this.instances.put(clazz, instance);
        return this;
    }

    @Override
    public BasicServicePool resolve() {
        while (this.instances.size() != this.services.size()) {
            for (Class<?> service : this.services) {
                if (this.instances.containsKey(service)) continue;

                try {
                    for (Constructor constructor : service.getDeclaredConstructors()) {
                        constructor.setAccessible(true);
                        int paramsCount = constructor.getParameterCount();
                        if (paramsCount > 0) {
                            Object[] params = Stream.of(constructor.getParameters())
                                    .map(param -> param.getType())
                                    .map(param -> this.instances
                                            .entrySet()
                                            .stream()
                                            .filter(entry -> param.isAssignableFrom(entry.getKey()))
                                            .map(Map.Entry::getValue)
                                            .findFirst()
                                            .orElse(null))
                                    .filter(Objects::nonNull)
                                    .toArray();

                            if (params.length == paramsCount) this.instances.put(service, constructor.newInstance(params));
                        } else this.instances.put(service, constructor.newInstance());
                        constructor.setAccessible(false);
                    }
                } catch (InvocationTargetException
                         | InstantiationException
                         | IllegalAccessException e) {
                    throw new RuntimeException(e);
                }
            }
        }

        return this;
    }
}
