package CRUD_Operation_with_BDD;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class getRequest {
	
	@Test
	public void getResponse() {
		when()
			.get("http://localhost:8084/projects")
		.then()
			.assertThat().statusCode(200)
			.log().all();
		
		
	}

}
