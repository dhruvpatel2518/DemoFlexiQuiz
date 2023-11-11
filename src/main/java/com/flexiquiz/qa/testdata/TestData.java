package com.flexiquiz.qa.testdata;

import org.testng.annotations.DataProvider;

public class TestData {
	
	@DataProvider
	public Object[][] getData()
	{
		String username = "automationwithnaveen@gmail.com";
		String password = "advaith6557";
		
		Object[][] login_data = new Object[5][2];
		
		login_data[0][0] = "";
		login_data[0][1] = "";
		
		login_data[1][0] = username;
		login_data[1][1] = "";
		
		login_data[2][0] = "";
		login_data[2][1] = password;
		
		login_data[3][0] = "naveen";
		login_data[3][1] = "kumar";
		
		login_data[4][0] = username;
		login_data[4][1] = password;
		
		return login_data;
	}
	
	@DataProvider
	public Object[][] getSingleChoiceRadioData() {
		
		Object[][] singleChoiceRadioData = new Object[2][8];
		
		singleChoiceRadioData[0][0] = "Test 1";
		singleChoiceRadioData[0][1] = "Radio";
		singleChoiceRadioData[0][2] = "What is the use of @ in Selenium?";
		singleChoiceRadioData[0][3] = "For E-Mail";
		singleChoiceRadioData[0][4] = "For Website";
		singleChoiceRadioData[0][5] = "For Anotation";
		singleChoiceRadioData[0][6] = "None of the above";
		singleChoiceRadioData[0][7] = 2;
		
		singleChoiceRadioData[1][0] = "Test 1";
		singleChoiceRadioData[1][1] = "Radio";
		singleChoiceRadioData[1][2] = "What is the use of DataProvider in Selenium?";
		singleChoiceRadioData[1][3] = "To add data";
		singleChoiceRadioData[1][4] = "To delete data";
		singleChoiceRadioData[1][5] = "To update data";
		singleChoiceRadioData[1][6] = "All of the above";
		singleChoiceRadioData[1][7] = 1;
		
		return singleChoiceRadioData;
	}
	
	@DataProvider
	public Object[][] getSingleChoiceDropdownWithFourOptnData() {
		
		Object[][] singleChoiceDropdownWithFourOptnData = new Object[1][8];
		
		singleChoiceDropdownWithFourOptnData[0][0] = "Test 1";
		singleChoiceDropdownWithFourOptnData[0][1] = "Dropdown";
		singleChoiceDropdownWithFourOptnData[0][2] = "What is the use of @ in Selenium?";
		singleChoiceDropdownWithFourOptnData[0][3] = "For E-Mail";
		singleChoiceDropdownWithFourOptnData[0][4] = "For Website";
		singleChoiceDropdownWithFourOptnData[0][5] = "For Anotation";
		singleChoiceDropdownWithFourOptnData[0][6] = "None of the above";
		singleChoiceDropdownWithFourOptnData[0][7] = 2;
		
		return singleChoiceDropdownWithFourOptnData;
	}
	
	@DataProvider
	public Object[][] getSingleChoiceDropdownWithTwoOptnData() {
		
		Object[][] singleChoiceDropdownWithTwoOptnData = new Object[1][5];
		
		singleChoiceDropdownWithTwoOptnData[0][0] = "Test 1";
		singleChoiceDropdownWithTwoOptnData[0][1] = "What is the use of @ in Selenium?";
		singleChoiceDropdownWithTwoOptnData[0][2] = "For E-Mail";
		singleChoiceDropdownWithTwoOptnData[0][3] = "For Anotation";
		singleChoiceDropdownWithTwoOptnData[0][4] = 1;
		
		
		return singleChoiceDropdownWithTwoOptnData;
	}
	
	@DataProvider
	public Object[][] getMultipleChoiceWithFourOptnData() {
		
		Object[][] multipleChoiceWithFourOptnData = new Object[1][8];
		
		multipleChoiceWithFourOptnData[0][0] = "Test 1";
		multipleChoiceWithFourOptnData[0][1] = "What technology I am currently using for Software Testing?";
		multipleChoiceWithFourOptnData[0][2] = "Selenium";
		multipleChoiceWithFourOptnData[0][3] = "TestNG";
		multipleChoiceWithFourOptnData[0][4] = "Dot.Net";
		multipleChoiceWithFourOptnData[0][5] = "Cypres";
		multipleChoiceWithFourOptnData[0][6] = 0;
		multipleChoiceWithFourOptnData[0][7] = 1;
		
		return multipleChoiceWithFourOptnData;
	}
	
	@DataProvider
	public Object[][] getFillInTheBlanksData() {
		
		Object[][] fillInTheBlanksData = new Object[1][4];
		
		fillInTheBlanksData[0][0] = "Test 1";
		fillInTheBlanksData[0][1] = "I am currently learning [a] using language [b]?";
		fillInTheBlanksData[0][2] = "SELENIUM";
		fillInTheBlanksData[0][3] = "JAVA";
		
		
		return fillInTheBlanksData;
	}
}
