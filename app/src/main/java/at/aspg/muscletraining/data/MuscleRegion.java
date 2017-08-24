package at.aspg.muscletraining.data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.EnumSet;

public enum MuscleRegion {
	
	// special
	SHOULDERS_1,
	SHOUDLERS_2,
	BELLY_1,
	// coarse
	SHOULDERS(SHOULDERS_1, SHOUDLERS_2),
	BREAST,
	ARMS,
	BACK,
	LEGS,
	BELLY(BELLY_1);
	
	private final EnumSet<MuscleRegion> specials;
	
	MuscleRegion(MuscleRegion... specials) {
		this.specials = EnumSet.copyOf(Arrays.asList(specials));
	}
	
	public EnumSet<MuscleRegion> getSpecials() {
		return specials;
	}
	
	public static EnumSet<MuscleRegion> getCoarse() {
		// TODO: EnumSet.of(a, b);
		return null;
	}
	
}
