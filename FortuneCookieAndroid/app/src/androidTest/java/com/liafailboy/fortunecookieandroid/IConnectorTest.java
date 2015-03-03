package com.liafailboy.fortunecookieandroid;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class IConnectorTest {

    // Classes used for the test case
    Connector con;
    MyPref pref;

    @Before
    public void setUp() throws Exception {

        // Initialize classes with arguments
        pref = new MyPref("Shotaro Watanabe", "liafailboy", "shotaro.w@gatech.edu");
        con = new Connector();

        // Create instance of Person
        IPerson personA = new Person("", "", "A", 5, 0);
        IPerson personB = new Person("", "", "B", 1, 0);
        IPerson personC = new Person("", "", "C", 2, 0);
        IPerson personD = new Person("", "", "D", 3, 0);
        IPerson personE = new Person("", "", "E", 3, 0);
        IPerson personF = new Person("", "", "F", 0, 0);
        IPerson personG = new Person("", "", "G", 1, 0);
        IPerson personH = new Person("", "", "H", 3, 0);
        IPerson personI = new Person("", "", "I", 1, 0);
        IPerson personJ = new Person("", "", "J", 3, 0);
        IPerson personK = new Person("", "", "K", 1, 0);

        // Add instance to the array
        pref.addPersonSelect(personA);
        pref.addPersonSelect(personB);
        pref.addPersonSelect(personC);
        pref.addPersonSelect(personD);
        pref.addPersonSelect(personE);
        pref.addPersonSelect(personF);
        pref.addPersonSelect(personG);
        pref.addPersonSelect(personH);
        pref.addPersonSelect(personI);
        pref.addPersonSelect(personJ);
        pref.addPersonSelect(personK);
    }

    @Test
    public void testSetNewUserToServer() throws Exception {

        // True will be returned when the user was added on server
        assertTrue(con.setNewUserToServer(pref));

        // False will be returned if the user try to add duplication ID and Email
        assertFalse(con.setNewUserToServer(pref));

        // False will be returned if the user try to add dupulicate ID
        pref.setMyEmail("liafailboy@gmail.com");
        assertFalse(con.setNewUserToServer(pref));

        // False will be returned if the user try to add dupulicate Email
        pref.setMyEmail("shotaro.w@gatech.edu");
        pref.setMyUserId("shotarow");
        assertFalse(con.setNewUserToServer(pref));
    }

    @Test
    public void testUpdateMyInfoAndGetInfoOnServer() throws Exception {

        // reset the ID, Email, and Name
        pref.setMyUserId("tommy03b");
        pref.setMyEmail("tiamo_eris@yahoo.co.jp");
        pref.setMyName("Eriko Sasaki");

        // Add new person on the array
        Person personL = new Person("", "", "L", 5, 0);
        pref.addPersonSelect(personL);

        // Update info on server
        assertTrue(con.updateMyInfoOnServer(pref));

        // Get the ID, Email, and Name from server and compare it to the local data
        assertEquals(pref.getMyUserId(), con.getUserIDFromServer());
        assertEquals(pref.getMyName(), con.getUserNameFromServer());
        assertEquals(pref.getMyEmail(), con.getUserEmailFromServer());
    }

    @Test
    public void testIsValidUserNameAndPass() throws Exception {

        // False will be returned with different username
        assertFalse(con.isValidUserNameAndPass("tommy03b", "shotaro.w@gatech.edu", pref));

        // False will be returned with different email
        assertFalse(con.isValidUserNameAndPass("liafailboy", "tiamo_eris@yahoo.co.jp", pref));

        // True will be returned with valid username and email
        assertTrue(con.isValidUserNameAndPass("tommy03b", "tiamo_eris@yahoo.co.jp", pref));
    }

    @Test
    public void testRefreshArrayOfPeople() throws Exception {

        pref = new MyPref("Eriko Sasaki", "tommy03b", "tiamo_eris@yahoo.co.jp");

        //set the values for pref.
        IPerson personA = new Person("", "", "A", 5, 0);
        IPerson personB = new Person("", "", "B", 1, 0);
        IPerson personC = new Person("", "", "C", 2, 0);
        IPerson personD = new Person("", "", "D", 3, 0);
        IPerson personE = new Person("", "", "E", 3, 0);
        IPerson personF = new Person("", "", "F", 0, 0);
        IPerson personG = new Person("", "", "G", 1, 0);
        IPerson personH = new Person("", "", "H", 3, 0);
        IPerson personI = new Person("", "", "I", 1, 0);
        IPerson personJ = new Person("", "", "J", 3, 0);
        IPerson personK = new Person("", "", "K", 1, 0);

        // Add instance to the array
        pref.addPersonSelect(personA);
        pref.addPersonSelect(personB);
        pref.addPersonSelect(personC);
        pref.addPersonSelect(personD);
        pref.addPersonSelect(personE);
        pref.addPersonSelect(personF);
        pref.addPersonSelect(personG);
        pref.addPersonSelect(personH);
        pref.addPersonSelect(personI);
        pref.addPersonSelect(personJ);
        pref.addPersonSelect(personK);

        con.setNewUserToServer(pref);

        //create different instance of MyPref and Person with changed values
        MyPref tmpPref = new MyPref("Shotaro Watanabe", "liafailboy", "shotaro.w@gatech.edu")

        IPerson personM = new Person("", "tiamo_eris@yahoo.co.jp", "", 2, 0);
        IPerson personN = new Person("", "", "B", 3, 0);
        IPerson personO = new Person("", "", "C", 2, 0);
        IPerson personP = new Person("", "", "D", 5, 0);
        IPerson personQ = new Person("", "", "E", 4, 0);
        IPerson personR = new Person("", "", "F", 5, 0);
        IPerson personS = new Person("", "", "G", 1, 0);
        IPerson personT = new Person("", "", "H", 2, 0);
        IPerson personU = new Person("", "", "I", 2, 0);
        IPerson personV = new Person("", "", "J", 3, 0);
        IPerson personW = new Person("", "", "K", 4, 0);

        // Add instance to the second array
        tmpPref.addPersonSelect(personM);
        tmpPref.addPersonSelect(personN);
        tmpPref.addPersonSelect(personO);
        tmpPref.addPersonSelect(personP);
        tmpPref.addPersonSelect(personQ);
        tmpPref.addPersonSelect(personR);
        tmpPref.addPersonSelect(personS);
        tmpPref.addPersonSelect(personT);
        tmpPref.addPersonSelect(personU);
        tmpPref.addPersonSelect(personV);
        tmpPref.addPersonSelect(personW);

        //created expected array after refresh is complete
        IPerson[] expected = new IPerson[10];
        expected[0] = personA;
        expected[1] = personM;
        expected[2] = personD;
        expected[3] = personE;
        expected[4] = personH;
        expected[5] = personJ;
        expected[6] = personC;
        expected[7] = personB;
        expected[8] = personG;
        expected[9] = personI;

        con.setNewUserToServer(tmpPref);
        assertTrue(con.refreshArrayOfPeople(pref));

        //check if array is really refreshed
        assertArrayEquals(expected, pref.getArrayOfPersonEvaluated());

        IPerson personX = new Person("", "shotaro.w@gatech.edu", "", 5, 0);
        pref.removePersonSelect(personI);
        pref.addPersonSelect(personX);
        //add shotaro.w@gatech.edu to selectedArray to see if myUserLevel and personUserLevel will be properly calculated.
        //only object number 0, 1, and 9 will change due to this action.
        expected[0] = personM;
        expected[1] = personA;
        expected[9] = personK;
        assertArrayEquals(expected, pref.getArrayOfPersonEvaluated());
    }
}