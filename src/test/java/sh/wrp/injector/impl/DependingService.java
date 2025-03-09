package sh.wrp.injector.impl;

import sh.wrp.injector.services.IDependingService;
import sh.wrp.injector.services.ISimpleService;

public class DependingService implements IDependingService {

    ISimpleService service;

    DependingService(ISimpleService service) {
        this.service = service;

        this.service.increase();
        System.out.println(this.service.get());

    }

}
