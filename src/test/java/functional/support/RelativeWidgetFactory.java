package functional.support;

import org.openqa.selenium.WebElement;

/**
 * @author tim.myerscough
 *
 * @param <T>
 *            The type created by this factory.
 * @deprecated This class is not longer required.
 */
@Deprecated
public interface RelativeWidgetFactory<T> {
	T forParent(final WebElement parent);
}
