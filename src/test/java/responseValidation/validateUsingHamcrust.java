package responseValidation;

import static io.restassured.RestAssured.*;

import java.util.concurrent.TimeUnit;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

public class validateUsingHamcrust {
	@Test
	public void validate() {
		String expectedProjectId="TY_PROJ_1002";
		when()
		.get("http://localhost:8084/projects")
	.then()
		.assertThat()
		.time(Matchers.lessThan(5000L), TimeUnit.MILLISECONDS)
		.body("[1].projectId", Matchers.equalTo(expectedProjectId))
		.statusCode(200)
		.log().all();
		
	
	
}
		
	}


