package differentWaysToPostTheRequest;

import org.testng.annotations.Test;

import com.rmgyantra.PojoLib.pojoLibrary;

import io.restassured.http.ContentType;
import static io.restassured.RestAssured.*;

public class postRequestUsingPojoClass {
	@Test
	public void postRequest() {
		pojoLibrary pobj=new pojoLibrary("akshay1", "ahaha", "completed", 9);
		
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
