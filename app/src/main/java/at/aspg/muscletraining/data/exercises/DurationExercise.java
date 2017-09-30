package at.aspg.muscletraining.data.exercises;

import at.aspg.muscletraining.util.NumberUtil;

public class DurationExercise extends SetsExercise implements Duration {
	
	private int duration;
	
	public DurationExercise() {
		duration = 0;
	}
	
	protected DurationExercise(DurationExercise toCopy) {
		super(toCopy);
		duration = toCopy.duration;
	}
	
	@Override
	public int getDuration() {
		return duration;
	}
	
	@Override
	public void setDuration(int duration) {
		this.duration = NumberUtil.checkRangeLowerBound(duration, 0);
	}
	
	@Override
	public String getDetails() {
		return null;
	}
	
	@Override
	public DurationExercise copy() {
		return new DurationExercise(this);
	}
	
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof DurationExercise)) return false;
		if (!super.equals(o)) return false;
		
		DurationExercise that = (DurationExercise) o;
		
		return duration == that.duration;
	}
	
	@Override
	public int hashCode() {
		int result = super.hashCode();
		result = 31 * result + duration;
		return result;
	}

}
