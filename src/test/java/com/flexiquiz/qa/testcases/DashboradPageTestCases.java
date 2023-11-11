package com.flexiquiz.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.flexiquiz.qa.base.TestBase;
import com.flexiquiz.qa.pages.DashboardPage;
import com.flexiquiz.qa.pages.HomePage;
import com.flexiquiz.qa.pages.LoginPage;
import com.flexiquiz.qa.testdata.TestData;

public class DashboradPageTestCases extends TestBase {
	
	DashboardPage dashBoardPage;
	LoginPage loginPage;
	HomePage homePage;
	
	//String sheetName = "name_of_excelsheet";
	
	public DashboradPageTestCases() {
		super();
	}
	
	//Before Method
	@BeforeMethod
	public void setUp() {
		
		initialization();
		dashBoardPage = new DashboardPage();
		homePage = new HomePage();
		loginPage = homePage.moveToLoginPage();
		loginPage.loginAction(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@Test
	public void createNewQuizNameTest() {
		String quizTitle = dashBoardPage.createNewQuizName("TestCase 1");
		Assert.assertEquals(quizTitle, dashBoardPage.newQuizTitleText.getText());
	}
	
	@Test(dataProvider = "getSingleChoiceRadioData", dataProviderClass = TestData.class)
	public void addItemNewQuestionForSingleChoiceRadioWithFourOptTestCase(String quizName,String quizType, String newQuestion, String firstOption, String secondOption, String thirdOption, String forthOption, int correctNo) {
		dashBoardPage.addItemNewQuestionForSingleChoiceRadioOrDropdownWithFourOpt(quizName, quizType, newQuestion, firstOption, secondOption, thirdOption, forthOption, correctNo);
	}
	
	@Test(dataProvider = "getSingleChoiceDropdownWithFourOptnData", dataProviderClass = TestData.class)
	public void addItemNewQuestionForSingleChoiceDropdownWithFourOptTestCase(String quizName, String quizType, String newQuestion, String firstOption, String secondOption, String thirdOption, String forthOption, int correctNo) {
		dashBoardPage.addItemNewQuestionForSingleChoiceRadioOrDropdownWithFourOpt(quizName, quizType, newQuestion, firstOption, secondOption, thirdOption, forthOption, correctNo);
	}
	
	@Test(dataProvider = "getSingleChoiceDropdownWithTwoOptnData", dataProviderClass = TestData.class)
	public void addItemNewQuestionForSingleChoiceDropdownWithTwoOptTestCase(String quizName, String newQuestion, String firstOption, String secondOption, int correctNo) {
		dashBoardPage.addItemNewQuestionForSingleChoiceDropdownWithTwoOption(quizName, newQuestion, firstOption, secondOption, correctNo);
	}
	
	@Test(dataProvider = "getMultipleChoiceWithFourOptnData", dataProviderClass = TestData.class)
	public void multipleChoiceWithFourOptnTestCase(String quizName, String newQuestion, String firstOption, String secondOption, String thirdOption, String fourthOption, int correctAns1, int correctAns2) {
		dashBoardPage.multipleChoiceWithFourOptn(quizName, newQuestion, firstOption, secondOption, thirdOption, fourthOption, correctAns1, correctAns2);
	}
	
	@Test(dataProvider = "getFillInTheBlanksData", dataProviderClass = TestData.class)
	public void fillInTheBlanksQuizTestCase(String quizName, String newQuestion, String firstAns, String secondAns) {
		dashBoardPage.fillInTheBlanksQuiz(quizName, newQuestion, firstAns, secondAns);
	}
	
	//After Method
	@AfterMethod
	public void tearDown() throws InterruptedException {
		Thread.sleep(3000);
		//dashBoardPage.logOutBtn.click();
		driver.quit();
	}
}
