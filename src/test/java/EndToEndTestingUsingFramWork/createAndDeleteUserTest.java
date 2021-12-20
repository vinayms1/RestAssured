package EndToEndTestingUsingFramWork;

import static io.restassured.RestAssured.given;

import java.util.concurrent.TimeUnit;

import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.rmgyantra.PojoLib.pojoLibrary;
import com.rmgyantra.generic.DataBaseUtility;
import com.rmgyantra.generic.JavaUtility;
import com.rmgyantra.generic.endPoints;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class createAndDeleteUserTest {
	@Test
	public void createAndDeleteTest() throws Throwable  {
	
		DataBaseUtility dlib=new DataBaseUtility();
		JavaUtility jobj=new JavaUtility();
		String expectedProjectName = "CHAI"+jobj.random();
		pojoLibrary pobj=new pojoLibrary("CHAITANYA", expectedProjectName, "completed", jobj.random());
		Response response = given()
			.body(pobj)
			.contentType(ContentType.JSON)
		.when()
			.post(endPoints.POSTPROJECTS);
		String responseProjectName = response.jsonPath().get("projectName");
		String responseProjectId =response.jsonPath().get("projectId");
		response.then().assertThat()
		.log().all()
		.and()
		.statusCode(201)
		.time(Matchers.lessThan(5000L), TimeUnit.MILLISECONDS);
		String dataBaseProjectname = dlib.getTheDataAndVerifyTheData("select * from project;", expectedProjectName, 4);
		Assert.assertEquals(responseProjectName, dataBaseProjectname);
		
		given()
			.pathParam("ProjectId", responseProjectId)
		
		.when()
			.delete("http://localhost:8084/projects/"+responseProjectId+"")
		.then()
			.assertThat().statusCode(201)
			.log().all();
	}

}
