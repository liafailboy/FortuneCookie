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
        // 15, 7, 4, 9, 13, 2, 5, 3, 3, 7, 9
        // A, E, D, K, B, J, G, C, H, I
        IPerson personA = new Person("", "", "A", 5, 5);
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

        // Add instance to the array
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
        Person personL = new Person("", "", "L", 5, 4);
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

    }
}