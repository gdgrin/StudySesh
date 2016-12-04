package dynamodb;

import model.User;
import model.UserDirectory;
import structures.AuthorizationKey;

public class UserDirectoryManager extends DynamoDBManager {

	public UserDirectoryManager() {
		super();
	}

	public UserDirectoryManager(AuthorizationKey authKey) {
		super(authKey, UserDirectory.tableName);
	}

	
	public User getUser(String id) {
		User primaryKey = new User(id);
		
		User returnUser = getMappedItem(User.class, primaryKey);
		
		return returnUser;
	}
	
}
