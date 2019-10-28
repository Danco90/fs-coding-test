package com.daniele.springboot.microservices.postcodesquery.mapper;

import java.util.ArrayList;
import java.util.List;

import com.daniele.springboot.microservices.postcodesquery.model.NearestPostcodesResponseBean;
import com.daniele.springboot.microservices.postcodesquery.model.Postcode;
import com.daniele.springboot.microservices.postcodesquery.model.PostcodeInfo;
import com.daniele.springboot.microservices.postcodesquery.model.PostcodeResponseBean;
import com.daniele.springboot.microservices.postcodesquery.model.PostcodesResponseBean;

public class Mapper {
	
	public static PostcodeInfo mapToPostcodeInfo( PostcodeResponseBean input) {
		PostcodeInfo out = new PostcodeInfo();
		Postcode postcode = input.getResult();
		out.setPostcode(postcode.getPostcode());
		out.setCountry(postcode.getCountry());
		out.setRegion(postcode.getRegion());
		
		return out;
	}
	
	public static List<PostcodeInfo> mapToNearestPostcodes(NearestPostcodesResponseBean input){
		List<PostcodeInfo> outList = new ArrayList<PostcodeInfo>();
		List<PostcodesResponseBean> resultList = input.getResult();
		for(PostcodesResponseBean postcode : resultList) {
			PostcodeInfo out = new PostcodeInfo();
			out.setPostcode(postcode.getPostcode());
			out.setCountry(postcode.getCountry());
			out.setRegion(postcode.getRegion());
			
			outList.add(out);
		}
		
		return outList;
	}

}
