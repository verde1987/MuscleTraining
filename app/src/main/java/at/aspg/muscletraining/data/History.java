package at.aspg.muscletraining.data;

import android.util.Pair;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import at.aspg.muscletraining.data.plans.Plan;
import at.aspg.muscletraining.data.plans.TrainingDay;
import at.aspg.muscletraining.util.IOUtil;
import at.aspg.muscletraining.util.ObjectUtil;

// TODO: make singleton? could then use "implements serializable"
public class History {
	
	private static final String HISTORY_FILENAME = "history/history.xml";
	
	/**
	 * Lazily initialized, so every access must be done via {@link #getHistory()}.
	 */
	private static Map<Plan, List<Pair<TrainingDay, Date>>> history;
	
	/**
	 * Returns the history, reading it from the file in case this method gets called for
	 * the first time. If the history does not yet exist (e.g., in case the file was
	 * deleted or it is the very first time this method is called), an empty history will
	 * be returned.
	 *
	 * @return the history
	 */
	public static Map<Plan, List<Pair<TrainingDay, Date>>> getHistory() {
		if (history == null) {
			try {
				history = readHistoryFromFile();
			} catch (FileNotFoundException e) {
				history = new HashMap<>();
			}
		}
		return history;
	}
	
	private static Map<Plan, List<Pair<TrainingDay, Date>>> readHistoryFromFile() throws FileNotFoundException {
		File historyFile = IOUtil.getReadableInternalFile(HISTORY_FILENAME);
		return IOUtil.deserialize(historyFile);
	}
	
	public static void add(Plan plan, TrainingDay trainingDay) {
		ObjectUtil.requireNonNull(plan, trainingDay);
		Date date = new Date();
		Map<Plan, List<Pair<TrainingDay, Date>>> history = getHistory();
		List<Pair<TrainingDay, Date>> planHistory = history.get(plan);
		if (planHistory == null) {
			planHistory = new ArrayList<>();
		}
		planHistory.add(Pair.create(trainingDay, date));
		history.put(plan, planHistory);
		// TODO: serialize history immediately again? or sth like "newAsyncThread.invokeLater(() -> history.serialize)"
		// TODO: append new data rather than writing the entire history!
		// TODO: use SQLite DB? (https://developer.android.com/training/basics/data-storage/databases.html)
		try {
			writeHistoryToFile(history);
		} catch (IOException e) {
			// TODO
			e.printStackTrace();
		}
	}
	
	private static void writeHistoryToFile(Map<Plan, List<Pair<TrainingDay, Date>>> history) throws IOException {
		File historyFile = IOUtil.getWritableInternalFile(HISTORY_FILENAME);
		IOUtil.serialize(history, historyFile);
	}
	
}
