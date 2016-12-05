package dynamodb;

import java.util.ArrayList;

import model.Course;
import model.Session;
import model.SessionDirectory;
import model.User;
import structures.AuthorizationKey;

public class SessionDirectoryManager extends DynamoDBManager {

	public SessionDirectoryManager() {
		super();
	}

	public SessionDirectoryManager(AuthorizationKey authKey) {
		super(authKey, SessionDirectory.tableName);
	}
	
	public Session getSession(String id) {
		Session primaryKeySession = new Session(id);
		
		Session returnSession = getMappedItem(Session.class, primaryKeySession);
		return returnSession;
	}
	
	public void createNewSession(Session newSession) {
		newSession.setId(null);
		
		saveMappedItem(newSession);
	}
	
	public void updateSession(Session updatedSession) throws Exception{
		if (updatedSession.getId() == null) {
			throw new Exception("Trying to update a session without an Id");
		}
		saveMappedItem(updatedSession);
	}
	
	public void deleteSession(Session sessionToDelete) throws Exception {
		if (sessionToDelete.getId() == null) {
			throw new Exception("Trying to delete a session without an Id");
		}
		
		deleteMappedItem(sessionToDelete);
	}
	
	public ArrayList<User> getUsersForSession(Session session) {
		ArrayList<User> users = new ArrayList<User>();
		
		for (String userID : session.getMembers()) {
			User primaryKey = new User(userID);
			
			User returnUser = getMappedItem(User.class, primaryKey);
			users.add(returnUser);
		}
		
		return users;
	}
	
	public Course getCourseForSession(Session session) throws Exception{
		if (session.getCourse() == null) {
			throw new Exception("This session does not have a course assigned to it.");
		}
		
		Course primaryKey = new Course(session.getCourse());
		
		Course returnCourse = getMappedItem(Course.class, primaryKey);
		return returnCourse;
	}

}
