package com.hrm.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.hrm.qa.base.TestBase;

public class DashBoardPage extends TestBase {

	// PageFactory - OR
	@FindBy(xpath = "//h6[text()='Dashboard']")
	WebElement dashboardLabelName;

	@FindBy(xpath = "//button[@title='Assign Leave']")
	WebElement assignLeaveBtn;

	// Initializing the page objects
	public DashBoardPage() {
		PageFactory.initElements(driver, this);
	}

	// Actions
	public String verifyDashboardPageTitle() {
		return driver.getTitle();
	}

	public String verifyDashboardLabel() {
		return dashboardLabelName.getText();
	}

	public LeavePage clickAssignLeaveButton() {
		assignLeaveBtn.click();
		return new LeavePage();
	}
}
