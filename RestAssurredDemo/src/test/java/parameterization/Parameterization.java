package parameterization;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;

import org.json.simple.JSONObject;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class Parameterization {

	@DataProvider
	public Object[][] readData() {

		Object[][] data= ReadDataFromExcel.testreadexcel();
		System.out.println(data);
		return data;
		
		
		// return new Object[][] {
		// {"Aniruddh","Madhusudan",2},
		// {"Shreya","Aniruddh",1}
		// };

	}

	@Test(dataProvider = "readData")
	public void test_Post(Object firstName, Object lastName, Object subjectId) {

		baseURI = "http://localhost:3000/";

		JSONObject request = new JSONObject();

		request.put("firstName", firstName);
		request.put("lastName", lastName);
		request.put("subjectId", subjectId);

		given().header("Content-Type", "application/json").contentType(ContentType.JSON).accept(ContentType.JSON)
				.body(request.toJSONString()).

				when().post("/users").

				then().statusCode(201).log().all();

	}

	// @DataProvider(name="deleteData")
	public Object[] deleteData() {

		return new Object[] { 4, 5

		};

	}

	// @Test(dataProvider="deleteData")
	public void Test01_Delete(int userId) {

		baseURI = "http://localhost:3000/";

		given().delete("/users/" + userId).then().statusCode(200);

	}

}
