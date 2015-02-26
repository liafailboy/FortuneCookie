
public class MyPref implements IMyPref {
	
	String myName;
	String myUserID;
	String myEmail;
	IPerson[] arrayOfPerson;
	
	// Constructor for the class. Initialize variables here.
	public MyPref() {
	}

	@Override
	public void setMyName(String stringOfName) {
		// TODO Auto-generated method stub
		myName = stringOfName;
	}

	@Override
	public String getMyName() {
		// TODO Auto-generated method stub
		return myName;
	}

	@Override
	public void setMyEmail(String stringOfEmail) {
		// TODO Auto-generated method stub
		myEmail = stringOfEmail;
	}

	@Override
	public String getMyEmail() {
		// TODO Auto-generated method stub
		return myEmail;
	}

	@Override
	public void setMyUserId(String stringOfUserId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getMyUserId() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addPerson(IPerson person) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removePerson(IPerson person) {
		// TODO Auto-generated method stub
		
	}
	
	/* This method should return the array of IPerson with the specified order
	 * Compare the level of the person in the array and make the order
	 * from highest to lowest.
	 * You should call this method every time after you added or removed person from the array
	 */
	private IPerson[] arrangeArrayOfPerson() {
		
		return null;
	}

	@Override
	public IPerson[] getArrayOfPerson() {
		// TODO Auto-generated method stub
		return null;
	}
}
