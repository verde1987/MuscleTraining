package at.aspg.muscletraining.util;

import android.util.Xml;

import org.xmlpull.v1.XmlSerializer;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Writer;
import java.util.Collection;

import at.aspg.muscletraining.data.DisplayableItem;

public class IOUtil {
	
	private IOUtil() {}
	
	public static void serializeDisplayableItems(Collection<? extends DisplayableItem> items, OutputStream out) {
		try {
			final XmlSerializer serializer = Xml.newSerializer(); //TODO extract to field!!
			serializer.setOutput(out, "UTF-8");
			serializer.startDocument("UTF-8", true);
			for (DisplayableItem item : items) {
				item.serialize(serializer, out);
			}
			serializer.endDocument();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static Collection<DisplayableItem> deserializeDisplayableItems(InputStream in) {
		// TODO
		/*
		switch (in.nextElement)
			case Break:
				newItem = Break.deserialize(in);
				collection.add(newItem)
		
		
		return collection;
		 */
		return null;
	}
	
}
