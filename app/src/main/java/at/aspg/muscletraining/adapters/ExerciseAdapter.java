package at.aspg.muscletraining.adapters;

import android.app.Activity;

import java.util.List;

import at.aspg.muscletraining.data.exercises.Exercise;

public class ExerciseAdapter extends RecyclerViewAdapter<Exercise> {
	
	public ExerciseAdapter(List<Exercise> dataset, Activity activity, int rowLayout) {
		super(dataset, activity, rowLayout);
	}
	
}
