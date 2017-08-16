package at.aspg.muscletraining.data;

public class CardioExercise extends Exercise {
	
	private int duration;
	
	public int getDuration() {
		return duration;
	}
	
	public void setDuration(int duration) {
		this.duration = duration;
	}
	
	@Override
	public String getDetails() {
		return super.getDetails() + " @ " + duration + "s";
	}
}
