package at.aspg.muscletraining.data.plans;

import java.util.Collection;

import at.aspg.muscletraining.util.StringUtil;

public class Plan extends AbstractPlan {
	
	private Collection<TrainingDay> trainingDays;
	
	public Collection<TrainingDay> getTrainingDays() {
		return trainingDays;
	}
	
	public void setTrainingDays(Collection<TrainingDay> trainingDays) {
		this.trainingDays = trainingDays;
	}
	
	@Override
	public String getDetails() {
		return StringUtil.join(trainingDays, " | ");
	}
	
}
