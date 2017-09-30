package at.aspg.muscletraining;

import org.junit.Test;

import at.aspg.muscletraining.util.NumberUtil;

import static org.junit.Assert.assertEquals;

public class NumberUtilTest {
	
	private static final double DELTA = 1E-5;
	
	// integer-based methods
	
	@Test(expected = IllegalArgumentException.class)
	public void testCheckRangeLowerBoundIntegerFail1() {
		NumberUtil.checkRangeLowerBound(0, 1);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testCheckRangeLowerBoundIntegerFail2() {
		NumberUtil.checkRangeLowerBound(-100, 0);
	}
	
	@Test
	public void testCheckRangeLowerBoundIntegerSameNumber() {
		final int expected = 0;
		int actual = NumberUtil.checkRangeLowerBound(expected, expected);
		assertEquals(expected, actual);
	}
	
	@Test
	public void testCheckRangeLowerBoundInteger1() {
		final int expected = 100;
		int actual = NumberUtil.checkRangeLowerBound(expected, 0);
		assertEquals(expected, actual);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testCheckRangeUpperBoundIntegerFail1() {
		NumberUtil.checkRangeUpperBound(1, 0);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testCheckRangeUpperBoundIntegerFail2() {
		NumberUtil.checkRangeUpperBound(100, 1);
	}
	
	@Test
	public void testCheckRangeUpperBoundIntegerSameNumber() {
		final int expected = 0;
		int actual = NumberUtil.checkRangeUpperBound(expected, expected);
		assertEquals(expected, actual);
	}
	
	@Test
	public void testCheckRangeUpperBoundInteger1() {
		final int expected = 1;
		int actual = NumberUtil.checkRangeUpperBound(expected, 100);
		assertEquals(expected, actual);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testCheckRangeIntegerFail1() {
		NumberUtil.checkRange(0, 1, 100);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testCheckRangeIntegerFail2() {
		NumberUtil.checkRange(-100, 0, 1);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testCheckRangeIntegerFail3() {
		NumberUtil.checkRange(100, 0, 1);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testCheckRangeIntegerFailSwappedBoundaries() {
		NumberUtil.checkRange(100, 1, 0);
	}
	
	@Test
	public void testCheckRangeIntegerSameNumber() {
		final int expected = 0;
		int actual = NumberUtil.checkRange(expected, expected, expected);
		assertEquals(expected, actual);
	}
	
	@Test
	public void testCheckRangeInteger1() {
		final int expected = 100;
		int actual = NumberUtil.checkRange(expected, 0, 100);
		assertEquals(expected, actual);
	}
	
	@Test
	public void testCheckRangeInteger2() {
		final int expected = 0;
		int actual = NumberUtil.checkRange(expected, 0, 100);
		assertEquals(expected, actual);
	}
	
	@Test
	public void testCheckRangeInteger3() {
		final int expected = 50;
		int actual = NumberUtil.checkRange(expected, 0, 100);
		assertEquals(expected, actual);
	}
	
	@Test
	public void testCheckRangeIntegerSwappedBoundaries() {
		final int expected = 50;
		int actual = NumberUtil.checkRange(expected, 100, 0);
		assertEquals(expected, actual);
	}
	
	// double-based methods
	
	@Test(expected = IllegalArgumentException.class)
	public void testCheckRangeLowerBoundDoubleFail1() {
		NumberUtil.checkRangeLowerBound(0., 1.);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testCheckRangeLowerBoundDoubleFail2() {
		NumberUtil.checkRangeLowerBound(-100., 0.);
	}
	
	@Test
	public void testCheckRangeLowerBoundDoubleSameNumber() {
		final double expected = 0;
		double actual = NumberUtil.checkRangeLowerBound(expected, expected);
		assertEquals(expected, actual, DELTA);
	}
	
	@Test
	public void testCheckRangeLowerBoundDouble1() {
		final double expected = 100;
		double actual = NumberUtil.checkRangeLowerBound(expected, 0);
		assertEquals(expected, actual, DELTA);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testCheckRangeUpperBoundDoubleFail1() {
		NumberUtil.checkRangeUpperBound(1., 0.);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testCheckRangeUpperBoundDoubleFail2() {
		NumberUtil.checkRangeUpperBound(100., 1.);
	}
	
	@Test
	public void testCheckRangeUpperBoundDoubleSameNumber() {
		final double expected = 0;
		double actual = NumberUtil.checkRangeUpperBound(expected, expected);
		assertEquals(expected, actual, DELTA);
	}
	
	@Test
	public void testCheckRangeUpperBoundDouble1() {
		final double expected = 1;
		double actual = NumberUtil.checkRangeUpperBound(expected, 100);
		assertEquals(expected, actual, DELTA);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testCheckRangeDoubleFail1() {
		NumberUtil.checkRange(0., 1., 100.);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testCheckRangeDoubleFail2() {
		NumberUtil.checkRange(-100., 0., 1.);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testCheckRangeDoubleFail3() {
		NumberUtil.checkRange(100., 0., 1.);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testCheckRangeDoubleFailSwappedBoundaries() {
		NumberUtil.checkRange(100., 1., 0.);
	}
	
	@Test
	public void testCheckRangeDoubleSameNumber() {
		final double expected = 0;
		double actual = NumberUtil.checkRange(expected, expected, expected);
		assertEquals(expected, actual, DELTA);
	}
	
	@Test
	public void testCheckRangeDouble1() {
		final double expected = 100;
		double actual = NumberUtil.checkRange(expected, 0, 100);
		assertEquals(expected, actual, DELTA);
	}
	
	@Test
	public void testCheckRangeDouble2() {
		final double expected = 0;
		double actual = NumberUtil.checkRange(expected, 0, 100);
		assertEquals(expected, actual, DELTA);
	}
	
	@Test
	public void testCheckRangeDouble3() {
		final double expected = 50;
		double actual = NumberUtil.checkRange(expected, 0, 100);
		assertEquals(expected, actual, DELTA);
	}
	
	@Test
	public void testCheckRangeDoubleSwappedBoundaries() {
		final double expected = 50;
		double actual = NumberUtil.checkRange(expected, 100, 0);
		assertEquals(expected, actual, DELTA);
	}
	
}
