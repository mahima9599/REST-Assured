package TestRA;

import static io.restassured.RestAssured.*;
import static io.restassured.RestAssured.given;

import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class PutPatchDeleteMethods {
	
	@Test
	public void testPut() {
		
		JSONObject request = new JSONObject();
		request.put("name", "morpheus");
		request.put("job", "zion resident");
		
		System.out.println(request);     //this json object print map in string form
		System.out.println(request.toJSONString());    //this is to make sure tht map convert to string only
	
	
	baseURI = "https://reqres.in/api";    
	
	given().
	
	//to tell server tht the header we are sending is of type json we use below code
	contentType(ContentType.JSON).
	//to tell server that we will only accept json type response we use content-type accept method
	accept(ContentType.JSON).
	body(request.toJSONString()).     //using json object we are giving response through body
	when().
	put("/users?page=2").  //this is the end point of the api 
	then(). 
	statusCode(200)
	.log().all();   //printing all response 
	
	
	
	
	
	}
	
	
	
	@Test
	public void testPatch() {
		
		JSONObject request = new JSONObject();
		request.put("name", "morpheus");
		request.put("job", "zion resident");
		
		System.out.println(request);     //this json object print map in string form
		System.out.println(request.toJSONString());    //this is to make sure tht map convert to string only
	
	
	baseURI = "https://reqres.in";    
	
	given().
	
	//to tell server tht the header we are sending is of type json we use below code
	contentType(ContentType.JSON).
	//to tell server that we will only accept json type response we use content-type accept method
	accept(ContentType.JSON).
	body(request.toJSONString()).     //using json object we are giving response through body
	when().
	put("/api/users/2").  //this is the end point of the api 
	then(). 
	statusCode(200)
	.log().all();   //printing all response 
	
	
	
	
	
	}
	
	

	@Test
	public void testDelete() {	
	
	baseURI = "https://reqres.in";    
	
	when().
	delete("/api/users/2").  //this is the end point of the api 
	then(). 
	statusCode(204)   //for successful delete 204 is status code
	.log().all();   //printing all response 
	
	
	
	
	
	}
	

}
