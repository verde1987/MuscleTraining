package at.aspg.muscletraining;

import static org.mockito.Mockito.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.xmlpull.v1.XmlSerializer;

import java.io.IOException;
import java.io.OutputStream;
import java.io.StringWriter;
import java.util.Arrays;

import at.aspg.muscletraining.data.DisplayableItem;
import at.aspg.muscletraining.data.Weekday;
import at.aspg.muscletraining.data.exercises.Break;
import at.aspg.muscletraining.data.exercises.WeightRepsExercise;
import at.aspg.muscletraining.data.plans.TrainingDay;
import at.aspg.muscletraining.util.IOUtil;
import at.aspg.muscletraining.util.XStreamUtil;

import static org.junit.Assert.assertTrue;

//TODO check how to write tests which use android libs! (Mockito / Robolectric)
@RunWith(RobolectricTestRunner.class)
public class TestIOUtil {
	
	private StringWriter writer;
	
	@Before
	public void setUp() {
		writer = new StringWriter();
	}
	
	@After
	public void tearDown() throws IOException {
		writer.close();
		writer = null;
	}
	
	
	@Test
	public void testSerializeBreak() throws IOException {
		//mock object
		Break aBreak = declareBreakMock();
		
		IOUtil.serializeDisplayableItems(Arrays.asList(aBreak), System.out);
		
		// TODO uncomment this after deserialize is also implemented!
//		Collection<DisplayableItem> displayableItems = IOUtil.deserializeDisplayableItems(System.in);
//		Iterator<DisplayableItem> iterator = displayableItems.iterator();
//		if(iterator.hasNext()) {
//			DisplayableItem next = iterator.next();
//			assertEquals(aBreak, next);
//		}
		assertTrue(true);
	}
	
//	TODO: generic object declaration with map for methods and returns ?  -> private <T> T declareMockObject(Class<T> clazz,)
	private Break declareBreakMock() throws IOException {
		Break aBreak = mock(Break.class);
		
		//mock behaviour
		when(aBreak.getDuration()).thenReturn(20);
		when(aBreak.getName()).thenReturn("Break");
		doCallRealMethod().when(aBreak).serialize(any(XmlSerializer.class), any(OutputStream.class));
		
		return aBreak;
	}
	
	@Test
	public void testSerializeTrainingDay() throws IOException {
		TrainingDay day = declareTrainingDayMock();
		
		IOUtil.serializeDisplayableItems(Arrays.asList(day), System.out);
	}
	
	private TrainingDay declareTrainingDayMock() throws IOException {
		TrainingDay day = mock(TrainingDay.class);
		
		Break b = new Break();
		b.setDuration(20);
		Break c = new Break();
		b.setDuration(30);
		
		
		when(day.getWeekday()).thenReturn(Weekday.MONDAY);
		when(day.getName()).thenReturn("MyTestTrainingDay");
		when(day.getDisplayableItems()).thenReturn(Arrays.<DisplayableItem>asList(b,c));
		doCallRealMethod().when(day).serialize(any(XmlSerializer.class), any(OutputStream.class));
		
		return  day;
	}
	
	@Test
	public void XStreamTest() throws IOException {
		Break aBreak = new Break();
		aBreak.setDuration(20);
		
		XStreamUtil.serializeToXML(aBreak);
	}
	
	@Test
	public void XStreamTest2() {
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
		
		XStreamUtil.serializeToXML(day);
	}
}
