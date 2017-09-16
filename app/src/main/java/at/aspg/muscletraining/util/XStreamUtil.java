package at.aspg.muscletraining.util;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.XStreamException;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import at.aspg.muscletraining.data.DisplayableItem;
import at.aspg.muscletraining.data.exercises.Break;
import at.aspg.muscletraining.data.exercises.WeightRepsExercise;
import at.aspg.muscletraining.data.plans.TrainingDay;

public class XStreamUtil {
	
	private static final XStream xStream = new XStream();
	
	static {
		xStream.alias("TrainingDay", TrainingDay.class);
		xStream.alias("Break", Break.class);
		xStream.alias("WeightRepsExercise", WeightRepsExercise.class);
		//TODO add all classes here?
	}
	
	private XStreamUtil() {	}
	
	public static void serializeToFile(DisplayableItem item, File file) throws IOException {
		BufferedWriter writer = new BufferedWriter(new FileWriter(file));
		
		String xmlString = serializeToXML(item);
		
		writer.write(xmlString);
		writer.flush();
		writer.close();
	}
	
	private static String serializeToXML(DisplayableItem item) {
		return xStream.toXML(item);
	}
	
	public static DisplayableItem deserializeFromFile(File file) throws NullPointerException, XStreamException {
		return (DisplayableItem) xStream.fromXML(file);
	}
}
