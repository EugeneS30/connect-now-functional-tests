package functional.support;

import java.lang.reflect.Field;

import lombok.RequiredArgsConstructor;

import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.pagefactory.FieldDecorator;

/**
 * Decorates WebElement fields annotated with @ParentRef with the given
 * SearchContext.
 *
 * If the SearchContext is not a WebElement, the parentRef will be ignored,
 * since it is assumed that it is populated by another means.
 *
 * @author tim.myerscough
 *
 */
@RequiredArgsConstructor
public class ParentRefFieldDecorator implements FieldDecorator {

	private final SearchContext context;

	@Override
	public Object decorate(final ClassLoader loader, final Field field) {

		if (fieldHasParentRefAnnotation(field) && hasWebElementContext()) {
			WebElement element = (WebElement) context;
			return element;
		}

		return null;
	}

	private boolean hasWebElementContext() {
		return context instanceof WebElement;
	}

	private boolean fieldHasParentRefAnnotation(final Field field) {
		return field.isAnnotationPresent(ParentRef.class);
	}

}