package com.daniele.springboot.microservices.postcodesquery.model;

import java.util.List;

public class NearestPostcodesResponseBean {
	
	private Integer status;
//	private List<Postcode> result;
	private List<PostcodesResponseBean> result;

	public NearestPostcodesResponseBean() {
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public List<PostcodesResponseBean> getResult() {
		return result;
	}

	public void setResult(List<PostcodesResponseBean> result) {
		this.result = result;
	}

	
}
