package dynamodb;

import structures.AuthorizationKey;
import structures.Requests.GetItemRequest;

import com.amazonaws.AmazonClientException;
import com.amazonaws.AmazonServiceException;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClient;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.document.DynamoDB;
import com.amazonaws.services.dynamodbv2.document.Item;
import com.amazonaws.services.dynamodbv2.document.Table;
import com.amazonaws.services.dynamodbv2.model.ResourceNotFoundException;

public class DynamoDBManager {
	
	public boolean isAuthenicated;
	
	protected AmazonDynamoDBClient dynamodbClient;
	private DynamoDBMapper mapper;
	protected String tableName;
	
	private AWSCredentials credentials;
	
	
	
	protected DynamoDBManager() {
		isAuthenicated  = false;
		dynamodbClient = null;
		credentials = null;
		mapper = null;
	}
	
	public DynamoDBManager(AuthorizationKey authKey, String tableName) {
		isAuthenicated = false;
		dynamodbClient = null;
		this.tableName = tableName;
		setUpClientWithKey(authKey);
	}
	
	protected boolean setUpClientWithKey(AuthorizationKey key) {
		if (authenticate(key.getAccessKey(), key.getSecretKey()) && doesTableExitst(this.tableName)) {
			isAuthenicated = true;
		}
		else {
			isAuthenicated = false;
		}
		
		return isAuthenicated;
	}
	
	private boolean doesTableExitst(String tableName) {
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
			
			mapper = new DynamoDBMapper(dynamodbClient);			
		}
		catch (AmazonClientException e) {
			System.out.println("Caught an AmazonClientException, which means the client encountered "
                    + "a serious internal problem while trying to communicate with AWS, "
                    + "such as not being able to access the network.");
            System.out.println("Error Message: " + e.getMessage());
		}
		
		if (dynamodbClient != null) {
			return true;
		}
		
		return false;
	}
	
	
	public Item getItem(GetItemRequest req) throws ResourceNotFoundException{
		if (!isAuthenicated) {
			return null;
		}
		
		Item result = null;
		try {
			DynamoDB db = new DynamoDB(dynamodbClient);
			Table classTable = db.getTable(req.getTableName());
			
			result = classTable.getItem(req.getRequest());
			
		} catch (AmazonServiceException ase) {
			printException(ase);
		}
		
		if (result == null) {
			ResourceNotFoundException exception = new ResourceNotFoundException("Could not find item matching GetItemRequest");
			exception.setServiceName("DynamoDB");
			throw exception;
		}
		
		return result;
	}
	
	
	protected void printException(AmazonServiceException ase) {
		System.out.println("Caught an AmazonServiceException, which means your request made it "
                + "to AWS, but was rejected with an error response for some reason.");
        System.out.println("Error Message:    " + ase.getMessage());
        System.out.println("HTTP Status Code: " + ase.getStatusCode());
        System.out.println("AWS Error Code:   " + ase.getErrorCode());
        System.out.println("Error Type:       " + ase.getErrorType());
        System.out.println("Request ID:       " + ase.getRequestId());
		ase.printStackTrace();
	}
	
	/**
	 * get an item of class and for primary key specified
	 * @param clazz
	 * @param primaryKey
	 * @return object of type specified
	 */
	
	public <T> T getMappedItem(Class<T> clazz, Object primaryKey) {
		T returnObj = mapper.load(clazz, primaryKey);
		return returnObj;
	}
	
	public void saveMappedItem(Object saveObj) {
		mapper.save(saveObj);
	}
	
	public void deleteMappedItem(Object objToDelete) {
		mapper.delete(objToDelete);
	}
	
	

}
