package at.aspg.muscletraining.util;

import android.os.Environment;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.security.ArrayTypePermission;
import com.thoughtworks.xstream.security.InterfaceTypePermission;
import com.thoughtworks.xstream.security.NoTypePermission;
import com.thoughtworks.xstream.security.NullPermission;
import com.thoughtworks.xstream.security.PrimitiveTypePermission;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URI;
import java.net.URL;
import java.nio.charset.Charset;
import java.text.DecimalFormatSymbols;
import java.util.BitSet;
import java.util.Collection;
import java.util.Currency;
import java.util.Date;
import java.util.HashSet;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;

import at.aspg.muscletraining.data.exercises.Break;
import at.aspg.muscletraining.data.exercises.WeightRepsExercise;
import at.aspg.muscletraining.data.plans.TrainingDay;
import at.aspg.muscletraining.exceptions.ExternalStorageNotReadable;
import at.aspg.muscletraining.exceptions.ExternalStorageNotWritable;

public class IOUtil {
	
	private IOUtil() {
	}
	
	/**
	 * Lazily initialized, so every access must be done via {@link #getXStream()}.
	 */
	private static XStream xStream;
	
	/**
	 * Returns the XStream instance. Upon first calling this method, the instance will be
	 * fully initialized with security setups and aliases.
	 *
	 * @return the XStream instance
	 */
	public static XStream getXStream() {
		if (xStream == null) {
			xStream = new XStream();
			// set up security
			// partly copied from static method XStream.setupDefaultSecurity(XStream)
			// which is only available in library version >= 1.4.10
			xStream.addPermission(NoTypePermission.NONE);
			xStream.addPermission(NullPermission.NULL);
			xStream.addPermission(PrimitiveTypePermission.PRIMITIVES);
			xStream.addPermission(ArrayTypePermission.ARRAYS);
			xStream.addPermission(InterfaceTypePermission.INTERFACES);
			// entire Java type hierarchies
			xStream.allowTypeHierarchy(Collection.class);
			xStream.allowTypeHierarchy(Map.class);
			xStream.allowTypeHierarchy(Map.Entry.class);
			xStream.allowTypeHierarchy(Number.class);
			xStream.allowTypeHierarchy(Enum.class);
			// selected single Java types
			Set<Class<?>> types = new HashSet<>();
			types.add(BitSet.class);
			types.add(Charset.class);
			types.add(Class.class);
			types.add(Currency.class);
			types.add(Date.class);
			types.add(DecimalFormatSymbols.class);
			types.add(File.class);
			types.add(Locale.class);
			types.add(Object.class);
			types.add(Pattern.class);
			types.add(StackTraceElement.class);
			types.add(String.class);
			types.add(StringBuffer.class);
			types.add(URL.class);
			types.add(URI.class);
			xStream.allowTypes(types.toArray(new Class[0]));
			// allow all types inside the data package (recursively)
			xStream.allowTypesByWildcard(new String[] {
					"at.aspg.muscletraining.data.**"
			});
			// set up aliases
			xStream.alias("TrainingDay", TrainingDay.class);
			xStream.alias("Break", Break.class);
			xStream.alias("WeightRepsExercise", WeightRepsExercise.class);
			//TODO add all classes here?
		}
		return xStream;
	}
	
	/**
	 * Serializes the specified object to the specified file. If the file already exists,
	 * it will be overwritten. If not, a new file will be created.
	 *
	 * @param object the object to serialize
	 * @param file   the destination file to which the object is serialized
	 * @throws IOException if the file cannot be created
	 */
	public static void serialize(Object object, File file) throws IOException {
		PrintWriter writer = null;
		try {
			writer = new PrintWriter(file);
			getXStream().toXML(object, writer);
		} finally {
			if (writer != null) {
				writer.close();
			}
		}
	}
	
	/**
	 * Deserializes an object from the specified file. The return value of this method is
	 * generic to allow arbitrary objects to be deserialized without having to use a type
	 * cast, e.g.:
	 * <pre>{@code
	 *     String string = deserialize(myFile1);
	 *     Map<Integer, List<Date>> map = deserialize(myFile2);
	 *     MyClass myClass = deserialize(myFile3);
	 * }</pre>
	 *
	 * @param file the file from which to deserialize the object
	 * @param <T>  the type of the deserialized object
	 * @return the deserialized object
	 * @throws FileNotFoundException if the specified file could not be found or if it is
	 *                               a directory
	 */
	@SuppressWarnings("unchecked")
	public static <T> T deserialize(File file) throws FileNotFoundException {
		if (!file.exists() || file.isDirectory()) {
			throw new FileNotFoundException();
		}
		return (T) getXStream().fromXML(file);
	}
	
	/**
	 * Returns the specified file from the internal storage for read access.
	 *
	 * @param filename the name of the file (may include subdirectories in case the file
	 *                 was stored in a subdirectory on the internal storage, e.g., when
	 *                 trying to retrieve the file from {@code INT/subdir/myFile.txt}, the
	 *                 specified {@code filename} would be {@code subdir/myFile.txt})
	 * @return the specified file from the internal storage
	 * @throws FileNotFoundException if the specified file could not be found
	 */
	public static File getReadableInternalFile(String filename) throws FileNotFoundException {
		ObjectUtil.requireNonNull(filename);
		File internalRootDir = AndroidUtil.getContext().getFilesDir();
		File file = new File(internalRootDir, filename);
		if (!file.exists()) {
			throw new FileNotFoundException();
		}
		return file;
	}
	
	/**
	 * Returns the specified file from the internal storage for write access. {@link
	 * File#exists()} might return {@code false} in case the specified file does not
	 * exist.
	 *
	 * @param filename the name of the file (may include subdirectories in case the file
	 *                 was stored in a subdirectory on the internal storage, e.g., when
	 *                 trying to retrieve the file from {@code INT/subdir/myFile.txt}, the
	 *                 specified {@code filename} would be {@code subdir/myFile.txt})
	 * @return the specified file from the internal storage
	 */
	public static File getWritableInternalFile(String filename) {
		ObjectUtil.requireNonNull(filename);
		File internalRootDir = AndroidUtil.getContext().getExternalFilesDir(null);
		return new File(internalRootDir, filename);
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
