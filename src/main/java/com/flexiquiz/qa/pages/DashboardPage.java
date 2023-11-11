package com.flexiquiz.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.flexiquiz.qa.base.TestBase;
import com.flexiquiz.qa.util.TestUtil;

public class DashboardPage extends TestBase {
	
	//Main page create quiz button
	@FindBy(xpath = "//button[contains(text(),'Create Quiz')]")
	WebElement createQuizBtn;
	
	@FindBy(xpath = "//span[contains(text(),'Logout')]")
	public WebElement logOutBtn;
	
	
	//First dialogbox Classic quiz button
	@FindBy(xpath = "//btn[contains(text(),'Classic Quiz')]")
	WebElement createClassicQuizBtn;
	
	//New title creating textbox and button and text.
	@FindBy(id = "dialogSurveyName")
	WebElement createNewQuizTitleTextBox;
	
	@FindBy(id = "renameSurveySaveButton")
	WebElement createNewQuizTitleBtn;
	
	@FindBy(id = "surveyMenuDetailsSurveyName")
	public WebElement newQuizTitleText;
	
	
	//Add items dropdown button and then selecting quiz.
	@FindBy(xpath = "//*[@id='addItemBelow']/button")
	WebElement addItemDropdownBtn;
	
	@FindBy(xpath = "//div[@id='addItemBelow']//li[1]//a[1]")
	WebElement newQuestionDropdown;
	
	
	//button to click to select question type from dropdown
	@FindBy(xpath = "//button[@class='btn btn-default dropdown-toggle']")
	WebElement newQuestionTypeDropdownBtn;
	
	
	//different question type to select
	@FindBy(id = "dialogQuestionRadioButton")
	public WebElement questionTypresingleChoiceRadioButton;
	
	@FindBy(id = "dialogQuestionDropdownlist")
	public WebElement questionTypresingleChoiceDropdown;
	
	@FindBy(id = "dialogQuestionCheckbox")
	public WebElement questionTypreMultiChoice;
	
	@FindBy(id = "dialogQuestionFillInTheBlanks")
	public WebElement questionTypreFillInTheBlanks;
	
	
	//switch to a frame for entering your question
	@FindBy(css = "#cke_1_contents>iframe")
	WebElement frameSwitch;
	@FindBy(xpath = "//div[@id='cke_dialogQuestionText']/div/div/iframe")
	WebElement frameSwitchForFillIntheBlanks;
	
	@FindBy(xpath = "/html/body")
	WebElement newQuestionRichTextBox;
	@FindBy(xpath = "/html/body/p")
	WebElement newFillIntheBlanksRichTextBox;
	
	
	//entering options for answer.
	@FindBy(id = "dialogOptionText_0")
	public WebElement firstOptionTextBox;
	
	@FindBy(id = "dialogOptionText_1")
	public WebElement secondOptionTextBox;
	
	@FindBy(id = "addDialogOptionButton")
	public WebElement addOptionBtn;
	
	@FindBy(id = "dialogOptionText_2")
	public WebElement thirdOptionTextBox;
	
	@FindBy(id = "dialogOptionText_3")
	public WebElement fourthOptionTextBox;
	
	
	//save buttons to save your quiz
	@FindBy(id = "questionDialogSaveButton")
	public WebElement saveQuestionBtn;
	
	@FindBy(id = "questionDialogSaveAndAddAnotherButton")
	public WebElement saveAndAddAnotherQuestionBtn;
	
	
	//Initializing the Page Object.
	public DashboardPage() {
		PageFactory.initElements(driver, this);
	}
	
	public String verifyDashboardPageTitle() {
		return driver.getTitle();
	}
	
	public String createNewQuizName(String quizTitle) {
		createQuizBtn.click();
		TestUtil.waitUntilElementVissible(createClassicQuizBtn);
		createClassicQuizBtn.click();
		TestUtil.waitUntilElementVissible(createNewQuizTitleTextBox);
		createNewQuizTitleTextBox.sendKeys(quizTitle);
		createNewQuizTitleBtn.click();
		
		return newQuizTitleText.getText();
	}
	
