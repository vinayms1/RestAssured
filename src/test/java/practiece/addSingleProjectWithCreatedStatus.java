package practiece;

import org.testng.annotations.Test;

import com.rmgyantra.PojoLib.pojoLibrary;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class addSingleProjectWithCreatedStatus {
	@Test
	public void projectCreate() {
		pojoLibrary pobj=new pojoLibrary("adharsh", "asdfghj", "completed", 23);
		given()
			.body(pobj)
			.contentType(ContentType.JSON)
		.when()
			.post("http://localhost:8084/addProject")
		.then()
			.assertThat().statusCode(201)
			.and()
			.contentType(ContentType.JSON)
			.log().all();
		
	}
}
