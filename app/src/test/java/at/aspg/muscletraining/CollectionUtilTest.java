package at.aspg.muscletraining;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import at.aspg.muscletraining.util.CollectionUtil;

import static org.junit.Assert.assertEquals;

public class CollectionUtilTest {
	
	private final List<Integer> originalList = Collections.unmodifiableList(Arrays.asList(1, 2, 3, 4, 5));
	private List<Integer> list;
	
	@Before
	public void initialize() {
		list = new ArrayList<>(originalList);
	}
	
	// tests for swap
	
	@Test(expected = NullPointerException.class)
	public void testSwapInvalidListNull() {
		CollectionUtil.swap(null, 0, 0);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testSwapInvalidListTooSmall() {
		CollectionUtil.swap(Collections.emptyList(), 0, 0);
	}
	
	@Test(expected = IndexOutOfBoundsException.class)
	public void testSwapInvalidFromTooSmall() {
		CollectionUtil.swap(list, -1, 0);
	}
	
	@Test(expected = IndexOutOfBoundsException.class)
	public void testSwapInvalidFromTooLarge() {
		CollectionUtil.swap(list, list.size(), 0);
	}
	
	@Test(expected = IndexOutOfBoundsException.class)
	public void testSwapInvalidToTooSmall() {
		CollectionUtil.swap(list, 0, -1);
	}
	
	@Test(expected = IndexOutOfBoundsException.class)
	public void testSwapInvalidToTooLarge() {
		CollectionUtil.swap(list, 0, list.size());
	}
	
	@Test(expected = IndexOutOfBoundsException.class)
	public void testSwapInvalidBothIndexesWrong() {
		CollectionUtil.swap(list, -1, -1);
	}
	
	@Test
	public void testSwapSameIndexes() {
		CollectionUtil.swap(list, 0, 0);
		assertEquals(originalList, list);
	}
	
	@Test
	public void testSwap1() {
		CollectionUtil.swap(list, 0, 1);
		assertEquals(Arrays.asList(2, 1, 3, 4, 5), list);
	}
	
	@Test
	public void testSwap2() {
		CollectionUtil.swap(list, 1, 4);
		assertEquals(Arrays.asList(1, 5, 3, 4, 2), list);
	}
	
	@Test
	public void testSwapToSmallerThanFrom1() {
		CollectionUtil.swap(list, 1, 0);
		assertEquals(Arrays.asList(2, 1, 3, 4, 5), list);
	}
	
	@Test
	public void testSwapToSmallerThanFrom2() {
		CollectionUtil.swap(list, 4, 1);
		assertEquals(Arrays.asList(1, 5, 3, 4, 2), list);
	}
	
	// tests for shift
	
	@Test(expected = NullPointerException.class)
	public void testShiftInvalidListNull() {
		CollectionUtil.shift(null, 0, 0);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testShiftInvalidListTooSmall() {
		CollectionUtil.shift(Collections.emptyList(), 0, 0);
	}
	
	@Test(expected = IndexOutOfBoundsException.class)
	public void testShiftInvalidFromTooSmall() {
		CollectionUtil.shift(list, -1, 0);
	}
	
	@Test(expected = IndexOutOfBoundsException.class)
	public void testShiftInvalidFromTooLarge() {
		CollectionUtil.shift(list, list.size(), 0);
	}
	
	@Test(expected = IndexOutOfBoundsException.class)
	public void testShiftInvalidToTooSmall() {
		CollectionUtil.shift(list, 0, -1);
	}
	
	@Test(expected = IndexOutOfBoundsException.class)
	public void testShiftInvalidToTooLarge() {
		CollectionUtil.shift(list, 0, list.size() + 1);
	}
	
	@Test(expected = IndexOutOfBoundsException.class)
	public void testShiftInvalidBothIndexesWrong() {
		CollectionUtil.shift(list, -1, -1);
	}
	
	@Test
	public void testShiftSameIndexes() {
		CollectionUtil.shift(list, 0, 0);
		assertEquals(originalList, list);
	}
	
	@Test
	public void testShift1() {
		CollectionUtil.shift(list, 0, 1);
		assertEquals(originalList, list);
	}
	
	@Test
	public void testShift2() {
		CollectionUtil.shift(list, 1, 4);
		assertEquals(Arrays.asList(1, 3, 4, 2, 5), list);
	}
	
	@Test
	public void testShift3() {
		CollectionUtil.shift(list, 1, list.size());
		assertEquals(Arrays.asList(1, 3, 4, 5, 2), list);
	}
	
	@Test
	public void testShiftToSmallerThanFrom1() {
		CollectionUtil.shift(list, 1, 0);
		assertEquals(Arrays.asList(2, 1, 3, 4, 5), list);
	}
	
	@Test
	public void testShiftToSmallerThanFrom2() {
		CollectionUtil.shift(list, 4, 1);
		assertEquals(Arrays.asList(1, 5, 2, 3, 4), list);
	}
	
	@Test
	public void testShiftToSmallerThanFrom3() {
		CollectionUtil.shift(list, 3, 0);
		assertEquals(Arrays.asList(4, 1, 2, 3, 5), list);
	}
	
}
