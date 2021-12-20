package com.rmgyantra.generic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.cj.jdbc.Driver;
/**
 * this class gives the methods of database
 * @author Vinay
 *
 */
public class DataBaseUtility {
	Connection connection = null;


	/**
	 * this method gives the data base connection
	 * @throws Throwable
	 */
	public void databaseConnection() throws Throwable {
		Driver driverReff = new Driver();
		DriverManager.registerDriver(driverReff);
		connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/projects", "root", "root");
	}
	/**
	 * this method gives the close the data base connection
	 * @throws SQLException
	 */
	public void closeDataBase() throws SQLException {
		connection.close();
	}
	/**
	 * 
	 * @param querry
	 * @return
	 * @throws SQLException
	 */
	public ResultSet getAllTheData(String querry) throws SQLException {
		ResultSet result = connection.createStatement().executeQuery(querry);
		return result;
	}
	/**
	 * this method is verifies the actual and expected data
	 * @param querry
	 * @param expectedData
	 * @param columnNmae
	 * @return
	 * @throws Throwable
	 */
	public String getTheDataAndVerifyTheData(String querry,String expectedData, int columnNumber) throws Throwable   {
		Driver driverReff = new Driver();
		
		DriverManager.registerDriver(driverReff);
		Connection connection1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/projects", "root", "root");
		ResultSet result = connection1.createStatement().executeQuery(querry);
		boolean flag=false; 
		String actualData=null;
		try {	
			while(result.next()) {

				if(result.getString(columnNumber).equals(expectedData)) {
					actualData=result.getString(columnNumber);
					flag=true;
					break;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if(flag) {
			System.out.println("Data is verified and matching the data");
			return actualData;
		}
		else {
			System.out.println("Data is not verified and not matching the data");
			return actualData;
		}

	}
}

