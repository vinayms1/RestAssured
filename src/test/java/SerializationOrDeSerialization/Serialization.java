  package SerializationOrDeSerialization;

import java.io.File;

import org.testng.annotations.Test;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rmgyantra.PojoLib.pojoLibrary;

public class Serialization {
	
	@Test
	public void ser() throws Throwable, Throwable, Throwable {
		pojoLibrary pojo = new pojoLibrary("kjhghfgdf", "argfds", "completed", 12);
		ObjectMapper mapper = new ObjectMapper();
		mapper.writerWithDefaultPrettyPrinter().writeValue(new File("./JsonValue"), pojo );
	}

}
