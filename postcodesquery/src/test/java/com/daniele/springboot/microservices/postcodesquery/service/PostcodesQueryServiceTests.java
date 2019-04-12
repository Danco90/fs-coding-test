package com.daniele.springboot.microservices.postcodesquery.service;

import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.hamcrest.collection.IsEmptyCollection;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.server.ResponseStatusException;

import com.daniele.springboot.microservices.postcodesquery.exception.InvalidInputException;
import com.daniele.springboot.microservices.postcodesquery.exception.RemoteResourceReadTimeoutException;
import com.daniele.springboot.microservices.postcodesquery.exception.ValidationFormatException;
import com.daniele.springboot.microservices.postcodesquery.model.Postcode;
import com.daniele.springboot.microservices.postcodesquery.model.PostcodeInfo;
import com.daniele.springboot.microservices.postcodesquery.model.PostcodeResponseBean;
import com.daniele.springboot.microservices.postcodesquery.model.PostcodeValidationResponseBean;

@RunWith(SpringRunner.class)
@SpringBootTest(properties = {"job.autorun.enabled=false"})
public class PostcodesQueryServiceTests {
	
	@Autowired
    private PostcodesQueryService service;

	@Test
	public void validatePostCodeTest() throws RemoteResourceReadTimeoutException, ValidationFormatException {
		String pCode = "CB30FA";
	
		PostcodeValidationResponseBean actual = service.validatePostCode(pCode); 
		
		assertEquals(true, actual.getResult());
	}
	
	@Test(expected = ValidationFormatException.class)
	public void whenValidateIsCalledOnInvalidPostcode_shouldThrowInvalidInputException() throws RemoteResourceReadTimeoutException, ValidationFormatException, InvalidInputException {
		String invalidPostcode = "CB30FX";
		
		service.validatePostCode(invalidPostcode);
	}
	
	@Test(expected = InvalidInputException.class)
	public void whenValidateIsCalledOnEmptyPostcode_shouldThrowInvalidInputException() throws RemoteResourceReadTimeoutException, ValidationFormatException, InvalidInputException {
		String invalidPostcode = "";
		
		service.validatePostCode(invalidPostcode);
	}
	
	@Test
	public void getPostcodeInfoTest() throws HttpClientErrorException, RemoteResourceReadTimeoutException {
		String input = "CB30FA";
		String pcode = "CB3 0FA";
		String country = "England";
		String region = "East of England";
		
		PostcodeInfo expectedOutput = new PostcodeInfo();
		expectedOutput.setPostcode(pcode);
		expectedOutput.setCountry("England");
		expectedOutput.setRegion("East of England");
		
		PostcodeResponseBean expectedBean = new PostcodeResponseBean();
		Postcode postcode = new Postcode(pcode, country, region);
		expectedBean.setStatus(200);
		expectedBean.setResult(postcode);

		PostcodeInfo actual = service.getPostcodeInfo(input); 
		
		assertNotNull(actual);
		
		assertEquals(pcode, actual.getPostcode());
		assertEquals(country, actual.getCountry());
		assertEquals(region, actual.getRegion());
	}
	
	@Test(expected = InvalidInputException.class)
	public void whenGetPostcodeInfoOnNotExistingPostcode_shouldThrowInvalidInputException() throws RemoteResourceReadTimeoutException, ValidationFormatException, InvalidInputException {
		String notExistingPostcode = "CB30FX";
		
		service.getPostcodeInfo(notExistingPostcode); 
	}
	
	@Test
	public void getAllTheNearestPostcodesInfoTest() throws HttpClientErrorException, RemoteResourceReadTimeoutException {
		String input = "CB30FA";
		
		//Expected nearest postcodes
		PostcodeInfo postcodeInfoA = new PostcodeInfo("CB3 0GT", "England", "East of England");
		PostcodeInfo postcodeInfoB = new PostcodeInfo("CB3 0FT", "England", "East of England");
		List<PostcodeInfo> expResultList = new ArrayList<PostcodeInfo>() ;
		expResultList.add(postcodeInfoA);
		expResultList.add(postcodeInfoB);

		List<PostcodeInfo> actualList = service.getAllTheNearestPostcodesInfo(input); 
	 
		assertThat(actualList, not(IsEmptyCollection.empty()));
		
        assertThat(actualList, hasSize(expResultList.size()));
	}
	
	@Test(expected = InvalidInputException.class)
	public void whenGetAllTheNearestPostcodesInfoIsCalledWithInvalidPostcode_shouldThrowInvalidInputException() throws ResponseStatusException, RemoteResourceReadTimeoutException {
		String invalidPostcode = "";
		
		service.getAllTheNearestPostcodesInfo(invalidPostcode);
	}

}
