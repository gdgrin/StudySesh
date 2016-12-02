package dynamodb;

import structures.AuthorizationKey;

import com.amazonaws.AmazonClientException;
import com.amazonaws.AmazonServiceException;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClient;
import com.amazonaws.services.dynamodbv2.document.DynamoDB;
import com.amazonaws.services.dynamodbv2.document.Item;
import com.amazonaws.services.dynamodbv2.document.PrimaryKey;
import com.amazonaws.services.dynamodbv2.document.Table;
import com.amazonaws.services.dynamodbv2.model.DescribeTableResult;
import com.amazonaws.services.dynamodbv2.model.ResourceNotFoundException;

public class DynamoDBManger {

	private AmazonDynamoDBClient dynamodbClient;
	private AWSCredentials credentials;
	public boolean isAuthenicated;
	
	
	protected DynamoDBManger() {
		isAuthenicated  = false;
		dynamodbClient = null;
		credentials = null;
	}
	
	public DynamoDBManger(String accessKey, String secretKey, String tableName) {
		isAuthenicated = false;
		dynamodbClient = null;
		authenticate(accessKey, secretKey);
	}
	
	public boolean setUpClientWithKey(AuthorizationKey key) {
		if (authenticate(key.getAccessKey(), key.getSecretKey())) {
			isAuthenicated = true;
		}
		else {
			isAuthenicated = false;
		}
		
		return isAuthenicated;
	}
	
	public boolean doesTableExitst(String tableName) {
		if (dynamodbClient != null) {
			try {
				dynamodbClient.describeTable(tableName);
				
				return true;
			}
			catch (ResourceNotFoundException e) {
				printException(e);
				return false;
			}
		}
		
		return false;
	}
	
	private boolean authenticate(String accessKey, String secretKey) {
		if (isAuthenicated) {
			return true;
		}
		
		credentials = new BasicAWSCredentials(accessKey, secretKey);
		
		try {
			dynamodbClient = new AmazonDynamoDBClient(credentials);
			
			if (dynamodbClient != null) {
				return true;
			}
			
		}
		catch (AmazonClientException e) {
			System.out.println("Caught an AmazonClientException, which means the client encountered "
                    + "a serious internal problem while trying to communicate with AWS, "
                    + "such as not being able to access the network.");
            System.out.println("Error Message: " + e.getMessage());
		}
		
		return false;
	}
	
	
	public Item getItem( idKey) {
		if (!isAuthenicated) {
			return null;
		}
		
		Item result = null;
		try {
			DynamoDB db = new DynamoDB(dynamodbClient);
			Table classTable = db.getTable(tableName);
			
			result = classTable.getItem(idKey);
			
		} catch (AmazonServiceException ase) {
			printException(ase);
		}
		
		return result;
	}
	
	
	public void printException(AmazonServiceException ase) {
		System.out.println("Caught an AmazonServiceException, which means your request made it "
                + "to AWS, but was rejected with an error response for some reason.");
        System.out.println("Error Message:    " + ase.getMessage());
        System.out.println("HTTP Status Code: " + ase.getStatusCode());
        System.out.println("AWS Error Code:   " + ase.getErrorCode());
        System.out.println("Error Type:       " + ase.getErrorType());
        System.out.println("Request ID:       " + ase.getRequestId());
		ase.printStackTrace();
	}
	
	

}
