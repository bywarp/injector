package sh.wrp.injector;

import sh.wrp.injector.pools.BasicServicePool;

public interface ServicePool<T extends ServicePool>  {

    /**
     * Add a scoped service to the service pool
     *
     * @param clazz the concrete class instance of the scoped service
     * @return the {@link ServicePool} instance
     * @param <I> the abstract class of the service you want to add
     */
    <I> T addScoped(Class<? extends I> clazz);

    /**
     * Add a singleton instance to the service pool
     *
     * @param instance the singleton
     * @return the {@link ServicePool} instance
     * @param <I> the generic type of the singleton
     */
    <I> T addSingleton(I instance);

    /**
     * Get an instance by its class from the service pool
     *
     * @param clazz the class you want to get
     * @param <I> the instance
     */
    <I> I get(Class<I> clazz);

    /**
     * Resolves the Service Pool by injecting the class instances
     *
     * @return the {@link ServicePool} instance
     */
    T inject();

}
