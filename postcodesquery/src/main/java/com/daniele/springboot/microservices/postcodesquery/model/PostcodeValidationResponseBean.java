package com.daniele.springboot.microservices.postcodesquery.model;

public class PostcodeValidationResponseBean {

	private Integer status;
	private Boolean result;
	
	
	public PostcodeValidationResponseBean() {
	}


	public Integer getStatus() {
		return status;
	}


	public void setStatus(Integer status) {
		this.status = status;
	}


	public Boolean getResult() {
		return result;
	}


	public void setResult(Boolean result) {
		this.result = result;
	}
	
	

	@Override
	public String toString() {
		return "PostcodeValidationResponseBean [status=" + status + ", result=" + result + "]";
	}

	@Override
	public boolean equals(Object obj) {
		PostcodeValidationResponseBean bean = (PostcodeValidationResponseBean) obj;
		boolean condition = false;
		if(this.status==(bean.getStatus())
			&& this.result.equals(bean.getResult())){
			condition = true;
		}
		return condition;
	}

}
