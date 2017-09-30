package at.aspg.muscletraining.data.plans;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import at.aspg.muscletraining.util.ObjectUtil;
import at.aspg.muscletraining.util.StringUtil;

public class GroupedPlan extends AbstractPlan {
	
	private final List<Plan> plans;
	
	public GroupedPlan() {
		plans = new ArrayList<>();
	}
	
	protected GroupedPlan(GroupedPlan toCopy) {
		super(toCopy);
		// make a deep copy of the plans-list
		plans = new ArrayList<>();
		for (Plan plan : toCopy.plans) {
			plans.add(plan.copy());
		}
	}
	
	public List<Plan> getPlans() {
		return plans;
	}
	
	public void addPlans(Plan... plans) {
		ObjectUtil.requireNonNullArray(plans);
		Collections.addAll(this.plans, plans);
	}
	
	@Override
	public String getDetails() {
		return StringUtil.join(plans, " | ");
	}
	
	@Override
	public GroupedPlan copy() {
		return new GroupedPlan(this);
	}
	
}
