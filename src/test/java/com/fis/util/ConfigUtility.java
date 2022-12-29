package com.fis.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigUtility {
 Properties props;

public ConfigUtility()
{
	try
	{
	File file=new File("F:\\selenium\\batch9\\selenium\\Framework\\customFramework\\src\\test\\java\\com\\fis\\config\\config.properties");
    FileInputStream fis=new FileInputStream(file);
    props=new Properties();
    props.load(fis);
    
	}catch(IOException e)
	{
		System.out.println(e.getMessage());
	}

}

public  String getUrl()
{
	return props.getProperty("url");
}

public String getUserName()
{
	return props.getProperty("userName");
}

public String getPassword()
{
	return props.getProperty("password");
}

public String getLog4jLocation()
{
	return props.getProperty("log4j_properties");
}

public String getEdgeDriverPath()
{
	return props.getProperty("edge_driver_location");
}

}
