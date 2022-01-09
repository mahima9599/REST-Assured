package TestRA;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.matcher.RestAssuredMatchers.*;




public class GetAndPostExamples {
	
	//@Test 
	public void testGet() {
		
		baseURI = "https://reqres.in/api"; 
		
		given().
			get("/users?page=2").
		then().
			statusCode(200).
			body("data[2].first_name", equalTo("Tobias")).
			body("data.first_name", hasItems("Tobias" , "Rachel"));
			
		
	}
	
	//post request -> post comes with a payload itself so we have to create that payload also
	
	@Test
	public void testPost() {
		
		Map<String, Object>map= new HashMap<String, Object>();
		map.put("name","Raghav");
		map.put("\"name\"","Raghav");   //this will print key in double quotes
		map.put("job","Teacher");
		System.out.println(map);
		
		JSONObject request = new JSONObject(map);
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
	post("/users").  //this is the end point of the api 
	then(). 
	statusCode(201)
	.log().all();   //printing all response 
	
	
	
	
	
	}

}
