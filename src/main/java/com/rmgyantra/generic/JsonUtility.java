package com.rmgyantra.generic;
import io.restassured.response.Response;
/**
 * this class gives the json related reusable methods
 * @author Vinay
 *
 */
public class JsonUtility {
	/**
	 * this method is gives the json path
	 * @param response
	 * @param jsonPath
	 * @return
	 */
	public String getJsonPath(Response response, String jsonPath) {
		String jsonPathValue = response.jsonPath().get(jsonPath);
		return jsonPathValue;
	}

}
