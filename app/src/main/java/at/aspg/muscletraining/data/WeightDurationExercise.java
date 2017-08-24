package at.aspg.muscletraining.data;

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
	
}
