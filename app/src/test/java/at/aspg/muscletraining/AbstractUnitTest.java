package at.aspg.muscletraining;

import android.content.Context;

import org.junit.After;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import at.aspg.muscletraining.util.AndroidUtil;

import static org.mockito.Mockito.when;

/**
 * This abstract class serves as a base test class for each kind of unit tests in need of context specific resources.
 * Therefore it mocks the global information about the application environment.
 */
//TODO: maybe add methods for simple mock objects?!
@RunWith(RobolectricTestRunner.class)
@Config(manifest = "app/src/main/AndroidManifest.xml")
public abstract class AbstractUnitTest {
	
	@Mock
	protected Context mockContext;
	
	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		AndroidUtil.setContext(mockContext);
		defineMockContext();
	}
	
	private void defineMockContext() {
		when(mockContext.getString(R.string.app_name)).thenReturn("MuscleTraining");
		when(mockContext.getString(R.string._break)).thenReturn("Break");
		when(mockContext.getString(R.string.default_exercise)).thenReturn("Default Exercise");
		when(mockContext.getString(R.string.default_plan)).thenReturn("Default Plan");
	}
	
	@After
	public void tearDown() throws Exception {
		
	}
	
}
