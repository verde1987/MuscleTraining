package at.aspg.muscletraining;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import at.aspg.muscletraining.data.IMuscleRegion;
import at.aspg.muscletraining.data.MuscleRegion;
import at.aspg.muscletraining.data.exercises.WeightRepsExercise;
import edu.emory.mathcs.backport.java.util.Collections;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class TestExercise extends AbstractUnitTest {
	
	private static final double DELTA = 1E-5;
	
	private WeightRepsExercise weightRepsExercise;
	
	@Before
	public void initialize() {
		weightRepsExercise = new WeightRepsExercise();
		weightRepsExercise.setName("TestName");
		weightRepsExercise.setDescription("TestDescription");
		weightRepsExercise.addPrimaryMuscleRegions(MuscleRegion.SHOULDERS);
		weightRepsExercise.addSecondaryMuscleRegions(MuscleRegion.SHOULDERS.getSpecials().toArray(new IMuscleRegion[0]));
		weightRepsExercise.setWeight(50);
		weightRepsExercise.setBreakTime(20);
		weightRepsExercise.setReps(10);
		weightRepsExercise.setSets(3);
	}
	
	@Test
	public void testCopyWeightRepsExercise() {
		WeightRepsExercise copy = weightRepsExercise.copy();
		assertEquals(weightRepsExercise, copy);
	}
	
	@Test
	public void testCopyWeightRepsExerciseChangeCopy1() {
		WeightRepsExercise copy = weightRepsExercise.copy();
		copy.setName("newName");
		assertNotEquals(weightRepsExercise, copy);
		assertEquals("TestName", weightRepsExercise.getName());
		assertEquals("newName", copy.getName());
		copy.setName(weightRepsExercise.getName());
		assertEquals(weightRepsExercise, copy);
	}
	
	@Test
	public void testCopyWeightRepsExerciseChangeCopy2() {
		WeightRepsExercise copy = weightRepsExercise.copy();
		copy.getPrimaryMuscleRegions().clear();
		assertNotEquals(weightRepsExercise, copy);
		assertEquals(Collections.singletonList(MuscleRegion.SHOULDERS), weightRepsExercise.getPrimaryMuscleRegions());
		assertEquals(Collections.emptyList(), copy.getPrimaryMuscleRegions());
	}
	
	@Test
	public void testCopyWeightRepsExerciseChangeCopy3() {
		WeightRepsExercise copy = weightRepsExercise.copy();
		copy.addPrimaryMuscleRegions(MuscleRegion.ABS);
		assertNotEquals(weightRepsExercise, copy);
		assertEquals(Collections.singletonList(MuscleRegion.SHOULDERS), weightRepsExercise.getPrimaryMuscleRegions());
		assertEquals(Arrays.asList(MuscleRegion.SHOULDERS, MuscleRegion.ABS), copy.getPrimaryMuscleRegions());
	}
	
	@Test
	public void testWeightRepsExercise() {
		assertEquals("TestName", weightRepsExercise.getName());
		assertEquals("TestDescription", weightRepsExercise.getDescription());
		assertEquals(50, weightRepsExercise.getWeight(), DELTA);
		assertEquals(20, weightRepsExercise.getBreakTime());
		assertEquals(10, weightRepsExercise.getReps());
		assertEquals(3, weightRepsExercise.getSets());
		assertEquals(Collections.singletonList(MuscleRegion.SHOULDERS), weightRepsExercise.getPrimaryMuscleRegions());
		assertEquals(MuscleRegion.SHOULDERS.getSpecials(), weightRepsExercise.getSecondaryMuscleRegions());
	}
	
}
