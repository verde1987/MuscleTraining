package at.aspg.muscletraining.util;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;

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
	
	/**
	 * Convenience method for {@link ContextCompat#getDrawable(Context, int)}.
	 */
	public static Drawable getDrawable(int resId) {
		return ContextCompat.getDrawable(context, resId);
	}
	
	/**
	 * Convenience method for {@link android.content.res.Resources#getDimensionPixelOffset(int)}
	 * Context.getResources().getDimension(resId)}.
	 */
	public static int getDimension(int resId) {
		return context.getResources().getDimensionPixelOffset(resId);
	}
	
}
