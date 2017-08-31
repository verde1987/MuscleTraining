package at.aspg.muscletraining.data;


import java.text.DateFormatSymbols;
import java.text.SimpleDateFormat;


//TODO: instead of null ---> exception?!
//TODO: add unitTest to ensure index matches DateFormatSymbols arrays
public enum Weekday {
	MONDAY(0),
	TUESDAY(1),
	WEDNESDAY(2),
	THURSDAY(3),
	FRIDAY(4),
	SATURDAY(5),
	SUNDAY(6);
	
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
