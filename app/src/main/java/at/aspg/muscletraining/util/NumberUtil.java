package at.aspg.muscletraining.util;

public class NumberUtil {
	
	/**
	 * Checks whether the given integer {@code toCheck} is in between the specified
	 * boundaries (inclusive), i.e., whether {@code lowerBound} &le; {@code toCheck} &le;
	 * {@code upperBound}. This method is designed primarily for doing integer parameter
	 * validation in methods and constructors, as demonstrated below:
	 * <pre>
	 * public Foo(int i) {
	 *     this.i = NumberUtil.checkRange(i, 1, 100);
	 * }
	 * </pre>
	 * In case {@code lowerBound > upperBound} (or vice versa), the bounds are internally
	 * swapped to retain the correct order.
	 *
	 * @param toCheck    the integer to check
	 * @param lowerBound the lower bound (inclusive)
	 * @param upperBound the upper bound (inclusive)
	 * @return {@code toCheck} if the integer is in between the specified boundaries
	 * @throws IllegalArgumentException if {@code toCheck} lies outside the specified
	 *                                  boundaries
	 */
	public static int checkRange(int toCheck, int lowerBound, int upperBound) {
		int actualLowerBound = Math.min(lowerBound, upperBound);
		int actualUpperBound = Math.max(lowerBound, upperBound);
		checkRangeLowerBound(toCheck, actualLowerBound);
		checkRangeUpperBound(toCheck, actualUpperBound);
		return toCheck;
	}
	
	/**
	 * Checks whether the given integer {@code toCheck} is greater than or equal to {@code
	 * lowerBound}, i.e., whether {@code lowerBound} &le; {@code toCheck}. This method is
	 * designed primarily for doing integer parameter validation in methods and
	 * constructors, as demonstrated below:
	 * <pre>
	 * public Foo(int i) {
	 *     this.i = NumberUtil.checkRangeLowerBound(i, 0);
	 * }
	 * </pre>
	 *
	 * @param toCheck    the integer to check
	 * @param lowerBound the lower bound (inclusive)
	 * @return {@code toCheck} if the integer is greater than or equal to {@code
	 * lowerBound}
	 * @throws IllegalArgumentException if {@code toCheck < lowerBound}
	 */
	public static int checkRangeLowerBound(int toCheck, int lowerBound) {
		if (toCheck < lowerBound) {
			throw new IllegalArgumentException("toCheck is < lowerBound");
		}
		return toCheck;
	}
	
	/**
	 * Checks whether the given integer {@code toCheck} is less than or equal to {@code
	 * upperBound}, i.e., whether {@code toCheck} &le; {@code upperBound}. This method is
	 * designed primarily for doing integer parameter validation in methods and
	 * constructors, as demonstrated below:
	 * <pre>
	 * public Foo(int i) {
	 *     this.i = NumberUtil.checkRangeUpperBound(i, 100);
	 * }
	 * </pre>
	 *
	 * @param toCheck    the integer to check
	 * @param upperBound the upper bound (inclusive)
	 * @return {@code toCheck} if the integer is less than or equal to {@code upperBound}
	 * @throws IllegalArgumentException if {@code toCheck > upperBound}
	 */
	public static int checkRangeUpperBound(int toCheck, int upperBound) {
		if (toCheck > upperBound) {
			throw new IllegalArgumentException("toCheck is > upperBound");
		}
		return toCheck;
	}
	
	/**
	 * Checks whether the given double {@code toCheck} is in between the specified
	 * boundaries (inclusive), i.e., whether {@code lowerBound} &le; {@code toCheck} &le;
	 * {@code upperBound}. This method is designed primarily for doing double parameter
	 * validation in methods and constructors, as demonstrated below:
	 * <pre>
	 * public Foo(double d) {
	 *     this.d = NumberUtil.checkRange(d, 0.0, 1.0);
	 * }
	 * </pre>
	 * In case {@code lowerBound > upperBound} (or vice versa), the bounds are internally
	 * swapped to retain the correct order.
	 *
	 * @param toCheck    the double to check
	 * @param lowerBound the lower bound (inclusive)
	 * @param upperBound the upper bound (inclusive)
	 * @return {@code toCheck} if the double is in between the specified boundaries
	 * @throws IllegalArgumentException if {@code toCheck} lies outside the specified
	 *                                  boundaries
	 */
	public static double checkRange(double toCheck, double lowerBound, double upperBound) {
		double actualLowerBound = Math.min(lowerBound, upperBound);
		double actualUpperBound = Math.max(lowerBound, upperBound);
		checkRangeLowerBound(toCheck, actualLowerBound);
		checkRangeUpperBound(toCheck, actualUpperBound);
		return toCheck;
	}
	
	/**
	 * Checks whether the given double {@code toCheck} is greater than or equal to {@code
	 * lowerBound}, i.e., whether {@code lowerBound} &le; {@code toCheck}. This method is
	 * designed primarily for doing double parameter validation in methods and
	 * constructors, as demonstrated below:
	 * <pre>
	 * public Foo(double d) {
	 *     this.d = NumberUtil.checkRangeLowerBound(d, 0.0);
	 * }
	 * </pre>
	 *
	 * @param toCheck    the double to check
	 * @param lowerBound the lower bound (inclusive)
	 * @return {@code toCheck} if the double is greater than or equal to {@code
	 * lowerBound}
	 * @throws IllegalArgumentException if {@code toCheck < lowerBound}
	 */
	public static double checkRangeLowerBound(double toCheck, double lowerBound) {
		if (toCheck < lowerBound) {
			throw new IllegalArgumentException("toCheck is < lowerBound");
		}
		return toCheck;
	}
	
	/**
	 * Checks whether the given double {@code toCheck} is less than or equal to {@code
	 * upperBound}, i.e., whether {@code toCheck} &le; {@code upperBound}. This method is
	 * designed primarily for doing double parameter validation in methods and
	 * constructors, as demonstrated below:
	 * <pre>
	 * public Foo(double d) {
	 *     this.d = NumberUtil.checkRangeUpperBound(d, 1.0);
	 * }
	 * </pre>
	 *
	 * @param toCheck    the double to check
	 * @param upperBound the upper bound (inclusive)
	 * @return {@code toCheck} if the double is less than or equal to {@code upperBound}
	 * @throws IllegalArgumentException if {@code toCheck > upperBound}
	 */
	public static double checkRangeUpperBound(double toCheck, double upperBound) {
		if (toCheck > upperBound) {
			throw new IllegalArgumentException("toCheck is > upperBound");
		}
		return toCheck;
	}
	
}
