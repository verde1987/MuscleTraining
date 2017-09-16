package at.aspg.muscletraining.data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

public enum MuscleRegion implements IMuscleRegion {
	
	SHOULDERS(SubMuscleRegion.SHOULDER1, SubMuscleRegion.SHOULDER2),
	BREAST(),
	ARMS();
	
	private final Collection<IMuscleRegion> specials = new ArrayList<>();
	
	MuscleRegion(IMuscleRegion... specials) {
		this.specials.addAll(Arrays.asList(specials));
	}
	
	public Collection<IMuscleRegion> getSpecials() {
		return specials;
	}
}
