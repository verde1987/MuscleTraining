package at.aspg.muscletraining.data.exercises;

public abstract class SetsExercise extends Exercise {
	
	private int sets;
	private int breakTime;
	
	public SetsExercise() {
		sets = 0;
		breakTime = 0;
	}
	
	public int getSets() {
		return sets;
	}
	
	public void setSets(int sets) {
		this.sets = sets;
	}
	
	public int getBreakTime() {
		return breakTime;
	}
	
	public void setBreakTime(int breakTime) {
		this.breakTime = breakTime;
	}
	
}
