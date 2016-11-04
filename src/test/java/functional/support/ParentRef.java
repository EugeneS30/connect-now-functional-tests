package functional.support;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Marker annotation to indicate that an element is used as a parent element for
 * another field.
 *
 * The element is volatile, liable to change and should not be proxied.
 *
 * @author tim.myerscough
 *
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(value = { ElementType.FIELD })
public @interface ParentRef {

}
