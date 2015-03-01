
public interface IConnector {
	
	/**
	 * Check the possibility of duplicate userID, pass, and userEmail
	 * and if you can add, add the values to server and return true
	 * but if you cannot, return false
	 * @param pref preference of the user entered at the first time
	 * @return whether server can accept the userID, pass, and userEmail entered by the user
	 */
	boolean setNewUserToServer(MyPref pref);
	
	/**
	 * Update the information on the server with the user preference
	 * @param pref preference of the user entered
	 * @return whether server successfully updated
	 */
	boolean updateMyInfoOnServer(MyPref pref);
	
	/**
	 * return whether the ID and pass are valid or not
	 * @param userID ID entered by user
	 * @param pass pass entered by user
	 * @throws IllegalArgumentException if userID or pass is null
	 * @return whether the user entered correct userID
	 */
	boolean isValidUserNameAndPass(String userID, String pass);
	
	/**
	 * return userID of the user if user entered valid ID and pass
	 * @return string of the userID from server
	 */
	String getUserIDFromServer();
	
	/**
	 * return userEmail of the user if user entered valid ID and pass
	 * @return string of the userEmail from server
	 */
	String getUserEmailFromServer();
	
	/**
	 * return userName of the user if user entered valid ID and pass
	 * @return string of the userName from server
	 */
	String getUserNameFromServer();
	
	/**
	 * There is a lot of things to do in this method
	 * 1. Search the user email on the server
	 * 2. Get the rank of each people by me, and the rank of the user from them
	 * 3. Create Person class instance for every people
	 * 4. add all instance using addPersonEvaluate(Person person)
	 * @return whether the array was refreshed successfully
	 */
	boolean refreshArrayOfPeople();
}
