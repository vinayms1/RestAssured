package SerializationOrDeSerialization;

import java.io.File;
import java.io.IOException;

import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.rmgyantra.PojoLib.pojoLibrary;

public class Deserialization {
	@Test
	public void deser() throws Throwable, Throwable, Throwable {
		
		ObjectMapper mapper = new ObjectMapper();
		pojoLibrary pojo = mapper.readValue(new File("./JsonValue"), pojoLibrary.class);
		System.out.println(pojo.createdBy);
		System.out.println(pojo.projectName);
		System.out.println(pojo.status);
		System.out.println(pojo.teamSize);
		
	}

}
