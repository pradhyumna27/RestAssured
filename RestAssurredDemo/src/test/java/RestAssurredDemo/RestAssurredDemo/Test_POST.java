package RestAssurredDemo.RestAssurredDemo;

import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class Test_POST {

	@Test
	public void Test01_POST() {

		Map<String, Object> map = new HashMap<String, Object>();

		// 1. Using Map and converting it into json using json simple library

		// map.put("name", "Pradhyumna");
		// map.put("job", "SSE");
		//
		// System.out.println(map);

		JSONObject request = new JSONObject();

		// System.out.println(request);
		// System.out.println(request.toJSONString());

		// 2. Without using Map

		request.put("name", "Pradhyumna");
		request.put("job", "SSE");

		System.out.println(request);
		System.out.println(request.toJSONString());

		given().
			header("Content-Type", "application/json").
			contentType(ContentType.JSON).accept(ContentType.JSON).
			body(request.toJSONString()).
		
		when().
			post("https://reqres.in/api/users").
		then().
			statusCode(201);

	}

}
