package com.demopom_framework.logintest;

import java.util.ArrayList;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.demopom_framework.base.ExcelReader;
import com.demopom_framework.pageobject.ForgotAccountPageObject;
import com.demopom_framework.pageobject.LoginPageObect;

public class ForgotAccountTest {

	static WebDriver driver = null;

	@Test(dataProvider = "testData")
	public void testForgotAccountPage(Object username) {

		driver = new FirefoxDriver();
		driver.get("https://www.facebook.com/login/identify/");

		ForgotAccountPageObject forgotPageObject = new ForgotAccountPageObject(driver);

		forgotPageObject.getIdentifyUserName().sendKeys(username.toString());
	}

	@DataProvider(name = "testData")
	public Object[][] getTestData() {

		ArrayList testData = ExcelReader.getTestData(
				"C:/Users/user/Desktop/Pankaj_Java_Testing/Manual_Testing/templates/pomforgotaccounttestdata.xlsx");

		Object[] array1D = testData.toArray();

//		Convertin from 1D array to 2D array:
		int numOfRows = testData.size();
		int numOfColumns = 1;
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
