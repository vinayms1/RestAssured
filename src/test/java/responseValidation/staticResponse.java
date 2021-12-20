package responseValidation;

import static io.restassured.RestAssured.when;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;

public class staticResponse {
	@Test
	public void validation() {
		String actualProjectId="TY_PROJ_1002";
		Response response = when()
		.get("http://localhost:8084/projects");
	String projectId= response.jsonPath().get("[1].projectId");	
	Assert.assertEquals(actualProjectId, projectId);
		}
	}


