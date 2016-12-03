package model;

public class Course {
	
	private String _college;
	private String _department;
	private String _number;
	private String _name;
	
	/**
	 * set default values: college = "ABC", department = "XX", and courseNumber = 100
	 */
	public Course() {
		setCollege("ABC");
		setDepartment("XX");
		setNumber("100");
		setName("Course Name");
	}
	
	/**
	 * construct with parameters
	 * @param 3 char collegeCode
	 * @param 2 char departmentCode
	 * @param 3 digit courseNumber
	 */
	public Course(String collegeCode, String departmentCode, String courseNumber, String courseName) {
		setCollege(collegeCode);
		setDepartment(departmentCode);
		setNumber(courseNumber);
		setName(courseName);
	}


	/**
	 * retrieve the college code
	 * @return the 3 char college code 
	 */
	public String getCollege() {
		return _college;
	}


	/**
	 * set the college code
	 * @param 3 char college code
	 */
	protected void setCollege(String college) {
		try {
			if (!CourseDirectory.isValidCollegeCode(college)) {
				throw new Exception("Trying to set college code to "+college+".");
			}
		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
			e.printStackTrace();
			System.out.println("---------------------");
		}
		
		this._college = college.toUpperCase();
	}


	/**
	 * get the department code 
	 * @return the department
	 */
	public String getDepartment() {
		return _department;
	}


	/**
	 * set the department code 
	 * @param 2 char department code
	 */
	protected void setDepartment(String department) {
		try {
			if (!CourseDirectory.isValidDepartmentCode(department)) {
				throw new Exception("Trying to set invalid department code.");
			}
		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
			e.printStackTrace();
			System.out.println("---------------------");
		}
		this._department = department.toUpperCase();
	}


	/**
	 * get the course number
	 * @return the courseNumber
	 */
	public String getNumber() {
		return _number;
	}


	/**
	 * set the course number
	 * @param 3 digit course number
	 */
	protected void setNumber(String courseNumber) {
		try {
			if (courseNumber.length() != 3) {
				throw new Exception("Trying to set invalid course number.");
			}
		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
			e.printStackTrace();
			System.out.println("---------------------");
		}
		this._number = courseNumber;
	}
	
	
	/**
	 * get the name of the course
	 * @return the name of the course
	 */
	public String getName() {
		return _name;
	}

	/**
	 * @param name the name to set
	 */
	protected void setName(String name) {
		this._name = name;
	}

	/**
	 * get String descriptor of the course 
	 * @return String of format (COL DP 100)
	 */
	public String toString() {
		return getCollege() + " " + getDepartment() + " " + getNumber() + ": " + getName();
	}
	
	
	
	
	
	

}
