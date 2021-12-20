package responseValidation;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.rmgyantra.PojoLib.pojoLibrary;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class multipleDataForSameRequest {
	@Test(dataProvider = "getData")
	public void createResponse(String createdBy, String projectName, String status, int teamSize) {

		pojoLibrary pobj = new pojoLibrary(createdBy, projectName, status, teamSize);
		given()
			.body(pobj)
			.contentType(ContentType.JSON)
		.when()
			.post("http://localhost:8084/addProject")
		.then()
			.assertThat().contentType(ContentType.JSON)
			.log().all();
	}

	@DataProvider
	public Object[][] getData() {
		Object[][] objArray = new Object[2][4];
		objArray[0][0] = "akash12";
		objArray[0][1] = "akash project12";
		objArray[0][2] = "completed";
		objArray[0][3] = 10;

		objArray[1][0] = "vikas12";
		objArray[1][1] = "vikas project12";
		objArray[1][2] = "completed";
		objArray[1][3] = 20;
		return objArray;
	}

}
