package Authentication;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

public class PreemptiveAndDigestive {
	@Test
	public void Preemptive() {
		given()
		 	.auth().preemptive().basic("rmgyantra", "rmgy@9999")
		 	.pathParam("log_in", "login")
		.when()
			.get("http://localhost:8084/{log_in}")
		.then()
			.log().all();
	}
	@Test
	public void digestive() {
		given()
			.auth().digest("rmgyantra", "rmgy@9999")
			.pathParam("log_in", "login")
		.when()
			.get("http://localhost:8084/{log_in}")
		.then()
			.log().all();
	}

}




