package model;


public class UserDirectory {
	
	static final public String tableName = "UserDirectory";
	static final public String firstNameAttributeName = "firstName";
	static final public String lastNameAttributeName = "lastName";
	static final public String emailAttributeName = "email";
	static final public String coursesAttributeName = "courses";
	static final public String sessionsAttributeName = "sessions";
	static final public String idAttributeName = "Id";
	static final public String verifiedAttributeName = "verified";
	
	public UserDirectory() {
		// TODO Auto-generated constructor stub
	}
	
	
	/**
	 * checks if the email is a BU email
	 * @param email
	 * @return
	 */
	static public boolean isValidEmail(String email) {		
		if (email.contains("@bu.edu")) {
			return true;
		}
		
		return false;
	}
	
	
	

}
