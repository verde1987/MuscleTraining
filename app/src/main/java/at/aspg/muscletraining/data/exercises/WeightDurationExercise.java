package at.aspg.muscletraining.data.exercises;

import org.xmlpull.v1.XmlSerializer;

import java.io.IOException;
import java.io.OutputStream;

public class WeightDurationExercise extends DurationExercise implements Weight {
	
	private double weight;
	
	public WeightDurationExercise() {
		weight = 0;
	}
	
	@Override
	public double getWeight() {
		return weight;
	}
	
	@Override
	public void setWeight(double weight) {
		this.weight = weight;
	}
	
	// TODO: @Override String getDetails()
	
	@Override
	public void serialize(XmlSerializer serializer, OutputStream out) throws IOException {
		// TODO: maybe can reuse from super.serialize???
//		super.serialize(serializer);
	}
}
