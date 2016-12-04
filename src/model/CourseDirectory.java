package model;

public class CourseDirectory {

	static final public String tableName = "ClassDirectory";
	static final public String departmentAttributeName = "department";
	static final public String collegeAttributeName = "college";
	static final public String numberAttributeName = "courseNumber";
	static final public String nameAttributeName = "title";
	
	static final int collegeCodeSize = 3;
	static final int departmentCodeSize = 2;
	static final int courseNumDigits = 3;
	
	public CourseDirectory() {
		
	}
	
	/**
	 * check if the college code is valid
	 * @param code
	 * @return true if is valid, false otherwise
	 */
	static public boolean isValidCollegeCode(String code) {
		if (code.length() != collegeCodeSize) {
			return false;
		}
		return true;
	}
	
	/**
	 * check if the dep. code is valid
	 * @param code
	 * @return true if is valid, false otherwise
	 */
	static public boolean isValidDepartmentCode(String code) {
		if (code.length() != departmentCodeSize) {
			return false;
		}
		return true;
	}
	
	/**
	 * check if the course number is valid
	 * @param code
	 * @return true if is valid, false otherwise
	 */
	static public boolean isValidCourseNumber(String code) {
		if (code.length() != courseNumDigits) {
			return false;
		}
		return true;
	}

}
