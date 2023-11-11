package com.flexiquiz.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.flexiquiz.qa.base.TestBase;
import com.flexiquiz.qa.pages.DashboardPage;
import com.flexiquiz.qa.pages.HomePage;
import com.flexiquiz.qa.pages.LoginPage;

public class LoginPageTestCases extends TestBase {
	
	LoginPage loginPage;
	HomePage homePage;
	DashboardPage dashboardPage;
	
	public LoginPageTestCases() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initialization();
		homePage = new HomePage();
		dashboardPage = new DashboardPage();
		loginPage = homePage.moveToLoginPage();
	}
	
	@Test
	public void rememberMeCheckBoxTest()  {
		Assert.assertTrue(loginPage.verifyRememberMeCheckBox(), "Cannot select Remember Me check box.");
	}
	
	@Test
	public void loginPageTest() {
		dashboardPage = loginPage.loginAction(prop.getProperty("username"), prop.getProperty("password"));
		String dashTitle = dashboardPage.verifyDashboardPageTitle();
		dashboardPage.logOutBtn.click();
		Assert.assertEquals(dashTitle, "FlexiQuiz - Dashboard");
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
