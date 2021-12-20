package CRUD_Operation_with_BDD;

import java.util.Random;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class updateRequest {
	@Test
	public void deleteRequest() {
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
		.put("http://localhost:8084/projects/TY_PROJ_1002")
		.then()
		.assertThat().contentType(ContentType.JSON)
		.and()
		.statusCode(200)
		.log().all();
		
	}

}
