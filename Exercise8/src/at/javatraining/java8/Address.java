package at.javatraining.java8;

public class Address {
	private long id;
	private String street;
	private String postcode;
	private String city;
	private String countryCode;
	
	public Address() {}

	public Address(long id, String street, String postcode, String city, String countryCode) {
		this.id = id;
		this.street = street;
		this.postcode = postcode;
		this.city = city;
		this.countryCode = countryCode;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getPostcode() {
		return postcode;
	}

	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}
	
	public boolean isValid() {
		return(street !=null && !street.trim().isEmpty() &&
				postcode !=null && !postcode.trim().isEmpty() &&
				city !=null && !city.trim().isEmpty() &&
				countryCode !=null && !countryCode.trim().isEmpty());
		
	}

	@Override
	public String toString() {
		return "Address [id=" + id + ", street=" + street + ", postcode=" + postcode + ", city=" + city
				+ ", countryCode=" + countryCode + "]";
	}
}