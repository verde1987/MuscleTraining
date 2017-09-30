package at.aspg.muscletraining.data.plans;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import at.aspg.muscletraining.util.ObjectUtil;
import at.aspg.muscletraining.util.StringUtil;

public class Plan extends AbstractPlan {
	
	private List<TrainingDay> trainingDays = new ArrayList<>();
	
	public List<TrainingDay> getTrainingDays() {
		return trainingDays;
	}
	
	public void addTrainingDays(TrainingDay... days) {
		ObjectUtil.requireNonNullArray(days);
		Collections.addAll(trainingDays, days);
	}
	
	@Override
	public String getDetails() {
		return StringUtil.join(trainingDays, " | ");
	}
	
}
