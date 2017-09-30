package at.aspg.muscletraining;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

import at.aspg.muscletraining.data.DisplayableItem;
import at.aspg.muscletraining.data.Weekday;
import at.aspg.muscletraining.data.exercises.Break;
import at.aspg.muscletraining.data.exercises.WeightRepsExercise;
import at.aspg.muscletraining.data.plans.TrainingDay;
import at.aspg.muscletraining.util.IOUtil;

import static org.junit.Assert.assertEquals;

public class TestIOUtil extends AbstractUnitTest {
	
	@Rule
	public TemporaryFolder tempFolder = new TemporaryFolder();
	
	private File file;
	
	@Override
	public void setUp() throws Exception {
		super.setUp();
		file = tempFolder.newFile("tempFile.xml");
	}

	@Test
	public void XStreamTest() throws IOException {
		Break aBreak = new Break();
		aBreak.setDuration(20);
		
		IOUtil.serialize(aBreak, file);
		DisplayableItem fromFile = IOUtil.deserialize(file);
		
		assertEquals(aBreak, fromFile);
	}
	
	@Test
	public void XStreamTest2() throws IOException {
		TrainingDay day = new TrainingDay();
		day.setWeekday(Weekday.MONDAY);
		
		Break b = new Break();
		b.setDuration(20);
		Break c = new Break();
		c.setDuration(30);
		WeightRepsExercise d = new WeightRepsExercise();
		d.setWeight(50);
		d.setBreakTime(10);
		d.setName("Arnold Press");
		d.setDescription("I fucking have no clue!");
		d.setReps(12);
		
		day.addDisplayableItems(b, c, d);
		
		IOUtil.serialize(day, file);
		TrainingDay fromFile = IOUtil.deserialize(file);
		
		assertEquals(day, fromFile);
	}
}
