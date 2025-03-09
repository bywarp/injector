package sh.wrp.injector.impl;

import sh.wrp.injector.services.ISimpleService;

public class SimpleService implements ISimpleService {

    private int value = 0;

    @Override
    public void increase() {
        this.value++;
    }

    @Override
    public int get() {
        return this.value;
    }
}
