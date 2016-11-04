package functional.support;

import java.lang.reflect.Field;

import org.openqa.selenium.support.pagefactory.DefaultFieldDecorator;
import org.openqa.selenium.support.pagefactory.ElementLocatorFactory;

public class ParentRefExclusionFieldDecorator extends DefaultFieldDecorator {

	public ParentRefExclusionFieldDecorator(final ElementLocatorFactory factory) {
		super(factory);
	}

	@Override
	public Object decorate(final ClassLoader loader, final Field field) {
		if (field.isAnnotationPresent(ParentRef.class)) {
			return null;
		}
		return super.decorate(loader, field);
	}

}
