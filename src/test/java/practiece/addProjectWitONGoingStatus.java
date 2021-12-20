package practiece;

import org.testng.annotations.Test;

import com.rmgyantra.PojoLib.pojoLibrary;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class addProjectWitONGoingStatus {
	@Test
	public void createProject() {
		
		pojoLibrary pobj=new pojoLibrary("karthik", "asdfgh", "on going", 12);
		given()
			.body(pobj)
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
