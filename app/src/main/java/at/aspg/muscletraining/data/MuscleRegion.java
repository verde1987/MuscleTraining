package at.aspg.muscletraining.data;

import static at.aspg.muscletraining.data.SubMuscleRegion.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

public enum MuscleRegion implements IMuscleRegion {
	
	SHOULDERS(FRONT_SHOULDER, SIDE_SHOULDER, BACK_SHOULDER),
	BACK(LOWER_BACK, LATISSIMUS, NECK),
	CHEST(MIDDLE_CHEST, UPPER_CHEST, LOWER_CHEST, SERRATUS_ANTERIOR), // TODO: PECTORAL?
	ARMS(BICEPS, TRICEPS, FOREARM),
	ABS(UPPER_ABS, LOWER_ABS, SIDE_ABS),
	GLUTES(ABDUCTORS, GLUTEUS_MAXIMUS),
	LEGS(THIGHS, CALVES);
	
	private final Collection<IMuscleRegion> specials = new ArrayList<>();
	
	MuscleRegion(IMuscleRegion... specials) {
		this.specials.addAll(Arrays.asList(specials));
	}
	
	public Collection<IMuscleRegion> getSpecials() {
		return specials;
	}
}
