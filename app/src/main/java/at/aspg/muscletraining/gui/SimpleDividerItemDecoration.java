package at.aspg.muscletraining.gui;

import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import at.aspg.muscletraining.R;
import at.aspg.muscletraining.util.AndroidUtil;

public class SimpleDividerItemDecoration extends RecyclerView.ItemDecoration {
	
	private final Drawable divider;
	private final int margin;
	
	public SimpleDividerItemDecoration() {
		divider = AndroidUtil.getDrawable(R.drawable.line_divider);
		margin = AndroidUtil.getDimension(R.dimen.default_margin);
	}
	
	@Override
	public void onDrawOver(Canvas c, RecyclerView parent, RecyclerView.State state) {
		int left = parent.getPaddingLeft();
		int right = parent.getWidth() - parent.getPaddingRight();
		
		int childCount = parent.getChildCount();
		for (int i = 0; i < childCount; i++) {
			View child = parent.getChildAt(i);
			
			RecyclerView.LayoutParams params = (RecyclerView.LayoutParams) child.getLayoutParams();
			
			int top = child.getBottom() + params.bottomMargin;
			int bottom = top + divider.getIntrinsicHeight();
			
			divider.setBounds(left + margin, top, right - margin, bottom);
			divider.draw(c);
		}
	}
	
}