package at.aspg.muscletraining.data;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import at.aspg.muscletraining.data.plans.AbstractPlan;
import at.aspg.muscletraining.util.IOUtil;
import at.aspg.muscletraining.util.ObjectUtil;

//TODO threadsafe singleton necessary?
public class DataStorage {
	
	private static final String PLANS_FILENAME = "plans/plans.xml";
	private static final String EXERCISES_FILENAME = "exercise/exercise.xml";
	
	private static DataStorage instance = null;
	
	private List<AbstractPlan> plans;
	private List<DisplayableItem> exercises;
	
	public static DataStorage getInstance() {
		if (instance == null) {
			instance = new DataStorage();
		}
		return instance;
	}
	
	private DataStorage() {
	}
	
	public List<AbstractPlan> getStoredPlans() {
		if (plans == null) {
			try {
				plans = readPlansFromFile();
			} catch (FileNotFoundException e) {
				plans = new ArrayList<>();
			}
		}
		return plans;
	}
	
	private List<AbstractPlan> readPlansFromFile() throws FileNotFoundException {
		File file = IOUtil.getReadableInternalFile(PLANS_FILENAME);
		return IOUtil.deserialize(file);
	}
	
	public List<DisplayableItem> getStoredExercises() {
		if (exercises == null) {
			try {
				exercises = readExercisesFromFile();
			} catch (FileNotFoundException e) {
				exercises = new ArrayList<>();
			}
		}
		return exercises;
	}
	
	private List<DisplayableItem> readExercisesFromFile() throws FileNotFoundException {
		File file = IOUtil.getReadableInternalFile(EXERCISES_FILENAME);
		return IOUtil.deserialize(file);
	}
	
	public void addPlan(AbstractPlan plan) {
		ObjectUtil.requireNonNull(plan);
		List<AbstractPlan> storedPlans = getStoredPlans();
		storedPlans.add(plan);
		try {
			writeToFile(storedPlans);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private void writeToFile(List<AbstractPlan> storedPlans) throws IOException {
		File file = IOUtil.getWritableInternalFile(PLANS_FILENAME);
		IOUtil.serialize(storedPlans, file);
	}
	
	public void addExercise(DisplayableItem exercise) {
		ObjectUtil.requireNonNull(exercise);
		List<DisplayableItem> storedExercises = getStoredExercises();
		storedExercises.add(exercise);
		try {
			writeToFile(exercise);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private void writeToFile(DisplayableItem exercise) throws IOException {
		File file = IOUtil.getWritableInternalFile(EXERCISES_FILENAME);
		IOUtil.serialize(exercise, file);
	}
	
}
