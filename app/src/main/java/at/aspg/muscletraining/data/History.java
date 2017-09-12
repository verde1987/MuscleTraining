package at.aspg.muscletraining.data;

import android.util.Pair;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import at.aspg.muscletraining.data.plans.Plan;
import at.aspg.muscletraining.data.plans.TrainingDay;

public class History {
	
	/**
	 * Lazily initialized, so every access must be done via {@link #getHistory()}.
	 */
	private static Map<Plan, List<Pair<TrainingDay, Date>>> history;
	
	/**
	 * Returns the history, reading it from the file in case this method gets called for
	 * the first time.
	 *
	 * @return the history
	 */
	public static Map<Plan, List<Pair<TrainingDay, Date>>> getHistory() {
		if (history == null) {
			history = readHistoryFromFile();
		}
		return history;
	}
	
	private static Map<Plan, List<Pair<TrainingDay, Date>>> readHistoryFromFile() {
		return null;
	}
	
	public static void add(Plan plan, TrainingDay trainingDay) {
		add(plan, trainingDay, new Date());
	}
	
	public static void add(Plan plan, TrainingDay trainingDay, Date date) {
		// TODO: parameters: requireNonNull
		Map<Plan, List<Pair<TrainingDay, Date>>> history = getHistory();
		List<Pair<TrainingDay, Date>> planHistory = history.get(plan);
		if (planHistory == null) {
			planHistory = new ArrayList<>();
		}
		planHistory.add(Pair.create(trainingDay, date));
		history.put(plan, planHistory);
		// serialize history immediately again? or sth like "newAsyncThread.invokeLater(() -> history.serialize)"
	}
	
}
