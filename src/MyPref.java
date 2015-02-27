
public class MyPref implements IMyPref {
	
	String myName;
	String myUserID;
	String myEmail;
	IPerson[] arrayOfPerson;
	
	// Constructor for the class. Initialize variables here.
	public MyPref(String myName, String myUserID, String myEmail) {
		this.myName = myName;
		this.myUserID = myUserID;
		this.myEmail = myEmail;
		arrayOfPerson = new IPerson[10];
	}
	
	// default constructor
	public MyPref() {
		this("", "", "");
	}

	@Override
	public void setMyName(String stringOfName) {
		myName = stringOfName;
	}

	@Override
	public String getMyName() {
		return myName;
	}

	@Override
	public void setMyEmail(String stringOfEmail) {
		myEmail = stringOfEmail;
	}

	@Override
	public String getMyEmail() {
		return myEmail;
	}

	@Override
	public void setMyUserId(String stringOfUserId) {
		myUserID = stringOfUserId;
	}

	@Override
	public String getMyUserId() {
		return myUserID;
	}

	@Override
	public void addPerson(IPerson person) {
		// throw exception if the argument is null
		if (null == person) {
			throw new IllegalArgumentException("Argument person was null");
		}
		boolean isAdded = false;
		IPerson tmpValuePrev = null;
		IPerson tmpValueNext = null;
		for(int i = 0; i < arrayOfPerson.length; i++){
			if(arrayOfPerson[i] != null && person.getPersonLevel() > arrayOfPerson[i].getPersonLevel() && !isAdded){
			tmpValuePrev = arrayOfPerson[i];
			arrayOfPerson[i] = person;
			isAdded = true;
			} else if(arrayOfPerson[i] == null && !isAdded){
				arrayOfPerson[i] = person;
				isAdded = true;
			}
			if(isAdded && i < arrayOfPerson.length - 1){
				tmpValueNext = arrayOfPerson[i + 1];
				arrayOfPerson[i + 1] = tmpValuePrev;
				tmpValuePrev = tmpValueNext;
			}
		}
	}
	
	@Override
	public IPerson[] getArrayOfPerson() {
		return arrayOfPerson;
	}
}
