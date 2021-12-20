package practiece;

import static io.restassured.RestAssured.given;

import java.io.File;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class CreateUSerWithInvalidMobileNum {
	@Test
	public void CreateUSer() {
		File file=new File("./src/test/resources/dsa.json");
		given()
			.body(file)
 			.contentType(ContentType.JSON)
		.when()
			.post("http://localhost:8084/employees")
		.then()
			.assertThat().contentType(ContentType.JSON)
			.and()
			.statusCode(201)
			.log().all();
		
		
		
	}

}
