package com.selenium.pages;

import java.io.IOException;

import javax.swing.text.html.HTMLDocument.HTMLReader;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.MediaEntityModelProvider;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.selenium.utility.BrowserFactory;
import com.selenium.utility.ConfigDataProvider;
import com.selenium.utility.ExcelDataProvider;

import Helper.HelperClass;

public class BaseClass {
	public WebDriver driver;
	public ExcelDataProvider excel;
	public ConfigDataProvider config;
	public ExtentTest logger;
	public ExtentHtmlReporter reporter;
	public ExtentReports extent ;

	@BeforeSuite
	public void setupSuite() {
		//excel objest created
		excel = new ExcelDataProvider();
		config = new ConfigDataProvider();

		reporter = new ExtentHtmlReporter(System.getProperty("user.dir")+ "/Reports/FreeCRMReport.html");
		//htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") + "/test-output/ExtentReport.html");
		 extent = new ExtentReports();
		extent.attachReporter(reporter);

	}
	@Parameters({"browser","url"})
	@BeforeClass
	public void setUp(String browser,String url) {
		//driver = BrowserFactory.startApplication(config.getBrowser(), config.getUrl(), driver);
		driver = BrowserFactory.startApplication(browser, url, driver);
		System.out.println(driver.getTitle());

	}

	@AfterMethod
	public void tearDownMethod(ITestResult result) throws Exception {
		if (result.getStatus() == ITestResult.FAILURE) {

			logger.log(Status.FAIL, MarkupHelper.createLabel(result.getName() + " Testcase failed", ExtentColor.RED));
			try {
				
				logger.fail(result.getThrowable().getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(HelperClass.captureScreenshot(driver, result.getName())).build());
			} catch (Exception e) {
				e.getMessage();
			}
		} else if (result.getStatus() == ITestResult.SUCCESS) {			
			String scpath=HelperClass.captureScreenshot(driver, result.getName());
			System.out.println(scpath);
			logger.log(Status.PASS, MarkupHelper.createLabel(result.getName() + "Test case passed", ExtentColor.GREEN));
			logger.pass("test passed", MediaEntityBuilder.createScreenCaptureFromPath(scpath).build());
		//	logger.fail(result.getThrowable().getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
		}
		extent.flush();
		Reporter.log("Test Generated>>>Report Generated");
		
	}

	@AfterClass
	public void tearDown() {
		BrowserFactory.quitBrowser(driver);

	}
}
