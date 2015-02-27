
public class Person implements IPerson {
	
	String userID;
	String userEmail;
	String userName;
	int myUserLevel;
	int personUserLevel;
	
	// Constructor for the class. Initialize variables here.
	public Person() {
		userID = "";
		userEmail = "";
		userName = "";
		myUserLevel = 0;
		personUserLevel = 0;
	}
	
	@Override
	public String getUserId() {
		// TODO Auto-generated method stub
		return userID;
	}
	@Override
	public String getUserEmail() {
		// TODO Auto-generated method stub
		return userEmail;
	}
	@Override
	public String getUserName() {
		// TODO Auto-generated method stub
		return userName;
	}
	@Override
	public int getPersonLevel() {
		// TODO Auto-generated method stub
		return myUserLevel + personUserLevel * 2;
	}
	@Override
	public void setMyUserLevel(int myLevel) {
		// TODO Auto-generated method stub
		myUserLevel = myLevel;
	}
	@Override
	public void setPersonUserLevel(int personLevel) {
		// TODO Auto-generated method stub
		personUserLevel = personLevel;
	}
	
}
