package at.aspg.muscletraining;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import at.aspg.muscletraining.util.ObjectUtil;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class ObjectUtilTest {
	
	private final Object nullObject = null;
	private final Object nonNullObject = new Object();
	private final String nonNullString = "test";
	private final Object[] nullArray = null;
	private final Object[] nonNullEmptyArray = new Object[0];
	private final String[] nonNullStringArrayWithNullElements = { nonNullString, null };
	private final String[] nonNullStringArrayWithoutNullElements = { nonNullString, nonNullString };
	private final List<Object> nullList = null;
	private final List<Object> nonNullEmptyList = Collections.emptyList();
	private final List<String> nonNullStringListWithNullElements = Arrays.asList(nonNullString, null);
	private final List<String> nonNullStringListWithoutNullElements = Arrays.asList(nonNullString, nonNullString);
	private final Set<String> nonNullStringSetWithNullElements = new HashSet<>(nonNullStringListWithNullElements);
	private final Set<String> nonNullStringSetWithoutNullElements = new HashSet<>(nonNullStringListWithoutNullElements);
	
	// tests for requireNonNull with return value
	
	@Test(expected = NullPointerException.class)
	public void testRequireNonNullWithReturnFail() {
		ObjectUtil.requireNonNull(nullObject);
	}
	
	@Test
	public void testRequireNonNullWithReturn1() {
		String actual = ObjectUtil.requireNonNull(nonNullString);
		assertEquals(nonNullString, actual);
	}
	
	@Test
	public void testRequireNonNullWithReturn2() {
		Object[] actual = ObjectUtil.requireNonNull(nonNullEmptyArray);
		assertArrayEquals(nonNullEmptyArray, actual);
	}
	
	@Test
	public void testRequireNonNullWithReturn3() {
		String[] actual = ObjectUtil.requireNonNull(nonNullStringArrayWithNullElements);
		assertArrayEquals(nonNullStringArrayWithNullElements, actual);
	}
	
	// tests for requireNonNull for multiple arguments (no return value)
	
	@Test(expected = NullPointerException.class)
	public void testRequireNonNullMultipleArgumentsFail1() {
		ObjectUtil.requireNonNull(nullObject, nullObject);
	}
	
	@Test(expected = NullPointerException.class)
	public void testRequireNonNullMultipleArgumentsFail2() {
		ObjectUtil.requireNonNull(nonNullString, nonNullObject, nullObject);
	}
	
	@Test(expected = NullPointerException.class)
	public void testRequireNonNullMultipleArgumentsFail3() {
		ObjectUtil.requireNonNull(nullObject, nonNullObject);
	}
	
	@Test
	public void testRequireNonNullMultipleArguments1() {
		ObjectUtil.requireNonNull(nonNullString, nonNullObject);
	}
	
	@Test
	public void testRequireNonNullMultipleArguments2() {
		ObjectUtil.requireNonNull(nonNullEmptyArray, nonNullObject, nonNullStringArrayWithNullElements);
	}
	
	// tests for requireNonNullArray
	
	@Test(expected = NullPointerException.class)
	public void testRequireNonNullArrayFail1() {
		ObjectUtil.requireNonNullArray(nullArray);
	}
	
	@Test(expected = NullPointerException.class)
	public void testRequireNonNullArrayFail2() {
		ObjectUtil.requireNonNullArray(nonNullStringArrayWithNullElements);
	}
	
	@Test
	public void testRequireNonNullArray1() {
		Object[] actual = ObjectUtil.requireNonNullArray(nonNullEmptyArray);
		assertArrayEquals(nonNullEmptyArray, actual);
	}
	
	@Test
	public void testRequireNonNullArray2() {
		String[] actual = ObjectUtil.requireNonNullArray(nonNullStringArrayWithoutNullElements);
		assertArrayEquals(nonNullStringArrayWithoutNullElements, actual);
	}
	
	// tests for requireNonNullCollection
	
	@Test(expected = NullPointerException.class)
	public void testRequireNonNullCollectionFail1() {
		ObjectUtil.requireNonNullCollection(nullList);
	}
	
	@Test(expected = NullPointerException.class)
	public void testRequireNonNullCollectionFail2() {
		ObjectUtil.requireNonNullCollection(nonNullStringListWithNullElements);
	}
	
	@Test(expected = NullPointerException.class)
	public void testRequireNonNullCollectionFail3() {
		ObjectUtil.requireNonNullCollection(nonNullStringSetWithNullElements);
	}
	
	@Test
	public void testRequireNonNullCollection1() {
		List<Object> actual = ObjectUtil.requireNonNullCollection(nonNullEmptyList);
		assertEquals(nonNullEmptyList, actual);
	}
	
	@Test
	public void testRequireNonNullCollection2() {
		List<String> actual = ObjectUtil.requireNonNullCollection(nonNullStringListWithoutNullElements);
		assertEquals(nonNullStringListWithoutNullElements, actual);
	}
	
	@Test
	public void testRequireNonNullCollection3() {
		Set<String> actual = ObjectUtil.requireNonNullCollection(nonNullStringSetWithoutNullElements);
		assertEquals(nonNullStringSetWithoutNullElements, actual);
	}
	
}
