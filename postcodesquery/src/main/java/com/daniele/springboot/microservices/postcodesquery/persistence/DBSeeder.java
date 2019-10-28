package com.daniele.springboot.microservices.postcodesquery.persistence;

import java.util.Arrays;
import java.util.Collection;

import org.springframework.boot.CommandLineRunner;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import com.daniele.springboot.microservices.postcodesquery.model.Codes;
import com.daniele.springboot.microservices.postcodesquery.model.Postcode;


@Service
public class DBSeeder implements CommandLineRunner {
	private MongoTemplate mongoTemplate;
	private PostcodeRepository postcodeRepository;

	public DBSeeder(PostcodeRepository postcodeRepository, MongoTemplate mongoTemplate) {
		this.mongoTemplate = mongoTemplate;
		this.postcodeRepository = postcodeRepository;
	}

	@Override
	public void run(String... args) throws Exception {
		//this.mongoTemplate.dropCollection(LegoSet.class);
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

}
