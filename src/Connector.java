import org.junit.Before;


public class Connector implements IConnector {
	
	private String objectId;
	private boolean isValid = false;
	
	@Override	
	public boolean setNewUserToServer(MyPref pref) {
		ParseQuery<ParseObject> query = ParseQuery.getQuery("PersonalData");
		query.whereEqualTo("myUserId", pref.getMyUserId());
		query.findInBackground(new FindCallback<ParseObject>() {
		    public void done(List<ParseObject> scoreList, ParseException e) {
		        if (e == null) {
		        	//isValid = false;
		        } else {
		            isValid = true;
		        }
		    }
		});
		if (!isValid) {
			return isValid;
		}else {		
		ParseQuery<ParseObject> query = ParseQuery.getQuery("PersonalData");
		query.whereEqualTo("myUserEmail", pref.getMyEmail());
		query.findInBackground(new FindCallback<ParseObject>() {
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
		
		ParseQuery<ParseObject> query = ParseQuery.getQuery("PersonalData");
		query.whereEqualTo("myUserId", pref.getMyUserId());
		query.findInBackground(new FindCallback<ParseObject>() {
		    public void done(List<ParseObject> scoreList, ParseException e) {
		        if (e == null) {
		        } else {
		            isValid = true;
		        }
		    }
		});
		if (!isValid) {
			return isValid;
		}else {		
		ParseQuery<ParseObject> query = ParseQuery.getQuery("PersonalData");
		query.whereEqualTo("myUserEmail", pref.getMyEmail());
		query.findInBackground(new FindCallback<ParseObject>() {
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
		isValid = false;
		ParseQuery<ParseObject> query = ParseQuery.getQuery("PersonalData");
		query.getInBackground(objectId, new GetCallback<ParseObject>() {
		  public void done(ParseObject object, ParseException e) {
		    if (e == null) {
		    	isValid = true;
		    } else {
		    	isValid = false;
		    }
		  }
		});
		if (isValid) {
		return myUserID = object.getString("myUserId");
		} else {
			return "invalid userID";
		}
	}

	@Override
	public String getUserEmailFromServer() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getUserNameFromServer() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean refreshArrayOfPeople() {
		// TODO Auto-generated method stub
		return false;
	}

}
