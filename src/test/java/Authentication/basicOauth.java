package Authentication;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class basicOauth {
	@Test
	public void basicOauthAuthentication() {
		given()
			.auth().basic("rmgyantra", "rmgy@9999")
			.pathParam("log_in", "login")
		.when()
			.get("http://localhost:8084/{log_in}")
		.then()
			.log().all();
	}
}
