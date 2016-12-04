package model;

import java.util.ArrayList;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;

@DynamoDBTable(tableName = UserDirectory.tableName)
public class User {

	private String firstName;
	private String lastName;
	private String id;
	private String email;
	private ArrayList<String> courses;
	private ArrayList<String> sessions;
	private boolean verified;
	
	
	public User() {
		// TODO Auto-generated constructor stub
	}
	
	

}
