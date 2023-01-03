package com.fis.testCases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.fis.pageObjects.AddNewCustomerPage;
import com.fis.pageObjects.LoginPage;

public class LoginTestCase extends BaseTest{
	String userName=configUtil.getUserName();
	String password=configUtil.getPassword();
	@Test
	public void testLoginPage()
	{
		logger.info("testLoginPage started" );
		//step3:call the action methods
		LoginPage loginPage=new LoginPage(driver);
		logger.info("Enter the userName:"+userName);
		loginPage.setUserId(userName);	
		logger.info("Enter the password:"+password);
		loginPage.setPassword(password);
		logger.info("Click on Login Button");
		loginPage.clickLoginButton();
		String expectedTitle="asasasass";
		String actualTitle=driver.getTitle();
		if(expectedTitle.equals(actualTitle))
		{
			logger.info("Test case is pass");
		}else
		{
			logger.info("Test case is failed");
			captureScreenshot(driver,"testLoginPage");
		}
		
		
		
		logger.info("testLoginPage is completed");
	}
	
	@Test
	public void testAddNewCustomer() throws InterruptedException
	{
		logger.info("testAddNewCustomer is started");
		
		//step3:call the action methods
		LoginPage loginPage=new LoginPage(driver);
		logger.info("Enter the userName:"+userName);
		loginPage.setUserId(userName);
		logger.info("Enter the password:"+password);
		loginPage.setPassword(password);
		logger.info("Click on Login Button");
		loginPage.clickLoginButton();
		
		Thread.sleep(5000);
		//step4:Add the logic for add new customer
		AddNewCustomerPage addNewCustomerPage=new AddNewCustomerPage(driver);
		addNewCustomerPage.clickNewCustomer();
		logger.info("Click on new Customer link");
		
		Thread.sleep(5000);
		logger.info("Enter the customer name");
		addNewCustomerPage.enterCustomerName("vishnu");
		logger.info("select the Gender");
		addNewCustomerPage.clickGender();
		logger.info("Enter Date of birth");
		addNewCustomerPage.enterDob("21-07-2010");
		logger.info("Enter Address");
		addNewCustomerPage.enterAddress("Bangalore");
		logger.info("Enter City");
		addNewCustomerPage.enterCity("Bangalore");
		logger.info("Enter State");
		addNewCustomerPage.enterState("Karnataka");
		logger.info("Enter Pin code");		
		addNewCustomerPage.enterPin("560067");
		logger.info("Enter Telphone number");
		addNewCustomerPage.enterTel("9986745720");
		logger.info("Enter email");
		addNewCustomerPage.enterEmail("samidid@gmail.com");
		logger.info("Click on submit button");
		addNewCustomerPage.clickSubmit();	
			
		logger.info("testAddNewCustomer test case is completed");
	}
	
	@Test
	public void testEditCustomer()
	{
		System.out.println("in testEditCustomer ");
	}

}
