package com.selenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		this.driver=driver;
	}

	
	
	@FindBy(how = How.NAME, using = "emailHH")
	WebElement userName;

	@FindBy(how = How.NAME, using = "password")
	WebElement password;
	
	@FindBy(xpath="//div[@class='ui fluid large blue submit button']")
	WebElement logintoCRMButton;
	
	public void login(String luserName,String lpassword) {
	
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
	
			e.printStackTrace();
		}
		
		userName.sendKeys(luserName);
		password.sendKeys(lpassword);
		logintoCRMButton.click();
	}
}
