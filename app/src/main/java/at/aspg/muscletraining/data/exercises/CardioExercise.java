package at.aspg.muscletraining.data.exercises;

import at.aspg.muscletraining.util.NumberUtil;

public class CardioExercise extends Exercise implements Duration {
	
	private int duration;
	
	public CardioExercise() {
		duration = 0;
	}
	

	protected CardioExercise(CardioExercise toCopy) {
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
	public CardioExercise copy() {
		return new CardioExercise(this);
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
