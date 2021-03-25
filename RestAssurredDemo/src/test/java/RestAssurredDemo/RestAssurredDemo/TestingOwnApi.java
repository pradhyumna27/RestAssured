package RestAssurredDemo.RestAssurredDemo;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class TestingOwnApi {

	//@Test
	public void test_Get() {

		baseURI = "http://localhost:3000/";

		given().header("Content-Type", "application/json").
			contentType(ContentType.JSON).accept(ContentType.JSON).param("firstName", "Pradhyumna").get("/users").
			
		then().
			body("subjectId[0]",equalTo(1)).
			statusCode(200).log().all();

	}
	
	//@Test
	public void test_Post() {
		
		baseURI = "http://localhost:3000/";
		
		JSONObject request=new JSONObject();
		
		request.put("firstName","Shreya");
		request.put("lastName","Aniruddh");
		request.put("subjectId","1");
		
		
		
		given().
			header("Content-Type", "application/json").
			contentType(ContentType.JSON).accept(ContentType.JSON).
			body(request.toJSONString()).
			
		when().
			post("/users").
			
		then().
			statusCode(201).log().all();
		
		
	}
	
	
	@Test
	public void test_put() {
		
		baseURI = "http://localhost:3000/";
		
		JSONObject request=new JSONObject();
		
		request.put("firstName","Geetha");
		request.put("lastName","Madhusudan");
		request.put("subjectId","2");
		
		
		
		given().
			header("Content-Type", "application/json").
			contentType(ContentType.JSON).accept(ContentType.JSON).
			body(request.toJSONString()).
			
		when().
			put("/users/2").
			
		then().
			statusCode(200);
		
		
	}
	
	
	
	//@Test
	public void test_patch() {
		
		baseURI = "http://localhost:3000/";
		
		JSONObject request=new JSONObject();
		
		
		request.put("lastName","Shreya");
		
		
		
		
		given().
			header("Content-Type", "application/json").
			contentType(ContentType.JSON).accept(ContentType.JSON).
			body(request.toJSONString()).
			
		when().
			patch("/users/4").
			
		then().
			statusCode(200);
		
		
	}
	
	
	//@Test
	public void test_delete() {
		
		
		baseURI = "http://localhost:3000/";
			
		given().
			delete("/users/4").
		then().
			statusCode(200);
		
		
	}
	
	
	
	

}
