package com.daniele.springboot.microservices.postcodesquery.persistence;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.daniele.springboot.microservices.postcodesquery.model.Postcode;

@Repository
public interface PostcodeRepository extends MongoRepository<Postcode, String>{

}
