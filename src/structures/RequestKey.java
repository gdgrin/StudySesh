package structures;

import com.amazonaws.services.dynamodbv2.document.KeyAttribute;
import com.amazonaws.services.dynamodbv2.document.PrimaryKey;

public class RequestKey extends PrimaryKey {

	public RequestKey() {
		// TODO Auto-generated constructor stub
	}

	public RequestKey(KeyAttribute... components) {
		super(components);
		// TODO Auto-generated constructor stub
	}

	public RequestKey(String hashKeyName, Object hashKeyValue) {
		super(hashKeyName, hashKeyValue);
		// TODO Auto-generated constructor stub
	}

	public RequestKey(String hashKeyName, Object hashKeyValue, String rangeKeyName, Object rangeKeyValue) {
		super(hashKeyName, hashKeyValue, rangeKeyName, rangeKeyValue);
		// TODO Auto-generated constructor stub
	}
	
	public String getAttribute(String attributeName) {
		for (KeyAttribute atr : getComponents()) {
			if (atr.getName() == attributeName) {
				return atr.getValue().toString();
			}
		}
		
		return null;
	}
	

}
