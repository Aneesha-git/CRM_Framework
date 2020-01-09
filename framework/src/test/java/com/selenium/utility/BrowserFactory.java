package com.selenium.utility;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserFactory {
	
	public static WebDriver startApplication(String browserName,String url,WebDriver driver){
		
		if(browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir" )+"/Drivers/chromedriver.exe");
			driver=new ChromeDriver();
		}
		else if(browserName.equals("firefox")) {
			System.setProperty("webdrivr.chrome.driver",System.getProperty("user.dir" )+"/Drivers/geckodriver.exe");
			driver=new FirefoxDriver();
		}
		else {
			System.out.println("browser not supported");
		}
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(url);
		return driver;
		
		
		
		
		
	}
	
	public static void quitBrowser(WebDriver driver) {
		driver.quit();
	}
	

}
