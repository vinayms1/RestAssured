package requestChainning;

import static io.restassured.RestAssured.given;

import java.util.Random;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class postAndDelete {
	@Test
	public void requestChaining() {
		Random ran=new Random();
		int random = ran.nextInt(1000);
		
		JSONObject jobj=new JSONObject();
		jobj.put("createdBy", "vinay"+random);
		jobj.put("projectName", "abc"+random);
		jobj.put("status", "completed");
		jobj.put("teamSize", random);
		
		Response response = given()
			.body(jobj)
			.contentType(ContentType.JSON)
		.when()
		.post("http://localhost:8084/addProject");
		String proId = response.jsonPath().get("projectId");
		
		given()
			.pathParam("projectID", proId)
		.when()
			.delete("http://localhost:8084/projects/{projectID}")
		.then()
			.log().all();
		
	}

}
