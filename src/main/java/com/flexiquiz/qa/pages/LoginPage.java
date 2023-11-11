package com.flexiquiz.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.flexiquiz.qa.base.TestBase;

public class LoginPage extends TestBase {
	
	@FindBy(id = "UserName")
	WebElement userNameTextBox;
	
	@FindBy(id = "Password")
	WebElement passwordTextBox;
	
	@FindBy(id = "loginNow")
	WebElement loginBtn;
	
	@FindBy(id = "loginNewAccount")
	WebElement signUpBtn;
	
	@FindBy(id = "RememberMe")
	WebElement rememberMeCheckBox;
	
	@FindBy(xpath = "//a[contains(text(),'Forgot password?')]")
	WebElement forgotPasswordLink;
	
	
	//Initializing the Page Object.
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	public boolean verifyRememberMeCheckBox() {
		rememberMeCheckBox.click();
		return rememberMeCheckBox.isSelected();
	}
	
	public String verifyLoginPageTitle() {
		return driver.getTitle();
	}
	
	public DashboardPage loginAction(String uname, String pass) {
		userNameTextBox.sendKeys(uname);
		passwordTextBox.sendKeys(pass);
		loginBtn.click();
		//Thread.sleep(2000);
		return new DashboardPage();
	}
	
}
