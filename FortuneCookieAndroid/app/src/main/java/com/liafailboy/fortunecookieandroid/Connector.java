package com.liafailboy.fortunecookieandroid;

import com.parse.FindCallback;
import com.parse.GetCallback;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;

import java.util.List;


public class Connector implements IConnector {
	
	private String objectId;
	private boolean isValid = false;
	
	@Override	
	public boolean setNewUserToServer(MyPref preference) {

        // set the final variable to use argument in the inner class
        final MyPref pref = preference;

        // Retrieve data as an query of the object
		ParseQuery<ParseObject> queryForID = ParseQuery.getQuery("PersonalData");
        queryForID.whereEqualTo("myUserId", pref.getMyUserId());
        queryForID.findInBackground(new FindCallback<ParseObject>() {
		    public void done(List<ParseObject> scoreList, ParseException e) {
		        if (e == null) {
		        } else {
		            isValid = true;
		        }
		    }
		});

        // If there is exsiting userID on the server, return false
		if (!isValid) {
			return isValid;
		} else {
		    ParseQuery<ParseObject> queryForEmail = ParseQuery.getQuery("PersonalData");
            queryForEmail.whereEqualTo("myUserEmail", pref.getMyEmail());
            queryForEmail.findInBackground(new FindCallback<ParseObject>() {
		    public void done(List<ParseObject> scoreList, ParseException e) {
		        if (e == null) {
		        	isValid = false;
		        } else {
                    // Create object and add the data on the server
		        	ParseObject personalData = new ParseObject("PersonalData");
		        	personalData.put("myName", pref.getMyName());
		        	personalData.put("myUserId", pref.getMyUserId());
		        	personalData.put("myUserEmail", pref.getMyEmail());
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
		}
		return isValid;
	}
	
	@Override
	public boolean updateMyInfoOnServer(MyPref preference) {

        // set the final variable to use argument in the inner class
        final MyPref pref = preference;

        // Retrieve data as an query of the object
		ParseQuery<ParseObject> query = ParseQuery.getQuery("PersonalData");
		query.getInBackground(objectId, new GetCallback<ParseObject>() {
		  public void done(ParseObject personalData, ParseException e) {
		    if (e == null) {
		      personalData.put("myName", pref.getMyName());
		      personalData.put("myUserId", pref.getMyUserId());
		      personalData.put("myUserEmail", pref.getMyUserId());
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

        // Retrieve data as an query of the object
		ParseQuery<ParseObject> queryForID = ParseQuery.getQuery("PersonalData");
        queryForID.whereEqualTo("myUserId", pref.getMyUserId());
        queryForID.findInBackground(new FindCallback<ParseObject>() {
		    public void done(List<ParseObject> scoreList, ParseException e) {
		        if (e == null) {
		        } else {
		            isValid = true;
		        }
		    }
		});
		if (!isValid) {
			return isValid;
		} else {
		    ParseQuery<ParseObject> queryForEmail = ParseQuery.getQuery("PersonalData");
            queryForEmail.whereEqualTo("myUserEmail", pref.getMyEmail());
            queryForEmail.findInBackground(new FindCallback<ParseObject>() {
		    public void done(List<ParseObject> scoreList, ParseException e) {
		        if (e == null) {
		        	isValid = false;
		        } else {
		            isValid = true;
		        }
		    }
		});
		}
		return isValid;
	}

	@Override
	public String getUserIDFromServer() {

        // set the final variable to use argument in the inner class
        final String[] myUserID = new String[1];

		isValid = false;
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

        // set the final variable to use argument in the inner class
        final String[] myUserEmail = new String[1];

		isValid = false;
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

        // set the final variable to use argument in the inner class
        final String[] myName = new String[1];

		isValid = false;
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
	public boolean refreshArrayOfPeople(MyPref pref) {
		isValid = false;
		ParseQuery<ParseObject> query = ParseQuery.getQuery("PersonalData");
		query.whereEqualTo("myUserEmail", pref.getMyEmail());
		query.findInBackground(new FindCallback<ParseObject>() {
		    public void done(List<ParseObject> scoreList, ParseException e) {
		        if (e == null) {
		        	isValid = true;
		        } else {
		        	isValid = false;
		        }
		    }
		});
        return isValid;
	}
}