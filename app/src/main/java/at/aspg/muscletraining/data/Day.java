package at.aspg.muscletraining.data;

import java.util.ArrayList;
import java.util.Collection;

public class Day implements DisplayableItem {
	
	private Weekday day;
	private Collection<DisplayableItem> exercises = new ArrayList<>();
	
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
		return null;
	}
	
	@Override
	public String getDetails() {
		return null;
	}
	
}
