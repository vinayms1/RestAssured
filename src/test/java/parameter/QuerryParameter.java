package parameter;

import static io.restassured.RestAssured.*;

import java.util.concurrent.TimeUnit;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class QuerryParameter {
	
	@Test
	public void query() {
		given()
			.pathParam("abcd", "users")
			.queryParam("page", "2")
		.when()
			.get("https://reqres.in/api/{abcd}")
		.then()
			.assertThat().statusCode(200)
			.time(Matchers.lessThan(1000L), TimeUnit.MILLISECONDS)
			.contentType(ContentType.JSON)
			.log().all();
		
		
		
		
		
		
		
	}

}
