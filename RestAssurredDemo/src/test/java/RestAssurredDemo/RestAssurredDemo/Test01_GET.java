package RestAssurredDemo.RestAssurredDemo;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class Test01_GET {

	@Test
	public void Test_01() {

		Response response = get("https://reqres.in/api/users?page=2");

		System.out.println(response.getHeader("content-type"));
		System.out.println(response.getStatusCode());
		System.out.println(response.getStatusLine());
		System.out.println(response.asString());
		System.out.println(response.getSessionId());
		System.out.println(response.getBody().asString());
		System.out.println(response.getTime());

		int statusCode = response.getStatusCode();
		Assert.assertEquals(statusCode, 200);
	}

	@Test
	public void Test_02() {
		
		given()
			.header("Content-Type","application/json")
			.get("https://reqres.in/api/users?page=2")
		.then()
			.statusCode(200)
			.body("data.id[1]", equalTo(8))
			.body("data.first_name[0]", equalTo("Michael"))
			.body("data.first_name", hasItems("Michael", "Lindsay"));
		
		

	}

}
