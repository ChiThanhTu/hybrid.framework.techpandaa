package com.techpanda.user;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import commons.BaseTest;
import pageObject.navigation.PageGeneratorManager;
import pageObject.user.CreateAnAccountPageObject;
import pageObject.user.MyDashboardPageObject;
import pageObject.user.UserHomePageObject;
import pageObject.user.UserLoginPageObject;
import reportConfig.ExtentManager;

public class RegisterUser extends BaseTest {
	WebDriver driver;
	UserHomePageObject homePage;
	UserLoginPageObject loginPage;
	MyDashboardPageObject myDashboardPage;
	CreateAnAccountPageObject createAnAccountPage;
	public static String firstName, middleName, lastName, password, comfirmPassword, invalidEmail, validEmail,
			invalidPassword,existingEmail;

	@Parameters({ "envName","serverName","browserName","ipAddress","port","osName","osVersion"})
	@BeforeClass
	public void beforeClass(@Optional("local")String envName, @Optional("USER")String serverName, @Optional("Chrome")String browserName, @Optional("localhost")String ipAddress, @Optional("5555")String port,  @Optional("Windows")String osName, @Optional("10")String osVersion) {
		driver = getBrowserDriver(envName, serverName, browserName, ipAddress, port, osName, osVersion);
		homePage = PageGeneratorManager.getUserHomePage(driver);
		firstName = "Tu";
		middleName = "Thanh";
		lastName = "Chi";
		password = "123456";
		invalidPassword = "12a";
		validEmail = "tuem" + getRandomNumber() + "@gmail.com";
		invalidEmail = "tuem@123123";
		comfirmPassword = "123456";
		existingEmail = "tuem1111@gmail.com";
	}

	@Test
	public void TC_01_Register_With_Emty_All(Method method) {
		ExtentManager.startTest(method.getName(), "TC 01 Register With Emty All");
		ExtentManager.getTest().log(Status.INFO, "TC_01 - Step 01: Click To My Account Link");
		loginPage = homePage.clickToMyAccountLink();
		ExtentManager.getTest().log(Status.INFO, "TC_01 - Step 02: Click To Create an Account Link");
		createAnAccountPage=loginPage.clickToCreateAnAccountLink();
		ExtentManager.getTest().log(Status.INFO, "TC_01 - Step 03: Input To First Name Textbox");
		createAnAccountPage.inputDynamicTextboxById("firstname", "");
		ExtentManager.getTest().log(Status.INFO, "TC_01 - Step 04: Input To Midle Name Textbox");
		createAnAccountPage.inputDynamicTextboxById("middlename", "");
		ExtentManager.getTest().log(Status.INFO, "TC_01 - Step 05: Input To Last Name Textbox");
		createAnAccountPage.inputDynamicTextboxById("lastname", "");
		ExtentManager.getTest().log(Status.INFO, "TC_01 - Step 06: Input To EmailAddress Textbox");
		createAnAccountPage.inputDynamicTextboxById("email_address", "");
		ExtentManager.getTest().log(Status.INFO, "TC_01 - Step 07: Input To Password Textbox");
		createAnAccountPage.inputDynamicTextboxById("password", "");
		ExtentManager.getTest().log(Status.INFO, "TC_01 - Step 08: Input To Confirm Password Textbox");
		createAnAccountPage.inputDynamicTextboxById("confirmation", "");
		ExtentManager.getTest().log(Status.INFO, "TC_01 - Step 09: Click To Sign Up for Newsletter Checkbox");
		createAnAccountPage.clickToSignUpForNewsletterCheckbox();
		ExtentManager.getTest().log(Status.INFO, "TC_01 - Step 10: Click To Register Button");
		createAnAccountPage.clickToRegisterButton();
		ExtentManager.getTest().log(Status.INFO, "TC_01 - Step assert: Verify First Name Empty Error Message");
		assertEquals(createAnAccountPage.getDynamicErrorMessageById("firstname"), "This is a required field.");
		ExtentManager.getTest().log(Status.INFO, "TC_01 - Step assert: Verify Last Name Empty Error Message");
		assertEquals(createAnAccountPage.getDynamicErrorMessageById("lastname"), "This is a required field.");
		ExtentManager.getTest().log(Status.INFO, "TC_01 - Step assert: Verify Email Address Empty Error Message");
		assertEquals(createAnAccountPage.getDynamicErrorMessageById("email_address"), "This is a required field.");
		ExtentManager.getTest().log(Status.INFO, "TC_01 - Step assert: Verify Password Empty Error Message");
		assertEquals(createAnAccountPage.getDynamicErrorMessageById("password"), "This is a required field.");
		ExtentManager.getTest().log(Status.INFO, "TC_01 - Step assert: Verify Comfirm Password Empty Error Message");
		assertEquals(createAnAccountPage.getDynamicErrorMessageById("confirmation"), "This is a required field.");
	}

