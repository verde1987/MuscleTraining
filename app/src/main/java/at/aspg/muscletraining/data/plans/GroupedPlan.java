package at.aspg.muscletraining.data.plans;

import java.util.Collection;
import java.util.Collections;

import at.aspg.muscletraining.util.StringUtil;

public class GroupedPlan extends AbstractPlan {
	
	private Collection<Plan> plans = Collections.emptyList();
	
	public Collection<Plan> getPlans() {
		return plans;
	}
	
	public void setPlans(Collection<Plan> plans) {
		this.plans = plans;
	}
	
	@Override
	public String getDetails() {
		return StringUtil.join(plans, " | ");
	}
	
}
