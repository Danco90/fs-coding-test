package com.daniele.springboot.microservices.postcodesquery.model;

public class PostcodeInfo {
	
	private String postcode;
	private String country;
	private String region;
	
	public PostcodeInfo() {
		
	}

	public PostcodeInfo(String postcode, String country, String region) {
		super();
		this.postcode = postcode;
		this.country = country;
		this.region = region;
	}



	public String getPostcode() {
		return postcode;
	}

	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	@Override
	public String toString() {
		return "{ postcode=" + postcode + ", country=" + country + ", region=" + region + " }";
	}
	
	@Override
	public boolean equals(Object obj) {
		PostcodeInfo bean = (PostcodeInfo) obj;
		boolean condition = false;
		if(this.postcode==(bean.postcode)
			&& this.country.equals(bean.country)
			&& this.region.equals(bean.region)){
			condition = true;
		}
		return condition;
	}
	

}
