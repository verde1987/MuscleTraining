package at.aspg.muscletraining.data.exercises;

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
