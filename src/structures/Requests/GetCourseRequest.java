package structures.Requests;

import com.amazonaws.services.dynamodbv2.document.KeyAttribute;

import model.CourseDirectory;
import structures.GetInterface;

public class GetCourseRequest extends GetItemRequest implements GetInterface{

	public GetCourseRequest() {
		super(CourseDirectory.tableName);
	}

	public GetCourseRequest(String department, String number) {
		super(CourseDirectory.tableName);
		
		KeyAttribute dep = new KeyAttribute(CourseDirectory.departmentAttributeName, department);
		KeyAttribute num = new KeyAttribute(CourseDirectory.numberAttributeName, Integer.parseInt(number));
		
		RequestKey primeKey = new RequestKey(dep, num);
		
		setRequest(primeKey);
		
	}
	
	
	
	@Override
	/**
	 * check to make sure requestKey fits the AWS course table schema
	 * @return isValid
	 */
	public boolean isValid() {
		boolean attributeNamesCorrect = true;
		int depCount = 0;
		int numCount = 0;
		
		for (String atrName : request.getComponentNameSet()) {		//Check if the attribute names fit the AWS course table schema
			switch (atrName) {
				case CourseDirectory.collegeAttributeName:			
					break;
				case CourseDirectory.departmentAttributeName:
					depCount++;
					break;
				case CourseDirectory.numberAttributeName:
					numCount++;
					break;
				case CourseDirectory.nameAttributeName:
					break;
				
			default:
				attributeNamesCorrect = false;
				break;
			}
		}
		
		if (depCount == 0 || numCount == 0) {
			attributeNamesCorrect = false;
		}
		
		if (!CourseDirectory.isValidDepartmentCode(getDepartment())) {		//check for the correct size dep code
			return false;
		}
		
		if (!CourseDirectory.isValidCourseNumber(getNumber())) {			//check for the correct num of digits in courseNumber
			return false;	
		}
		
		return attributeNamesCorrect;
	}
	

	
	public String getDepartment() {
		return request.getAttribute(CourseDirectory.departmentAttributeName);
	}
	
	public String getNumber() {
		return request.getAttribute(CourseDirectory.numberAttributeName);
	}
}
