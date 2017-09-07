package at.aspg.muscletraining;

import org.junit.Test;

import java.util.Calendar;

import at.aspg.muscletraining.data.Weekday;

import static org.junit.Assert.assertEquals;


public class TestWeekday {
	
	@Test
	public void testParseLongName() {
		Weekday day = Weekday.parse("montag");
		assertEquals(Weekday.MONDAY, day);
	}
	
	@Test
	public void testParseShortName() {
		Weekday day = Weekday.parse("do");
		assertEquals(Weekday.THURSDAY, day);
	}
	
	@Test
	public void testFromInt() {
		Weekday day = Weekday.fromInt(Calendar.TUESDAY);
		assertEquals(Weekday.TUESDAY, day);
	}
	
	@Test
	public void testToString() {
		String dayString = Weekday.WEDNESDAY.toString();
		assertEquals(dayString, "Mittwoch");
	}
}
