package org.extentreport;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Screenshot {
	static WebDriver driver;
	public static void main(String[] args) throws IOException {
		System.setProperty("webdriver.chrome.driver", "D:\\Automate tools\\Training\\Testng\\Drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://kedge.srinsofttech.com/#/kn-pages/auth/login");
		driver.manage().window().maximize();
        TakesScreenshot ts = (TakesScreenshot)driver;
        File source = ts.getScreenshotAs(OutputType.FILE);
        File destination = new File("D:\\Automate tools\\Report\\screenshot\\issuetest.png");
        FileUtils.copyFile(source,destination);
     
}
}