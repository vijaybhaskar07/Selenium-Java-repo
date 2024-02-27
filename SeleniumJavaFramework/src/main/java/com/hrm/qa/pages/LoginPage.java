package com.hrm.qa.pages;
import com.hrm.qa.pages.DashBoardPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.hrm.qa.base.TestBase;
import com.hrm.qa.extentReports.ExtentReport;

public class LoginPage extends TestBase {

	// Page Factory - OR:

	@FindBy(name = "username")
	WebElement userName;

	@FindBy(name = "password")
	WebElement password;

	@FindBy(xpath = "//button[text()= ' Login ']")
	WebElement loginBtn;

	@FindBy(xpath = "//h5[text()='Login']")
	WebElement loginPageName;

	@FindBy(xpath = "//p[text()= 'Invalid credentials']")
	WebElement loginErrorMessage;

	// Initializing the page objects
	public LoginPage() {

		PageFactory.initElements(driver, this);
	}

	// Actions:

	public String validateLoginPageTitle() {
		return driver.getTitle();
	}

	public boolean validateHRMLoginPageName() {
		return loginPageName.isDisplayed();

	}

	public DashBoardPage validateLogin(String un, String pwd) {
		userName.sendKeys(un);
		password.sendKeys(pwd);
		loginBtn.click();
		//ExtentReport.test.pass("Login button clicked successfully");
		ExtentReport.test.pass("Login button clicked successfully");
		return new DashBoardPage();

	}
	
	public DashBoardPage validateLoginData(String uname, String pwd) {
		userName.sendKeys(uname);
		password.sendKeys(pwd);
		loginBtn.click();	
		ExtentReport.test.pass("Welcome DashBoard Page");
		return new DashBoardPage();
		
	}

	public String validateLoginErrorMessage() {
		return loginErrorMessage.getText();

	}

}
