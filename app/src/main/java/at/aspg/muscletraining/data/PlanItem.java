package at.aspg.muscletraining.data;

/**
 * This class represents an item which can be part of a training plan.
 */
public interface PlanItem {
	
	/**
	 * Returns the name of this plan item.
	 *
	 * @return the name of this plan item
	 */
	String getName();
	
	/**
	 * Returns a detailed string representation of this plan item. This method should
	 * provide detailed information about this plan item but should not include the name.
	 *
	 * @return a detailed string representation of this plan item
	 */
	String getDetails();
	
}
