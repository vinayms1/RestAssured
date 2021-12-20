package CRUD_Operation_with_BDD;

import java.util.Random;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class postRequest {
	@Test
	public void createRequest() {
		
		Random ran=new Random();
		int random = ran.nextInt(1000);
		
		JSONObject jobj=new JSONObject();
		jobj.put("createdBy", "manoj"+random);
		jobj.put("projectName", "abc"+random);
		jobj.put("status", "completed");
		jobj.put("teamSize", random);
		
		given()
			.body(jobj)
			.contentType(ContentType.JSON)
			
		.when()
		.post("http://localhost:8084/addProject")
		.then()
		.assertThat().contentType(ContentType.JSON)
		.and()
		.statusCode(201)
		.log().all();
		
		
		
		
	}

}
