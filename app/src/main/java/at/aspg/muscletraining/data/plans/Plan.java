package at.aspg.muscletraining.data.plans;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import at.aspg.muscletraining.util.ObjectUtil;
import at.aspg.muscletraining.util.StringUtil;

public class Plan extends AbstractPlan {
	
	private final List<TrainingDay> trainingDays;
	
	public Plan() {
		trainingDays = new ArrayList<>();
	}
	
	protected Plan(Plan toCopy) {
		super(toCopy);
		// make a deep copy of the trainingDays-list
		trainingDays = new ArrayList<>();
		for (TrainingDay trainingDay : toCopy.trainingDays) {
			trainingDays.add(trainingDay.copy());
		}
	}
	
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
	
	@Override
	public Plan copy() {
		return new Plan(this);
	}
}
