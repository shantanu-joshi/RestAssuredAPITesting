package restapi.restapipractice;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import org.testng.annotations.Test;

public class JSONSchemaValidator {
	
	
	@Test
	void test3()
	{
		
		//Base URI is from rest assured lass
		baseURI = "https://reqres.in/api";
		//JSON PATH FINDER
		//log all is to print the complete response
		given().get("/users?page=2").then().assertThat().body(matchesJsonSchemaInClasspath("schema.json")).statusCode(200);
	
	
		
		

	}

}
