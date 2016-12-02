package classDirectory;


public class DirectoryTester {
	
	static final private String accessKey = "AKIAJMYDIODMCSWDV6JQ";
	static final private String secretKey = "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";
	
	public static void main(String[] args) {
		CourseDirectoryManager manager = new CourseDirectoryManager(accessKey, secretKey);
		
		if (!manager.isAuthenicated) {
			System.out.println("Failing to Authenicate");
			return;
		}
		
		Course be200;
		try {
			be200 = manager.getCourse("BE", "200");
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			return;
		}
		
		
		if (be200 != null) {
			System.out.println(be200.toString());
		}
		

	}

}
