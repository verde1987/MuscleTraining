package at.aspg.muscletraining;

import android.content.Context;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.EnumSet;
import java.util.List;

import at.aspg.muscletraining.data.IMuscleRegion;
import at.aspg.muscletraining.data.MuscleRegion;
import at.aspg.muscletraining.data.SubMuscleRegion;
import at.aspg.muscletraining.data.exercises.WeightRepsExercise;
import at.aspg.muscletraining.util.AndroidUtil;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

public class TestExercise {

	@Mock
	Context mockContext;
	
	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		AndroidUtil.setContext(mockContext);
		defineMockContext();
	}
	
	private void defineMockContext() {
		when(mockContext.getString(R.string.default_exercise)).thenReturn("Default Exercise");
	}
	
	@Test
	public void testWeightRepsExercise() {
		WeightRepsExercise exercise = new WeightRepsExercise();
		exercise.setName("TestName");
		exercise.setDescription("TestDescription");
		exercise.setPrimaryMuscleRegions(Arrays.<IMuscleRegion>asList(MuscleRegion.SHOULDERS));
		exercise.setSecondaryMuscleRegions(Arrays.<IMuscleRegion>asList(SubMuscleRegion.SHOULDER1, SubMuscleRegion.SHOULDER2));
		exercise.setWeight(50);
		exercise.setBreakTime(20);
		exercise.setReps(10);
		exercise.setSets(3);
		
		assertEquals("TestName", exercise.getName());
		assertEquals("TestDescription", exercise.getDescription());
		assertEquals(50, exercise.getWeight(), 0.002);
		assertEquals(20, exercise.getBreakTime());
		assertEquals(10, exercise.getReps());
		assertEquals(3, exercise.getSets());
		
		assertListEquals(Arrays.<IMuscleRegion>asList(MuscleRegion.SHOULDERS), exercise.getPrimaryMuscleRegions());
		assertListEquals(Arrays.<IMuscleRegion>asList(SubMuscleRegion.SHOULDER1, SubMuscleRegion.SHOULDER2), exercise.getSecondaryMuscleRegions());
//		assertEquals(Arrays.<IMuscleRegion>asList(SubMuscleRegion.SHOULDER2), exercise.getPrimaryMuscleRegions());
	}
	
	private void assertListEquals(List<IMuscleRegion> iMuscleRegions, Collection<IMuscleRegion> secondaryMuscleRegions) {
		secondaryMuscleRegions.retainAll(secondaryMuscleRegions);
		
		assertEquals(iMuscleRegions.size(), secondaryMuscleRegions.size());
		
	}
	
	@Test
	public void testRepsExercise() {
		
	}
	
}
