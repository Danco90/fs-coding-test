package com.daniele.springboot.microservices.postcodesquery;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringRunner;

import com.daniele.springboot.microservices.postcodesquery.model.Codes;
import com.daniele.springboot.microservices.postcodesquery.model.Postcode;
import com.daniele.springboot.microservices.postcodesquery.persistence.PostcodeRepository;

@RunWith(SpringRunner.class)
//@SpringBootTest(properties = {"job.autorun.enabled=false"})
@DataMongoTest
public class PostcodesQueryApplicationTests {
	
	@Autowired
	private PostcodeRepository postcodeRepository;

	@Before
	public void before() {
		this.postcodeRepository.deleteAll();
		
		//this.mongoTemplate.dropCollection(PaymentOptions.class);

		/*
		 *  Postcodes
		 */
		Postcode postcode1 = new Postcode(
                "CB3 0FA",
                "England",
                "East of England");
		
		Postcode postcode2 = new Postcode(
                "CB3 0EA",
                "England",
                "East of England");
		
		Postcode postcodeWithNearest = new Postcode(
                "CB3 0AA", 1, 544410, 259026,
                "England",
                "East of England", 0.112119, 52.210537,
                "Eastern",
                "Cambridgeshire",
                "East of England",
                "Cambridge 005D",
                "Cambridge 005",
                "0AA",
                "CB3", 
                "Cambridge",
                "Cambridge",
                "Cambridge, unparished area",
                "Cambridgeshire",
                "Castle",
                "Castle",
                "NHS Cambridgeshire and Peterborough",
                "Cambridgeshire CC",
                new Codes("E07000008", 
                			"E10000003",
                			"E05002704",
                			"E43000042",
                			"E14000617",
                			"E38000026",
                			"E58000057",
                			"UKH12") );
		
		Postcode postcodeWithNearest2 = new Postcode(
                "CB3 0AL", 1, 544455, 259086,
                "England",
                "East of England", 0.112803, 52.211064,
                "Eastern",
                "Cambridgeshire",
                "East of England",
                "Cambridge 005D",
                "Cambridge 005",
                "0AL",
                "CB3", 
                "Cambridge",
                "Cambridge",
                "Cambridge, unparished area",
                "Cambridgeshire",
                "Castle",
                "Castle",
                "NHS Cambridgeshire and Peterborough",
                "Cambridgeshire CC",
                new Codes("E07000008", 
                			"E10000003",
                			"E05002704",
                			"E43000042",
                			"E14000617",
                			"E38000026",
                			"E58000057",
                			"UKH12") );

        Collection<Postcode> initialProducts = Arrays.asList(postcode1, postcode2, postcodeWithNearest, postcodeWithNearest2);

        this.postcodeRepository.insert(initialProducts);
	}
	
	@Test
	public void findAllByPostcodeContains_should_return_postcodes_that_match_such_combination_of_characters() {
		List<Postcode> results = (List<Postcode>)this.postcodeRepository.findAllByPostcodeContains("CB3", Sort.by("postcode").ascending());
		assertEquals(4, results.size());
	}
	
	@After
	public void after() {
		this.postcodeRepository.deleteAll();
	}

}
