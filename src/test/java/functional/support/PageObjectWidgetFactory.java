package functional.support;

import java.text.MessageFormat;

import javax.inject.Inject;

import org.openqa.selenium.SearchContext;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.DefaultElementLocatorFactory;
import org.springframework.stereotype.Component;

/**
 * Creates Page Object Widgets, which also have any required dependencies injected.
 *
 * This is an attempt at simplifying the existing relative-finder module by using OOTB Selenium.
 *
 * TODO - If this experiment is successful, then rather than replace the relative-finder module
 * completely, the @ParentElement, and @ParentRef annotations should be applied to a PageObject
 * instead, and define the parent field to dynamically invoke this factory as part of a post
 * processor. In this way, Widgets can be declaratively defined, without the need for instantiation
 * directly by the class (they could even be made standard beans). A PostProcessor would need to
 * identify fields annotated with @ParentRef and instantiate and inject/initialise the Page Object
 * appropriately.
 *
 * Note, this implementation is incompatible with decorating WebElements.
 *
 * @author tim.myerscough
 *
 */

//@Experimental(value = "18/12/2014. The current relative-finder widget adds a complexity to a class that is already supported by Selenium, requiring potentially unnecessary boilerplate."
//        + "This implementation is an attempt to return to the simplicity of creating PageObjects using OOTB Selenium."
//        + "This should be wired in to the existing PageObjectBeanPostProcessor to perform the actual injection by the PageFactory using the search context.  "
//        + "The PostProcessor should be refactored to identify the appropriate search context to inject (either default scope, or an @ParentElement reference).")
@Component
public class PageObjectWidgetFactory {

    @Inject
    private DependencyInjectionProvider dip;

    /**
     * Create a PageObjectWidget from the given type using the default search context (the page).
     *
     * @param type
     *            The type to instantiate. It must have a default/no-argument constructor.
     */
    public <T> T create(final Class<T> type) {

        return dip.inject(newInstance(type));
    }

    private <T> T newInstance(final Class<T> type) {
        try {
            return type.newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            throw new RuntimeException(MessageFormat.format("{0} must have a public no argument constructor", type), e);
        }
    }

    /**
     * Create a PageObjectWidget from the given type. The type must have a default/no-argument
     * constructor. In addition, the PageObject will be initialised from the given search context.
     * All elements will be located from that search context
     *
     * @param type
     * @param context
     * @return
     */
    public <T> T create(final Class<T> type, final SearchContext context) {
        T instance = newInstance(type);

        injectParentElements(instance, context);
        dip.inject(instance);
        injectWebElements(instance, context);

        return instance;
    }

    /**
     * Inject a previously created page object using the given search context
     *
     * @param pageObject
     * @param searchContext
     */
    public void inject(final Object pageObject, final SearchContext searchContext) {
        injectWebElements(pageObject, searchContext);
        injectParentElements(pageObject, searchContext);
    }

    private void injectWebElements(final Object pageObject, final SearchContext searchContext) {
        PageFactory.initElements(new ParentRefExclusionFieldDecorator(new DefaultElementLocatorFactory(searchContext)), pageObject);
    }

    private void injectParentElements(final Object pageObject, final SearchContext searchContext) {
        PageFactory.initElements(new ParentRefFieldDecorator(searchContext), pageObject);
    }

}