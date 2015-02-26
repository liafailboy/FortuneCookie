public interface IMyPref {

	void setMyName(String stringOfName);

	String getMyName();

	void setMyEmail(String stringOfEmail);

	String getMyEmail();

	void setMyUserId(String stringOfUserId);

	String getMyUserId();

	void addPerson(IPerson person);

	// throws NoSuchElementException if there is no person in the array
	void removePerson(IPerson person);

	IPerson[] getArrayOfPerson();
}