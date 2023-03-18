package com.demopom_framework.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

// Locates the fields of login page:
public class LoginPageObect {
	
	private WebDriver driver;

	public LoginPageObect(WebDriver driver) {
		this.driver = driver;
	}
	
	By username = By.xpath("//*[@id='email']");
	By password = By.xpath("//*[@id='pass']");
	By loginButton = By.xpath("//*[@id='loginbutton']");
	
	public WebElement getUserName() {
		return driver.findElement(username);
	}
	
	public WebElement getPassword() {
		return driver.findElement(password);
	}
	
	public WebElement getLoginButton() {
		return driver.findElement(loginButton);
	}
	
	
}
