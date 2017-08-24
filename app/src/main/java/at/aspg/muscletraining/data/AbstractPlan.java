package at.aspg.muscletraining.data;

import at.aspg.muscletraining.R;
import at.aspg.muscletraining.Util;

public abstract class AbstractPlan implements DisplayableItem {
	
	private String name;
	
	public AbstractPlan() {
		name = Util.getString(R.string.default_plan);
	}
	
	@Override
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
}
