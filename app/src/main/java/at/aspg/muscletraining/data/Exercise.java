package at.aspg.muscletraining.data;

import java.util.EnumSet;

public abstract class Exercise implements PlanItem {
	
	private String name;
	private String description;
	private int sets;
	private int reps;
	private int breakTime;
	private EnumSet<MuscleRegion> primaryMuscleRegions;
	private EnumSet<MuscleRegion> secondaryMuscleRegions;
	
	@Override
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public int getSets() {
		return sets;
	}
	
	public void setSets(int sets) {
		this.sets = sets;
	}
	
	public int getReps() {
		return reps;
	}
	
	public void setReps(int reps) {
		this.reps = reps;
	}
	
	public int getBreakTime() {
		return breakTime;
	}
	
	public void setBreakTime(int breakTime) {
		this.breakTime = breakTime;
	}
	
	public EnumSet<MuscleRegion> getPrimaryMuscleRegions() {
		return primaryMuscleRegions;
	}
	
	public void setPrimaryMuscleRegions(EnumSet<MuscleRegion> primaryMuscleRegions) {
		this.primaryMuscleRegions = primaryMuscleRegions;
	}
	
	public EnumSet<MuscleRegion> getSecondaryMuscleRegions() {
		return secondaryMuscleRegions;
	}
	
	public void setSecondaryMuscleRegions(EnumSet<MuscleRegion> secondaryMuscleRegions) {
		this.secondaryMuscleRegions = secondaryMuscleRegions;
	}
	
	@Override
	public String getDetails() {
		return sets + " x " + reps;
	}
	
}
