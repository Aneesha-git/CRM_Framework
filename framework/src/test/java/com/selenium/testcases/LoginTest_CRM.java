package com.selenium.testcases;


import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.selenium.pages.BaseClass;
import com.selenium.pages.HomePage;
import com.selenium.pages.LoginPage;



public class LoginTest_CRM extends BaseClass {
	
	@Test
	public void TestCase_loginToCRM_001() {
		logger=extent.createTest("Login To FreeCRM Appliaction");
		Reporter.log("Application loaded");
		String username=excel.getStringData(0, 0, 0);
		System.out.println(username);
		String pass=excel.getStringData(0, 0, 1);
		System.out.println(pass);
		Reporter.log("Excel dta loaded",true);
		HomePage homepage=PageFactory.initElements(driver, HomePage.class);
		LoginPage loginpage = PageFactory.initElements(driver, LoginPage.class);
		homepage.clickLogin();
		logger.createNode("Clicked on login");
		Reporter.log("Clicked on login on Home page");
		loginpage.login(username, pass);
		Reporter.log("Login Successful");
		logger.createNode("Login Successful");

	}

}
