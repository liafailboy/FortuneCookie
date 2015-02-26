public interface IMyPref {

	String myName;
	String myUserID;
	String myEmail;
	Person[] arrayOfPerson;

	void setMyName(String stringOfName);

	String getMyName();

	void setMyEmail(String stringOfEmail);

	String getMyEmail();

	void setMyUserId(String stringOfUserId);

	String getMyUserId();

	void addPerson(Person person);

	// throws NoSuchElementException if there is no person in the array
	void removePerson(Person person);

	Person[] getArrayOfPerson();
}