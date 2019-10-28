package com.daniele.springboot.microservices.postcodesquery.model;

public class Codes {
	
	private String admin_district;
	private String admin_country;
	private String admin_ward;
	private String parish;
	private String parliamentary_consitutency;
	private String ccg;
	private String ced;
	private String nuts;
	
	public Codes() {
		
	}
	
	public Codes(String admin_district, String admin_country, String admin_ward, String parish,
			String parliamentary_consitutency, String ccg, String ced, String nuts) {
		
		this.admin_district = admin_district;
		this.admin_country = admin_country;
		this.admin_ward = admin_ward;
		this.parish = parish;
		this.parliamentary_consitutency = parliamentary_consitutency;
		this.ccg = ccg;
		this.ced = ced;
		this.nuts = nuts;
	}



	public String getAdmin_district() {
		return admin_district;
	}

	public void setAdmin_district(String admin_district) {
		this.admin_district = admin_district;
	}

	public String getAdmin_country() {
		return admin_country;
	}

	public void setAdmin_country(String admin_country) {
		this.admin_country = admin_country;
	}

	public String getAdmin_ward() {
		return admin_ward;
	}

	public void setAdmin_ward(String admin_ward) {
		this.admin_ward = admin_ward;
	}

	public String getParish() {
		return parish;
	}

	public void setParish(String parish) {
		this.parish = parish;
	}

	public String getParliamentary_consitutency() {
		return parliamentary_consitutency;
	}

	public void setParliamentary_consitutency(String parliamentary_consitutency) {
		this.parliamentary_consitutency = parliamentary_consitutency;
	}

	public String getCcg() {
		return ccg;
	}

	public void setCcg(String ccg) {
		this.ccg = ccg;
	}

	public String getCed() {
		return ced;
	}

	public void setCed(String ced) {
		this.ced = ced;
	}

	public String getNuts() {
		return nuts;
	}

	public void setNuts(String nuts) {
		this.nuts = nuts;
	}
	

}
