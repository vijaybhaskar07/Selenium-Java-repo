package com.hrm.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.hrm.qa.extentReports.ExtentReport;
import com.hrm.qa.util.TestUtil;

public class TestBase {

	public static WebDriver driver;
	public static Properties prop;
	

	public TestBase()
	{
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream("./src/main/java/com/hrm/qa/config/config.properties");
			prop.load(ip);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static void initialization() {

		String browserName = prop.getProperty("browser");
		if (browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
			driver = new ChromeDriver();

		}
		 /*else {
			if (browserName.equals("edge")) {
				System.setProperty("webdriver.edge.driver", "./Drivers/msedgedriver.exe");
				driver = new EdgeDriver();
			}
		*/
		
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(TestUtil.PAGE_LOAD_TIMEOUT));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(TestUtil.IMPLICIT_WAIT));
		driver.get(prop.getProperty("url"));

	}
	
//	@BeforeSuite
//	public static void beforeSuite() {
//		ExtentReport.initReports();
//	}
//	
//	@AfterSuite
//	public static void afterSuite() throws IOException {
//		ExtentReport.flushReports();
//	}

//}
}
