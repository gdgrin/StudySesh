package structures;

import model.CourseDirectory;

import com.amazonaws.services.dynamodbv2.document.KeyAttribute;

import structures.RequestKey;

public class CoursePrimaryKey extends RequestKey {

	public CoursePrimaryKey(String depCode, Integer courseNumber) {
		super();
		KeyAttribute dep = new KeyAttribute(CourseDirectory.departmentAttributeName, depCode);
		KeyAttribute num = new KeyAttribute(CourseDirectory.numberAttributeName, courseNumber);
		addComponents(dep, num);
	}
	
	public String getDepartment() {
		return getAttribute(CourseDirectory.departmentAttributeName);
	}
	
	public Integer getNumber() {
		return Integer.parseInt(getAttribute(CourseDirectory.numberAttributeName));
	}

}
