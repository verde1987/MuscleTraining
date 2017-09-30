package at.aspg.muscletraining.data.exercises;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import at.aspg.muscletraining.R;
import at.aspg.muscletraining.data.DisplayableItem;
import at.aspg.muscletraining.data.IMuscleRegion;
import at.aspg.muscletraining.util.AndroidUtil;
import at.aspg.muscletraining.util.ObjectUtil;

public abstract class Exercise implements DisplayableItem {
	
	private String name;
	private String description;
	private List<IMuscleRegion> primaryMuscleRegions;
	private List<IMuscleRegion> secondaryMuscleRegions;
	
	public Exercise() {
		name = AndroidUtil.getString(R.string.default_exercise);
		description = "";
		primaryMuscleRegions = new ArrayList<>();
		secondaryMuscleRegions = new ArrayList<>();
	}
	
	/**
	 * Creates a new Exercise instance which will be a 1:1 copy of the specified Exercise,
	 * i.e., the following will be true:
	 * <pre>
	 *     Exercise existingExercise = ...;
	 *     Exercise copy = new Exercise(existingExercise);
	 *     copy.equals(existingExercise)
	 * </pre>
	 * Naturally, changes to the new Exercise will <i>not</i> be reflected in the original
	 * Exercise.
	 */
	protected Exercise(Exercise toCopy) {
		ObjectUtil.requireNonNull(toCopy);
		name = toCopy.name;
		description = toCopy.description;
		// no deep copy of muscle regions necessary since they are enums and thus immutable
		primaryMuscleRegions = new ArrayList<>(toCopy.primaryMuscleRegions);
		secondaryMuscleRegions = new ArrayList<>(toCopy.secondaryMuscleRegions);
	}
	
	@Override
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = ObjectUtil.requireNonNull(name);
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = ObjectUtil.requireNonNull(description);
	}
	
	public List<IMuscleRegion> getPrimaryMuscleRegions() {
		return primaryMuscleRegions;
	}
	
	public void addPrimaryMuscleRegions(IMuscleRegion... primaryMuscleRegions) {
		ObjectUtil.requireNonNullArray(primaryMuscleRegions);
		Collections.addAll(this.primaryMuscleRegions, primaryMuscleRegions);
	}
	
	public List<IMuscleRegion> getSecondaryMuscleRegions() {
		return secondaryMuscleRegions;
	}
	
	public void addSecondaryMuscleRegions(IMuscleRegion... secondaryMuscleRegions) {
		ObjectUtil.requireNonNullArray(secondaryMuscleRegions);
		Collections.addAll(this.secondaryMuscleRegions, secondaryMuscleRegions);
	}
	
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Exercise)) return false;
		
		Exercise exercise = (Exercise) o;
		
		if (name != null ? !name.equals(exercise.name) : exercise.name != null)
			return false;
		if (description != null ? !description.equals(exercise.description) : exercise.description != null)
			return false;
		if (primaryMuscleRegions != null ? !primaryMuscleRegions.equals(exercise.primaryMuscleRegions) : exercise.primaryMuscleRegions != null)
			return false;
		return secondaryMuscleRegions != null ? secondaryMuscleRegions.equals(exercise.secondaryMuscleRegions) : exercise.secondaryMuscleRegions == null;
		
	}
	
	@Override
	public int hashCode() {
		int result = name != null ? name.hashCode() : 0;
		result = 31 * result + (description != null ? description.hashCode() : 0);
		result = 31 * result + (primaryMuscleRegions != null ? primaryMuscleRegions.hashCode() : 0);
		result = 31 * result + (secondaryMuscleRegions != null ? secondaryMuscleRegions.hashCode() : 0);
		return result;
	}
}
