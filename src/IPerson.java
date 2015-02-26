
public interface IPerson {
	
	String getUserId();
	
	String getUserEmail();
	
	String getUserName();
	
	/* return the value of the integer for this person
	 * Calculated value from myUserLevel and personUserLevel
	 */
	int getPersonLevel();
	
	void setMyUserLevel(int myLevel);
	
	void setPersonUserLevel(int personLevel);
	
}
