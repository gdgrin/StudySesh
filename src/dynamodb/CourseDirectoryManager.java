package dynamodb;

import model.Course;
import model.CourseDirectory;
import model.User;
import structures.AuthorizationKey;
import structures.Requests.GetCourseRequest;

import java.util.ArrayList;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.services.dynamodbv2.document.Item;

public class CourseDirectoryManager extends DynamoDBManager {
		
	/**
	 * instantiate default null ClassDirectoryManager
	 */
	public CourseDirectoryManager() {
		super();
	}
	
	/**
	 * instantiate a ClassDirectory Manager, and attempt to authenticate with keys.
	 * @param accessKey
	 * @param secretKey
	 */
	public CourseDirectoryManager(AuthorizationKey authKey) {
		super(authKey, CourseDirectory.tableName);
		
	}

	
	
	/**
	 * get the Course object for a department code and course number from the AWS server
	 * @param 3 char dep. code
	 * @param 3 digit course number
	 * @return Course object representing the course
	 * @throws if not authenticated, if invalid codes, or AWS Service Excpetions
	 */
	public Course getCourse(GetCourseRequest courseReq) throws AmazonServiceException {
		
		if (!courseReq.isValid()) {
			throw new AmazonServiceException("GetCourseReq is invalid and does not fit the schema ");
		}
		
		Item returnItem = getItem(courseReq);
		
		int numba = returnItem.getInt(CourseDirectory.numberAttributeName);
		
		Course returnCourse = new Course(returnItem.getString(CourseDirectory.collegeAttributeName),
				returnItem.getString(CourseDirectory.departmentAttributeName),
				Integer.toString(numba), 
				returnItem.getString(CourseDirectory.nameAttributeName));
			

		return returnCourse;
	}
	
	
	public void updateCourse(Course course) throws Exception{
		if (course.getPrimaryKey() == null) {
			throw new Exception("Course does not have a valid unique primary key.");
		}
		saveMappedItem(course);
	}
	
	public ArrayList<User> getMembersOfCourse(Course course) {
		ArrayList<User> members = new ArrayList<User>();
		
		for (String userID : course.getMembers()) {
			User primaryKey = new User(userID);
			
			User returnUser = getMappedItem(User.class, primaryKey);
			members.add(returnUser);
		}
		
		return members;
	}
	

}
