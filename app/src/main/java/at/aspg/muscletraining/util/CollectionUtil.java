package at.aspg.muscletraining.util;

import java.util.List;

public class CollectionUtil {
	
	/**
	 * Swaps two items in the given list, specified by their indexes {@code from} and
	 * {@code to}. Swapping items with {@code from == to} has no effect.
	 *
	 * @param list the list in which the items will be swapped
	 * @param from the index of the item which will be swapped with the item at index
	 *             {@code to}
	 * @param to   the index of the item which will be swapped with the item at index
	 *             {@code from}
	 * @param <T>  the type of the list elements
	 * @throws IllegalArgumentException  if the list does not contain at least two items
	 * @throws IndexOutOfBoundsException if either {@code from} or {@code to} are outside
	 *                                   the valid index range of the given list
	 */
	public static <T> void swap(List<T> list, int from, int to) {
		ObjectUtil.requireNonNull(list);
		if (list.size() < 2) {
			throw new IllegalArgumentException("the list must contain at least 2 items");
		}
		if (from < 0 || from >= list.size() || to < 0 || to >= list.size()) {
			throw new IndexOutOfBoundsException();
		}
		T itemFrom = list.get(from);
		T itemTo = list.get(to);
		list.set(to, itemFrom);
		list.set(from, itemTo);
	}
	
	/**
	 * Shifts an item specified by index {@code from} in the given list to the specified
	 * index {@code to}. All other elements in the list are shifted accordingly. Shifting
	 * items with {@code from == to} or with {@code from + 1 == to} has no effect.
	 *
	 * @param list the list in which the item will be shifted
	 * @param from the index of the item which will be shifted to position {@code to}
	 * @param to   the new index of the item at previous index {@code from}
	 * @param <T>  the type of the list elements
	 * @throws IllegalArgumentException  if the list does not contain at least two items
	 * @throws IndexOutOfBoundsException if either {@code from} or {@code to} are outside
	 *                                   the valid index range of the given list, however,
	 *                                   {@code to} may be equal to the size of the list
	 *                                   in case the item should be shifted to the end of
	 *                                   the list
	 */
	public static <T> void shift(List<T> list, int from, int to) {
		ObjectUtil.requireNonNull(list);
		if (list.size() < 2) {
			throw new IllegalArgumentException("the list must contain at least 2 items");
		}
		if (from < 0 || from >= list.size() || to < 0 || to > list.size()) {
			throw new IndexOutOfBoundsException();
		}
		T itemFrom = list.get(from);
		list.add(to, itemFrom);
		if (to < from) {
			from++;
		}
		list.remove(from);
	}
	
}
