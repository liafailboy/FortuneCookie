import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


public class MyPrefTest {

	MyPref pref;
	
	@Before
	public void setUp() {
		pref = new MyPref("Shotaro Watanabe", "liafailboy", "shotaro.w@gatech.edu");
	}
	
	@Test
	public void testSetGetMyname() {
		pref.setMyName("Eriko Sasaki");
		String str = pref.getMyName();
		assertEquals(str,"Eriko Sasaki");
	}

}