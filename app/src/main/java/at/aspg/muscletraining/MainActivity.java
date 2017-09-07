package at.aspg.muscletraining;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import at.aspg.muscletraining.util.AndroidUtil;

public class MainActivity extends AppCompatActivity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		AndroidUtil.setContext(getApplicationContext());
	}
	
}
