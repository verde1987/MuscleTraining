package at.aspg.muscletraining;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import java.util.List;

import at.aspg.muscletraining.adapters.ExerciseAdapter;
import at.aspg.muscletraining.data.DataStorage;
import at.aspg.muscletraining.data.exercises.Exercise;
import at.aspg.muscletraining.gui.SimpleDividerItemDecoration;

public class ExercisesActivity extends AppCompatActivity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_exercises);
		Toolbar toolbar = (Toolbar) findViewById(R.id.activity_exercises_toolbar);
		setSupportActionBar(toolbar);
		
		// TODO
		FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.activity_exercises_fab);
		fab.setOnClickListener(view -> Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
				.setAction("Action", null).show());
		ActionBar supportActionBar = getSupportActionBar();
		if (supportActionBar != null) {
			supportActionBar.setDisplayHomeAsUpEnabled(true);
		}
		
		RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_view_exercises);
		recyclerView.addItemDecoration(new SimpleDividerItemDecoration());
		// use this setting to improve performance if you know that changes
		// in content do not change the layout size of the RecyclerView
		// TODO
		recyclerView.setHasFixedSize(true);
		recyclerView.setLayoutManager(new LinearLayoutManager(this));
		// TODO
		List<Exercise> dataset = DataStorage.createPredefinedExercises();
		recyclerView.setAdapter(new ExerciseAdapter(dataset, this, R.layout.list_item));
	}
	
}
