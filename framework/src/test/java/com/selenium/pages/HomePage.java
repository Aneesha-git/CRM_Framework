package com.selenium.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage {

	@FindBy(xpath ="//span[contains(text(),'Log In')]")
	WebElement loginButton;
	
	public void clickLogin() {
		loginButton.click();
	}
}
