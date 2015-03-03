package com.liafailboy.fortunecookieandroid;

import com.parse.FindCallback;
import com.parse.GetCallback;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;

import java.util.List;
import java.util.NoSuchElementException;


public class Connector implements IConnector {
	
	private String objectId;
	private boolean isValid = false;
	
	@Override	
	public boolean setNewUserToServer(MyPref preference, String pass) {

        // set the final variable to use argument in the inner class
        final MyPref pref = preference;
        final String password = pass;

        // Retrieve data as an query of the object
		ParseQuery<ParseObject> queryForID = ParseQuery.getQuery("PersonalData");
        queryForID.whereEqualTo("myUserId", pref.getMyUserId());
        queryForID.findInBackground(new FindCallback<ParseObject>() {
		    public void done(List<ParseObject> scoreList, ParseException e) {
		        if (e == null) {
		            // this userId is already used by another user.
		        } else {
		            // this userId can be used.
                    isValid = true;
		        }
		    }
		});

        // If there is exsiting userID on the server, return false
		if (!isValid) return isValid;

        ParseQuery<ParseObject> queryForEmail = ParseQuery.getQuery("PersonalData");
        queryForEmail.whereEqualTo("myUserEmail", pref.getMyEmail());
        queryForEmail.findInBackground(new FindCallback<ParseObject>() {
		    public void done(List<ParseObject> scoreList, ParseException e) {
		    if (e == null) {
		        // there is already another user using this EMail.
		        isValid = false;
		    } else {
		        // Create object and add the data on the server
		        ParseObject personalData = new ParseObject("PersonalData");
		       	personalData.put("myName", pref.getMyName());
		        personalData.put("myUserId", pref.getMyUserId());
		        personalData.put("myUserEmail", pref.getMyEmail());
                personalData.put("myPass", password);
		        for (int i = 0; i < 10; i++) {
		        	personalData.put("person" + i + "Email", pref.getArrayOfPersonSelected()[i]);
		        	personalData.put("myPerson" + i + "Level", pref.getArrayOfPersonSelected()[i].getMyUserLevel());
		        }
		        personalData.saveInBackground();
		        objectId = personalData.getObjectId();
		        isValid = true;
		    }
		    }
		});
		return isValid;
	}
	
	@Override
	public boolean updateMyInfoOnServer(MyPref preference, String pass) {

        // set the final variable to use argument in the inner class
        final MyPref pref = preference;
        final String password = pass;

        // Retrieve data as an query of the object
		ParseQuery<ParseObject> query = ParseQuery.getQuery("PersonalData");
		query.getInBackground(objectId, new GetCallback<ParseObject>() {
		  public void done(ParseObject personalData, ParseException e) {
		    if (e == null) {
		      personalData.put("myName", pref.getMyName());
		      personalData.put("myUserId", pref.getMyUserId());
		      personalData.put("myUserEmail", pref.getMyUserId());
              personalData.put("myPass", password);
		      for (int i = 0; i < 10; i++) {
	        		personalData.put("person" + i + "Email", pref.getArrayOfPersonSelected()[i]);
	        		personalData.put("myPerson" + i + "Level", pref.getArrayOfPersonSelected()[i].getMyUserLevel());
	        	}
		      personalData.saveInBackground();
		    }
		  }
		});
		return true;
	}

	@Override
	public boolean isValidUserNameAndPass(String userID, String pass, MyPref preference) {

        // throw the exception if the argument was null
        if (userID == null || pass == null || preference == null) {
            throw new IllegalArgumentException("userId, pass, or preference is null");
        }

        // set the final variable to use argument in the inner class
        final MyPref pref = preference;
        final String password = pass;

        // Retrieve data as an query of the object
		ParseQuery<ParseObject> queryForID = ParseQuery.getQuery("PersonalData");
        queryForID.whereEqualTo("myUserId", pref.getMyUserId());
        queryForID.findInBackground(new FindCallback<ParseObject>() {
		    public void done(List<ParseObject> scoreList, ParseException e) {
		        if (e == null) {
                //server userId matched the entered userId
                isValid = true;
		        } else {
                //server userId did not match the entered userId
		        }
		    }
		});

        // return false if userID is not valid
        if (!isValid) {
            return isValid;
        }

        ParseQuery<ParseObject> queryForPass = ParseQuery.getQuery("PersonalData");
        queryForPass.whereEqualTo("myPass", password);
        queryForPass.findInBackground(new FindCallback<ParseObject>() {
            public void done(List<ParseObject> scoreList, ParseException e) {
                if (e == null) {
                    //server pass matched the entered pass
                    isValid = true;
                } else {
                    //server pass did not match the entered pass
                }
            }
        });
		return isValid;
	}

	@Override
	public String getUserIDFromServer() {

        // throw exception if there is no objectId set
        if (objectId.equals("")) {
            throw new NoSuchElementException("objectId is not yet set");
        }

        // set the final variable to use argument in the inner class
        final String[] myUserID = new String[1];

		isValid = false;

        // Get data with query from the server
		ParseQuery<ParseObject> query = ParseQuery.getQuery("PersonalData");
		query.getInBackground(objectId, new GetCallback<ParseObject>() {
		  public void done(ParseObject object, ParseException e) {
		    if (e == null) {
		    	isValid = true;
		    	myUserID[0] = object.getString("myUserId");
		    } else {
		    	isValid = false;
		    }
		  }
		});
		if (isValid) {
		    return myUserID[0];
		} else {
			return "Invalid userID or password";
		}
	}