	@Test
	public void TC_02_Register_With_Invalid_Email(Method method) {
		ExtentManager.startTest(method.getName(), "TC 02 Register With Invalid Email");
		ExtentManager.getTest().log(Status.INFO, "TC_02 - Step 01: Input To First Name '" + firstName + "' Textbox");
		createAnAccountPage.inputDynamicTextboxById("firstname", firstName);
		ExtentManager.getTest().log(Status.INFO, "TC_02 - Step 02: Input To Midle Name '" + middleName + "' Textbox");
		createAnAccountPage.inputDynamicTextboxById("middlename", middleName);
		ExtentManager.getTest().log(Status.INFO, "TC_02 - Step 03: Input To Last Name '" + lastName + "' Textbox");
		createAnAccountPage.inputDynamicTextboxById("lastname", lastName);
		ExtentManager.getTest().log(Status.INFO,
				"TC_02 - Step 04: Input To EmailAddress '" + invalidEmail + "' Textbox");
		createAnAccountPage.inputDynamicTextboxById("email_address", invalidEmail);
		ExtentManager.getTest().log(Status.INFO, "TC_02 - Step 05: Input To Password '" + password + "' Textbox");
		createAnAccountPage.inputDynamicTextboxById("password", password);
		ExtentManager.getTest().log(Status.INFO,
				"TC_02 - Step 06: Input To Confirm Password '" + comfirmPassword + "' Textbox");
		createAnAccountPage.inputDynamicTextboxById("confirmation", comfirmPassword);
		ExtentManager.getTest().log(Status.INFO, "TC_02 - Step 07: Click To Sign Up for Newsletter Checkbox");
		createAnAccountPage.clickToSignUpForNewsletterCheckbox();
		ExtentManager.getTest().log(Status.INFO, "TC_02 - Step 08: Click To Register Button");
		createAnAccountPage.clickToRegisterButton();
		ExtentManager.getTest().log(Status.INFO, "TC_02 - Step assert: Verify Email Invalid Error Message");
		assertEquals(createAnAccountPage.getEmailInvalidErrorMessage("email_address"),
				"Please enter a valid email address. For example johndoe@domain.com.");
	}

