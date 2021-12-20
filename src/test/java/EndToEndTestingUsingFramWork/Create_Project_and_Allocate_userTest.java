package EndToEndTestingUsingFramWork;

import static io.restassured.RestAssured.given;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.rmgyantra.PojoLib.pojoLibrary;
import com.rmgyantra.generic.JavaUtility;
import com.rmgyantra.generic.endPoints;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class Create_Project_and_Allocate_userTest {
	@Test
	public void createProjectTest()  {
		
		JavaUtility jobj=new JavaUtility();
		String expectedProjectName = "CHAI"+jobj.random();
		pojoLibrary pobj=new pojoLibrary("CHAITANYA", expectedProjectName, "completed", jobj.random());
		Response response = given()
			.body(pobj)
			.contentType(ContentType.JSON)
		.when()
			.post(endPoints.POSTPROJECTS);
		String responseProjectName = response.jsonPath().get("projectName");
		response.then().assertThat()
		.log().all()
		.and()
		.statusCode(201);
	//	.time(Matchers.lessThan(5000L), TimeUnit.MILLISECONDS);
		
		String expectedUserName="vinayms_"+jobj.random();
		
		
		JSONObject jobj1=new JSONObject();
		jobj1.put("designation", "SDET_"+jobj.random());
		jobj1.put("dob", "10/09/1997");
		jobj1 .put("email", "VINAY@GMAIL.COM");
		jobj1.put("experience", 12);
		jobj1.put("mobileNo", "9964648142");
		jobj1.put("project", ""+responseProjectName+"");
		jobj1 .put("role", "ROLE_ADMIN");
		jobj1.put("username", expectedUserName);
		
		
	Response response1 = given()
	.body(jobj1)
	.contentType(ContentType.JSON)
		.when()
			.post("http://localhost:8084/employees");
	String ActualUserName = response1.jsonPath().get("username");
	response1.then()
	
		.assertThat().statusCode(201)
			.log().all();
		Assert.assertEquals(expectedUserName, ActualUserName);
	}
		}


