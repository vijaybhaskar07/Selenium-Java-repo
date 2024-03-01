package com.hrm.qa.tests;

import org.openxml4j.exceptions.InvalidFormatException;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.hrm.qa.base.TestBase;
import com.hrm.qa.extentReports.ExtentReport;
import com.hrm.qa.pages.DashBoardPage;
import com.hrm.qa.pages.LoginPage;
import com.hrm.qa.util.TestUtil;

@Listeners(com.qa.ExtentReportListener.MyTestListener.class) 
public class LoginPageTest extends TestBase {

	LoginPage loginPage;
	DashBoardPage dashboardPage;


	public LoginPageTest() {
		super();
	}
   
	
	@BeforeMethod	
	public void setUp() {
		initialization();	
		loginPage = new LoginPage();
		dashboardPage = new DashBoardPage();
	}

	
	@Test(priority = 1)
	public void loginPageTitleTest() {
		String title = loginPage.validateLoginPageTitle();
		Assert.assertEquals(title, "OrangeHRM");
	}

	@Test(priority = 2)
	public void loginpageNameTest() {
		boolean flag = loginPage.validateHRMLoginPageName();
		Assert.assertTrue(flag);
	}

	@Test(priority = 3)
	public void loginTest() {
		ExtentReport.createTest("loginTest");
		dashboardPage = loginPage.validateLogin(prop.getProperty("username"), prop.getProperty("password"));

	}

	@DataProvider
	public Object[][] getLoginData() throws InvalidFormatException {
		Object data[][] = TestUtil.getTestData("login");
		return data;
	}
	
	

	@Test(priority =4, dataProvider = "getLoginData")
	public void loginTestDataProvider(String username, String password) {
		dashboardPage = loginPage.validateLoginData(username, password);

	}

	@Test(priority = 5)
	public void loginErrorMessageTest() {
		loginPage.validateLogin(prop.getProperty("username"), prop.getProperty("pwd"));
		String actualErrorMessage = loginPage.validateLoginErrorMessage();
		Assert.assertEquals(actualErrorMessage, "Invalid credentials");
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();

	}

}
