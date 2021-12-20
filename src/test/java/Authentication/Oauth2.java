package Authentication;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.response.Response;

public class Oauth2 {
	
	@Test
	public void oauthAthentication() {
	Response response = given()
		.formParam("client_id", "VINAY_SDET")
		.formParam("client_secret", "a783835d2babfae039186ffbf107750b")
		.formParam("grant_type", "client_credentials")
		.formParam("redirect_uri", "https://example.com")
	.when()
		.post("http://coop.apps.symfonycasts.com/token");
	String tokenId = response.jsonPath().get("access_token");
	 	
	given()
		.auth().oauth2(tokenId)
		.pathParam("use_id", 2542)
	.when()
		.post("http://coop.apps.symfonycasts.com/api/{use_id}/eggs-collect")
		
	.then()
		.log().all();
		
	
	
			
	}

}
