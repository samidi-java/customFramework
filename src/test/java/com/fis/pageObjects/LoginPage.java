package com.fis.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	WebDriver ldriver;
	
	public LoginPage(WebDriver rdriver)
	{
		this.ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	
	@FindBy(name="uid")
	WebElement userIdField;
	
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(name="btnLogin")
	WebElement loginButton;
	
	@FindBy(linkText = "Log out")
	WebElement loggoutButton;
	
	public void setUserId(String userId)
	{
		userIdField.sendKeys(userId);
	}
	
	
	public void setPassword(String password)
	{
		this.password.sendKeys(password);
	}
	
	
	public void clickLoginButton()
	{
		loginButton.click();
	}
	
	public void clickLogout()
	{
		loggoutButton.click();
	}
	
}
