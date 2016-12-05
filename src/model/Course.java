package model;


import java.util.List;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;

import structures.CoursePrimaryKey;

@DynamoDBTable(tableName = CourseDirectory.tableName)
public class Course {
	
	private String _college;
	private String _department;
	private Integer _number;
	private String _name;
	private List<String> members;
	
	/**
	 * set default values: college = "ABC", department = "XX", and courseNumber = 100
	 */
	public Course() {
		setCollege(null);
		setDepartment(null);
		setNumber(null);
		setName(null);
	}
	
	
	public Course(CoursePrimaryKey key) {
		this();
		setDepartment(key.getDepartment());
		setNumber(key.getNumber());
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
		setNumber(Integer.parseInt(courseNumber));
		setName(courseName);
	}
	



	/**
	 * retrieve the college code
	 * @return the 3 char college code 
	 */
	@DynamoDBAttribute(attributeName = CourseDirectory.collegeAttributeName)
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
				throw new Exception("Error: Trying to set college code to "+college+".");
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("---------------------");
		}
		
		this._college = college.toUpperCase();
	}


	/**
	 * get the department code 
	 * @return the department
	 */
	@DynamoDBHashKey(attributeName = CourseDirectory.departmentAttributeName)
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
				throw new Exception("Error: Trying to set invalid department code.");
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("---------------------");
		}
		this._department = department.toUpperCase();
	}


	/**
	 * get the course number
	 * @return the courseNumber
	 */
	@DynamoDBHashKey(attributeName = CourseDirectory.numberAttributeName)
	public Integer getNumber() {
		return _number;
	}


	/**
	 * set the course number
	 * @param 3 digit course number
	 */
	protected void setNumber(Integer courseNumber) {
		try {
			if (!CourseDirectory.isValidCourseNumber(Integer.toString(courseNumber))) {
				throw new Exception("Error: Trying to set invalid course number.");
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("---------------------");
		}
		this._number = courseNumber;
	}
	
	
	public String getNumberAsString() {
		return Integer.toString(getNumber());
	}
	
	/**
	 * get the name of the course
	 * @return the name of the course
	 */
	@DynamoDBAttribute(attributeName = CourseDirectory.nameAttributeName)
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
	
	public CoursePrimaryKey getPrimaryKey() {
		if (getDepartment() == null || getNumber() == null) {
			return null;
		}
		return new CoursePrimaryKey(getDepartment(), getNumber());
	}

	@DynamoDBAttribute(attributeName = CourseDirectory.membersAttributeName)
	public List<String> getMembers() {return members;}
	public void setMembers(List<String> members) {this.members = members;}
	
	
	
	

}
