package com.daniele.springboot.microservices.postcodesquery;

import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.ResponseStatusException;

import com.daniele.springboot.microservices.postcodesquery.exception.InvalidInputException;
import com.daniele.springboot.microservices.postcodesquery.exception.RemoteResourceReadTimeoutException;
import com.daniele.springboot.microservices.postcodesquery.exception.ValidationFormatException;
import com.daniele.springboot.microservices.postcodesquery.model.PostcodeInfo;
import com.daniele.springboot.microservices.postcodesquery.model.PostcodeValidationResponseBean;
import com.daniele.springboot.microservices.postcodesquery.service.PostcodesQueryService;

@SpringBootApplication(scanBasePackages={
		"com.daniele.springboot.microservices.postcodesquery"
		})
public class PostcodesQueryApplication {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	public static void main(String[] args) {
		SpringApplication.run(PostcodesQueryApplication.class, args);
	}

	@Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }

//    @Bean
//    @ConditionalOnProperty(prefix = "job.autorun", name = "enabled", havingValue = "true", matchIfMissing = true)
//    public CommandLineRunner run(PostcodesQueryService postcodesQueryService) {
//       	logger.debug("postcodes query  starts");
//        return args -> {
//	    		
//        		try {
//	        		final String postcode = args.length > 0 ? args[0] : "" ;
//		    		logger.info("input arg : postcode='{}'", postcode);
//		    		
//		    		postcodesQueryService.validatePostCode(postcode);
//	
//		    		PostcodeInfo result = postcodesQueryService.getPostcodeInfo(postcode);
//		    		logger.info("postcode:  {}, country='{}', region='{}'", result.getPostcode(), result.getCountry(), result.getRegion());
//		    		 
//		    		List<PostcodeInfo> resultList = postcodesQueryService.getAllTheNearestPostcodesInfo(postcode);
//		    	     
//		    		String nearestList = resultList.stream()
//		    		        .map( n -> n.toString() )
//		    		        .collect( Collectors.joining( "," ) );
//		    		
//		    		logger.info("nearest postcodes:  {}", nearestList);
//		    		
//        		} catch (InvalidInputException ex) {
//        			logger.error("INPUT ERROR, cause ", ex);
//        		} catch (RemoteResourceReadTimeoutException ex) {
//        			logger.error("API ERROR, cause ", ex);
//        		} finally {
//        			logger.debug("postcodes query  ends");
//        		}
//        };
//    }

}
