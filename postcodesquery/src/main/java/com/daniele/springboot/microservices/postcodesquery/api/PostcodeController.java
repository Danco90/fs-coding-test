package com.daniele.springboot.microservices.postcodesquery.api;

import java.util.Collection;

import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.daniele.springboot.microservices.postcodesquery.model.Postcode;
import com.daniele.springboot.microservices.postcodesquery.persistence.PostcodeRepository;
import com.querydsl.core.types.Predicate;
import com.querydsl.core.types.dsl.BooleanExpression;


@RestController
@RequestMapping("postcodesquery/api")
public class PostcodeController {
	
//	private MongoTemplate mongoTemplate;
	private PostcodeRepository postcodeRepository;

//	public PostcodeController(MongoTemplate mongoTemplate) {
//		this.mongoTemplate = mongoTemplate;
//	}
	public PostcodeController(PostcodeRepository postcodeRepository) {
		this.postcodeRepository = postcodeRepository;
    }
	
	@PostMapping
	public void insert(@RequestBody Postcode input) {
		this.postcodeRepository.insert(input);
	}
	
	@GetMapping("/all")
	public Collection<Postcode> all(){
		Sort sortByPostcodeAsc = Sort.by("postcode").ascending();
		return this.postcodeRepository.findAll(sortByPostcodeAsc);
	}
	
	@PutMapping
	public void update(@RequestBody Postcode input) {
		this.postcodeRepository.save(input);
	}
	
	@DeleteMapping
	public void delete(@PathVariable String id) {
		this.postcodeRepository.deleteById(id);
	}
	
	@GetMapping("{id}")
	public Postcode byId(@PathVariable String id) {
		Postcode out = this.postcodeRepository.findById(id).orElse(null);
		return out;
	}
	
	@GetMapping("/byPostcode/{postcode}")
	public Collection<Postcode> byPostcode(@PathVariable String postcode) {
		Sort sortByPostcodeAsc = Sort.by("postcode").ascending();
		return this.postcodeRepository.findAllByPostcodeContains(postcode, sortByPostcodeAsc);	
	}
	
//	@GetMapping("withNoCodes")
//	public Collection<Postcode> withNoCodes(){
//		QPostcode query = new QPostcode("query");
//		BooleanExpression noCodesFilter = query.codes.isEmpty();
//		//Predicate notOfInterestFilter = noCodesFilter;
//		return (Collection<LegoSet>) this.postcodeRepository.findAll(noCodesFilter); 
//	}
	
	

}
