package at.aspg.muscletraining.data.plans;

import org.xmlpull.v1.XmlSerializer;

import java.io.IOException;
import java.io.OutputStream;
import java.util.Collection;

import at.aspg.muscletraining.data.DisplayableItem;
import at.aspg.muscletraining.util.IOUtil;
import at.aspg.muscletraining.util.StringUtil;

public class Plan extends AbstractPlan {
	
	private Collection<TrainingDay> trainingDays;
	
	public Collection<TrainingDay> getTrainingDays() {
		return trainingDays;
	}
	
	public void setTrainingDays(Collection<TrainingDay> trainingDays) {
		this.trainingDays = trainingDays;
	}
	
	@Override
	public String getDetails() {
		return StringUtil.join(trainingDays, " | ");
	}
	
	@Override
	public void serialize(XmlSerializer serializer, OutputStream out) throws IOException {
		
	}

//	@Override
//	public void serialize(OutputStream out) {
//		// TODO: out.write(BEGIN_OF_LIST)
//		// TODO: for all other serialize implementations!!!! ---> use IOUtil.serializeDisplayableItems
//		IOUtil.serializeDisplayableItems(trainingDays, out);
//		// TODO: out.write(END_OF_LIST)
//	}
//
//	// TODO: static deserialize, also in all other classes!!!!!!
	
}
