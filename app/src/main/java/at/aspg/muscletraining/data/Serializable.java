package at.aspg.muscletraining.data;

import java.io.InputStream;
import java.io.OutputStream;

public interface Serializable {
	
	void serialize(OutputStream out);
	
}
