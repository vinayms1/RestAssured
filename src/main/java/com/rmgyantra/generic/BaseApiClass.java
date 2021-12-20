package com.rmgyantra.generic;

import java.sql.SQLException;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import static io.restassured.RestAssured.*;

public class BaseApiClass {
	DataBaseUtility dobj=new DataBaseUtility();
	@BeforeSuite
	public void dataBaseConnection() {
		
		try {
			dobj.databaseConnection();
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		System.out.println("=============>DATA BASE CONNECTION IS ESTABLISHED<=================");
		baseURI="http://localhost";
		port=8084;
	
	}
	@AfterSuite
	public void dataBaseClose() {
		try {
			dobj.closeDataBase();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("=============>DATA BASE IS CLOSED<=================");
	}
	

}
