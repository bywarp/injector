package sh.wrp.injector.impl;

import sh.wrp.injector.IPool;
import sh.wrp.injector.TestPool;
import sh.wrp.injector.services.IDependingService;
import sh.wrp.injector.services.INestedService;
import sh.wrp.injector.services.ISimpleService;

public class NestedService implements INestedService {

    public ISimpleService service;
    public IDependingService depending;

//    public NestedService() {
//        this.service = null;
//        this.depending = null;
//    }

    public NestedService(IPool pool, ISimpleService service, IDependingService depending) {
        this.service = service;
        this.depending = depending;

        this.service.increase();
        System.out.println(this.service.get());
        System.out.println(pool.getClass().getName());

    }
}
