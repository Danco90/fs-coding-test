package com.daniele.springboot.microservices.postcodesquery.service;

import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestClientResponseException;
import org.springframework.web.client.RestTemplate;

import com.daniele.springboot.microservices.postcodesquery.exception.InvalidInputException;
import com.daniele.springboot.microservices.postcodesquery.exception.RemoteResourceReadTimeoutException;
import com.daniele.springboot.microservices.postcodesquery.exception.ValidationFormatException;
import com.daniele.springboot.microservices.postcodesquery.mapper.Mapper;
import com.daniele.springboot.microservices.postcodesquery.model.NearestPostcodesResponseBean;
import com.daniele.springboot.microservices.postcodesquery.model.PostcodeInfo;
import com.daniele.springboot.microservices.postcodesquery.model.PostcodeResponseBean;
import com.daniele.springboot.microservices.postcodesquery.model.PostcodeValidationResponseBean;

@Service
public class PostcodesQueryService {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Value("${postcodes.base.uri}")
	private String POSTCODE_BASE_URI;

	private final String VALIDATION_PATH = "/validate";
	
	private final String NEAREST_PATH = "/nearest";
	
	private RestTemplate restTemplate;
	
	public PostcodesQueryService(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}
	
	public PostcodeValidationResponseBean validatePostCode(String postcode) throws RemoteResourceReadTimeoutException, ValidationFormatException, InvalidInputException{
		logger.debug("validate postcode  begins");
		PostcodeValidationResponseBean validationResponse ;
		try {
			validationResponse = restTemplate.getForObject(POSTCODE_BASE_URI + "/" + postcode + VALIDATION_PATH, PostcodeValidationResponseBean.class);
			
			Boolean isValid = validationResponse.getResult();
			logger.info("postcode validation, result={}", isValid);
			if(!isValid) {
				logger.info("invalid input '{}'. Try again.", postcode);
				throw new ValidationFormatException("Input format ERROR : wrong postcode '"+postcode+"'");
			} 
			
		} catch (HttpClientErrorException e) {
			logger.info("INPUT ERROR : Invalid postcode, cause  " + e.getMessage());
			throw new InvalidInputException(e.getStatusCode(), "Invalid postcode, cause " +e.getCause());
		 
		} catch (RestClientResponseException | ResourceAccessException e) {
			logger.info("Response timeout : Failed to get remote resource because  " + e.getMessage());
    			throw new RemoteResourceReadTimeoutException(e);
		}
		return validationResponse;
	}
	
	public PostcodeInfo getPostcodeInfo(String postcode) throws RemoteResourceReadTimeoutException, InvalidInputException {
		logger.debug("get postcode info  begins");
		PostcodeResponseBean response;
		try {
			response = restTemplate.getForObject(POSTCODE_BASE_URI + "/" + postcode, PostcodeResponseBean.class);

	    } catch (HttpClientErrorException e) {
			logger.info("INPUT ERROR : Invalid postcode, cause  " + e.getMessage());
			throw new InvalidInputException(e.getStatusCode(), "Invalid postcode, cause " +e.getCause());
		 
	    } catch (RestClientResponseException | ResourceAccessException e) {
	    
			logger.info("Response timeout : Failed to get remote resource because  " + e.getMessage());
			throw new RemoteResourceReadTimeoutException(e);
	    }
	    return Mapper.mapToPostcodeInfo(response);
	}
	
	public List<PostcodeInfo> getAllTheNearestPostcodesInfo(String postcode) throws RemoteResourceReadTimeoutException, InvalidInputException {
		logger.debug("get all the nearest postcodes info  begins");
		NearestPostcodesResponseBean result;
		
		try {
			result = new RestTemplate().getForObject(POSTCODE_BASE_URI + "/" + postcode + NEAREST_PATH, NearestPostcodesResponseBean.class);
		} catch (HttpClientErrorException e) {
			logger.info("INPUT ERROR : Invalid postcode, cause  " + e.getMessage());
			throw new InvalidInputException(e.getStatusCode(), "Invalid postcode, cause " +e.getCause());
		
		} catch (RestClientResponseException | ResourceAccessException e) {
			logger.info("Response timeout : Failed to get remote resource because  " + e.getMessage());
			throw new RemoteResourceReadTimeoutException(e);
		}
		
		List<PostcodeInfo> resultList = Mapper.mapToNearestPostcodes(result);
		
		return resultList.stream()
					.filter( p -> !p.getPostcode().replaceAll("\\s","").equals(postcode))
					.collect(Collectors.toList());
	}
	

}
