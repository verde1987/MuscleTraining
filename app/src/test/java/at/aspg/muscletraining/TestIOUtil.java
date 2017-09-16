package at.aspg.muscletraining;

import android.content.Context;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

import at.aspg.muscletraining.data.DisplayableItem;
import at.aspg.muscletraining.data.Weekday;
import at.aspg.muscletraining.data.exercises.Break;
import at.aspg.muscletraining.data.exercises.WeightRepsExercise;
import at.aspg.muscletraining.data.plans.TrainingDay;
import at.aspg.muscletraining.util.AndroidUtil;
import at.aspg.muscletraining.util.XStreamUtil;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(RobolectricTestRunner.class)
@Config(manifest = "app/src/main/AndroidManifest.xml")
public class TestIOUtil {
	
	@Rule
	public TemporaryFolder tempFolder = new TemporaryFolder();
	
	private File file;
	
	@Mock
	Context mockContext;
	
	@Before
	public void setUp() throws IOException {
		MockitoAnnotations.initMocks(this);
		AndroidUtil.setContext(mockContext);
		defineMockContext();
		
		file = tempFolder.newFile("tempFile.xml");
	}
	
	private void defineMockContext() {
		when(mockContext.getString(R.string._break)).thenReturn("Break");
	}
	
	@After
	public void tearDown() throws IOException {
		
	}
	
	@Test
	public void XStreamTest() throws IOException {
		Break aBreak = new Break();
		aBreak.setDuration(20);
		
		XStreamUtil.serializeToFile(aBreak, file);
		DisplayableItem fromFile = XStreamUtil.deserializeFromFile(file);
		
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
		
		
		day.setDisplayableItems(Arrays.asList(b,c,d));
		
		XStreamUtil.serializeToFile(day, file);
		DisplayableItem fromFile = XStreamUtil.deserializeFromFile(file);
		
		assertEquals(day, fromFile);
	}
}
