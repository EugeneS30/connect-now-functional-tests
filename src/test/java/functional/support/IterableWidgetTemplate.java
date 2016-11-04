package functional.support;

import java.util.Iterator;
import java.util.List;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

import javax.inject.Inject;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ResolvableType;

public abstract class IterableWidgetTemplate<T> implements Iterable<T> {
	protected abstract List<WebElement> getItems();

	/**
	 * Refactoring to use PageObjectWidgetFactory *should* mean that this is no
	 * longer required.
	 */
	@Autowired(required = false)
	@Deprecated
	private RelativeWidgetFactory<T> item;

	@Inject
	private PageObjectWidgetFactory powFactory;

	@Inject
	private FluentWait<WebDriver> wait;

	@Override
	public Iterator<T> iterator() {
		return new ItemIterator();
	}

	public Stream<T> stream() {
		return StreamSupport.stream(spliterator(), false);
	}

	public int size() {
		try {
			return getItems().size();
		} catch (NoSuchElementException e) {
			return 0;
		}
	}

	protected T createItem(final WebElement next) {
		if (item != null) {
			// legacy code
			return item.forParent(next);
		} else {

			Class<T> itemType = getGenericType();
			return powFactory.create(itemType, next);
		}
	}

	/**
	 * This method gets the actual type of the generic <T> parameter.
	 *
	 * @return
	 */
	private Class<T> getGenericType() {

		Class<T> genericType = getIterableGenericTypeFromHierarchy(ResolvableType.forType(this.getClass()));

		if (genericType == null) {
			// No generic class has been found
			throw new NoSuchElementException("No generic type found");
		}

		return genericType;

	}

	@SuppressWarnings("unchecked")
	private Class<T> getIterableGenericTypeFromHierarchy(final ResolvableType type) {

		if (type.getRawClass().equals(IterableWidgetTemplate.class)) {
			return (Class<T>) type.getGeneric().resolve();
		} else {
			return getIterableGenericTypeFromHierarchy(type.getSuperType());
		}

	}

	private class ItemIterator implements Iterator<T> {

		// Use the index into the list of rows, rather than a wrapped iterator,
		// since the elements may become stale during iteration.
		int currentIdx = 0;

		@Override
		public boolean hasNext() {
			try {

				return getItems().size() > currentIdx;
			} catch (NoSuchElementException e) {
				return false;
			}
		}

		private T currentItem = null;

		@Override
		public T next() {
			int nextIdx = currentIdx++;

			// Ewwwww!
			wait.until(ExpectedConditions.not(ExpectedConditions.stalenessOf(getItems().get(nextIdx))));
			currentItem = createItem(getItems().get(nextIdx));
			return currentItem;
		}

		@Override
		public void remove() {

			if (currentItem instanceof Removable) {
				Removable item = (Removable) currentItem;
				item.remove();
				currentIdx--;

			} else {
				String msg = String.format("%s does not implement %s.  Items cannot be removed.",
						currentItem.getClass(), Removable.class);
				throw new UnsupportedOperationException(msg);
			}

		}

	}

}
