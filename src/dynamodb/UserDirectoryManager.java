package dynamodb;

import java.util.ArrayList;

import model.Course;
import model.User;
import model.UserDirectory;
import structures.AuthorizationKey;
import structures.CoursePrimaryKey;

public class UserDirectoryManager extends DynamoDBManager {

	public UserDirectoryManager() {
		super();
	}

	public UserDirectoryManager(AuthorizationKey authKey) {
		super(authKey, UserDirectory.tableName);
	}

	
	public User getUser(String id) {
		User primaryKey = new User(id);
		
		User returnUser = getMappedItem(User.class, primaryKey);
		
		return returnUser;
	}
	
	public void addNewUser(User newUser) {
		newUser.setId(null);  		//forced AWS to auto-generate a new UDID
		saveMappedItem(newUser);
	}
	
	public void updateUser(User updateUser) throws Exception{
		if (updateUser.getId() == null) {
			throw new Exception("Trying to update a user without an Id");
		}
		
		saveMappedItem(updateUser);
	}
	
	public ArrayList<Course> getCoursesForUser(User user) {
		
		ArrayList<Course> courses = new ArrayList<Course>();
		
		for (CoursePrimaryKey id : user.getCourses()) {
			
			Course primaryKeyUser = new Course(id);
			Course aCourseForUser = getMappedItem(Course.class, primaryKeyUser);
			
			courses.add(aCourseForUser);
		}
		
		return courses;
	}
	
	
	
	
	
}
