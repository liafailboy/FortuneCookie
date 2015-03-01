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
	public boolean setNewUserToServer(MyPref pref) {
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
	public boolean updateMyInfoOnServer(MyPref pref) {
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
	public boolean isValidUserNameAndPass(String userID, String pass) {
		
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
		String myUserID;
		isValid = false;
		ParseQuery<ParseObject> query = ParseQuery.getQuery("PersonalData");
		query.getInBackground(objectId, new GetCallback<ParseObject>() {
		  public void done(ParseObject object, ParseException e) {
		    if (e == null) {
		    	isValid = true;
		    	myUserID = object.getString("myUserId");
		    } else {
		    	isValid = false;
		    }
		  }
		});
		if (isValid) {
		return myUserID;
		} else {
			return "invalid userID or password";
		}
	}

	@Override
	public String getUserEmailFromServer() {
		String myUserEmail;
		isValid = false;
		ParseQuery<ParseObject> query = ParseQuery.getQuery("PersonalData");
		query.getInBackground(objectId, new GetCallback<ParseObject>() {
		  public void done(ParseObject object, ParseException e) {
		    if (e == null) {
		    	isValid = true;
		    	myUserEmail = object.getString("myUserEmail");
		    } else {
		    	isValid = false;
		    }
		  }
		});
		if (isValid) {
		return myUserEmail;
		} else {
			return "invalid userID or password";
		}
	}

	@Override
	public String getUserNameFromServer() {
		String myName;
		isValid = false;
		ParseQuery<ParseObject> query = ParseQuery.getQuery("PersonalData");
		query.getInBackground(objectId, new GetCallback<ParseObject>() {
		  public void done(ParseObject object, ParseException e) {
		    if (e == null) {
		    	isValid = true;
		    	myName = object.getString("myName");
		    } else {
		    	isValid = false;
		    }
		  }
		});
		if (isValid) {
		return myName;
		} else {
			return "invalid userID or password";
		}
	}
	
	
	/**
	 * There is a lot of things to do in this method
	 * 1. Search the user email on the server
	 * 2. Get the rank of each people by me, and the rank of the user from them
	 * 3. Create Person class instance for every people
	 * 4. add all instance using addPersonEvaluate(Person person)
	 * @return whether the array was refreshed successfully
	 */
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