	@Test
	public void TC_03_Register_With_Invalid_Password(Method method) {
		ExtentManager.startTest(method.getName(), "TC 03 Register With Invalid Password");
		ExtentManager.getTest().log(Status.INFO, "TC_03 - Step 01: Input To First Name '" + firstName + "' Textbox");
		createAnAccountPage.inputDynamicTextboxById("firstname", firstName);
		ExtentManager.getTest().log(Status.INFO, "TC_03 - Step 02: Input To Midle Name '" + middleName + "' Textbox");
		createAnAccountPage.inputDynamicTextboxById("middlename", middleName);
		ExtentManager.getTest().log(Status.INFO, "TC_03 - Step 03: Input To Last Name '" + lastName + "' Textbox");
		createAnAccountPage.inputDynamicTextboxById("lastname", lastName);
		ExtentManager.getTest().log(Status.INFO, "TC_03 - Step 04: Input To EmailAddress '" + validEmail + "' Textbox");
		createAnAccountPage.inputDynamicTextboxById("email_address", validEmail);
		ExtentManager.getTest().log(Status.INFO,
				"TC_03 - Step 05: Input To Password '" + invalidPassword + "' Textbox");
		createAnAccountPage.inputDynamicTextboxById("password", invalidPassword);
		ExtentManager.getTest().log(Status.INFO,
				"TC_03 - Step 06: Input To Confirm Password '" + comfirmPassword + "' Textbox");
		createAnAccountPage.inputDynamicTextboxById("confirmation", comfirmPassword);
		ExtentManager.getTest().log(Status.INFO, "TC_03 - Step 07: Click To Sign Up for Newsletter Checkbox");
		createAnAccountPage.clickToSignUpForNewsletterCheckbox();
		ExtentManager.getTest().log(Status.INFO, "TC_03 - Step 08: Click To Register Button");
		createAnAccountPage.clickToRegisterButton();
		ExtentManager.getTest().log(Status.INFO, "TC_03 - Step assert: Verify Password Invalid Error Message");
		assertEquals(createAnAccountPage.getPasswordInvalidErrorMessage("password"),
				"Please enter 6 or more characters without leading or trailing spaces.");
		ExtentManager.getTest().log(Status.INFO, "TC_03 - Step assert: Verify Comfirm Invalid Password  Error Message");
		assertEquals(createAnAccountPage.getConfirmPasswordInvalidErrorMessage("confirmation"),
				"Please make sure your passwords match.");
	}
	@Test
	public void TC_04_Register_With_Existing_Email(Method method) {
		ExtentManager.startTest(method.getName(), "TC 04 Register With ExistingEmail");
		ExtentManager.getTest().log(Status.INFO, "TC_04 - Step 01: Input To First Name '" + firstName + "' Textbox");
		createAnAccountPage.inputDynamicTextboxById("firstname", firstName);
		ExtentManager.getTest().log(Status.INFO, "TC_04 - Step 02: Input To Midle Name '" + middleName + "' Textbox");
		createAnAccountPage.inputDynamicTextboxById("middlename", middleName);
		ExtentManager.getTest().log(Status.INFO, "TC_04 - Step 03: Input To Last Name '" + lastName + "' Textbox");
		createAnAccountPage.inputDynamicTextboxById("lastname", lastName);
		ExtentManager.getTest().log(Status.INFO, "TC_04 - Step 04: Input To EmailAddress '" + validEmail + "' Textbox");
		createAnAccountPage.inputDynamicTextboxById("email_address", existingEmail);
		ExtentManager.getTest().log(Status.INFO,
				"TC_03 - Step 05: Input To Password '" + password + "' Textbox");
		createAnAccountPage.inputDynamicTextboxById("password", password);
		ExtentManager.getTest().log(Status.INFO,
				"TC_03 - Step 06: Input To Confirm Password '" + password + "' Textbox");
		createAnAccountPage.inputDynamicTextboxById("confirmation", comfirmPassword);
		ExtentManager.getTest().log(Status.INFO, "TC_04 - Step 07: Click To Sign Up for Newsletter Checkbox");
		createAnAccountPage.clickToSignUpForNewsletterCheckbox();
		ExtentManager.getTest().log(Status.INFO, "TC_04 - Step 08: Click To Register Button");
		createAnAccountPage.clickToRegisterButton();
		ExtentManager.getTest().log(Status.INFO, "TC_04 - Step assert: Verify Existing Email Error Message");
		verifyTrue(createAnAccountPage.isExistingEmailErrorMessageDisplayed());
	}

	@Test
	public void TC_05_Register_With_Incorrect_All(Method method) {
		ExtentManager.startTest(method.getName(), "TC 05 Register With Incorrect All");
		ExtentManager.getTest().log(Status.INFO, "TC_05 - Step 01: Input To First Name '" + firstName + "' Textbox");
		createAnAccountPage.inputDynamicTextboxById("firstname", firstName);
		ExtentManager.getTest().log(Status.INFO, "TC_05 - Step 02: Input To Midle Name '" + middleName + "' Textbox");
		createAnAccountPage.inputDynamicTextboxById("middlename", middleName);
		ExtentManager.getTest().log(Status.INFO, "TC_05 - Step 03: Input To Last Name '" + lastName + "' Textbox");
		createAnAccountPage.inputDynamicTextboxById("lastname", lastName);
		ExtentManager.getTest().log(Status.INFO, "TC_05 - Step 04: Input To EmailAddress '" + validEmail + "' Textbox");
		createAnAccountPage.inputDynamicTextboxById("email_address", validEmail);
		ExtentManager.getTest().log(Status.INFO, "TC_05 - Step 05: Input To Password '" + password + "' Textbox");
		createAnAccountPage.inputDynamicTextboxById("password", password);
		ExtentManager.getTest().log(Status.INFO,
				"TC_04 - Step 06: Input To Confirm Password '" + comfirmPassword + "' Textbox");
		createAnAccountPage.inputDynamicTextboxById("confirmation", comfirmPassword);
		ExtentManager.getTest().log(Status.INFO, "TC_05 - Step 07: Click To Sign Up for Newsletter Checkbox");
		createAnAccountPage.clickToSignUpForNewsletterCheckbox();
		ExtentManager.getTest().log(Status.INFO, "TC_05 - Step 8: Click To Register Button");
		myDashboardPage = createAnAccountPage.clickToRegisterButton();
		ExtentManager.getTest().log(Status.INFO, "TC_05 - Step assert: Verify Register Message");
		assertTrue(myDashboardPage.isRegisterMessageSaveDisplayed());
	}

	@AfterClass
	public void quit() {
		driver.quit();
	}
}
