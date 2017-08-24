package at.aspg.muscletraining.data;

public class WeightRepsExercise extends RepsExercise implements Weight {
	
	private double weight;
	
	public WeightRepsExercise() {
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
