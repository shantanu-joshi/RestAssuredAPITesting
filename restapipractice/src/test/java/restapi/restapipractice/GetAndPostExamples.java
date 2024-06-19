package restapi.restapipractice;


import org.json.simple.JSONObject;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import io.restassured.response.Response;
import static org.hamcrest.Matcher.*;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.CoreMatchers.equalTo;



import java.util.HashMap;
import java.util.Map;

public class GetAndPostExamples {

	@Test
	public void testGet() {
		baseURI = "https://reqres.in";

		given().get("/api/users?page=2").then().statusCode(200).log().all();
	}

	@Test
	public void Equal() {
		baseURI = "https://reqres.in";
		given().get("/api/users?page=2").then().body("data[4].first_name", equalTo("George"));

	}

	@Test
	public void HasItem() {

		baseURI = "https://reqres.in";
		// It will check if the JSON path has these names specified under hasItems+
		//for this recognize we need to add thsi library import static org.hamcrest.Matchers.*;  there is s after matcher in the imported line
		given().get("/api/users?page=2").then().statusCode(200).body("data.first_name", hasItems("George", "rachel"));

	}

	@Test
	public void hasitem2()
	{
		
		baseURI = "https://www.reqres.in";
		given().get("/users?page=2").then().statusCode(200).body("data.firstname",hasItems("Nkf"));
		
		
	}

	@Test
	public void TestPost() {
		
		//Here we are using JSONObject by json simple it will create json objects 
		JSONObject request = new JSONObject();
		request.put("name","shantanu");
		request.put("job", "software engineer");
		System.out.println(request.toJSONString());
		baseURI = "https://reqres.in/api";
		
		
		//For successful post req 201 will be there
		given().body(request.toJSONString()).when().post("/users").then().statusCode(201).log().all();
	}
}