	@Override
	public String getUserEmailFromServer() {

        // throw exception if there is no objectId set
        if (objectId.equals("")) {
            throw new NoSuchElementException("objectId is not yet set");
        }

        // set the final variable to use argument in the inner class
        final String[] myUserEmail = new String[1];

		isValid = false;

        // Get data with query from the server
		ParseQuery<ParseObject> query = ParseQuery.getQuery("PersonalData");
		query.getInBackground(objectId, new GetCallback<ParseObject>() {
		  public void done(ParseObject object, ParseException e) {
		    if (e == null) {
		    	isValid = true;
		    	myUserEmail[0] = object.getString("myUserEmail");
		    } else {
		    	isValid = false;
		    }
		  }
		});
		if (isValid) {
		    return myUserEmail[0];
		} else {
			return "Invalid userID or password";
		}
	}

	@Override
	public String getUserNameFromServer() {

        // throw exception if there is no objectId set
        if (objectId.equals("")) {
            throw new NoSuchElementException("objectId is not yet set");
        }
        // set the final variable to use argument in the inner class
        final String[] myName = new String[1];

		isValid = false;

        // Get data with query from the server
		ParseQuery<ParseObject> query = ParseQuery.getQuery("PersonalData");
		query.getInBackground(objectId, new GetCallback<ParseObject>() {
		  public void done(ParseObject object, ParseException e) {
		    if (e == null) {
		    	isValid = true;
		    	myName[0] = object.getString("myName");
		    } else {
		    	isValid = false;
		    }
		  }
		});
		if (isValid) {
		    return myName[0];
		} else {
			return "Invalid userID or password";
		}
	}

	@Override
	public boolean refreshArrayOfPeople(MyPref preference) {
		isValid = false;

        // set final variables to use argument in the inner class
        final MyPref pref = preference;
        final int[] myUserLevel = new int[1];
        final int[] matchedPersonUserLevel = new int[1];

        //create list of people who entered the user's email
		ParseQuery<ParseObject> query = ParseQuery.getQuery("PersonalData");
		for (int i = 0; i < 10; i++) {
            query.whereEqualTo("person" + i + "Email", pref.getMyEmail());
        }

        query.findInBackground(new FindCallback<ParseObject>() {
		    public void done(List<ParseObject> scoreList, ParseException e) {
                if (e == null) {
                    //there was a match with email and server data
                    isValid = true;
                } else {
                    //there was no match with email and server
                    isValid = true;
                }

                for (int i = 0; i < scoreList.size(); i++) {

                    //retrieve necessary data from scoreList to create new Person instance
                    String matchedPersonId = scoreList.get(i).getString("myUserId");
                    String matchedPersonEmail = scoreList.get(i).getString("myUserEmail");
                    String matchedPersonName = scoreList.get(i).getString("myName");

                    for (int n = 0; n < 10; n++) {
                        if (scoreList.get(i).getString("person" + n + "Email").equals(pref.getMyEmail())) {
                            matchedPersonUserLevel[0] = Integer.parseInt(scoreList.get(i).getString("myPerson" + n + "Level"));
                            isValid = true;
                        } else {
                            throw new NoSuchElementException("error occurred when refreshing");
                        }
                    }

                    if (pref.arrayOfPersonSelected[i].getUserEmail().equals(matchedPersonEmail)) {
                        myUserLevel[0] = pref.arrayOfPersonSelected[i].getMyUserLevel();
                    } else {
                        myUserLevel[0] = 0;
                    }

                    // create new Person instance using scoreList data
                    IPerson matchedPerson = new Person(matchedPersonId, matchedPersonEmail, matchedPersonName, myUserLevel[0], matchedPersonUserLevel[0]);

                    //add matched persons to array
                    pref.addPersonEvaluate(matchedPerson);
                }
            }
        });

        //next, addPerson from the user's selected list of people.
        //the other users who added the user on their list have already been added.
        //so, only consider the ones that are only Selected by the user.
        ParseQuery<ParseObject> queryForSelectedPerson = ParseQuery.getQuery("PersonalData");
        final int[] arrayOfI = new int[1];
        for (int i = 0; i < 10; i++) {
            arrayOfI[0] = i;
            queryForSelectedPerson.whereEqualTo("myUserEmail", pref.getArrayOfPersonSelected()[i].getUserEmail());
//            filter out persons already added with matchedPerson
            queryForSelectedPerson.whereNotEqualTo("person" + i + "Email", pref.getMyEmail());
            queryForSelectedPerson.getFirstInBackground(new GetCallback<ParseObject>() {
                public void done(ParseObject object, ParseException e) {
                    if (object == null) {
                        // request failed
                    } else {
                        //successfully retrieved object
                        isValid = true;
                    }

                //retrieve necessary info from object
                String selectedPersonId = object.getString("myUserId");
                String selectedPersonEmail = object.getString("myUserEmail");
                String selectedPersonName = object.getString("myName");
                final int selectedMyUserLevel = pref.getArrayOfPersonSelected()[arrayOfI[0]].getMyUserLevel();

                //create new Person instance using above data
                IPerson selectedPerson = new Person (selectedPersonId, selectedPersonEmail, selectedPersonName, selectedMyUserLevel, 0);

                pref.addPersonEvaluate(selectedPerson);
                }
            });
        }
        return isValid;
	}
}