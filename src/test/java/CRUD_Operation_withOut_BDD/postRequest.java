package CRUD_Operation_withOut_BDD;

import java.util.Random;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class postRequest {
	@Test
	public void postRequestTest() {
		Random ran=new Random();
		int randomNumber = ran.nextInt(1000);
		JSONObject jobj = new JSONObject();
		jobj.put("createdBy", "vinay"+randomNumber);
		jobj.put("projectName", "abcsd"+randomNumber);
		jobj.put("status", "completed");
		jobj.put("teamSize",randomNumber );
		
		RequestSpecification requstSpecification = RestAssured.given();
		requstSpecification.body(jobj);
		requstSpecification.contentType(ContentType.JSON);
		Response response = requstSpecification.post("http://localhost:8084/addProject");
		response.then().log().all();
		ValidatableResponse vresp = response.then().assertThat();
		vresp.contentType(ContentType.JSON);
		vresp.statusCode(201);
	
		
	}

}
