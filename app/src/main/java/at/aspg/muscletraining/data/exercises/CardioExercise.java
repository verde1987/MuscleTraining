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
	
}
