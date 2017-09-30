package at.aspg.muscletraining;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collection;

import at.aspg.muscletraining.data.IMuscleRegion;
import at.aspg.muscletraining.data.MuscleRegion;
import at.aspg.muscletraining.data.exercises.WeightRepsExercise;

import static org.junit.Assert.assertEquals;

public class TestExercise extends AbstractUnitTest {

	@Test
	public void testWeightRepsExercise() {
		WeightRepsExercise exercise = new WeightRepsExercise();
		exercise.setName("TestName");
		exercise.setDescription("TestDescription");
		exercise.addPrimaryMuscleRegions(MuscleRegion.SHOULDERS);
		exercise.addSecondaryMuscleRegions(MuscleRegion.SHOULDERS.getSpecials().toArray(new IMuscleRegion[0]));
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
		assertListEquals(MuscleRegion.SHOULDERS.getSpecials(), exercise.getSecondaryMuscleRegions());
//		assertEquals(Arrays.<IMuscleRegion>asList(SubMuscleRegion.SHOULDER2), exercise.getPrimaryMuscleRegions());
	}
	
	private void assertListEquals(Collection<IMuscleRegion> iMuscleRegions, Collection<IMuscleRegion> secondaryMuscleRegions) {
		secondaryMuscleRegions.retainAll(secondaryMuscleRegions);
		assertEquals(iMuscleRegions.size(), secondaryMuscleRegions.size());
	}
	
	@Test
	public void testRepsExercise() {
		
	}
	
}
