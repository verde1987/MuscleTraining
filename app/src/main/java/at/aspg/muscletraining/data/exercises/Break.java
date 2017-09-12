package at.aspg.muscletraining.data.exercises;

import org.xmlpull.v1.XmlSerializer;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import at.aspg.muscletraining.R;
import at.aspg.muscletraining.util.AndroidUtil;
import at.aspg.muscletraining.data.DisplayableItem;
import at.aspg.muscletraining.util.IOUtil;

public class Break implements DisplayableItem {
	
	private int duration;
	
	public int getDuration() {
		return duration;
	}
	
	public void setDuration(int duration) {
		this.duration = duration;
	}
	
	@Override
	public String getName() {
		return AndroidUtil.getString(R.string._break);
	}
	
	@Override
	public String getDetails() {
		return "";
	}
	
	@Override
	public void serialize(XmlSerializer serializer, OutputStream out) throws IOException {
		serializer.startTag("", "exercise");
		serializer.attribute("", "type", Break.class.getName());
		serializer.startTag("", "name");
		serializer.text(getName());
		serializer.endTag("", "name");
		serializer.startTag("", "duration");
		serializer.text(String.valueOf(getDuration()));
		serializer.endTag("", "duration");
		serializer.endTag("", "exercise");
		
		// also include Break.class, so we know that we are dealing with a Break when deserializing
	}
	
	// TODO: add "public static CLASS deserialize(InputStream in)" to all concrete DisplayableItem classes
	public static Break deserialize(InputStream in) {
		return null;
	}
	
}
