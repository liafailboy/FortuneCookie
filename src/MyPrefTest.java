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
	
<<<<<<< HEAD
=======
	@Test
	public void testAddPerson(){
		IPerson personA = new Person("", "", "A", 5, 5);
//		15, 7, 4, 9, 13, 2, 5, 3, 3, 7, 9
//		A, E, D, K, B, J, G, C, H, I
		IPerson personB = new Person("", "", "B", 1, 3);
		IPerson personC = new Person("", "", "C", 2, 1);
		IPerson personD = new Person("", "", "D", 3, 3);
		IPerson personE = new Person("", "", "E", 3, 5);
		IPerson personF = new Person("", "", "F", 0, 1);
		IPerson personG = new Person("", "", "G", 1, 2);
		IPerson personH = new Person("", "", "H", 3, 0);
		IPerson personI = new Person("", "", "I", 1, 1);
		IPerson personJ = new Person("", "", "J", 3, 2);
		IPerson personK = new Person("", "", "K", 1, 4);
		pref.addPerson(personA);
		pref.addPerson(personB);
		pref.addPerson(personC);
		pref.addPerson(personD);
		pref.addPerson(personE);
		pref.addPerson(personF);
		pref.addPerson(personG);
		pref.addPerson(personH);
		pref.addPerson(personI);
		pref.addPerson(personJ);
		pref.addPerson(personK);
		IPerson[] expected = new IPerson[10];
		expected[0] = personA;
		expected[1] = personE;
		expected[2] = personD;
		expected[3] = personK;
		expected[4] = personB;
		expected[5] = personJ;
		expected[6] = personG;
		expected[7] = personC;
		expected[8] = personH;
		expected[9] = personI;
		for(int i=0; i < 10; i++){
		System.out.println(pref.getArrayOfPerson()[i].getUserName());
		}
		assertArrayEquals(expected, pref.getArrayOfPerson());
	}
>>>>>>> cd1334b3c018384264a30d8f6bbe7a71e2bd3d3a
}