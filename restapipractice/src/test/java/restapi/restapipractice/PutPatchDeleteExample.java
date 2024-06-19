package restapi.restapipractice;

import static io.restassured.RestAssured.*;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class PutPatchDeleteExample {

	@Test
	public void TestPut() {

		// Here we are using JSONObject by json simple it will create json objects
		JSONObject request = new JSONObject();
		request.put("name", "shantanu");
		request.put("job", "software engineer");
		System.out.println(request.toJSONString());
		baseURI = "https://reqres.in/api";

		// For successful post req 201 will be there
		given().body(request.toJSONString()).when().put("/users/2").then().statusCode(201).log().all();
	}

	@Test
	public void TestPatch() {

		// Here we are using JSONObject by json simple it will create json objects
		JSONObject request = new JSONObject();
		request.put("name", "shantanu");
		request.put("job", "software engineer");
		System.out.println(request.toJSONString());
		baseURI = "https://reqres.in";

		// For successful post req 201 will be there
		given().body(request.toJSONString()).when().put("/api/users/2").then().statusCode(200).log().all();
	}

	@Test
	public void TestPatch2() {

		// Here we are using JSONObject by json simple it will create json objects
		JSONObject request = new JSONObject();
		request.put("name", "shantanu");
		request.put("job", "software engineer");
		System.out.println(request.toJSONString());
		baseURI = "https://reqres.in";

		// For successful post req 201 will be there
		given().header("Content-Type", "application/json").contentType(ContentType.JSON).accept(ContentType.JSON)
				.body(request.toJSONString()).when().put("/api/users/2").then().statusCode(200).log().all();
	}

//204 status code for delete 
	@Test
	public void TestDelete() {

		baseURI = "https://reqres.in";

		when().delete("/api/users/2").then().statusCode(204).log().all();
	}

}
