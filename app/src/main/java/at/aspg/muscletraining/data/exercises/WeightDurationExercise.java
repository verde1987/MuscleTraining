package at.aspg.muscletraining.data.exercises;

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
	public void serialize(OutputStream out) {
		// TODO: maybe can reuse from super.serialize???
	}
	
}
