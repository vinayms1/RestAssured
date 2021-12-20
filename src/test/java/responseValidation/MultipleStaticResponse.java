package responseValidation;

import static io.restassured.RestAssured.when;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;


import io.restassured.response.Response;

public class MultipleStaticResponse {
	@Test
	public void validation() {
		String actualProjectId="TY_PROJ_1002";
		boolean b=false;

		Response response = when()
				.get("http://localhost:8084/projects");
		List<String> projectId= response.jsonPath().get("projectId");
		for(String proId:projectId) {
			if(proId.equals(actualProjectId)) {
				b=true;
			}
		}
		Assert.assertEquals(b, true);
	}

}
