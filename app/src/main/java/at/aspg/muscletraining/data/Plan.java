package at.aspg.muscletraining.data;

import java.util.EnumSet;

public class Plan extends AbstractPlan {
	
	private EnumSet<Weekday> weekDays = EnumSet.noneOf(Weekday.class);
	
	public EnumSet<Weekday> getWeekdays() {
		return weekDays;
	}
	
	public void setWeekdays(EnumSet<Weekday> weekdays) {
		this.weekDays = weekdays;
	}
	
	@Override
	public String getDetails() {
		return null;
	}
	
}
