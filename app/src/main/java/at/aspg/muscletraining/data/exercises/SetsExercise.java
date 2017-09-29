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
	
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof SetsExercise)) return false;
		if (!super.equals(o)) return false;
		
		SetsExercise that = (SetsExercise) o;
		
		if (sets != that.sets) return false;
		return breakTime == that.breakTime;
	}
	
	@Override
	public int hashCode() {
		int result = super.hashCode();
		result = 31 * result + sets;
		result = 31 * result + breakTime;
		return result;
	}
}
