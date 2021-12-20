package differentWaysToPostTheRequest;

import static io.restassured.RestAssured.given;

import java.util.HashMap;
import java.util.Random;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class PostRequestFromHashMap {
	@Test
	public void postRequest() {
		Random ran = new Random();
		int random = ran.nextInt(1000);
		HashMap hash = new HashMap();
		hash.put("createdBy", "manoj" + random);
		hash.put("projectName", "abc" + random);
		hash.put("status", "completed");
		hash.put("teamSize", random);

		given()
			.body(hash)
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
