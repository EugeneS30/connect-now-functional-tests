package functional.support;

import lombok.Setter;

import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class DynamicSpringAutowiringProvider implements DependencyInjectionProvider, ApplicationContextAware {

	@Setter
	private ApplicationContext applicationContext;

	@Override
	public <T> T inject(final T instance) {
		AutowireCapableBeanFactory bf = applicationContext.getAutowireCapableBeanFactory();
		// Ensure bean processors are applied to fully initialise this instance
		// (e.g.
		// PageObjectBeanPostProcessor)
		// A name is not supplied as part of the initialisation, since the bean
		// is not registered
		// with the SpringContext
		bf.applyBeanPostProcessorsBeforeInitialization(instance, null);
		bf.autowireBean(instance);
		bf.applyBeanPostProcessorsAfterInitialization(instance, null);
		return instance;
	}

	@Override
	public <T> T injectWithoutAdditionalProcessing(final T instance) {
		AutowireCapableBeanFactory bf = applicationContext.getAutowireCapableBeanFactory();
		bf.autowireBean(instance);
		return instance;
	}

}
