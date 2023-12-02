package com.flexiquiz.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.flexiquiz.qa.base.TestBase;
import com.flexiquiz.qa.pages.HomePage;
import com.flexiquiz.qa.pages.LoginPage;


public class HomePageTestCases extends TestBase {
	
	HomePage homePage;
	LoginPage loginPage;
	
	public HomePageTestCases() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initialization();
		homePage = new HomePage();
	}
	
	@Test
	public void verifyHomePageTitleTest() {
		String title = homePage.verifyHomePageTitle();
		Assert.assertEquals(title, "Free Test Generator - easily create an online quiz");
	}
	
	@Test
	public void flexiLogoImageTest() {
		boolean logo = homePage.verifyFlexiLogoImage();
		Assert.assertTrue(logo);
	}
	
	@Test
	public void navigateToLoginPageTest() {
		loginPage = homePage.moveToLoginPage();
		String loginPageTitle = loginPage.verifyLoginPageTitle();
		Assert.assertEquals(loginPageTitle, "Login - FlexiQuiz");
	}
	
	@Test
	public void verifySignUpPageTitleTest() {
		String title = homePage.verifySignUpPageTitle();
		Assert.assertEquals(title, "Sign Up");
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
}
