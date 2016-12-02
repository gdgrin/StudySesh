package structures;

import com.amazonaws.services.dynamodbv2.document.KeyAttribute;
import com.amazonaws.services.dynamodbv2.document.PrimaryKey;

public class GetItemRequest {

	private PrimaryKey request;
	private String tableName;
	
	/**
	 * creates request with tableName and default PrimaryKey
	 * @param tableName
	 */
	public GetItemRequest(String tableName) {
		this.tableName = tableName;
		request = new PrimaryKey();
	}
	
	/**
	 * creates ready to use request with name and request key
	 * @param tableName
	 * @param requestKey representing unique table item
	 */
	public GetItemRequest(String tableName, PrimaryKey requestKey) {
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
	
	public PrimaryKey getRequest() {
		return request;
	}

	public void setRequest(PrimaryKey request) {
		this.request = request;
	}

	public void addKeyAttributesToRequestKey(KeyAttribute... attributes) {
		request.addComponents(attributes);
	}
	
	public void addComponentToRequestKey(String attributeName, Object attributeValue) {
		request.addComponent(attributeName, attributeValue);
	}
	
	

}
