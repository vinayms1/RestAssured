package CRUD_Operation_withOut_BDD;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class Delete {
	@Test
	public void deleteResponse() {
		
		Response response = RestAssured.delete("http://localhost:8084/projects/TY_PROJ_1004");
		response.then().log().all();
		response.then().assertThat().statusCode(204);
		
		
	}

}
