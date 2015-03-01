package com.liafailboy.fortunecookieandroid;
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
		pref.addPersonEvaluate(personA);
		pref.addPersonEvaluate(personB);
		pref.addPersonEvaluate(personC);
		pref.addPersonEvaluate(personD);
		pref.addPersonEvaluate(personE);
		pref.addPersonEvaluate(personF);
		pref.addPersonEvaluate(personG);
		pref.addPersonEvaluate(personH);
		pref.addPersonEvaluate(personI);
		pref.addPersonEvaluate(personJ);
		pref.addPersonEvaluate(personK);
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
		assertArrayEquals(expected, pref.getArrayOfPersonEvaluated());
	}
}