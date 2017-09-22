package at.aspg.muscletraining.util;

import android.os.Environment;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.XStreamException;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

import at.aspg.muscletraining.data.DisplayableItem;
import at.aspg.muscletraining.data.exercises.Break;
import at.aspg.muscletraining.data.exercises.WeightRepsExercise;
import at.aspg.muscletraining.data.plans.TrainingDay;
import at.aspg.muscletraining.exceptions.ExternalStorageNotReadable;
import at.aspg.muscletraining.exceptions.ExternalStorageNotWritable;

public class IOUtil {
	
	private IOUtil() {
	}
	
	private static final XStream xStream = new XStream();
	
	static {
		xStream.alias("TrainingDay", TrainingDay.class);
		xStream.alias("Break", Break.class);
		xStream.alias("WeightRepsExercise", WeightRepsExercise.class);
		//TODO add all classes here?
	}
	
	public static void serializeToFile(DisplayableItem item, File file) throws IOException {
		BufferedWriter writer = new BufferedWriter(new FileWriter(file));
		
		String xmlString = serializeToXML(item);
		
		writer.write(xmlString);
		writer.flush();
		writer.close();
	}
	
	private static String serializeToXML(DisplayableItem item) {
		return xStream.toXML(item);
	}
	
	public static DisplayableItem deserializeFromFile(File file) throws NullPointerException, XStreamException {
		return (DisplayableItem) xStream.fromXML(file);
	}
	
	/**
	 * Checks if the external storage is available for read and write access.
	 * <p>
	 * If this methods yields {@code true}, {@link #isExternalStorageReadable()} yields
	 * {@code true} as well.
	 *
	 * @return {@code true} if the external storage is available for read and write
	 * access, {@code false} otherwise
	 */
	public static boolean isExternalStorageWritable() {
		String state = Environment.getExternalStorageState();
		return Environment.MEDIA_MOUNTED.equals(state);
	}
	
	/**
	 * Checks if external storage is available for read access.
	 *
	 * @return {@code true} if the external storage is available for read access, {@code
	 * false} otherwise
	 */
	public static boolean isExternalStorageReadable() {
		String state = Environment.getExternalStorageState();
		return Environment.MEDIA_MOUNTED.equals(state) || Environment.MEDIA_MOUNTED_READ_ONLY.equals(state);
	}
	
	/**
	 * Returns the specified file from the external storage for read access.
	 *
	 * @param filename the name of the file (may include subdirectories in case the file
	 *                 was stored in a subdirectory on the external storage, e.g., when
	 *                 trying to retrieve the file from {@code EXT/subdir/myFile.txt}, the
	 *                 specified {@code filename} would be {@code subdir/myFile.txt})
	 * @return the specified file from the external storage
	 * @throws ExternalStorageNotReadable if the external storage is unavailable for read
	 *                                    access
	 * @throws FileNotFoundException      if the specified file could not be found
	 */
	public static File getReadableExternalFile(String filename) throws ExternalStorageNotReadable, FileNotFoundException {
		ObjectUtil.requireNonNull(filename);
		if (!isExternalStorageReadable()) {
			throw new ExternalStorageNotReadable();
		}
		File externalRootDir = AndroidUtil.getContext().getExternalFilesDir(null);
		File file = new File(externalRootDir, filename);
		if (!file.exists()) {
			throw new FileNotFoundException();
		}
		return file;
	}
	
	/**
	 * Returns the specified file from the external storage for write access. {@link
	 * File#exists()} might return {@code false} in case the specified file does not
	 * exist.
	 *
	 * @param filename the name of the file (may include subdirectories in case the file
	 *                 was stored in a subdirectory on the external storage, e.g., when
	 *                 trying to retrieve the file from {@code EXT/subdir/myFile.txt}, the
	 *                 specified {@code filename} would be {@code subdir/myFile.txt})
	 * @return the specified file from the external storage
	 * @throws ExternalStorageNotWritable if the external storage is unavailable for write
	 *                                    access
	 */
	public static File getWritableExternalFile(String filename) throws ExternalStorageNotWritable {
		ObjectUtil.requireNonNull(filename);
		if (!isExternalStorageWritable()) {
			throw new ExternalStorageNotWritable();
		}
		File externalRootDir = AndroidUtil.getContext().getExternalFilesDir(null);
		return new File(externalRootDir, filename);
	}
	
}
