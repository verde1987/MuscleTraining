package at.aspg.muscletraining.data.exercises;

import java.util.List;

import at.aspg.muscletraining.data.IMuscleRegion;
import at.aspg.muscletraining.util.NumberUtil;

public abstract class SetsExercise extends Exercise {
	
	private int sets;
	private int breakTime;
	
	public SetsExercise() {
		sets = 0;
		breakTime = 0;
	}
	
	protected SetsExercise(SetsExercise toCopy) {
		super(toCopy);
		sets = toCopy.sets;
		breakTime = toCopy.breakTime;
	}
	
	public SetsExercise(String name, String description, List<IMuscleRegion> primaryMuscleRegions, List<IMuscleRegion> secondaryMuscleRegions, int sets, int breakTime) {
		super(name, description, primaryMuscleRegions, secondaryMuscleRegions);
		this.sets = NumberUtil.checkRangeLowerBound(sets, 0);
		this.breakTime = NumberUtil.checkRangeLowerBound(breakTime, 0);
	}
	
	public int getSets() {
		return sets;
	}
	
	public void setSets(int sets) {
		this.sets = NumberUtil.checkRangeLowerBound(sets, 0);
	}
	
	public int getBreakTime() {
		return breakTime;
	}
	
	public void setBreakTime(int breakTime) {
		this.breakTime = NumberUtil.checkRangeLowerBound(breakTime, 0);
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
