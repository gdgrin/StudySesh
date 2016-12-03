package structures;

public class AuthorizationKey {

	static final private String accessKeyDefault = "AKIAJMYDIODMCSWDV6JQ";
	static final private String secretKeyDefault = "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";
	
	private String accessKey;
	private String secretKey;
	
	
	/**
	 * created AuthorizationKey with default keys with access to StudySesh AWS dynamoDB
	 */
	public AuthorizationKey() {
		this.accessKey = accessKeyDefault;
		this.secretKey = secretKeyDefault;
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
