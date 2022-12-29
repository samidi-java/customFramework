package com.fis.testCases;

import java.io.IOException;

import org.openqa.selenium.NoAlertPresentException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.fis.pageObjects.LoginPage;
import com.fis.util.XLUtil;
public class TC_LoginDTT_002 extends BaseTest
{

	@Test(dataProvider="LoginData")
	public void loginDDT(String user,String pwd) throws InterruptedException, IOException
	{
		LoginPage lp=new LoginPage(driver);
		lp.setUserId(user);
		logger.info("user name provided");
		lp.setPassword(pwd);
		logger.info("password provided");
		lp.clickLoginButton();
		
		Thread.sleep(3000);
		
		if(isAlertPresent()==true)
		{
			driver.switchTo().alert().accept();//close alert
			driver.switchTo().defaultContent();
			captureScreenshot(driver, "loginDDT");
			Assert.assertTrue(false);
			logger.warn("Login Test is failed");
		}
		else
		{
			Assert.assertTrue(true);
			logger.info("Login Test passed");
			lp.clickLogout();
			Thread.sleep(3000);
			driver.switchTo().alert().accept();//close logout alert
			driver.switchTo().defaultContent();
			
		}
		
		
	}
	
	
	public boolean isAlertPresent() //user defined method created to check alert is presetn or not
	{
		try
		{
		driver.switchTo().alert();
		return true;
		}
		catch(NoAlertPresentException e)
		{
			return false;
		}
		
	}
	
	
	@DataProvider(name="LoginData")
	String [][] getData() throws IOException
	{
		String path=System.getProperty("user.dir")+"\\src\\test\\java\\com\\fis\\testData\\LoginData.xlsx";
		
		int rownum=XLUtil.getRowCount(path, "Sheet1");
		int cellCount=XLUtil.getCellCount(path,"Sheet1",1);
		
		String logindata[][]=new String[rownum][cellCount];
		
		for(int i=1;i<=rownum;i++)
		{
			for(int j=0;j<cellCount;j++)
			{
				logindata[i-1][j]=XLUtil.getCellData(path,"Sheet1", i,j);//1 0
			}
				
		}
	return logindata;
	}
	
}