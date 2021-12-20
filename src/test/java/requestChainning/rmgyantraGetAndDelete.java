package requestChainning;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;

import org.testng.annotations.Test;

import io.restassured.response.Response;

public class rmgyantraGetAndDelete {
	
	@Test
	public void requestChanning() {
		Response response = when()
		.get("http://localhost:8084/projects");
		String proId = response.jsonPath().get("[1].projectId");
		
		given()
		.pathParam("projectId", proId)
	.when()
		.delete("http://localhost:8084/projects/{projectId}")
		
	.then()
		.log().all();
		
		
	
		
		
	}

}
