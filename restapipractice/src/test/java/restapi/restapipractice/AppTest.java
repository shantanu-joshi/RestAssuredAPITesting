package restapi.restapipractice;

import static io.restassured.RestAssured.*; //static import for using direct methods of REST API
import io.restassured.response.Response;
import io.restassured.*;

import static org.hamcrest.CoreMatchers.equalTo;

import org.testng.*;
import org.testng.annotations.Test;

public class AppTest {
	@Test
	void test1() {

		// rest api is from reqres.in

		Response response = get("https://reqres.in/api/users?page=2");
		// Response response = get("https://reqres.in/api/users?page=2");
		System.out.println(response.getStatusCode());
		System.out.println("Status code :" + response.getStatusCode());
		System.out.println("Body :" + response.getBody().asString());
		System.out.println("Time Taken :" + response.getTime());
		System.out.println("Header :" + response.getContentType());

		int statusCode = response.getStatusCode();
		Assert.assertEquals(statusCode, 202);

	}

	@Test
	void test2() {
		given().get("https://reqres.in/api/users?page=2").then().statusCode(201);

	}
	
	
	@Test
	void test3()
	{
		
		//Base URI is from rest assured lass
		baseURI = "https://reqres.in/api";
		//JSON PATH FINDER
		//log all is to print the complete response
		given().get("/users?page=2").then().statusCode(200).body("data[1].id", equalTo(8)).log().all();
		

	}
	
	@Test
	void test4()
	{
		
		//Base URI is from rest assured lass
		baseURI = "https://reqres.in/api";
		//JSON PATH FINDER
		//log all is to print the complete response
		given().get("/users?page=2").then().statusCode(200).body("data[1].id", equalTo(8)).log().all();
		

	}
	
}
