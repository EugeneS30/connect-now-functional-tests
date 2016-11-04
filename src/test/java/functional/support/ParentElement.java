package functional.support;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Provides a declarative mechanism for using PageObject @FindBy annotations for
 * a dynamic parent element.
 *
 * The @FindBy annotation will be executed from the given element held in the
 * field referenced by the {@link #field()} property.
 *
 * The {@linkplain #field()} must refer to a field within the same class which
 * contains the WebElement that should be used as the parent for the finders.
 *
 * The parent field may also utilise the @FindBy annotation. If the perent
 * element is set dynamically, by a factory for example, then the field should
 * be marked with the {@link ParentRef} annotation, to prevent the field being
 * incorrectly wired.
 *
 * For an example, see au.com.permeance.selenium.glue.CompoundWidgetPage
 *
 * {@link ParentElement} should only be applied to PageObjects, when using
 * composition over inheritance. Legacy implementation supported the annotation
 * of WebElements, but this has since been deprecated and references should be
 * updated.
 *
 *
 * If you are using spring import {@link RelativeFinderModuleConfig} in your
 * configuration to have everything wired up as required. For an example of how
 * to do that, see au.com.permeance.selenium.config.ModuleTestConfig
 *
 *
 * @author tim.myerscough
 *
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(value = { ElementType.FIELD })
public @interface ParentElement {

	/**
	 * The field in the enclosing class which contains the parent element that
	 * should be used as a parent for the finder.
	 *
	 * @return
	 */
	String field();
}
