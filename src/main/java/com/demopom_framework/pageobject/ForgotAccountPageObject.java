package com.demopom_framework.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

// Locates the fields of login page:
public class ForgotAccountPageObject {
	
	private WebDriver driver;

	public ForgotAccountPageObject(WebDriver driver) {
		this.driver = driver;
	}
	
	By username = By.xpath("//*[@id='identify_email']");
	
	public WebElement getIdentifyUserName() {
		return driver.findElement(username);
	}
	
}
