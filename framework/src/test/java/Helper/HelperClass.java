package Helper;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class HelperClass {
	
	
	public static String captureScreenshot(WebDriver driver,String testName) {
		
		TakesScreenshot screenshot=(TakesScreenshot)driver;
		File from=screenshot.getScreenshotAs(OutputType.FILE);
		
		String destination=System.getProperty("user.dir")+"/Screenshots/"+testName+getCurrentDate()+".png";
		System.out.println(destination);
		try {
			FileHandler.copy(from, new File(destination));
		} catch (IOException e) {
			e.getMessage();
		}
		
		return destination;
		
	}
	
	public static String getCurrentDate() {
		Date date = new Date();
		SimpleDateFormat customFormat= new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
		return customFormat.format(date);
		
	}
	

}
