package dynamodb;

import model.Course;
import model.CourseDirectory;
import structures.AuthorizationKey;
import structures.Requests.GetCourseRequest;

import com.amazonaws.AmazonClientException;
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
	
	
	public void saveCourse(Course course) {
		
	}
	

}
