package structures;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBDocument;

@DynamoDBDocument
public class SessionLocation {

	private Long latitude;
	private Long longitude;
	
	private String country;
	private String state;
	private String city;
	private String address;
	private String zipcode;
	
	
	/**
	 * instantiates a location object with latitude and longitude
	 * @param latitude
	 * @param longitude
	 */
	public SessionLocation(Long latitude, Long longitude) {
		this.setLatitude(latitude);
		this.setLongitude(longitude);
	}


	public Long getLatitude() {
		return latitude;
	}


	public void setLatitude(Long latitude) {
		if (latitude <= 90.0 && latitude >= -90.0) {
			this.latitude = latitude;
		}
		else {
			System.out.println("Did not set latitude because input out of range");
			this.latitude = null;
		}
	}


	public Long getLongitude() {
		return longitude;
	}


	public void setLongitude(Long longitude) {
		if (longitude <= 180.0 && longitude >= -180.0) {
			this.longitude = longitude;
		}
		else {
			System.out.println("Did not set longitude because input out of range");
			this.longitude = null;
		}
	}


	public String getCountry() {
		return country;
	}


	public void setCountry(String country) {
		this.country = country;
	}


	public String getState() {
		return state;
	}


	public void setState(String state) {
		this.state = state;
	}


	public String getCity() {
		return city;
	}


	public void setCity(String city) {
		this.city = city;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public String getZipcode() {
		return zipcode;
	}


	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
	
	
	
	

}
