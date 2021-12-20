package CRUD_Operation_with_BDD;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class deleteRequest {
	@Test
	public void deleteRequestTest() {
		when()
			.delete("http://localhost:8084/projects/TY_PROJ_1203")
		.then()
			.assertThat().statusCode(204)
			.log().all();
	}

}
