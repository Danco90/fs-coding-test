package com.daniele.springboot.microservices.postcodesquery.model;

public class Postcode {
	
	private String postcode;
	private Integer quality;
	private Integer eastings;
	private Integer northings;
	private String country;
	private String nhs_ha;
	private Double longitude;
	private Double latitude;
	private String european_electoral_region;
	private String primary_care_trust;
	private String region;
	private String lsoa;
	private String msoa;
	private String incode;
	private String outcode;
	private String parliamentary_constituency;
	private String admin_district;
	private String parish;
	private String admin_country;
	private String admin_ward;
	private String ced;
	private String ccg;
	private String nuts;
	
	private Codes codes;
	
	public Postcode() {
		
	}
	
	public Postcode(String postcode, String country, String region) {
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

	public Integer getQuality() {
		return quality;
	}

	public void setQuality(Integer quality) {
		this.quality = quality;
	}

	public Integer getEastings() {
		return eastings;
	}

	public void setEastings(Integer eastings) {
		this.eastings = eastings;
	}

	public Integer getNorthings() {
		return northings;
	}

	public void setNorthings(Integer northings) {
		this.northings = northings;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getNhs_ha() {
		return nhs_ha;
	}

	public void setNhs_ha(String nhs_ha) {
		this.nhs_ha = nhs_ha;
	}

	public Double getLongitude() {
		return longitude;
	}

	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}

	public Double getLatitude() {
		return latitude;
	}

	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}

	public String getEuropean_electoral_region() {
		return european_electoral_region;
	}

	public void setEuropean_electoral_region(String european_electoral_region) {
		this.european_electoral_region = european_electoral_region;
	}

	public String getPrimary_care_trust() {
		return primary_care_trust;
	}

	public void setPrimary_care_trust(String primary_care_trust) {
		this.primary_care_trust = primary_care_trust;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getLsoa() {
		return lsoa;
	}

	public void setLsoa(String lsoa) {
		this.lsoa = lsoa;
	}

	public String getMsoa() {
		return msoa;
	}

	public void setMsoa(String msoa) {
		this.msoa = msoa;
	}

	public String getIncode() {
		return incode;
	}

	public void setIncode(String incode) {
		this.incode = incode;
	}

	public String getOutcode() {
		return outcode;
	}

	public void setOutcode(String outcode) {
		this.outcode = outcode;
	}

	public String getParliamentary_constituency() {
		return parliamentary_constituency;
	}

	public void setParliamentary_constituency(String parliamentary_constituency) {
		this.parliamentary_constituency = parliamentary_constituency;
	}

	public String getAdmin_district() {
		return admin_district;
	}

	public void setAdmin_district(String admin_district) {
		this.admin_district = admin_district;
	}

	public String getParish() {
		return parish;
	}

	public void setParish(String parish) {
		this.parish = parish;
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

	public String getCed() {
		return ced;
	}

	public void setCed(String ced) {
		this.ced = ced;
	}

	public String getCcg() {
		return ccg;
	}

	public void setCcg(String ccg) {
		this.ccg = ccg;
	}

	public String getNuts() {
		return nuts;
	}

	public void setNuts(String nuts) {
		this.nuts = nuts;
	}

	public Codes getCodes() {
		return codes;
	}

	public void setCodes(Codes codes) {
		this.codes = codes;
	}

	
	
	@Override
	public String toString() {
		return "Postcode [postcode=" + postcode + ", quality=" + quality + ", eastings=" + eastings + ", northings="
				+ northings + ", country=" + country + ", nhs_ha=" + nhs_ha + ", longitude=" + longitude + ", latitude="
				+ latitude + ", european_electoral_region=" + european_electoral_region + ", primary_care_trust="
				+ primary_care_trust + ", region=" + region + ", lsoa=" + lsoa + ", msoa=" + msoa + ", incode=" + incode
				+ ", outcode=" + outcode + ", parliamentary_constituency=" + parliamentary_constituency
				+ ", admin_district=" + admin_district + ", parish=" + parish + ", admin_country=" + admin_country
				+ ", admin_ward=" + admin_ward + ", ced=" + ced + ", ccg=" + ccg + ", nuts=" + nuts + ", codes=" + codes
				+ "]";
	}

	public String toStringFilter() {
		return "Postcode [postcode=" + postcode + ", country=" + country + ", region=" + region 
				+ "]";
	}

	
}
