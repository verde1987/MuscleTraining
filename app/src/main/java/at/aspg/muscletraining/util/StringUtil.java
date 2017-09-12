package at.aspg.muscletraining.util;

import java.util.Iterator;

/**
 * A utility class that consists solely of static methods that can be used for operating
 * on {@link String}s.
 */
public class StringUtil {
	
	/**
	 * Creates a single String by concatenating the items in the specified Iterable using
	 * the specified String as delimiter. On each item, the {@link Object#toString()}
	 * method is invoked.
	 * <p>
	 * Given the items {A, B, ..., M, N}, the following String will be created: {@code
	 * AxBx...MxN} where {@code x} is the specified delimiter.
	 *
	 * @param items     the items to concatenate into a single String using the specified
	 *                  delimiter
	 * @param delimiter the String to separate individual items
	 * @param <T>       the type of the items
	 * @return a single String by concatenating the items in the specified Iterable using
	 * the specified delimiter
	 */
	public static <T> String join(Iterable<T> items, String delimiter) {
		StringBuilder sb = new StringBuilder();
		Iterator<T> iter = items.iterator();
		while (iter.hasNext()) {
			T next = iter.next();
			sb.append(next);
			if (iter.hasNext()) {
				sb.append(delimiter);
			}
		}
		return sb.toString();
	}
	
}
