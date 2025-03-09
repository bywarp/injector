package dev.nstruck.injector;

public interface ServicePool {

    /**
     * Add a service to the service pool
     *
     * @param implementation the implementation
     * @return the {@link ServicePool} instance
     * @param <I> the interface of the service you want to add
     */
    <I> ServicePool add(Class<? extends I> implementation);

}
