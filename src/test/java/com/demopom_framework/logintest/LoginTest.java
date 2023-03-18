package com.demopom_framework.logintest;

import java.util.ArrayList;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.demopom_framework.base.ExcelReader;
import com.demopom_framework.pageobject.LoginPageObect;

public class LoginTest {

	static WebDriver driver = null;

	@Test(dataProvider = "testData")
	public void testLoginPage(Object username, Object password) {

		driver = new FirefoxDriver();
		driver.get("https://www.facebook.com/login/");

		LoginPageObect pageObject = new LoginPageObect(driver);

		pageObject.getUserName().sendKeys(username.toString());
		pageObject.getPassword().sendKeys(password.toString());
		pageObject.getLoginButton().click();
	}

	@DataProvider(name = "testData")
	public Object[][] getTestData() {

		ArrayList testData = ExcelReader.getTestData(
				"C:/Users/user/Desktop/Pankaj_Java_Testing/Manual_Testing/templates/pomlogintestdata.xlsx");

		Object[] array1D = testData.toArray();

//		Convertin from 1D array to 2D array:
		int numOfRows = testData.size() / 2;
		int numOfColumns = 2;
		int index = 0;

		Object[][] array2D = new Object[numOfRows][numOfColumns];
		for (int i = 0; i < numOfRows; i++) {
			for (int j = 0; j < numOfColumns; j++) {
				array2D[i][j] = array1D[index++];
			}
		}

		return array2D;
	}

}
