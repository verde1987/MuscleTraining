package at.aspg.muscletraining.data.exercises;

import at.aspg.muscletraining.util.NumberUtil;

public class RepsExercise extends SetsExercise {
	
	private int reps;
	
	public RepsExercise() {
		reps = 0;
	}
	
	public RepsExercise(RepsExercise blueprint) {
		super(blueprint);
	}
	
	public int getReps() {
		return reps;
	}
	
	public void setReps(int reps) {
		this.reps = NumberUtil.checkRangeLowerBound(reps, 0);
	}
	
	@Override
	public String getDetails() {
		return null;
	}
	
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof RepsExercise)) return false;
		if (!super.equals(o)) return false;
		
		RepsExercise that = (RepsExercise) o;
		
		return reps == that.reps;
	}
	
	@Override
	public int hashCode() {
		int result = super.hashCode();
		result = 31 * result + reps;
		return result;
	}
}
