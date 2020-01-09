package com.selenium.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigDataProvider {
	
	Properties pro;


	public ConfigDataProvider() {
		File src = new File("./Config/config.properties");
		try {
			 FileInputStream fis = new FileInputStream(src);
			 pro = new Properties();
			pro.load(fis);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.getMessage();
		}

	}
	
	public String getBrowser() {
		System.out.println(pro.getProperty("Browser"));
		
		return pro.getProperty("Browser");
		
	}
public String getUrl() {
		
		return pro.getProperty("URL");
		
		
		}
public String getConfigData(String key) {
	
	return pro.getProperty(key);
	
		
	}

}
