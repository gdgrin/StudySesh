package testers;

import dynamodb.*;
import model.*;
import structures.AuthorizationKey;
import structures.Requests.GetCourseRequest;

public class DirectoryTester {
	
	static final private String accessKeyDefault = "AKIAJPEHNSRXJWHG5YEQ";
	static final private String secretKeyDefault = "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";
	
	public static void main(String[] args) {
		AuthorizationKey testKey = new AuthorizationKey(accessKeyDefault, secretKeyDefault);
		
		CourseDirectoryManager manager = new CourseDirectoryManager(testKey);
		
		UserDirectoryManager userManager = new UserDirectoryManager(testKey);
		
		if (!manager.isAuthenicated || !userManager.isAuthenicated) {
			System.out.println("Failing to Authenicate");
			return;
		}
		
		GetCourseRequest request = new GetCourseRequest("EC", "327");
		
		Course be200;
		try {
			be200 = manager.getCourse(request);
		} catch (Exception e) {
			e.printStackTrace();
			return;
		}
		
		
		if (be200 != null) {
			System.out.println(be200.toString());
		}
		
		
		User testUser = new User("Test2", "Changed", "8df8e7e6-e26b-494a-8fc8-0abeeb52e35a", "test@bu.edu", null, null, true);
		userManager.addNewUser(testUser);
		

	}

}
