package com.hrm.qa.tests;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class DockerWithChrome {
	
	//@Test
	public void testDockerChrome( )throws MalformedURLException {
	
		ChromeOptions options = new ChromeOptions();
		URL url = new URL("http://192.168.0.108:4444/wd/hub");
		RemoteWebDriver driver = new RemoteWebDriver(url, options);
		driver.navigate().to("https://opensource-demo.orangehrmlive.com/");
		System.out.println(driver.getTitle());       
        driver.close();
	}
	
	@Test
	public void testDockerFirefox( )throws MalformedURLException {
		
		FirefoxOptions options = new FirefoxOptions();
		URL url = new URL("http://192.168.0.108:4444/wd/hub");
		RemoteWebDriver driver = new RemoteWebDriver(url, options);
		driver.navigate().to("https://opensource-demo.orangehrmlive.com/");
		System.out.println(driver.getTitle());       
        driver.close();
	}

}
