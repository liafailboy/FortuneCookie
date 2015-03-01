
public class MyPref implements IMyPref {
	
	String myName;
	String myUserID;
	String myEmail;
	IPerson[] arrayOfPersonSelected;
	IPerson[] arrayOfPersonEvaluated;
	
	// Constructor for the class. Initialize variables here.
	public MyPref(String myName, String myUserID, String myEmail) {
		this.myName = myName;
		this.myUserID = myUserID;
		this.myEmail = myEmail;
		arrayOfPersonSelected = new IPerson[10];
		arrayOfPersonEvaluated = new IPerson[10];
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
	public void addPersonEvaluate(IPerson person) {
		// throw exception if the argument is null
		if (null == person) {
			throw new IllegalArgumentException("Argument person was null");
		}
		boolean isAdded = false;
		IPerson tmpValuePrev = null;
		IPerson tmpValueNext = null;
		for (int i = 0; i < arrayOfPersonEvaluated.length; i++) {
			boolean arrayElementNotNull = arrayOfPersonEvaluated[i] != null;
			if (arrayElementNotNull && person.getPersonLevel() > arrayOfPersonEvaluated[i].getPersonLevel() && !isAdded) {
			tmpValuePrev = arrayOfPersonEvaluated[i];
			arrayOfPersonEvaluated[i] = person;
			isAdded = true;
			} else if (arrayOfPersonEvaluated[i] == null && !isAdded) {
				arrayOfPersonEvaluated[i] = person;
				isAdded = true;
			}
			if (isAdded && i < arrayOfPersonEvaluated.length - 1) {
				tmpValueNext = arrayOfPersonEvaluated[i + 1];
				arrayOfPersonEvaluated[i + 1] = tmpValuePrev;
				tmpValuePrev = tmpValueNext;
			}
		}
	}
	
	@Override
	public boolean addPersonSelect(IPerson person) {
		for (int i = 0; i < arrayOfPersonSelected.length; i++) {
			if (null == arrayOfPersonSelected[i]) {
				arrayOfPersonSelected[i] = person;
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean removePersonSelect(IPerson person) {
		for (int i = 0; i < arrayOfPersonSelected.length; i++) {
			if (person.equals(arrayOfPersonSelected[i])) {
				arrayOfPersonSelected[i] = null;
				return true;
			}
		}
		return false;
	}
	
	@Override
	public IPerson[] getArrayOfPersonSelected() {
		return arrayOfPersonSelected;
	}
	
	@Override
	public IPerson[] getArrayOfPersonEvaluated() {
		return arrayOfPersonEvaluated;
	}
	
}
