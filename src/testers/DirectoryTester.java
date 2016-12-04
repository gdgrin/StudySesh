package testers;

import dynamodb.*;
import model.*;
import structures.AuthorizationKey;
import structures.Requests.GetCourseRequest;

public class DirectoryTester {
	
	
	public static void main(String[] args) {
		CourseDirectoryManager manager = new CourseDirectoryManager(new AuthorizationKey());
		
		if (!manager.isAuthenicated) {
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
		

	}

}
