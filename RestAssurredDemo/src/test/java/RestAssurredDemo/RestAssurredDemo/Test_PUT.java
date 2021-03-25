package RestAssurredDemo.RestAssurredDemo;

import static io.restassured.RestAssured.given;

import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class Test_PUT {
	


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
		request.put("job", "TL");

		System.out.println(request);
		System.out.println(request.toJSONString());

		given().
			header("Content-Type", "application/json").
			contentType(ContentType.JSON).accept(ContentType.JSON).
			body(request.toJSONString()).
		
		when().
			put("https://reqres.in/api/users").
		then().
			statusCode(200);

	}



}
