package com.daniele.springboot.microservices.postcodesquery.model;

import java.util.List;

public class NearestPostcodesResponseBean {
	
	private Integer status;
	
	private List<Postcode> result;

//	private List<PostcodeInfo> postcodes;
	
	
	public NearestPostcodesResponseBean() {
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public List<Postcode> getResult() {
		return result;
	}

	public void setResult(List<Postcode> result) {
		this.result = result;
	}


//	public List<PostcodeInfo> getPostcodes() {
//		return postcodes;
//	}
//
//
//	public void setPostcodes(List<PostcodeInfo> postcodes) {
//		this.postcodes = postcodes;
//	}

	
	
}
