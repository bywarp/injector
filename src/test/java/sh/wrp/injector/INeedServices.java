package sh.wrp.injector;

import sh.wrp.injector.services.IDependingService;
import sh.wrp.injector.services.INestedService;

public class INeedServices {

    private IDependingService service;

    @Injected
    public INeedServices(IDependingService service) {
        this.service = service;
    }

}
