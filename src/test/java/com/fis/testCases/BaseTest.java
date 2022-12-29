package com.fis.testCases;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.fis.util.ConfigUtility;

public class BaseTest {
	WebDriver driver=null;
	public static final Logger logger=Logger.getLogger("Guru99 Banking Application");
	public ConfigUtility configUtil=new ConfigUtility();
	@BeforeMethod
	public void init()
	{
		
		PropertyConfigurator.configure(configUtil.getLog4jLocation());
		//step1:set System property for Driver class
		System.setProperty("webdriver.edge.driver", configUtil.getEdgeDriverPath());
		driver=new EdgeDriver();

		//step2:open the given url
		driver.get(configUtil.getUrl());		
		logger.info("open the given url:"+configUtil.getUrl());

	}
	
	
	@AfterMethod
	public void destroy()
	{
		//step4:close the browser
		driver.quit();
		logger.info("Closing the browser");
	}
	
	
	public static void captureScreenshot(WebDriver driver,String tname)
	{
		try
		{
		TakesScreenshot ts=(TakesScreenshot)driver;
		File source=ts.getScreenshotAs(OutputType.FILE);
		File destination=new File(System.getProperty("user.dir")+"/screenshots/"+tname+".png");
		FileUtils.copyFile(source, destination);
		}catch(IOException e)
		{
			System.out.println(e.getMessage());
		}
		
	}
}
