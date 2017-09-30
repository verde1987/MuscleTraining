package at.aspg.muscletraining.data;

/**
 * This class represents an item which can be displayed in a list.
 */
public interface DisplayableItem {
	
	String getName();
	
	/**
	 * Returns a detailed string representation of this item but should not include the
	 * name.
	 *
	 * @return a detailed string representation of this item
	 */
	String getDetails();
	
	/**
	 * Creates a copy of {@code this} DisplayableItem. The returned instance must be a new
	 * instance for which changes <i>must not</i> be reflected in {@code this}
	 * DisplayableItem (the original which is copied with this method). Subclasses are
	 * encouraged to change the return type of this method to the corresponding type of
	 * the subclass.
	 *
	 * @return a copy of {@code this} DisplayableItem
	 */
	DisplayableItem copy();
	
	// TODO: icon ---> int getIconResource(); ?
	
}
