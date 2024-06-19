package restapi.restapipractice;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.internal.util.IOUtils;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
public class SOAPXMLRequest {


// URL for soap req :- http://dneonline.com/calculator.asmx?op=Add
//copied SOAP of addition into SOAPRequest folder in the curent folder, also added the response in the 
	
	@Test
	public void validateSoapXML() throws FileNotFoundException
	{
		
		File file = new File("./SOAPRequest/Add.xml");
		
		
		FileInputStream fl = new FileInputStream(file);
		//String requestBody = IOUtils.toString(fl,"UTF-8");
		
		baseURI = "http://dneonline.com";
		
		given().contentType("text/xml").accept(ContentType.XML).body(file).when().post("calculator.asmx").then().statusCode(200).log().all();
		
	}

}
