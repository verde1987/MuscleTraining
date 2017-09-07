package at.aspg.muscletraining.data;


import java.text.DateFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.Calendar;


//TODO: instead of null ---> exception?!
//TODO: add locale for different languages
public enum Weekday {
	MONDAY(Calendar.MONDAY),
	TUESDAY(Calendar.TUESDAY),
	WEDNESDAY(Calendar.WEDNESDAY),
	THURSDAY(Calendar.THURSDAY),
	FRIDAY(Calendar.FRIDAY),
	SATURDAY(Calendar.SATURDAY),
	SUNDAY(Calendar.SUNDAY);
	
	private static final DateFormatSymbols dateSymbols = new SimpleDateFormat().getDateFormatSymbols();
	private final int index;
	
	Weekday(int index) {
		this.index = index;
	}
	
	/**
	 *
	 * @param index
	 * @return
	 */
	public static Weekday fromInt(int index) {
		for(Weekday day : Weekday.values()) {
			if(day.index == index) {
				return day;
			}
		}
		return null;
	}
	
	/**
	 *
	 * @param str
	 * @return
	 */
	public static Weekday parse(String str) {
		String[] weekdayNames = dateSymbols.getWeekdays();
		String[] shortWeekdayNames = dateSymbols.getShortWeekdays();
		
		for(Weekday day : Weekday.values()) {
			if (str.equalsIgnoreCase(shortWeekdayNames[day.index]) ||
					str.equalsIgnoreCase(weekdayNames[day.index])) {
				 return day;
			}
		}
		return null;
	}
	
	@Override
	public String toString() {
		return dateSymbols.getWeekdays()[index];
	}
}
