package at.aspg.muscletraining.data;

public class WeightExercise extends Exercise {
	
	private double weight;
	
	public double getWeight() {
		return weight;
	}
	
	public void setWeight(double weight) {
		this.weight = weight;
	}
	
	@Override
	public String getDetails() {
		return super.getDetails() + " @ " + weight;
	}
}
