package dev.nstruck.injector;

import dev.nstruck.injector.pools.BasicServicePool;
import dev.nstruck.injector.services.ISimpleService;
import dev.nstruck.injector.services.SimpleService;

public class TestPool {

    public static void main(String[] args) {
        new BasicServicePool()
                .<ISimpleService>add(SimpleService.class)
                .<ISimpleService>add(SimpleService.class);
    }

}
