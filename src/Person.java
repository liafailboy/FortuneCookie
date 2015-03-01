
public class Person implements IPerson {
	
	String userID;
	String userEmail;
	String userName;
	int myUserLevel;
	int personUserLevel;
	
	// Constructor for the class. Initialize variables here.
	public Person(String userID, String userEmail, String userName, int myUserLevel, int personUserLevel) {
		this.userID = userID;
		this.userEmail = userEmail;
		this.userName = userName;
		this.myUserLevel = myUserLevel;
		this.personUserLevel = personUserLevel;
	}
	
	// default constructor
	public Person() {
		this("", "", "", 0, 0);
	}
	
	@Override
	public String getUserId() {
		return userID;
	}
	@Override
	public String getUserEmail() {
		return userEmail;
	}
	@Override
	public String getUserName() {
		return userName;
	}
	@Override
	public int getPersonLevel() {
		return myUserLevel + personUserLevel * 2;
	}
	@Override
	public int getMyUserLevel(){
		return myUserLevel;
	}
	
	@Override
	public void setMyUserLevel(int myLevel) {
		myUserLevel = myLevel;
	}
	@Override
	public void setPersonUserLevel(int personLevel) {
		personUserLevel = personLevel;
	}
	
}
