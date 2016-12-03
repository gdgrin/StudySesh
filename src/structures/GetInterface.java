package structures;


import com.amazonaws.services.dynamodbv2.document.KeyAttribute;

public interface GetInterface {
	
	public boolean isValid();
	public void addKeyAttributesToRequestKey(KeyAttribute... attributes);
	public void addComponentToRequestKey(String attributeName, Object attributeValue);
	
}