	public void addItemNewQuestionForSingleChoiceRadioOrDropdownWithFourOpt(String quizName, String quizType, String newQuestion, String firstOption, String secondOption, String thirdOption, String fourthOption, int correctNo) {
		driver.findElement(By.xpath("//a[contains(text(),'" + quizName + "')]")).click();
		addItemDropdownBtn.click();
		TestUtil.waitUntilElementVissible(newQuestionDropdown);
		newQuestionDropdown.click();
		TestUtil.waitUntilElementVissible(newQuestionTypeDropdownBtn);
		newQuestionTypeDropdownBtn.click();
		
		//Question Type and switch to another frame to type question and switch back
		if(quizType.equalsIgnoreCase(quizType)) {
			TestUtil.waitUntilElementVissible(questionTypresingleChoiceRadioButton);
			questionTypresingleChoiceRadioButton.click();
		} else if(quizType.equalsIgnoreCase(quizType)) {
			TestUtil.waitUntilElementVissible(questionTypresingleChoiceDropdown);
			questionTypresingleChoiceDropdown.click();
		}
		TestUtil.switchToFrame(frameSwitch);
		newQuestionRichTextBox.sendKeys(newQuestion);
		driver.switchTo().parentFrame();
		
		//Adding Options for Answer.
		firstOptionTextBox.sendKeys(firstOption);
		secondOptionTextBox.sendKeys(secondOption);
		addOptionBtn.click();
		thirdOptionTextBox.sendKeys(thirdOption);
		addOptionBtn.click();
		fourthOptionTextBox.sendKeys(fourthOption);
		
		//Selecting Correct Answer.
		driver.findElement(By.id("dialogOptionPoints_" + correctNo)).click();
		
		//saveQuestionBtn.click();
	}
	
	public void addItemNewQuestionForSingleChoiceDropdownWithTwoOption(String quizName, String newQuestion, String firstOption, String secondOption, int correctNo) {
		driver.findElement(By.xpath("//a[contains(text(),'" + quizName + "')]")).click();
		addItemDropdownBtn.click();
		TestUtil.waitUntilElementVissible(newQuestionDropdown);
		newQuestionDropdown.click();
		TestUtil.waitUntilElementVissible(newQuestionTypeDropdownBtn);
		newQuestionTypeDropdownBtn.click();
		
		//Question Type and switch to another frame to type question and switch back
		TestUtil.waitUntilElementVissible(questionTypresingleChoiceRadioButton);
		questionTypresingleChoiceRadioButton.click();
		TestUtil.switchToFrame(frameSwitch);
		newQuestionRichTextBox.sendKeys(newQuestion);
		driver.switchTo().parentFrame();
		
		//Adding Options for Answer.
		firstOptionTextBox.sendKeys(firstOption);
		secondOptionTextBox.sendKeys(secondOption);
		
		//Selecting Correct Answer.
		driver.findElement(By.id("dialogOptionPoints_" + correctNo)).click();
		
		//saveQuestionBtn.click();
	}
	
	public void multipleChoiceWithFourOptn(String quizName, String newQuestion, String firstOption, String secondOption, String thirdOption, String fourthOption, int correctAns1, int correctAns2) {
		driver.findElement(By.xpath("//a[contains(text(),'" + quizName + "')]")).click();
		addItemDropdownBtn.click();
		TestUtil.waitUntilElementVissible(newQuestionDropdown);
		newQuestionDropdown.click();
		TestUtil.waitUntilElementVissible(newQuestionTypeDropdownBtn);
		newQuestionTypeDropdownBtn.click();
		
		//Question Type and switch to another frame to type question and switch back.
		TestUtil.waitUntilElementVissible(questionTypreMultiChoice);
		questionTypreMultiChoice.click();
		TestUtil.switchToFrame(frameSwitch);
		newQuestionRichTextBox.sendKeys(newQuestion);
		driver.switchTo().parentFrame();
		
		//Adding Options for Answer.
		firstOptionTextBox.sendKeys(firstOption);
		secondOptionTextBox.sendKeys(secondOption);
		addOptionBtn.click();
		thirdOptionTextBox.sendKeys(thirdOption);
		addOptionBtn.click();
		fourthOptionTextBox.sendKeys(fourthOption);
		
		//Selecting Multiple Correct Answer.
		driver.findElement(By.id("dialogOptionPoints_" + correctAns1)).click();
		driver.findElement(By.id("dialogOptionPoints_" + correctAns2)).click();
		
		//saveQuestionBtn.click();
	}
	
	public void fillInTheBlanksQuiz(String quizName, String newQuestion, String firstAns, String secondAns) {
		driver.findElement(By.xpath("//a[contains(text(),'" + quizName + "')]")).click();
		addItemDropdownBtn.click();
		TestUtil.waitUntilElementVissible(newQuestionDropdown);
		newQuestionDropdown.click();
		TestUtil.waitUntilElementVissible(newQuestionTypeDropdownBtn);
		newQuestionTypeDropdownBtn.click();
		
		//Question Type and switch to another frame to type question and switch back
		TestUtil.waitUntilElementVissible(questionTypreFillInTheBlanks);
		questionTypreFillInTheBlanks.click();
		TestUtil.switchToFrame(frameSwitchForFillIntheBlanks);
		newFillIntheBlanksRichTextBox.sendKeys(newQuestion);
		driver.switchTo().parentFrame();
		
		//In this for answer option starts with 2
		thirdOptionTextBox.sendKeys(firstAns);
		fourthOptionTextBox.sendKeys(secondAns);
		
		//saveQuestionBtn.click();
	}
}
