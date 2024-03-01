package com.hrm.qa.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.hrm.qa.base.TestBase;
import com.hrm.qa.pages.DashBoardPage;
import com.hrm.qa.pages.LeavePage;
import com.hrm.qa.pages.LoginPage;

public class DashBoardPageTest extends TestBase {

	LoginPage loginPage;
	DashBoardPage dashboardPage;
	LeavePage leavePage;

	public DashBoardPageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		initialization();
		loginPage = new LoginPage();
		dashboardPage = new DashBoardPage();
		loginPage.validateLogin(prop.getProperty("username"), prop.getProperty("password"));

	}

	@Test(priority =1)
	public void verifyDashboardPageTitleTest() {
		String dashboardTitle = driver.getTitle();
		Assert.assertEquals(dashboardTitle, "OrangeHRM", "DashboardTitle not matched");
	}

	@Test(priority =2)
	public void verifyDashboardLabelTest() {
		String dashboardLabel = dashboardPage.verifyDashboardLabel();
		Assert.assertEquals(dashboardLabel, "Dashboard");
	}
	
	@Test(priority =3)
	public void verifyAssignLeaveButtonTest() {
		leavePage = dashboardPage.clickAssignLeaveButton();	
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
