package at.aspg.muscletraining.data.plans;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import at.aspg.muscletraining.util.StringUtil;

public class GroupedPlan extends AbstractPlan {
	
	private List<Plan> plans = new ArrayList<>();
	
	public List<Plan> getPlans() {
		return plans;
	}
	
	public void addPlans(Plan... plans) {
		Collections.addAll(this.plans, plans);
	}
	
	@Override
	public String getDetails() {
		return StringUtil.join(plans, " | ");
	}
	
}
