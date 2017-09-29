package at.aspg.muscletraining.data.exercises;

public class CardioExercise extends Exercise implements Duration {
	
	private int duration;
	
	public CardioExercise() {
		duration = 0;
	}
	
	@Override
	public int getDuration() {
		return duration;
	}
	
	@Override
	public void setDuration(int duration) {
		this.duration = duration;
	}
	
	@Override
	public String getDetails() {
		return null;
	}
	
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof CardioExercise)) return false;
		if (!super.equals(o)) return false;
		
		CardioExercise that = (CardioExercise) o;
		
		return duration == that.duration;
	}
	
	@Override
	public int hashCode() {
		int result = super.hashCode();
		result = 31 * result + duration;
		return result;
	}
	
}
