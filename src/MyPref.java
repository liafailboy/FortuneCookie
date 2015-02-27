
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
		// TODO Auto-generated method stub
	}
	
	@Override
	public void removePerson(IPerson person) {
		// TODO Auto-generated method stub
	}

	@Override
	public IPerson[] getArrayOfPerson() {
		// TODO Auto-generated method stub
		return null;
	}
}
