package at.aspg.muscletraining.data.plans;

import org.xmlpull.v1.XmlSerializer;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collection;

import at.aspg.muscletraining.util.IOUtil;
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
	public void serialize(XmlSerializer serializer, OutputStream out) throws IOException {
		serializer.startTag("", "trainingDay");
		serializer.attribute("", "type", TrainingDay.class.getName());
		serializer.startTag("", "name");
		serializer.text(getName());
		serializer.endTag("", "name");
		serializer.startTag("", "day");
		serializer.text(String.valueOf(getWeekday()));
		serializer.endTag("", "day");
		IOUtil.serializeDisplayableItems(exercises, out);
		serializer.endTag("", "trainingDay");
	}
	
	public static TrainingDay deserialize(InputStream in) {
		return null;
	}
	
}
