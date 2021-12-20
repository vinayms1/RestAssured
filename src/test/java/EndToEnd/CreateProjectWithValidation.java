package EndToEnd;

import static io.restassured.RestAssured.given;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.hamcrest.Matchers;
import org.json.simple.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement; 
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.mysql.cj.jdbc.Driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class CreateProjectWithValidation {
	
	@SuppressWarnings("unchecked")
	@Test
	public void validation() throws Throwable {
	
		//Business layer validation
		Random ran=new Random();
		int random = ran.nextInt(1000);
		
		JSONObject jobj=new JSONObject();
		jobj.put("createdBy", "visay_"+random);
		jobj.put("projectName", "abc"+random);
		jobj.put("status", "completed");
		jobj.put("teamSize", random);
		
		Response response = given()
			.body(jobj)
			.contentType(ContentType.JSON)	
		.when()
			.post("http://localhost:8084/addProject");
		String projectId = response.jsonPath().get("projectId");
		String projectName = response.jsonPath().get("projectName");
		response.then()
			.assertThat().contentType(ContentType.JSON)
			.time(Matchers.lessThan(5000L), TimeUnit.MILLISECONDS)
			.and()
			.statusCode(201);
	
		//data base layer validation 
		
		Connection connection=null;
		String compare=null;
		try {
		Driver driverref= new Driver();
		DriverManager.registerDriver(driverref);
		connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/projects", "root", "root");

		Statement statement = connection.createStatement();
		ResultSet result = statement.executeQuery("select project_name from project where project_id = '"+projectId+"';");
	
		while(result.next()) {
			compare = result.getString(1);
		}	
		}
			catch(Exception e) {}
			finally {
				connection.close();
			}
		
		
		//GUI layer validation
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("http://localhost:8084/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.id("usernmae")).sendKeys("rmgyantra");
		driver.findElement(By.id("inputPassword")).sendKeys("rmgy@9999");
		driver.findElement(By.xpath("//button[@type=\"submit\"]")).click();
		driver.findElement(By.xpath("//a[contains(text(),\"Projects\")]")).click();
		Thread.sleep(3000);
		List<WebElement> text = driver.findElements(By.xpath("//table/tbody/tr[*]/td[2]/../td[2]"));
		int count = text.size();
		System.out.println(count);
		boolean projectNameFromRmgYantra=false;
		
		for (WebElement t : text) {
			String projNameFromRmgYantra = t.getText();
			if(projectName.equals(projNameFromRmgYantra)) {
				projectNameFromRmgYantra=true;
				break;
			}
		}
		
		Assert.assertEquals(projectName, compare);
		Assert.assertEquals(projectNameFromRmgYantra, true);
	
	}
}	
	