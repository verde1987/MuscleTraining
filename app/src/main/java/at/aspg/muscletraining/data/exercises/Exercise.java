package at.aspg.muscletraining.data.exercises;

import java.util.EnumSet;

import at.aspg.muscletraining.R;
import at.aspg.muscletraining.util.AndroidUtil;
import at.aspg.muscletraining.data.DisplayableItem;
import at.aspg.muscletraining.data.MuscleRegion;

public abstract class Exercise implements DisplayableItem {
	
	private String name;
	private String description;
	private EnumSet<MuscleRegion> primaryMuscleRegions;
	private EnumSet<MuscleRegion> secondaryMuscleRegions;
	
	public Exercise() {
		name = AndroidUtil.getString(R.string.default_exercise);
		description = "";
		primaryMuscleRegions = EnumSet.noneOf(MuscleRegion.class);
		secondaryMuscleRegions = EnumSet.noneOf(MuscleRegion.class);
	}
	
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
	
}
