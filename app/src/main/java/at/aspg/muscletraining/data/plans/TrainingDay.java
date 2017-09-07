package at.aspg.muscletraining.data.plans;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collection;

import at.aspg.muscletraining.util.StringUtil;
import at.aspg.muscletraining.data.DisplayableItem;
import at.aspg.muscletraining.data.Weekday;

public class TrainingDay implements DisplayableItem {
	
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
		return day.toString();
	}
	
	@Override
	public String getDetails() {
		return StringUtil.join(exercises, " | ");
	}
	
	@Override
	public void serialize(OutputStream out) {
		// TODO: out.write(BEGIN_OF_LIST)
		for (DisplayableItem exercise : exercises) {
			exercise.serialize(out);
		}
		// TODO: out.write(END_OF_LIST)
	}
	
	public static TrainingDay deserialize(InputStream in) {
		return null;
	}
	
}
