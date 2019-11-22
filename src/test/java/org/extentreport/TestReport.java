package org.extentreport;


import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;



public class TestReport {
	
	static ExtentTest test;
	static ExtentReports report;
	static WebDriver driver;
	@BeforeTest
	public static void startTest()
	{
		System.out.println(1);
	report = new ExtentReports("D:\\Automate tools\\Report\\ExtentReportResults.html");
	test = report.startTest("Selenium");
	}
	
	@Test
	public void extentReportsDemo() throws IOException, InterruptedException
	{
	System.setProperty("webdriver.chrome.driver", "D:\\Automate tools\\Training\\Testng\\Drivers\\chromedriver.exe");
	WebDriver driver = new ChromeDriver();
	driver.get("https://www.seleniumeasy.com/testng-tutorials/parameterization-in-testng");
	driver.manage().window().maximize();
    TakesScreenshot ts = (TakesScreenshot)driver;
    File source = ts.getScreenshotAs(OutputType.FILE);
    File destination = new File("D:\\Automate tools\\Report\\screenshot\\issuepass.png");
    FileUtils.copyFile(source,destination);
	String title = driver.getTitle();
	System.out.println(title);
	if(title.startsWith("Parameterization "))
	 
	{
	test.log(LogStatus.PASS, "Test passed");
	test.log(LogStatus.PASS,test.addScreenCapture("D:\\Automate tools\\Report\\screenshot\\issuepass.png"));
	System.out.println("2");
	}
	else
	{

	test.log(LogStatus.FAIL, "Test Failed");
	test.log(LogStatus.FAIL,test.addScreenCapture("D:\\Automate tools\\Report\\screenshot\\issuetest.png"));
	System.out.println("3");
	}
	Thread.sleep(5000);
	}
	
	@AfterTest
	public static void endTest()
	{
	test.log(LogStatus.PASS,"Quit");
	report.endTest(test);
	report.flush();	
	
	}
	}
	



