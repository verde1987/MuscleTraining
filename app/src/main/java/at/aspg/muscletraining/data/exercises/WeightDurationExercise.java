package at.aspg.muscletraining.data.exercises;

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
	
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof WeightDurationExercise)) return false;
		if (!super.equals(o)) return false;
		
		WeightDurationExercise that = (WeightDurationExercise) o;
		
		return Double.compare(that.weight, weight) == 0;
	}
	
	@Override
	public int hashCode() {
		int result = super.hashCode();
		long temp;
		temp = Double.doubleToLongBits(weight);
		result = 31 * result + (int) (temp ^ (temp >>> 32));
		return result;
	}
	
	// TODO: @Override String getDetails()
}
