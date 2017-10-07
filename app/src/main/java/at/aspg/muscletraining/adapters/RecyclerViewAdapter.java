package at.aspg.muscletraining.adapters;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import at.aspg.muscletraining.R;
import at.aspg.muscletraining.data.DisplayableItem;
import at.aspg.muscletraining.util.AndroidUtil;

abstract class RecyclerViewAdapter<E extends DisplayableItem> extends RecyclerView.Adapter<RecyclerViewAdapter<E>.ViewHolder> {
	
	protected final List<E> dataset;
	protected final Context context;
	protected final Activity activity;
	
	private final int rowLayout;
	
	protected RecyclerViewAdapter(List<E> dataset, Activity activity, int rowLayout) {
		this.dataset = dataset;
		this.context = activity;
		this.activity = activity;
		this.rowLayout = rowLayout;
	}

	@Override
	public int getItemCount() {
		return dataset.size();
	}
	
	@Override
	public RecyclerViewAdapter<E>.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
		// create a new view
		View v = LayoutInflater.from(parent.getContext()).inflate(rowLayout, parent, false);
		// create the view holder that holds this created view
		return new ViewHolder(v);
	}
	
	@Override
	public void onBindViewHolder(final RecyclerViewAdapter<E>.ViewHolder holder, int position) {
		holder.firstLine.setText(dataset.get(position).getName());
	}

	class ViewHolder extends RecyclerView.ViewHolder {
		
		final TextView firstLine;
		final ImageView icon;
		final View wholeItem;
		
		ViewHolder(View v) {
			super(v);
			firstLine = (TextView) v.findViewById(R.id.list_item_first_line);
			icon = (ImageView) v.findViewById(R.id.list_item_icon);
			wholeItem = v.findViewById(R.id.list_item_whole);
		}
		
	}
	
}