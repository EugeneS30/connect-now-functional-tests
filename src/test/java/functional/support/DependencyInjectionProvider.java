package functional.support;

/**
 * Provides dependency injection capabilities for classes created outside the DI Framework, for
 * example through factory methods/builders.
 *
 * @author tim.myerscough
 *
 */
public interface DependencyInjectionProvider {

    /**
     * Inject dependencies for the given instance and perform any post processing.
     *
     * Provides a mechanism for beans dynamically created outside the
     * ApplicationContext/DependencyInjection framework to utilise DI.
     *
     * @param bean
     *            the bean to inject
     * @return the injected instance
     */
    <T> T inject(final T bean);

    /**
     * Same as {@link #inject(Object)}, but omits any pre/post processing. @Inject and @Autowired
     * fields are injected only.
     *
     * @param bean
     *            the bean to inject
     * @return the injected instance
     */
    <T> T injectWithoutAdditionalProcessing(final T bean);

}

