package at.aspg.muscletraining.data;

import at.aspg.muscletraining.R;
import at.aspg.muscletraining.Util;

public class Break implements PlanItem {
	
	@Override
	public String getName() {
		return Util.getString(R.string.plan_item_break);
	}
	
	@Override
	public String getDetails() {
		return "";
	}
	
}
