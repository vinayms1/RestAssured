package Authentication;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

public class BerearToken {
	@Test
	public void BerearTokenAuthentication() {
		given()
			.auth().oauth2("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")
			.pathParam("rep_os", "repos")
		.when()
			.get("https://api.github.com/user/{rep_os}")
		.then()
			.log().all();

	}
}