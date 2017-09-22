package at.aspg.muscletraining.data.plans;

import java.util.Collection;
import java.util.Collections;

import at.aspg.muscletraining.data.DisplayableItem;
import at.aspg.muscletraining.data.Weekday;
import at.aspg.muscletraining.util.StringUtil;

public class TrainingDay implements DisplayableItem {
	
	private Weekday day;
	private Collection<DisplayableItem> exercises = Collections.emptyList();
	
	public Weekday getWeekday() {
		return day;
	}
	
	public void setWeekday(Weekday weekday) {
		this.day = weekday;
	}
	
	public Collection<DisplayableItem> getDisplayableItems() {
		return exercises;
	}
	
	// TODO: renaming necessary!
	public void setDisplayableItems(Collection<DisplayableItem> displayableItems) {
		this.exercises = displayableItems;
	}
	
	@Override
	public String getName() {
		return day.toString();
	}
	
	@Override
	public String getDetails() {
		return StringUtil.join(exercises, " | ");
	}
	
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof TrainingDay)) return false;
		
		TrainingDay that = (TrainingDay) o;
		
		if (day != that.day) return false;
		return exercises != null ? exercises.equals(that.exercises) : that.exercises == null;
		
	}
	
	@Override
	public int hashCode() {
		int result = day != null ? day.hashCode() : 0;
		result = 31 * result + (exercises != null ? exercises.hashCode() : 0);
		return result;
	}
}
