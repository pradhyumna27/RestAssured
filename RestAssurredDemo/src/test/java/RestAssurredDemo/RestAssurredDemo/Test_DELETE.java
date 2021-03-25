package RestAssurredDemo.RestAssurredDemo;

import org.testng.annotations.Test;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class Test_DELETE {
	


	@Test
	public void Test01_POST() {
		
		
		when().
			delete("https://reqres.in/api/users/2").
		then().
			statusCode(204);

	}



}
