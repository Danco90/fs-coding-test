package com.daniele.springboot.microservices.postcodesquery.model;

import org.springframework.data.annotation.Id;

public class PostcodesResponseBean {

		@Id
		private String id;
		
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
		private Integer distance;
		private String parliamentary_constituency;
		private String admin_district;
		private String parish;
		private String admin_country;
		private String admin_ward;
		private String ced;
		private String ccg;
		private String nuts;
		
		private Codes codes;
		
		public PostcodesResponseBean() {
			
		}
		
		public PostcodesResponseBean(String postcode, Integer quality, Integer eastings, Integer northings, String country,
				String nhs_ha, Double longitude, Double latitude, String european_electoral_region,
				String primary_care_trust, String region, String lsoa, String msoa, String incode, String outcode,
				Integer distance, String parliamentary_constituency, String admin_district, String parish, String admin_country,
				String admin_ward, String ced, String ccg, String nuts, Codes codes) {
			
			this(postcode, country, region);
			
			this.quality = quality;
			this.eastings = eastings;
			this.northings = northings;
			
			this.nhs_ha = nhs_ha;
			this.longitude = longitude;
			this.latitude = latitude;
			this.european_electoral_region = european_electoral_region;
			this.primary_care_trust = primary_care_trust;
			
			this.lsoa = lsoa;
			this.msoa = msoa;
			this.incode = incode;
			this.outcode = outcode;
			this.parliamentary_constituency = parliamentary_constituency;
			this.distance = distance;
			this.admin_district = admin_district;
			this.parish = parish;
			this.admin_country = admin_country;
			this.admin_ward = admin_ward;
			this.ced = ced;
			this.ccg = ccg;
			this.nuts = nuts;
			this.codes = codes;
		}



		public PostcodesResponseBean(String postcode, String country, String region) {
			super();
			this.postcode = postcode;
			this.country = country;
			this.region = region;
		}


		public String getId() {
			return id;
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

		public Integer getDistance() {
			return distance;
		}

		public void setDistance(Integer distance) {
			this.distance = distance;
		}
		
		

}
