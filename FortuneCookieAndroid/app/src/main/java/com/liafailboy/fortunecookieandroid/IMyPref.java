package com.liafailboy.fortunecookieandroid;

public interface IMyPref {

	void setMyName(String stringOfName);

	String getMyName();

	void setMyEmail(String stringOfEmail);

	String getMyEmail();

	void setMyUserId(String stringOfUserId);

	String getMyUserId();

	// put the new person into the array and arrange the order by the rank of the person
	void addPersonEvaluate(IPerson person);
	
	boolean addPersonSelect(IPerson person);
	
	boolean removePersonSelect(IPerson person);

	IPerson[] getArrayOfPersonSelected();
	
	IPerson[] getArrayOfPersonEvaluated();
}