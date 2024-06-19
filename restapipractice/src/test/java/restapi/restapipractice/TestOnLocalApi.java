package restapi.restapipractice;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class TestOnLocalApi {

//We have created a local API and we are testing the command on it	
	@Test
	public void get() {

		baseURI = "http://localhost:3000";
		given().get("/user").then().statusCode(200).log().all();

	}

	@Test
	public void post() {
		JSONObject request = new JSONObject();

		request.put("firstName", "Thor");
		request.put("lastName", "Madarchod");
		request.put("subjectId", 2);

		baseURI = "http://localhost:3000";

		given().contentType(ContentType.JSON).accept(ContentType.JSON).body(request.toJSONString()).when().post("/user")
				.then().statusCode(201);

	}

	@Test
	public void put() {
		JSONObject request = new JSONObject();

		request.put("firstName", "LOLO");
		request.put("lastName", "BKL");
		request.put("subjectId", 2);

		baseURI = "http://localhost:3000";

//Updating the 4 id our local API we have created

		given().contentType(ContentType.JSON).accept(ContentType.JSON).body(request.toJSONString()).when()
				.put("/user/4").then().statusCode(200);

	}
	
	
	
	@Test
	public void delete()
	{
		baseURI = "http://localhost:3000";
		when().delete("/user/2").then().statusCode(200);
	}

}
