package at.aspg.muscletraining.data;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import at.aspg.muscletraining.R;
import at.aspg.muscletraining.data.exercises.CardioExercise;
import at.aspg.muscletraining.data.exercises.Exercise;
import at.aspg.muscletraining.data.exercises.RepsExercise;
import at.aspg.muscletraining.data.exercises.WeightRepsExercise;
import at.aspg.muscletraining.data.plans.AbstractPlan;
import at.aspg.muscletraining.util.AndroidUtil;
import at.aspg.muscletraining.util.IOUtil;
import at.aspg.muscletraining.util.ObjectUtil;

//TODO threadsafe singleton necessary?
public class DataStorage {
	
	private static final String PLANS_FILENAME = "plans/plans.xml";
	private static final String EXERCISES_FILENAME = "exercise/exercises.xml";
	
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
	
	/**
	 * Creates a list of predefined exercises. This method is primarily intended for one
	 * initial call to create these exercises and store them on a file on the disk.
	 * However, it can also be used in case the file gets deleted (to restore the
	 * predefined exercises rather than having lost them).
	 * <p>
	 * All of the returned exercises only have their name, description and muscle regions
	 * set.
	 *
	 * @return a list of predefined exercises
	 */
	public static List<Exercise> createPredefinedExercises() {
		List<Exercise> exercises = new ArrayList<>();
		
		// TODO: add more exercises
		// TODO: secondary muscle regions missing
		// weight reps exercises
		exercises.add(new WeightRepsExercise(AndroidUtil.getString(R.string.exercise_barbell_curls), AndroidUtil.getString(R.string.exercise_description_barbell_curls), Arrays.asList(MuscleRegion.ARMS), new ArrayList<>(), 0, 0, 0, 0));
		exercises.add(new WeightRepsExercise(AndroidUtil.getString(R.string.exercise_dumbbell_curls), AndroidUtil.getString(R.string.exercise_description_dumbbell_curls), Arrays.asList(MuscleRegion.ARMS), new ArrayList<>(), 0, 0, 0, 0));
		exercises.add(new WeightRepsExercise(AndroidUtil.getString(R.string.exercise_concentration_curls), AndroidUtil.getString(R.string.exercise_description_concentration_curls), Arrays.asList(MuscleRegion.ARMS), new ArrayList<>(), 0, 0, 0, 0));
		exercises.add(new WeightRepsExercise(AndroidUtil.getString(R.string.exercise_hammer_curls), AndroidUtil.getString(R.string.exercise_description_hammer_curls), Arrays.asList(MuscleRegion.ARMS), new ArrayList<>(), 0, 0, 0, 0));
		exercises.add(new WeightRepsExercise(AndroidUtil.getString(R.string.exercise_triceps_push_downs), AndroidUtil.getString(R.string.exercise_description_triceps_push_downs), Arrays.asList(MuscleRegion.ARMS), new ArrayList<>(), 0, 0, 0, 0));
		exercises.add(new WeightRepsExercise(AndroidUtil.getString(R.string.exercise_skull_crushers), AndroidUtil.getString(R.string.exercise_description_skull_crushers), Arrays.asList(MuscleRegion.ARMS), new ArrayList<>(), 0, 0, 0, 0));
		exercises.add(new WeightRepsExercise(AndroidUtil.getString(R.string.exercise_kick_backs), AndroidUtil.getString(R.string.exercise_description_kick_backs), Arrays.asList(MuscleRegion.ARMS), new ArrayList<>(), 0, 0, 0, 0));
		exercises.add(new WeightRepsExercise(AndroidUtil.getString(R.string.exercise_close_grips_bench_press), AndroidUtil.getString(R.string.exercise_description_close_grips_bench_press), Arrays.asList(MuscleRegion.ARMS, MuscleRegion.CHEST), new ArrayList<>(), 0, 0, 0, 0));
		exercises.add(new WeightRepsExercise(AndroidUtil.getString(R.string.exercise_single_arm_triceps_extension), AndroidUtil.getString(R.string.exercise_description_single_arm_triceps_extension), Arrays.asList(MuscleRegion.ARMS), new ArrayList<>(), 0, 0, 0, 0));
		exercises.add(new WeightRepsExercise(AndroidUtil.getString(R.string.exercise_dumbbell_wrist_curls), AndroidUtil.getString(R.string.exercise_description_dumbbell_wrist_curls), Arrays.asList(MuscleRegion.ARMS), new ArrayList<>(), 0, 0, 0, 0));
		exercises.add(new WeightRepsExercise(AndroidUtil.getString(R.string.exercise_barbell_bench_press), AndroidUtil.getString(R.string.exercise_description_barbell_bench_press), Arrays.asList(MuscleRegion.CHEST, MuscleRegion.ARMS), new ArrayList<>(), 0, 0, 0, 0));
		exercises.add(new WeightRepsExercise(AndroidUtil.getString(R.string.exercise_pullover), AndroidUtil.getString(R.string.exercise_description_pullover), Arrays.asList(MuscleRegion.CHEST), new ArrayList<>(), 0, 0, 0, 0));
		exercises.add(new WeightRepsExercise(AndroidUtil.getString(R.string.exercise_flies), AndroidUtil.getString(R.string.exercise_description_flies), Arrays.asList(MuscleRegion.CHEST), new ArrayList<>(), 0, 0, 0, 0));
		exercises.add(new WeightRepsExercise(AndroidUtil.getString(R.string.exercise_dumbbell_bench_press), AndroidUtil.getString(R.string.exercise_description_dumbbell_bench_press), Arrays.asList(MuscleRegion.CHEST, MuscleRegion.ARMS), new ArrayList<>(), 0, 0, 0, 0));
		exercises.add(new WeightRepsExercise(AndroidUtil.getString(R.string.exercise_butterfly), AndroidUtil.getString(R.string.exercise_description_butterfly), Arrays.asList(MuscleRegion.CHEST), new ArrayList<>(), 0, 0, 0, 0));
		exercises.add(new WeightRepsExercise(AndroidUtil.getString(R.string.exercise_incline_dumbbell_bench_press), AndroidUtil.getString(R.string.exercise_description_incline_dumbbell_bench_press), Arrays.asList(MuscleRegion.CHEST, MuscleRegion.ARMS), new ArrayList<>(), 0, 0, 0, 0));
		exercises.add(new WeightRepsExercise(AndroidUtil.getString(R.string.exercise_incline_flies), AndroidUtil.getString(R.string.exercise_description_incline_flies), Arrays.asList(MuscleRegion.CHEST), new ArrayList<>(), 0, 0, 0, 0));
		exercises.add(new WeightRepsExercise(AndroidUtil.getString(R.string.exercise_incline_barbell_bench_press), AndroidUtil.getString(R.string.exercise_description_incline_barbell_bench_press), Arrays.asList(MuscleRegion.CHEST, MuscleRegion.ARMS), new ArrayList<>(), 0, 0, 0, 0));
		exercises.add(new WeightRepsExercise(AndroidUtil.getString(R.string.exercise_decline_barbell_bench_press), AndroidUtil.getString(R.string.exercise_description_decline_barbell_bench_press), Arrays.asList(MuscleRegion.CHEST, MuscleRegion.ARMS), new ArrayList<>(), 0, 0, 0, 0));
		exercises.add(new WeightRepsExercise(AndroidUtil.getString(R.string.exercise_decline_dumbbell_bench_press), AndroidUtil.getString(R.string.exercise_description_decline_dumbbell_bench_press), Arrays.asList(MuscleRegion.CHEST, MuscleRegion.ARMS), new ArrayList<>(), 0, 0, 0, 0));
		exercises.add(new WeightRepsExercise(AndroidUtil.getString(R.string.exercise_decline_flies), AndroidUtil.getString(R.string.exercise_description_decline_flies), Arrays.asList(MuscleRegion.CHEST), new ArrayList<>(), 0, 0, 0, 0));
		exercises.add(new WeightRepsExercise(AndroidUtil.getString(R.string.exercise_one_arm_dumbbell_row), AndroidUtil.getString(R.string.exercise_description_one_arm_dumbbell_row), Arrays.asList(MuscleRegion.BACK, MuscleRegion.SHOULDERS), new ArrayList<>(), 0, 0, 0, 0));
		exercises.add(new WeightRepsExercise(AndroidUtil.getString(R.string.exercise_bend_over_barbell_row), AndroidUtil.getString(R.string.exercise_description_bend_over_barbell_row), Arrays.asList(MuscleRegion.BACK, MuscleRegion.SHOULDERS), new ArrayList<>(), 0, 0, 0, 0));
		exercises.add(new WeightRepsExercise(AndroidUtil.getString(R.string.exercise_seated_cable_row), AndroidUtil.getString(R.string.exercise_description_seated_cable_row), Arrays.asList(MuscleRegion.BACK, MuscleRegion.SHOULDERS), new ArrayList<>(), 0, 0, 0, 0));
		exercises.add(new WeightRepsExercise(AndroidUtil.getString(R.string.exercise_cable_lat_pulldown), AndroidUtil.getString(R.string.exercise_description_cable_lat_pulldown), Arrays.asList(MuscleRegion.BACK), new ArrayList<>(), 0, 0, 0, 0));
		exercises.add(new WeightRepsExercise(AndroidUtil.getString(R.string.exercise_t_bar_row), AndroidUtil.getString(R.string.exercise_description_t_bar_row), Arrays.asList(MuscleRegion.BACK, MuscleRegion.SHOULDERS), new ArrayList<>(), 0, 0, 0, 0));
		exercises.add(new WeightRepsExercise(AndroidUtil.getString(R.string.exercise_dumbbell_reverse_flies), AndroidUtil.getString(R.string.exercise_description_dumbbell_reverse_flies), Arrays.asList(MuscleRegion.BACK, MuscleRegion.SHOULDERS), new ArrayList<>(), 0, 0, 0, 0));
		exercises.add(new WeightRepsExercise(AndroidUtil.getString(R.string.exercise_upright_barbell_row), AndroidUtil.getString(R.string.exercise_description_upright_barbell_row), Arrays.asList(MuscleRegion.BACK, MuscleRegion.SHOULDERS), new ArrayList<>(), 0, 0, 0, 0));
		exercises.add(new WeightRepsExercise(AndroidUtil.getString(R.string.exercise_shrugs), AndroidUtil.getString(R.string.exercise_description_shrugs), Arrays.asList(MuscleRegion.BACK), new ArrayList<>(), 0, 0, 0, 0));
		exercises.add(new WeightRepsExercise(AndroidUtil.getString(R.string.exercise_dead_lifts), AndroidUtil.getString(R.string.exercise_description_dead_lifts), Arrays.asList(MuscleRegion.BACK, MuscleRegion.LEGS), new ArrayList<>(), 0, 0, 0, 0));
		exercises.add(new WeightRepsExercise(AndroidUtil.getString(R.string.exercise_dumbbell_shoulder_press), AndroidUtil.getString(R.string.exercise_description_dumbbell_shoulder_press), Arrays.asList(MuscleRegion.SHOULDERS), new ArrayList<>(), 0, 0, 0, 0));
		exercises.add(new WeightRepsExercise(AndroidUtil.getString(R.string.exercise_barbell_shoulder_press), AndroidUtil.getString(R.string.exercise_description_barbell_shoulder_press), Arrays.asList(MuscleRegion.SHOULDERS), new ArrayList<>(), 0, 0, 0, 0));
		exercises.add(new WeightRepsExercise(AndroidUtil.getString(R.string.exercise_front_raise), AndroidUtil.getString(R.string.exercise_description_front_raise), Arrays.asList(MuscleRegion.SHOULDERS), new ArrayList<>(), 0, 0, 0, 0));
		exercises.add(new WeightRepsExercise(AndroidUtil.getString(R.string.exercise_lateral_raise), AndroidUtil.getString(R.string.exercise_description_lateral_raise), Arrays.asList(MuscleRegion.SHOULDERS), new ArrayList<>(), 0, 0, 0, 0));
		exercises.add(new WeightRepsExercise(AndroidUtil.getString(R.string.exercise_inner_thigh_squeezes), AndroidUtil.getString(R.string.exercise_description_inner_thigh_squeezes), Arrays.asList(MuscleRegion.LEGS), new ArrayList<>(), 0, 0, 0, 0));
		exercises.add(new WeightRepsExercise(AndroidUtil.getString(R.string.exercise_squats), AndroidUtil.getString(R.string.exercise_description_squats), Arrays.asList(MuscleRegion.LEGS), new ArrayList<>(), 0, 0, 0, 0));
		exercises.add(new WeightRepsExercise(AndroidUtil.getString(R.string.exercise_leg_press), AndroidUtil.getString(R.string.exercise_description_leg_press), Arrays.asList(MuscleRegion.LEGS), new ArrayList<>(), 0, 0, 0, 0));
		exercises.add(new WeightRepsExercise(AndroidUtil.getString(R.string.exercise_lying_leg_curls), AndroidUtil.getString(R.string.exercise_description_lying_leg_curls), Arrays.asList(MuscleRegion.LEGS), new ArrayList<>(), 0, 0, 0, 0));
		exercises.add(new WeightRepsExercise(AndroidUtil.getString(R.string.exercise_dumbbell_lunges), AndroidUtil.getString(R.string.exercise_description_dumbbell_lunges), Arrays.asList(MuscleRegion.LEGS), new ArrayList<>(), 0, 0, 0, 0));
		exercises.add(new WeightRepsExercise(AndroidUtil.getString(R.string.exercise_calf_raise), AndroidUtil.getString(R.string.exercise_description_calf_raise), Arrays.asList(MuscleRegion.LEGS), new ArrayList<>(), 0, 0, 0, 0));
		// reps exercises
		exercises.add(new RepsExercise(AndroidUtil.getString(R.string.exercise_dips), AndroidUtil.getString(R.string.exercise_description_dips), Arrays.asList(MuscleRegion.ARMS, MuscleRegion.CHEST), new ArrayList<>(), 0, 0, 0));
		exercises.add(new RepsExercise(AndroidUtil.getString(R.string.exercise_triceps_push_ups), AndroidUtil.getString(R.string.exercise_description_triceps_push_ups), Arrays.asList(MuscleRegion.ARMS, MuscleRegion.CHEST), new ArrayList<>(), 0, 0, 0));
		exercises.add(new RepsExercise(AndroidUtil.getString(R.string.exercise_push_ups), AndroidUtil.getString(R.string.exercise_description_push_ups), Arrays.asList(MuscleRegion.CHEST, MuscleRegion.ARMS), new ArrayList<>(), 0, 0, 0));
		exercises.add(new RepsExercise(AndroidUtil.getString(R.string.exercise_decline_push_ups), AndroidUtil.getString(R.string.exercise_description_decline_push_ups), Arrays.asList(MuscleRegion.CHEST, MuscleRegion.ARMS), new ArrayList<>(), 0, 0, 0));
		exercises.add(new RepsExercise(AndroidUtil.getString(R.string.exercise_criss_cross), AndroidUtil.getString(R.string.exercise_description_criss_cross), Arrays.asList(MuscleRegion.ABS), new ArrayList<>(), 0, 0, 0));
		exercises.add(new RepsExercise(AndroidUtil.getString(R.string.exercise_crunches), AndroidUtil.getString(R.string.exercise_description_crunches), Arrays.asList(MuscleRegion.ABS), new ArrayList<>(), 0, 0, 0));
		exercises.add(new RepsExercise(AndroidUtil.getString(R.string.exercise_decline_sit_ups), AndroidUtil.getString(R.string.exercise_description_decline_sit_ups), Arrays.asList(MuscleRegion.ABS), new ArrayList<>(), 0, 0, 0));
		exercises.add(new RepsExercise(AndroidUtil.getString(R.string.exercise_hip_thrusts), AndroidUtil.getString(R.string.exercise_description_hip_thrusts), Arrays.asList(MuscleRegion.ABS), new ArrayList<>(), 0, 0, 0));
		exercises.add(new RepsExercise(AndroidUtil.getString(R.string.exercise_hanging_leg_raises), AndroidUtil.getString(R.string.exercise_description_hanging_leg_raises), Arrays.asList(MuscleRegion.ABS), new ArrayList<>(), 0, 0, 0));
		exercises.add(new RepsExercise(AndroidUtil.getString(R.string.exercise_vertical_leg_lifts), AndroidUtil.getString(R.string.exercise_description_vertical_leg_lifts), Arrays.asList(MuscleRegion.ABS), new ArrayList<>(), 0, 0, 0));
		exercises.add(new RepsExercise(AndroidUtil.getString(R.string.exercise_windshield_wipers), AndroidUtil.getString(R.string.exercise_description_windshield_wipers), Arrays.asList(MuscleRegion.ABS), new ArrayList<>(), 0, 0, 0));
		exercises.add(new RepsExercise(AndroidUtil.getString(R.string.exercise_side_to_side_crunches), AndroidUtil.getString(R.string.exercise_description_side_to_side_crunches), Arrays.asList(MuscleRegion.ABS), new ArrayList<>(), 0, 0, 0));
		exercises.add(new RepsExercise(AndroidUtil.getString(R.string.exercise_pull_ups), AndroidUtil.getString(R.string.exercise_description_pull_ups), Arrays.asList(MuscleRegion.BACK, MuscleRegion.ARMS), new ArrayList<>(), 0, 0, 0));
		exercises.add(new RepsExercise(AndroidUtil.getString(R.string.exercise_back_extension), AndroidUtil.getString(R.string.exercise_description_back_extension), Arrays.asList(MuscleRegion.BACK), new ArrayList<>(), 0, 0, 0));
		// cardio exercises
		exercises.add(new CardioExercise(AndroidUtil.getString(R.string.exercise_running), AndroidUtil.getString(R.string.exercise_description_running), Arrays.asList(MuscleRegion.LEGS), new ArrayList<>(), 0));
		exercises.add(new CardioExercise(AndroidUtil.getString(R.string.exercise_ergometer), AndroidUtil.getString(R.string.exercise_description_ergometer), Arrays.asList(MuscleRegion.LEGS), new ArrayList<>(), 0));
		
		return exercises;
	}
	
}
