package CRUD_Operation_withOut_BDD;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

public class getResponse {
	@Test
	public void getRequest() {
	Response resp = RestAssured.get("http://localhost:8084/projects");
	resp.then().log().all();
	ValidatableResponse validatableResponse = resp.then().assertThat();
	validatableResponse.statusCode(200);
	validatableResponse.contentType(ContentType.JSON);
		
	}

}
