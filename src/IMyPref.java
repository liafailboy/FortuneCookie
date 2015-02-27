public interface IMyPref {

	void setMyName(String stringOfName);

	String getMyName();

	void setMyEmail(String stringOfEmail);

	String getMyEmail();

	void setMyUserId(String stringOfUserId);

	String getMyUserId();

	void addPerson(IPerson person);

	IPerson[] getArrayOfPerson();
}