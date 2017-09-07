package at.aspg.muscletraining.util;

import java.util.Iterator;

public class StringUtil {
	
	// TODO: doc
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
