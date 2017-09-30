package at.aspg.muscletraining.data.plans;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import at.aspg.muscletraining.data.DisplayableItem;
import at.aspg.muscletraining.data.Weekday;
import at.aspg.muscletraining.util.ObjectUtil;
import at.aspg.muscletraining.util.StringUtil;

public class TrainingDay implements DisplayableItem {
	
	private Weekday day;
	private final List<DisplayableItem> exercises;
	
	public TrainingDay() {
		exercises = new ArrayList<>();
	}
	
	protected TrainingDay(TrainingDay toCopy) {
		ObjectUtil.requireNonNull(toCopy);
		day = toCopy.day;
		// make a deep copy of the exercises-list
		exercises = new ArrayList<>();
		for (DisplayableItem item : toCopy.exercises) {
			exercises.add(item.copy());
		}
	}
	
	public Weekday getWeekday() {
		return day;
	}
	
	public void setWeekday(Weekday weekday) {
		this.day = ObjectUtil.requireNonNull(weekday);
	}
	
	public List<DisplayableItem> getDisplayableItems() {
		return exercises;
	}
	
	public void addDisplayableItems(DisplayableItem... items) {
		ObjectUtil.requireNonNullArray(items);
		Collections.addAll(exercises, items);
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
	public TrainingDay copy() {
		return new TrainingDay(this);
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
