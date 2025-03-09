package sh.wrp.injector;

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
     * Resolves the Service Pool by injecting the class instances
     *
     * @return the {@link ServicePool} instance
     */
    T resolve();

}
