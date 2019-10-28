# Postcodes Query

This repository contains the sample code for the following techical exercise :

Create a client which allows the user to query and show details for a given UK postcode.

Make use of REST API at a postcodes.base.uri=http://postcodes.io

Configuration :

You can easily configure your postcodes API base uri path from property file (src/main/resources/application.properties)

	postcodes.base.uri={BASE_PATH}/postcodes
	
	ex: postcodes.base.uri=http://localhost:8000/postcodes

Here are the required details: :
 
	● Validate the postcode parameter – invalid postcodes should produce an error message
	● Print the country and region for that postcode.
	● Print a list of the nearest postcodes, and their countries and regions.
	● It should query the API to
		GET /postcodes/{POSTCODE}
		GET /postcodes/{POSTCODE}/validate
		GET /postcodes/{POSTCODE}/nearest
		
	● Consider carefully your error handling (eg API failure / timeout, invalid input etc)
	● Please add some unit tests - don’t go overboard, but show us an example or two of some edge cases or things that 	  could go wrong.
	
	● Time-depending, you could also consider additional API calls, such as postcode suggestions.
	
	
 
Open the command prompt/Terminal 
to run the code clone the repository using below command - 

git clone https://github.com/Danco90/fs-conding-test.git

## compile the code-
	mvn clean install

## run the compiled code with Maven config
	mvn spring-boot:run -Dspring-boot.run.arguments={POSTCODE}
	
	ex: mvn spring-boot:run -Dspring-boot.run.arguments=CB30FA

## unit test 
	mvn test

## run API executable

Test the Application by running the executable in a terminal :

    cd $PROJECT/target
    java -jar postcodesquery-0.0.1-SNAPSHOT.jar {POSTCODE}
    
    example:
    java -jar postcodesquery-0.0.1-SNAPSHOT.jar CB30FA



