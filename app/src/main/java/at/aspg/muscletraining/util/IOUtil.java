package at.aspg.muscletraining.util;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.Collection;

import at.aspg.muscletraining.data.DisplayableItem;

public class IOUtil {
	
	public static void serializeDisplayableItems(Collection<? extends DisplayableItem> items, OutputStream out) {
		for (DisplayableItem item : items) {
			item.serialize(out);
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
