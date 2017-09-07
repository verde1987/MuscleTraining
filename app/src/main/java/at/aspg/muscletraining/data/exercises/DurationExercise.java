package at.aspg.muscletraining.data.exercises;

import java.io.OutputStream;

public class DurationExercise extends SetsExercise implements Duration {
	
	private int duration;
	
	public DurationExercise() {
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
	public void serialize(OutputStream out) {
		
	}
	
}
