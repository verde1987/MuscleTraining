package at.aspg.muscletraining.util;

import android.content.Context;

/**
 * A class consisting of various static utility method regarding Android functionality.
 */
public class AndroidUtil {
	
	private static Context context;
	
	/**
	 * Returns the global context object of the main application.
	 *
	 * @return the global context object of the main application
	 */
	public static Context getContext() {
		return context;
	}
	
	/**
	 * Sets the global context object of the main application.
	 *
	 * @param context the global context object of the main application.
	 */
	public static void setContext(Context context) {
		AndroidUtil.context = context;
	}
	
	/**
	 * Convenience method for {@link Context#getString(int)}.
	 */
	public static String getString(int resId) {
		return context.getString(resId);
	}
	
}
