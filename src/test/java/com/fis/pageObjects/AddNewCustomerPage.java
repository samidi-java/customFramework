package com.fis.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddNewCustomerPage {
	
	WebDriver ldriver;
	
	public AddNewCustomerPage(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(linkText = "New Customer")
	WebElement newCustomerLink;
	
	@FindBy(name = "name")
	WebElement customerNameField;
	
	@FindBy(name = "rad1")
	WebElement gender;
	
	
	@FindBy(name = "dob")
	WebElement dob;
	

	@FindBy(name = "addr")
	WebElement address;
	
	
	@FindBy(name = "city")
	WebElement city;
	
	@FindBy(name = "state")
	WebElement state;
	
	@FindBy(name = "pinno")
	WebElement pin;
	
	@FindBy(name = "telephoneno")
	WebElement tel;
	
	@FindBy(name = "emailid")
	WebElement email;
	
	@FindBy(name = "sub")
	WebElement submit;
	
	
	
	public void clickNewCustomer()
	{
		newCustomerLink.click();
	}
	
	
	public void enterCustomerName(String customerName)
	{
		customerNameField.sendKeys(customerName);
	}
	
	public void enterDob(String dob)
	{
		this.dob.sendKeys(dob);
	}
	
	
	public void enterAddress(String address)
	{
		this.address.sendKeys(address);
		
	}
	
	public void clickGender()
	{
		gender.click();
	}
	
	public void enterCity(String city)
	{
		this.city.sendKeys(city);
		
	}
	
	public void enterState(String state)
	{
		this.state.sendKeys(state);
		
	}
	
	
	public void enterPin(String pin)
	{
		this.pin.sendKeys(pin);
		
	}
	
	public void enterTel(String tel)
	{
		this.tel.sendKeys(tel);
		
	}
	
	public void enterEmail(String email)
	{
		this.email.sendKeys(email);
		
	}
	
	public void clickSubmit()
	{
		submit.click();
	}
	
	
}
