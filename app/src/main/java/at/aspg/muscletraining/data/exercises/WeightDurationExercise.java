package at.aspg.muscletraining.data.exercises;

import java.util.List;

import at.aspg.muscletraining.data.IMuscleRegion;
import at.aspg.muscletraining.util.NumberUtil;

public class WeightDurationExercise extends DurationExercise implements Weight {
	
	private double weight;
	
	public WeightDurationExercise() {
		weight = 0;
	}
	
	protected WeightDurationExercise(WeightDurationExercise toCopy) {
		super(toCopy);
		weight = toCopy.weight;
	}
	
	public WeightDurationExercise(String name, String description, List<IMuscleRegion> primaryMuscleRegions, List<IMuscleRegion> secondaryMuscleRegions, int sets, int breakTime, int duration, double weight) {
		super(name, description, primaryMuscleRegions, secondaryMuscleRegions, sets, breakTime, duration);
		this.weight = NumberUtil.checkRangeLowerBound(weight, 0);
	}
	
	@Override
	public double getWeight() {
		return weight;
	}
	
	@Override
	public void setWeight(double weight) {
		this.weight = NumberUtil.checkRangeLowerBound(weight, 0);
	}
	
	@Override
	public WeightDurationExercise copy() {
		return new WeightDurationExercise(this);
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
