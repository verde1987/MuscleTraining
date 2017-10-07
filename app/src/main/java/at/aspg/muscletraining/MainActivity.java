package at.aspg.muscletraining;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import at.aspg.muscletraining.util.AndroidUtil;

public class MainActivity extends AppCompatActivity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		AndroidUtil.setContext(getApplicationContext());
	}
	
	public void startExercisesActivity(View view) {
		Intent intent = new Intent(this, ExercisesActivity.class);
		startActivity(intent);
	}
	
}
