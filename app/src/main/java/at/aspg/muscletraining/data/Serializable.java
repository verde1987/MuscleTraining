package at.aspg.muscletraining.data;

import org.xmlpull.v1.XmlSerializer;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public interface Serializable {
	
	void serialize(XmlSerializer serializer, OutputStream out) throws IOException;
	
}
