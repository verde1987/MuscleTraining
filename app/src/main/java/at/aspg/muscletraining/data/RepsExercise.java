package at.aspg.muscletraining.data;

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
	
}
