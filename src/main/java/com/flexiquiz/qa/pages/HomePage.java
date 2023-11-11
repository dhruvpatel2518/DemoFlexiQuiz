package com.flexiquiz.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.flexiquiz.qa.base.TestBase;

public class HomePage extends TestBase {
	//Page Factory or Object Repository
	
	@FindBy(id="fq-main-menu-auth")
	WebElement loginBtn;
	
	@FindBy(id="fq-main-menu-access")
	WebElement signupBtn;
	
	@FindBy(id="fq-main-menu-logo")
	WebElement flexiLogo;
	
	//Initializing the Page Object.
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	//Actions:
	public String verifyHomePageTitle() {
		return driver.getTitle();
	}
	
	public boolean verifyFlexiLogoImage() {
		return flexiLogo.isDisplayed();
	}
	
	public LoginPage moveToLoginPage() {
		loginBtn.click();
		return new LoginPage();
	}
}
