package com.hrm.qa.util;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverListener;

//WebDriver Listeners
public class MyListener implements WebDriverListener {

	public void beforeNavigateTo(String url, WebDriver driver) {
		System.out.println("Before navigating to: '" + url + "'");

	}
	
	public void afterNavigateTo(String url, WebDriver driver) {
		System.out.println("Navigated to: '" + url + "'");

	}

	public void beforeClickOn(WebElement element, WebDriver driver) {
		System.out.println("Trying to click on: " + element.toString());
	}

	public void afterClickOn(WebElement element, WebDriver driver) {
		System.out.println("Clicked on: " + element.toString());
	}

	public void beforeNavigateBack(WebDriver driver) {
		System.out.println("Navigating back to previous page");
	}

	public void afterNavigateBack(WebDriver driver) {
		System.out.println("Navigated back to previous page");
	}

	public void beforeNavigateForward(WebDriver driver) {
		System.out.println("Navigating forward to next page");
	}

	public void afterNavigateForward(WebDriver driver) {
		System.out.println("Navigated forward to next page");
	}

	public void afterNavigateRefresh(WebDriver arg0) {

	}

	public void afterChangeValueOf(WebElement element, WebDriver driver) {
		System.out.println("Element Value changed to: " + element.toString());
	}

	public void beforeChangeValueOf(WebElement element, WebDriver driver) {
		System.out.println("Value of the: " + element.toString() + " before any changes made");
	}

	public void beforeFindBy(By by, WebElement element, WebDriver driver) {
		System.out.println("Trying to find Element By : " + by.toString());
	}

	public void afterFindBy(By by, WebElement element, WebDriver driver) {
		System.out.println("Found Element By : " + by.toString());
	}

	public void beforeNavigateRefresh(WebDriver driver) {

	}

	public void onException(Throwable error, WebDriver driver) {
		System.out.println("Exception occured:" + error);
		try {
			TestUtil.takeScreenshotAtEndOfTest();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	
	  public void afterAlertAccept(WebDriver driver) {
		  System.out.println("After Alert Accept "+driver.toString() );
	  }
	  
	  public void beforeAlertAccept(WebDriver driver) {
		  System.out.println("Before Alert Accept");
	  }
	  
	  public void beforeAlertDismiss(WebDriver driver) {
		  System.out.println("Before Alert Dismiss");
	  }
	  
	  public void afterAlertDismiss(WebDriver driver) {
		  System.out.println("After Alert Dismiss "+ driver);
	  }
	  
	  public void beforeScript(String arg0, WebDriver arg1) {
		  System.out.println("Before Script");
	  }
	  
	  public void afterScript(String arg0, WebDriver arg1) {
		  System.out.println("After Script");
	  }
	 

}