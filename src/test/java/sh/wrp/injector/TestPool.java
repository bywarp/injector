package sh.wrp.injector;

import sh.wrp.injector.impl.NestedService;
import sh.wrp.injector.pools.BasicServicePool;
import sh.wrp.injector.impl.DependingService;
import sh.wrp.injector.services.IDependingService;
import sh.wrp.injector.services.INestedService;
import sh.wrp.injector.services.ISimpleService;
import sh.wrp.injector.impl.SimpleService;

public class TestPool implements IPool {

    public static void main(String[] args) {
        new TestPool();
    }

    public TestPool() {
        new BasicServicePool()
                .<INestedService>addScoped(NestedService.class)
                .<ISimpleService>addScoped(SimpleService.class)
                .<IDependingService>addScoped(DependingService.class)
                .<IPool>addSingleton(this)
                .resolve();
    }

}
