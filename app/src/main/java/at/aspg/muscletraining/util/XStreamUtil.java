package at.aspg.muscletraining.util;

import com.thoughtworks.xstream.XStream;

import at.aspg.muscletraining.data.DisplayableItem;

/**
 * Created by Phil on 10.09.2017.
 */

public class XStreamUtil {
	
	public static void serializeToXML(DisplayableItem item) {
		XStream xStream = new XStream();
		
		String xml = xStream.toXML(item);
		System.out.print(xml);
	}
	
}
