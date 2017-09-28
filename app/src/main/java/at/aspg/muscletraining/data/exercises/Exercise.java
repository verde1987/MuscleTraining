package at.aspg.muscletraining.data.exercises;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.EnumSet;

import at.aspg.muscletraining.R;
import at.aspg.muscletraining.data.IMuscleRegion;
import at.aspg.muscletraining.util.AndroidUtil;
import at.aspg.muscletraining.data.DisplayableItem;
import at.aspg.muscletraining.data.MuscleRegion;

public abstract class Exercise implements DisplayableItem {
	
	private String name;
	private String description;
	private Collection<IMuscleRegion> primaryMuscleRegions;
	private Collection<IMuscleRegion> secondaryMuscleRegions;
	
	// TODO: copy constructor
	
	public Exercise() {
		name = AndroidUtil.getString(R.string.default_exercise);
		description = "";
		primaryMuscleRegions = new ArrayList<>();
		secondaryMuscleRegions = new ArrayList<>();
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
	
	public Collection<IMuscleRegion> getPrimaryMuscleRegions() {
		return primaryMuscleRegions;
	}
	
	public void setPrimaryMuscleRegions(Collection<IMuscleRegion> primaryMuscleRegions) {
		this.primaryMuscleRegions = primaryMuscleRegions;
	}
	
	public Collection<IMuscleRegion> getSecondaryMuscleRegions() {
		return secondaryMuscleRegions;
	}
	
	public void setSecondaryMuscleRegions(Collection<IMuscleRegion> secondaryMuscleRegions) {
		this.secondaryMuscleRegions = secondaryMuscleRegions;
	}
	
}
