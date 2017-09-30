package at.aspg.muscletraining.data.exercises;

import at.aspg.muscletraining.R;
import at.aspg.muscletraining.data.DisplayableItem;
import at.aspg.muscletraining.util.AndroidUtil;
import at.aspg.muscletraining.util.NumberUtil;

public class Break implements DisplayableItem {
	
	private int duration;
	
	public int getDuration() {
		return duration;
	}
	
	public void setDuration(int duration) {
		this.duration = NumberUtil.checkRangeLowerBound(duration, 0);
	}
	
	@Override
	public String getName() {
		return AndroidUtil.getString(R.string._break);
	}
	
	@Override
	public String getDetails() {
		return "";
	}
	
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Break)) return false;
		
		Break aBreak = (Break) o;
		
		return duration == aBreak.duration;
	}
	
	@Override
	public int hashCode() {
		return duration;
	}
	
}
