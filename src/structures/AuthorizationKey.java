package structures;

public class AuthorizationKey {
	
	private String accessKey;
	private String secretKey;
	
	
	/**
	 * created AuthorizationKey with null keys
	 */
	public AuthorizationKey() {
		this.accessKey = null;
		this.secretKey = null;
	}
	
	/**
	 * creates Authorization Key with given parameters
	 * @param accessKey obtained from AWS
	 * @param secretKey obtained from AWS
	 */
	public AuthorizationKey(String accessKey, String secretKey) {
		this.accessKey = accessKey;
		this.secretKey = secretKey;
	}
	
	
	/**
	 * retrieve accessKey of this AuthorizationKey
	 */
	public String getAccessKey() {
		return this.accessKey;
	}
	
	/**
	 * retrieve secretKey of this AuthorizationKey
	 */
	public String getSecretKey() {
		return this.secretKey;
	}

}
