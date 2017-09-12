package at.aspg.muscletraining.data.exercises;

import org.xmlpull.v1.XmlSerializer;

import java.io.IOException;
import java.io.OutputStream;

public class RepsExercise extends SetsExercise {
	
	private int reps;
	
	public RepsExercise() {
		reps = 0;
	}
	
	public int getReps() {
		return reps;
	}
	
	public void setReps(int reps) {
		this.reps = reps;
	}
	
	@Override
	public String getDetails() {
		return null;
	}
	
	@Override
	public void serialize(XmlSerializer serializer, OutputStream out) throws IOException {
		
	}
}
