package at.aspg.muscletraining.data;

/**
 * This class represents an item which can be displayed in a list.
 */
public interface DisplayableItem extends Serializable {
	
	String getName();
	
	/**
	 * Returns a detailed string representation of this item but should not include the
	 * name.
	 *
	 * @return a detailed string representation of this item
	 */
	String getDetails();
	
	// TODO: icon ---> int getIconResource(); ?
	
}
