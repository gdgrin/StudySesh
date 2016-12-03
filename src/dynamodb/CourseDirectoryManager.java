package dynamodb;

import model.Course;
import model.CourseDirectory;

import com.amazonaws.AmazonClientException;
import com.amazonaws.AmazonServiceException;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClient;
import com.amazonaws.services.dynamodbv2.document.DynamoDB;
import com.amazonaws.services.dynamodbv2.document.KeyAttribute;
import com.amazonaws.services.dynamodbv2.document.PrimaryKey;
import com.amazonaws.services.dynamodbv2.document.Table;



public class CourseDirectoryManager {
	
	private AmazonDynamoDBClient dynamodbClient;
	private AWSCredentials credentials;
	public boolean isAuthenicated;
	
	/**
	 * instantiate default null ClassDirectoryManager
	 */
	public CourseDirectoryManager() {
		isAuthenicated  = false;
		dynamodbClient = null;
		credentials = null;
	}
	
	/**
	 * instantiate a ClassDirectory Manager, and attempt to authenticate with keys.
	 * @param accessKey
	 * @param secretKey
	 */
	public CourseDirectoryManager(String accessKey, String secretKey) {
		isAuthenicated = false;
		dynamodbClient = null;
		authenticate(accessKey, secretKey);
	}
	
	/**
	 * authenticate a ClassDirectoryManager with keys, does not do anything if already authenticated.
	 * @param accessKey
	 * @param secretKey
	 */
	
	public void authenticate(String accessKey, String secretKey) {
		if (isAuthenicated) {
			return;
		}
		
		credentials = new BasicAWSCredentials(accessKey, secretKey);
		
		try {
			dynamodbClient = new AmazonDynamoDBClient(credentials);
			
			isAuthenicated = true;
		}
		catch (AmazonClientException e) {
			System.out.println("Caught an AmazonClientException, which means the client encountered "
                    + "a serious internal problem while trying to communicate with AWS, "
                    + "such as not being able to access the network.");
            System.out.println("Error Message: " + e.getMessage());
		}
	}
	
	
	/**
	 * get the Course object for a department code and course number from the AWS server
	 * @param 3 char dep. code
	 * @param 3 digit course number
	 * @return Course object represing the course
	 * @throws if not authenticated, if invalid codes, or AWS Service Excpetions
	 */
	public Course getCourse(String department, String number) throws Exception {
		if (!isAuthenicated) {
			throw new Exception("getCourse: Failed because we are not authenticated.");
		}
		
		if (!Course.isValidDepartmentCode(department)) {
			throw new Exception("getCourse: Invalid department code.");
		}
		
		if (!Course.isValidCourseNumber(number)) {
			throw new Exception("getCourse: Invalid course number.");
		}
		
		
		KeyAttribute dep = new KeyAttribute(CourseDirectory.departmentAttributeName, department);
		KeyAttribute num = new KeyAttribute(CourseDirectory.numberAttributeName, Integer.parseInt(number));
		
		PrimaryKey primeKey = new PrimaryKey(dep, num);
		
		Course returnCourse = null;
		
		try {
			DynamoDB db = new DynamoDB(dynamodbClient);
			
			Table classTable = db.getTable(CourseDirectory.tableName);
			
			com.amazonaws.services.dynamodbv2.document.Item result = classTable.getItem(primeKey);
			
			int numba = result.getInt(CourseDirectory.numberAttributeName);
			
			returnCourse = new Course(result.getString(CourseDirectory.collegeAttributeName),
					result.getString(CourseDirectory.departmentAttributeName),
					Integer.toString(numba), 
					result.getString(CourseDirectory.nameAttributeName));
			
		} catch (AmazonServiceException ase) {
			System.out.println("Caught an AmazonServiceException, which means your request made it "
                    + "to AWS, but was rejected with an error response for some reason.");
            System.out.println("Error Message:    " + ase.getMessage());
            System.out.println("HTTP Status Code: " + ase.getStatusCode());
            System.out.println("AWS Error Code:   " + ase.getErrorCode());
            System.out.println("Error Type:       " + ase.getErrorType());
            System.out.println("Request ID:       " + ase.getRequestId());
			ase.printStackTrace();
		}
		
		return returnCourse;
	}
	
	

}
