package com.daniele.springboot.microservices.postcodesquery.model;

public class PostcodeResponseBean {

	private Integer status;
	private Postcode result;
	
	
	public PostcodeResponseBean() {
	}


	public Integer getStatus() {
		return status;
	}


	public void setStatus(Integer status) {
		this.status = status;
	}


	public Postcode getResult() {
		return result;
	}


	public void setResult(Postcode result) {
		this.result = result;
	}


}
