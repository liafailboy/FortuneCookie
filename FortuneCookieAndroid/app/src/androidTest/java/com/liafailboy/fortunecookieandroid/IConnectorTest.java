package com.liafailboy.fortunecookieandroid;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class IConnectorTest {

    Connector con;
    MyPref pref;


    @Before
    public void setUp() throws Exception {
        pref = new MyPref;
        pref.setMyEmail("shotaro.w@gatech.edu");
        pref.setMyName("Shotaro Watanabe");
        pref.setMyUserId("liafailboy");
        Person personA = new Person("", "", "A", 5, 5);
        //		15, 7, 4, 9, 13, 2, 5, 3, 3, 7, 9
        //		A, E, D, K, B, J, G, C, H, I
        Person personB = new Person("", "", "B", 1, 3);
        Person personC = new Person("", "", "C", 2, 1);
        Person personD = new Person("", "", "D", 3, 3);
        Person personE = new Person("", "", "E", 3, 5);
        Person personF = new Person("", "", "F", 0, 1);
        Person personG = new Person("", "", "G", 1, 2);
        Person personH = new Person("", "", "H", 3, 0);
        Person personI = new Person("", "", "I", 1, 1);
        Person personJ = new Person("", "", "J", 3, 2);
        Person personK = new Person("", "", "K", 1, 4);
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
        assertTrue(con.setNewUserToServer(pref));
        assertFalse(con.setNewUserToServer(pref));
        pref.setMyEmail("liafailboy@gmail.com");
        assertFalse(con.setNewUserToServer(pref));
        pref.setMyEmail("shotaro.w@gatech.edu");
        pref.setMyUserId("liafailbay");
        assertFalse(con.setNewUserToServer(pref));
    }

    @Test
    public void testUpdateMyInfoOnServer() throws Exception {
        con.setNewUserToServer(pref);
        pref.setMyUserId("tommy03b");
        pref.setMyEmail("tiamo_eris@yahoo.co.jp");
        pref.setMyName("Eriko Sasaki");
        Person personL = new Person("", "", "L", 5, 4);
        pref.addPersonSelect(personL);
        assertTrue(con.updateMyInfoOnServer(pref));
        System.out.println(pref.getMyUserId());
        System.out.println(pref.getMyEmail());
        System.out.println(pref.getMyName());
        System.out.println(pref.getArrayOfPersonSelected()[1]);
    }

    @Test
    public void testIsValidUserNameAndPass() throws Exception {
        assertFalse(con.isValidUserNameAndPass("tommy03b", "shotaro.w@gatech.edu", pref));
        assertFalse(con.isValidUserNameAndPass("liafailboy", "tiamo_eris@yahoo.co.jp", pref));
        assertTrue(con.isValidUserNameAndPass("tommy03b", "tiamo_eris@yahoo.co.jp", pref));
    }

    @Test
    public void testGetUserIDFromServer() throws Exception {
        con.setNewUserToServer(pref);
        assertEquals("liafailboy",con.getUserIDFromServer());
    }

    @Test
    public void testGetUserEmailFromServer() throws Exception {
        con.setNewUserToServer(pref);
        assertEquals("shotaro.w@gatech.edu", con.getUserEmailFromServer());
    }

    @Test
    public void testGetUserNameFromServer() throws Exception {
        con.setNewUserToServer(pref);
        assertEquals("Shotaro Watanabe", con.getUserNameFromServer());
    }

    @Test
    public void testRefreshArrayOfPeople() throws Exception {

    }
}