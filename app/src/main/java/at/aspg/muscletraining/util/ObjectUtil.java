package at.aspg.muscletraining.util;

public class ObjectUtil {
	
	// copied from java.util.Objects due to API restrictions
	/**
	 * Checks that the specified object is not {@code null} and returns the same object
	 * again if it is not {@code null}. This method is designed primarily for doing
	 * parameter validation in methods and constructors, as demonstrated below:
	 * <pre>
	 * public Foo(Bar bar) {
	 *     this.bar = ObjectUtil.requireNonNull(bar);
	 * }
	 * </pre>
	 *
	 * @param object the object to check for {@code null}
	 * @param <T>    the type of the object
	 * @return {@code object} if not {@code null}
	 * @throws NullPointerException if {@code object} is {@code null}
	 */
	public static <T> T requireNonNull(T object) {
		if (object == null) {
			throw new NullPointerException();
		}
		return object;
	}
	
	/**
	 * Checks that the specified objects are not {@code null}. This method is designed for
	 * conveniently performing {@code null}-checks for multiple parameters in methods and
	 * constructors, as demonstrated below:
	 * <pre>
	 * public Foo(Bar bar, Baz baz) {
	 *     ObjectUtil.requireNonNull(bar, baz);
	 * }
	 * </pre>
	 *
	 * @param objects the objects to check for {@code null}
	 * @throws NullPointerException if any of the objects is {@code null}
	 */
	public static void requireNonNull(Object... objects) {
		for (Object o : objects) {
			if (o == null) {
				throw new NullPointerException();
			}
		}
	}
	
}
