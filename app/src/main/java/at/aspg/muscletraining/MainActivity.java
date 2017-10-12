package at.aspg.muscletraining;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import at.aspg.muscletraining.util.AndroidUtil;

public class MainActivity extends AppCompatActivity {
	
	private ListView drawerList;
	private ArrayAdapter<String> drawerListAdapter;
	private ActionBarDrawerToggle drawerToggle;
	private DrawerLayout drawerLayout;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		AndroidUtil.setContext(getApplicationContext());
		
		drawerList = (ListView) findViewById(R.id.navList);
		drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
		drawerListAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, new String[] { AndroidUtil.getString(R.string.list_item_plans), AndroidUtil.getString(R.string.list_item_exercises) });
		drawerList.setAdapter(drawerListAdapter);
		drawerList.setOnItemClickListener((parent, view, position, id) -> {
			String item = (String) parent.getItemAtPosition(position);
			switch(item) { //TODO
				case "Plans":
					break;
				case "Exercises":
					startExercisesActivity();
					break;
			}
		});
		
		
		setupDrawer();
		
		getSupportActionBar().setDisplayHomeAsUpEnabled(true);
		getSupportActionBar().setHomeButtonEnabled(true);
	}
	
	private void setupDrawer() {
		drawerToggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.drawer_open, R.string.drawer_close) {
			
			@Override
			public void onDrawerOpened(View drawerView) {
				super.onDrawerOpened(drawerView);
				invalidateOptionsMenu();
			}
			
			@Override
			public void onDrawerClosed(View drawerView) {
				super.onDrawerClosed(drawerView);
				invalidateOptionsMenu();
			}
		};
		
		drawerToggle.setDrawerIndicatorEnabled(true);
		drawerLayout.setDrawerListener(drawerToggle);
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Activate the navigation drawer toggle
		if (drawerToggle.onOptionsItemSelected(item)) {
			return true;
		}
		
		return super.onOptionsItemSelected(item);
	}
	
	@Override
	protected void onPostCreate(Bundle savedInstanceState) {
		super.onPostCreate(savedInstanceState);
		drawerToggle.syncState();
	}
	
	private void startExercisesActivity() {
		Intent intent = new Intent(this, ExercisesActivity.class);
		startActivity(intent);
	}
	
}
