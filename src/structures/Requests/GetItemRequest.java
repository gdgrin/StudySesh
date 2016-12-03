package structures.Requests;

import com.amazonaws.services.dynamodbv2.document.KeyAttribute;
import structures.GetInterface;
import structures.Requests.RequestKey;

public class GetItemRequest implements GetInterface {

	protected RequestKey request;
	protected String tableName;
	
	/**
	 * creates request with tableName and default PrimaryKey
	 * @param tableName
	 */
	public GetItemRequest(String tableName) {
		this.tableName = tableName;
		request = new RequestKey();
	}
	
	/**
	 * creates ready to use request with name and request key
	 * @param tableName
	 * @param requestKey representing unique table item
	 */
	public GetItemRequest(String tableName, RequestKey requestKey) {
		this.setTableName(tableName);
		this.request = requestKey;
	}

	/**
	 * get the table name of the request
	 * @return the tableName
	 */
	public String getTableName() {
		return tableName;
	}

	/**
	 * set which table to send request to
	 * @param tableName the tableName to set
	 */
	public void setTableName(String tableName) {
		this.tableName = tableName;
	}
	
	/**
	 * get the request key itself
	 * @return
	 */
	public RequestKey getRequest() {
		return request;
	}

	/**
	 * set the request key to a whole now PrimaryKey object
	 * @param request
	 */
	public void setRequest(RequestKey request) {
		this.request = request;
	}
	
	/**
	 * add 1 or more KeyAttribute objects directly to the requestKey as unique identifier components
	 * @param attributes: KeyAttribute Objects
	 */
	public void addKeyAttributesToRequestKey(KeyAttribute... attributes) {
		request.addComponents(attributes);
	}
	
	
	/**
	 * add a object key pair to the request key as part of the unique identifier
	 * @param attributeName
	 * @param attributeValue
	 */
	public void addComponentToRequestKey(String attributeName, Object attributeValue) {
		request.addComponent(attributeName, attributeValue);
	}

	/**
	 * checks if a tableName is specified, and request key has at least 1 component
	 * @return valid status
	 */
	public boolean isValid() {
		if (tableName == "") {
			return false;
		}
		if (request == null) {
			return false;
		}
		if (request.getComponents().size() < 1) {
			return false;
		}
		return true;
	}
	
	
	

}
