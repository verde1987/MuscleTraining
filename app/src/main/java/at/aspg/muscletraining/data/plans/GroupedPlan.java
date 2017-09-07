package at.aspg.muscletraining.data.plans;

import java.io.OutputStream;
import java.util.Collection;

import at.aspg.muscletraining.util.IOUtil;
import at.aspg.muscletraining.util.StringUtil;

public class GroupedPlan extends AbstractPlan {
	
	private Collection<Plan> plans;
	
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
	
	@Override
	public void serialize(OutputStream out) {
		// TODO: out.write(BEGIN_OF_LIST)
		IOUtil.serializeDisplayableItems(plans, out);
		// TODO: out.write(END_OF_LIST)
	}
	
}
