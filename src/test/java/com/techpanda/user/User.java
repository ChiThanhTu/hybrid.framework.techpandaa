package com.techpanda.user;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import java.lang.reflect.Method;

import javax.swing.JList.DropLocation;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import commons.BaseTest;
import pageObject.navigation.PageGeneratorManager;
import pageObject.user.AboutUsPageObject;
import pageObject.user.AccountInformationPageObject;
import pageObject.user.AddressBookPageObject;
import pageObject.user.AdvanceSearchPageObject;
import pageObject.user.BillingAgreementsPageObject;
import pageObject.user.ContactUsPageObject;
import pageObject.user.CustomerServicePageObject;
import pageObject.user.MyApplicationPageObject;
import pageObject.user.MyDashboardPageObject;
import pageObject.user.MyDownloadableProductsPageObject;
import pageObject.user.MyOrderPageObject;
import pageObject.user.MyProductReviewPageObject;
import pageObject.user.MyWishlistPageObject;
import pageObject.user.NewsletterSubscriptionPageObject;
import pageObject.user.OrdersAndReturnsPageObject;
import pageObject.user.PrivacyPolicyPageObject;
import pageObject.user.RecurringProfilesPageObject;
import pageObject.user.SearchTermsPageObject;
import pageObject.user.SiteMapPageObject;
import pageObject.user.UserHomePageObject;
import pageObject.user.UserLoginPageObject;
import reportConfig.ExtentManager;

public class User extends BaseTest {
	UserHomePageObject homePage;
	UserLoginPageObject loginPage;
	MyDashboardPageObject myDashboardPage;
	AccountInformationPageObject accountInformationPage;
	AddressBookPageObject addressBookPage;
	MyOrderPageObject myOrderPage;
	BillingAgreementsPageObject billingAgreementsPage;
	RecurringProfilesPageObject recurringProfilesPage;
	MyProductReviewPageObject myProductReviewPage;
	MyWishlistPageObject myWishlistPage;
	MyApplicationPageObject myApplicationPage;
	NewsletterSubscriptionPageObject newsletterSubscriptionPage;
	MyDownloadableProductsPageObject myDownloadableProductsPage;
	SiteMapPageObject siteMapPage;
	AdvanceSearchPageObject advanceSearchPage;
	ContactUsPageObject contactUsPage;
	SearchTermsPageObject searchTermsPage;
	OrdersAndReturnsPageObject ordersAndReturnsPage;
	CustomerServicePageObject customerServicePage;
	PrivacyPolicyPageObject privacyPolicyPage;
	AboutUsPageObject aboutUsPage;
	public static String firstName, middleName, lastName, email, password, invalidEmail, invalidPassword,
			incorrectEmail, incorrectpassword, city, telephone, country, stateProvince, street, company,zip;
	WebDriver driver;

	@Parameters({ "envName", "serverName", "browserName", "ipAddress", "port", "osName", "osVersion" })
	@BeforeClass
	public void beforeClass(@Optional("local") String envName, @Optional("USER") String serverName,
			@Optional("Chrome") String browserName, @Optional("localhost") String ipAddress,
			@Optional("5555") String port, @Optional("Windows") String osName, @Optional("10") String osVersion) {
		driver = getBrowserDriver(envName, serverName, browserName, ipAddress, port, osName, osVersion);
		homePage = PageGeneratorManager.getUserHomePage(driver);
		firstName = "Tu";
		middleName = "Thanh";
		lastName = "Chi";
		email = "tuem1111@gmail.com";
		password = "123456";
		invalidEmail = "tuem1111@123123";
		invalidPassword = "12a";
		incorrectEmail = "tuem" + getRandomNumber() + "@gmail.com";
		incorrectpassword = "tuemmm123123";
		city="TP.Hồ Chí Minh";
		telephone="0123456789";
		company= "ông ty 1 thành viên";
		country= "United States";
		stateProvince="Texas";
		zip="70000";
		street="72 duong 23";
		
	}

	@Test
	public void TC_01_Login_With_Empty_Email_Password(Method method) {
		ExtentManager.startTest(method.getName(), "TC 01 Empty Email Password");
		ExtentManager.getTest().log(Status.INFO, "TC_01 - Step 01: Click To My Account Link");
		loginPage = homePage.clickToMyAccountLink();
		ExtentManager.getTest().log(Status.INFO, "TC_01 - Step 02: Input To Element Address Textbox");
		loginPage.inputToElementAddressTextbox("");
		ExtentManager.getTest().log(Status.INFO, "TC_01 - Step 03: Input To Password Textbox");
		loginPage.inputToPasswordTextbox("");
		ExtentManager.getTest().log(Status.INFO, "TC_01 - Step 04: Click To Login Button");
		loginPage.clickToLoginButton();
		ExtentManager.getTest().log(Status.INFO, "TC_01 - Step assert: Verify Empty Email Address  Error Message");
		assertEquals(loginPage.getEmailAddressEmptyErrorMessage(), "This is a required field.");
		ExtentManager.getTest().log(Status.INFO, "TC_01 - Step assert: Verify Empty Password  Error Message");
		assertEquals(loginPage.getPasswordEmptyErrorMessage(), "This is a required field.");
	}

	@Test
	public void TC_02_Login_With_Invalid_Email(Method method) {
		ExtentManager.startTest(method.getName(), "TC 02 Invalid Email");
		ExtentManager.getTest().log(Status.INFO, "TC_02 - Step 01: Click To My Account Link");
		loginPage = homePage.clickToMyAccountLink();
		ExtentManager.getTest().log(Status.INFO,
				"TC_02 - Step 02:  Input To Element Address '" + invalidEmail + "' Textbox");
		loginPage.inputToElementAddressTextbox(invalidEmail);
		ExtentManager.getTest().log(Status.INFO, "TC_02 - Step 03:   Input To Password '" + password + "' Textbox");
		loginPage.inputToPasswordTextbox(password);
		ExtentManager.getTest().log(Status.INFO, "TC_02 - Step 04: Click To Login Button");
		loginPage.clickToLoginButton();
		ExtentManager.getTest().log(Status.INFO, "TC_02 - Step assert: Verify Invalid Email Address Error Message");
		assertEquals(loginPage.getEmailAddressInvalidErrorMessage(),
				"Please enter a valid email address. For example johndoe@domain.com.");
	}

	@Test
	public void TC_03_Login_With_Incorrect_Email(Method method) {
		ExtentManager.startTest(method.getName(), "TC 03 Incorrect Password");
		ExtentManager.getTest().log(Status.INFO, "TC_03 - Step 01: Click To My Account Link");
		loginPage = homePage.clickToMyAccountLink();
		ExtentManager.getTest().log(Status.INFO,
				"TC_03 - Step 02:  Input To Element Address '" + invalidEmail + "' Textbox");
		loginPage.inputToElementAddressTextbox(incorrectEmail);
		ExtentManager.getTest().log(Status.INFO, "TC_03 - Step 03:   Input To Password '" + invalidEmail + "' Textbox");
		loginPage.inputToPasswordTextbox(password);
		ExtentManager.getTest().log(Status.INFO, "TC_03 - Step 04: Click To Login Button");
		loginPage.clickToLoginButton();
		ExtentManager.getTest().log(Status.INFO,
				"TC_03 - Step assert: Verify Incorrect Email Address Password Error Message");
		assertEquals(loginPage.getEmailAddressPasswordIncorrectMessage(), "Invalid login or password.");
	}

	@Test
	public void TC_04_Login_With_Invalid_Password(Method method) {
		ExtentManager.startTest(method.getName(), "TC 04 Invalid Password");
		ExtentManager.getTest().log(Status.INFO, "TC_04 - Step 01: Click To My Account Link");
		loginPage = homePage.clickToMyAccountLink();
		ExtentManager.getTest().log(Status.INFO,
				"TC_04 - Step 02:  Input To Element Address '" + incorrectEmail + "' Textbox");
		loginPage.inputToElementAddressTextbox(incorrectEmail);
		ExtentManager.getTest().log(Status.INFO,
				"TC_04 - Step 03:   Input To Password '" + invalidPassword + "' Textbox");
		loginPage.inputToPasswordTextbox(invalidPassword);
		ExtentManager.getTest().log(Status.INFO, "TC_04 - Step 04: Click To Login Button");
		loginPage.clickToLoginButton();
		ExtentManager.getTest().log(Status.INFO, "TC_04 - Step assert: Verify Invalid Password Error Message");
		assertEquals(loginPage.getPasswordInvalidErrorMessage(),
				"Please enter 6 or more characters without leading or trailing spaces.");
	}

	@Test
	public void TC_05_Login_With_Incorrect_Email_Password(Method method) {
		ExtentManager.startTest(method.getName(), "TC 05 Incorrect Email Password");
		ExtentManager.getTest().log(Status.INFO, "TC_05 - Step 01: Click To My Account Link");
		loginPage = homePage.clickToMyAccountLink();
		ExtentManager.getTest().log(Status.INFO,
				"TC_05 - Step 02:  Input To Element Address '" + incorrectEmail + "' Textbox");
		loginPage.inputToElementAddressTextbox(incorrectEmail);
		ExtentManager.getTest().log(Status.INFO,
				"TC_05 - Step 03:   Input To Password '" + incorrectpassword + "' Textbox");
		loginPage.inputToPasswordTextbox(incorrectpassword);
		ExtentManager.getTest().log(Status.INFO, "TC_05 - Step 04: Click To Login Button");
		loginPage.clickToLoginButton();
		ExtentManager.getTest().log(Status.INFO,
				"TC_05 - Step assert: Verify Incorrect Email Address  Password Error Message");
		assertEquals(loginPage.getEmailAddressPasswordIncorrectMessage(), "Invalid login or password.");
	}

	@Test
	public void TC_06_TC_Login_Valid_Email_And_Password(Method method) {
		ExtentManager.startTest(method.getName(), "TC 06 Valid Email Password");
		ExtentManager.getTest().log(Status.INFO, "TC_06 - Step 01: Click To My Account Link");
		loginPage = homePage.clickToMyAccountLink();
		ExtentManager.getTest().log(Status.INFO, "TC_06 - Step 02:  Input To Element Address '" + email + "' Textbox");
		loginPage.inputToElementAddressTextbox(email);
		ExtentManager.getTest().log(Status.INFO, "TC_06 - Step 03:   Input To Password '" + password + "' Textbox");
		loginPage.inputToPasswordTextbox(password);
		ExtentManager.getTest().log(Status.INFO, "TC_06 - Step 04: Click To Login Button");
		myDashboardPage = loginPage.clickToLoginButton();
		ExtentManager.getTest().log(Status.INFO, "TC_06 - Step assert: Login Success");
		assertTrue(myDashboardPage.getContactInforText(email));

	}
	@Test
	public void TC_07_Account_Information_With_Empty_All(Method method) {
		ExtentManager.startTest(method.getName(), "TC 07 Update Account Information Empty All");
		ExtentManager.getTest().log(Status.INFO, "TC_07 - Step 01: Click to account information");
		accountInformationPage = myDashboardPage.openAccountInformationPage();
		ExtentManager.getTest().log(Status.INFO, "TC_07 - Step 02: Enter To First Name TextBox");
		accountInformationPage.inputToFirstNameTextBox("");
		ExtentManager.getTest().log(Status.INFO, "TC_07 - Step 03: Enter To Last Name TextBox");
		accountInformationPage.inputToLastNameTextBox("");
		ExtentManager.getTest().log(Status.INFO, "TC_07 - Step 04: Enter To Email TextBox");
		accountInformationPage.inputToEmailTextBox("");
		ExtentManager.getTest().log(Status.INFO, "TC_07 - Step 05: Enter To Password TextBox");
		accountInformationPage.inputToPasswordTextBox("");
		ExtentManager.getTest().log(Status.INFO, "TC_07 - Step 06: Click To Save Button And Back MyDashboard");
		accountInformationPage.backMyDashboardPage();
		ExtentManager.getTest().log(Status.INFO, "TC_07 - Step assert: verify Empty First Name  Error Message ");
		assertEquals(accountInformationPage.getDynamicErrorMessage("firstname"), "This is a required field.");
		ExtentManager.getTest().log(Status.INFO, "TC_07 - Step assert: verify Empty Last Name  Error Message ");
		assertEquals(accountInformationPage.getDynamicErrorMessage("lastname"), "This is a required field.");
		ExtentManager.getTest().log(Status.INFO, "TC_07 - Step assert: verify Empty Email Address  Error Message ");
		assertEquals(accountInformationPage.getDynamicErrorMessage("email"), "This is a required field.");
		ExtentManager.getTest().log(Status.INFO, "TC_07 - Step assert: verify Empty Current Password  Error Message ");
		assertEquals(accountInformationPage.getDynamicErrorMessage("current_password"), "This is a required field.");		
	}
	@Test
	public void TC_08_Account_Information_With_Invalid_Email(Method method) {
		ExtentManager.startTest(method.getName(), "TC 08 Update Account Information Invalid_Email");
		ExtentManager.getTest().log(Status.INFO, "TC_08 - Step 01: Click to account information");
		accountInformationPage = myDashboardPage.openAccountInformationPage();
		ExtentManager.getTest().log(Status.INFO, "TC_08 - Step 02: Enter To First Name TextBox");
		accountInformationPage.inputToFirstNameTextBox(firstName);
		ExtentManager.getTest().log(Status.INFO, "TC_08 - Step 03: Enter To Last Name TextBox");
		accountInformationPage.inputToLastNameTextBox(lastName);
		ExtentManager.getTest().log(Status.INFO, "TC_08 - Step 04: Enter To Email TextBox");
		accountInformationPage.inputToEmailTextBox(invalidEmail);
		ExtentManager.getTest().log(Status.INFO, "TC_08 - Step 05: Enter To Password TextBox");
		accountInformationPage.inputToPasswordTextBox(password);
		ExtentManager.getTest().log(Status.INFO, "TC_08 - Step 06: Click To Save Button And Back MyDashboard");
		accountInformationPage.backMyDashboardPage();
		ExtentManager.getTest().log(Status.INFO, "TC_08 - Step assert: verify Invalid Email Error Message ");
		assertEquals(accountInformationPage.getInvalidEmailErrorMessage(), "Please enter a valid email address. For example johndoe@domain.com.");
	}
	@Test
	public void TC_09_Account_Information_With_Invalid_Password(Method method) {
		ExtentManager.startTest(method.getName(), "TC 08 Update Account Information Invalid_password");
		ExtentManager.getTest().log(Status.INFO, "TC_08 - Step 01: Click to account information");
		accountInformationPage = myDashboardPage.openAccountInformationPage();
		ExtentManager.getTest().log(Status.INFO, "TC_08 - Step 02: Enter To First Name TextBox");
		accountInformationPage.inputToFirstNameTextBox(firstName);
		ExtentManager.getTest().log(Status.INFO, "TC_08 - Step 03: Enter To Last Name TextBox");
		accountInformationPage.inputToLastNameTextBox(lastName);
		ExtentManager.getTest().log(Status.INFO, "TC_08 - Step 04: Enter To Email TextBox");
		accountInformationPage.inputToEmailTextBox(email);
		ExtentManager.getTest().log(Status.INFO, "TC_08 - Step 05: Enter To Password TextBox");
		accountInformationPage.inputToPasswordTextBox(invalidPassword);
		ExtentManager.getTest().log(Status.INFO, "TC_08 - Step 06: Click To Save Button And Back MyDashboard");
		accountInformationPage.backMyDashboardPage();
		ExtentManager.getTest().log(Status.INFO, "TC_08 - Step assert: verify Invalid password Error Message ");
		assertEquals(accountInformationPage.getInvalidPasswordErrorMessage(), "Invalid current password");
	}
	
	@Test
	public void TC_10_Account_Information_With_Valid_All(Method method) {
		ExtentManager.startTest(method.getName(), "TC 10 Update Account Information_Valid_All");
		ExtentManager.getTest().log(Status.INFO, "TC_10 - Step 01: Click to account information");
		accountInformationPage = myDashboardPage.openAccountInformationPage();
		ExtentManager.getTest().log(Status.INFO, "TC_10 - Step 02: Enter To First Name TextBox");
		accountInformationPage.inputToFirstNameTextBox(firstName);
		ExtentManager.getTest().log(Status.INFO, "TC_10 - Step 03: Enter To Last Name TextBox");
		accountInformationPage.inputToLastNameTextBox(lastName);
		ExtentManager.getTest().log(Status.INFO, "TC_10 - Step 04: Enter To Email TextBox");
		accountInformationPage.inputToEmailTextBox(email);
		ExtentManager.getTest().log(Status.INFO, "TC_10 - Step 05: Enter To Password TextBox");
		accountInformationPage.inputToPasswordTextBox(password);
		ExtentManager.getTest().log(Status.INFO, "TC_10 - Step 06: Click To Save Button And Back MyDashboard");
		myDashboardPage = accountInformationPage.backMyDashboardPage();
		ExtentManager.getTest().log(Status.INFO,
				"TC_07 - Step assert: Verify Account Information Message Saved Display");
		assertTrue(myDashboardPage.isAccountInformationMessageSavedDisplay());
	}
	@Test
	public void TC_11_Address_Book_With_Empty_All(Method method) {
		ExtentManager.startTest(method.getName(), "TC 11 New Address Book Empty All");
		ExtentManager.getTest().log(Status.INFO, "TC_11 - Step 01: Click to Address Book");
		addressBookPage = myDashboardPage.clickToAddressBook();
		ExtentManager.getTest().log(Status.INFO, "TC_11 - Step 02: Click To Add New Address");
		addressBookPage.clickToAddNewAddress();
		ExtentManager.getTest().log(Status.INFO, "TC_11 - Step 03: Enter To First Name");
		addressBookPage.inputToTextboxById("firstname", "");
		ExtentManager.getTest().log(Status.INFO, "TC_11 - Step 04: Enter To Middle Name");
		addressBookPage.inputToTextboxById("middlename", "");
		ExtentManager.getTest().log(Status.INFO, "TC_11 - Step 05: Enter To Last Name");
		addressBookPage.inputToTextboxById("lastname", "");
		ExtentManager.getTest().log(Status.INFO, "TC_11 - Step 06: Enter To Company ");
		addressBookPage.inputToTextboxById("company", "");
		ExtentManager.getTest().log(Status.INFO, "TC_11 - Step 07: Enter To Telephone");
		addressBookPage.inputToTextboxById("telephone", "");
		ExtentManager.getTest().log(Status.INFO, "TC_11 - Step 08: Enter To Fax");
		addressBookPage.inputToTextboxById("fax", "5555");
		ExtentManager.getTest().log(Status.INFO, "TC_11 - Step 09: Enter To Street Address");
		addressBookPage.inputToTextboxById("street_1", "");
		ExtentManager.getTest().log(Status.INFO, "TC_11 - Step 10: Enter To City");
		addressBookPage.inputToTextboxById("city", "");
		ExtentManager.getTest().log(Status.INFO, "TC_11 - Step 11: Choose The State/Province");
		addressBookPage.selectStateProvince("");
		ExtentManager.getTest().log(Status.INFO, "TC_11 - Step 12: Enter To Zip");
		addressBookPage.inputToTextboxById("zip", "");
		ExtentManager.getTest().log(Status.INFO, "TC_11 - Step 13: Choose The Country");
		addressBookPage.selectCountry("");
		ExtentManager.getTest().log(Status.INFO, "TC_11 - Step 14: Click To Use as my default billing address ");
		addressBookPage.clickDefaultShippingAddress();
		ExtentManager.getTest().log(Status.INFO, "TC_11 - Step 15: Click To Save Address");
		addressBookPage.clickToSaveAddress();
		assertTrue(addressBookPage.isAddressMessageSavedDisplay());
		ExtentManager.getTest().log(Status.INFO, "TC_11 - Step assert: Verify Empty First Name Error Message ");
		assertEquals(addressBookPage.getDynamicEmptyErrorMessage("firstname"), "This is a required field.");
		ExtentManager.getTest().log(Status.INFO, "TC_11 - Step assert: Verify Empty Last Name Error Message ");
		assertEquals(addressBookPage.getDynamicEmptyErrorMessage("lasttname"), "This is a required field.");
		ExtentManager.getTest().log(Status.INFO, "TC_11 - Step assert: Verify Empty Telephone Error Message ");
		assertEquals(addressBookPage.getDynamicEmptyErrorMessage("telephone"), "This is a required field.");
		ExtentManager.getTest().log(Status.INFO, "TC_11 - Step assert: Verify Empty Street Error Message ");
		assertEquals(addressBookPage.getDynamicEmptyErrorMessage("street_1"), "This is a required field.");
		ExtentManager.getTest().log(Status.INFO, "TC_11 - Step assert: Verify Empty City Error Message ");
		assertEquals(addressBookPage.getDynamicEmptyErrorMessage("city"), "This is a required field.");
		ExtentManager.getTest().log(Status.INFO, "TC_11 - Step assert: Verify Empty Zip Name Error Message ");
		assertEquals(addressBookPage.getDynamicEmptyErrorMessage("zip"), "This is a required field.");
		ExtentManager.getTest().log(Status.INFO, "TC_11 - Step assert: Verify Empty Country Name Error Message ");
		assertEquals(addressBookPage.getEmptyCountryErrorMessage(), "Please select an option.");
	}	
	@Test
	public void TC_12_Address_Book_With_Empty_State_Province(Method method) {
		ExtentManager.startTest(method.getName(), "TC 12 New Address Book Empty State Province");
		ExtentManager.getTest().log(Status.INFO, "TC_12 - Step 01: Click to Address Book");
		addressBookPage = myDashboardPage.clickToAddressBook();
		ExtentManager.getTest().log(Status.INFO, "TC_12 - Step 02: Click To Add New Address");
		addressBookPage.clickToAddNewAddress();
		ExtentManager.getTest().log(Status.INFO, "TC_12 - Step 03: Enter To First Name");
		addressBookPage.inputToTextboxById("firstname", firstName);
		ExtentManager.getTest().log(Status.INFO, "TC_12 - Step 04: Enter To Middle Name");
		addressBookPage.inputToTextboxById("middlename", middleName);
		ExtentManager.getTest().log(Status.INFO, "TC_12 - Step 05: Enter To Last Name");
		addressBookPage.inputToTextboxById("lastname", lastName);
		ExtentManager.getTest().log(Status.INFO, "TC_12 - Step 06: Enter To Company ");
		addressBookPage.inputToTextboxById("company", company);
		ExtentManager.getTest().log(Status.INFO, "TC_12 - Step 07: Enter To Telephone");
		addressBookPage.inputToTextboxById("telephone", telephone);
		ExtentManager.getTest().log(Status.INFO, "TC_12 - Step 08: Enter To Fax");
		addressBookPage.inputToTextboxById("fax", "5555");
		ExtentManager.getTest().log(Status.INFO, "TC_12 - Step 09: Enter To Street Address");
		addressBookPage.inputToTextboxById("street_1", street);
		ExtentManager.getTest().log(Status.INFO, "TC_12 - Step 10: Enter To City");
		addressBookPage.inputToTextboxById("city", city);
		ExtentManager.getTest().log(Status.INFO, "TC_12 - Step 11: Choose The State/Province");
		addressBookPage.selectStateProvince("");
		ExtentManager.getTest().log(Status.INFO, "TC_12 - Step 12: Enter To Zip");
		addressBookPage.inputToTextboxById("zip", zip);
		ExtentManager.getTest().log(Status.INFO, "TC_12 - Step 13: Choose The Country");
		addressBookPage.selectCountry(country);
		ExtentManager.getTest().log(Status.INFO, "TC_12 - Step 14: Click To Use as my default billing address ");
		addressBookPage.clickDefaultShippingAddress();
		ExtentManager.getTest().log(Status.INFO, "TC_12 - Step 15: Click To Save Address");
		addressBookPage.clickToSaveAddress();
		assertTrue(addressBookPage.isAddressMessageSavedDisplay());
		ExtentManager.getTest().log(Status.INFO, "TC_12 - Step assert: Verify Empty State/Province Error Message ");
		assertEquals(addressBookPage.getDynamicEmptyErrorMessage("region_id"), "This is a required field.");
		
	}
	@Test
	public void TC_13_Address_Book_With_Valid_All(Method method) {
		ExtentManager.startTest(method.getName(), "TC 13 Add New Address Valid All");
		ExtentManager.getTest().log(Status.INFO, "TC_13 - Step 01: Click to Address Book");
		addressBookPage = myDashboardPage.clickToAddressBook();
		ExtentManager.getTest().log(Status.INFO, "TC_13 - Step 02: Click To Add New Address");
		addressBookPage.clickToAddNewAddress();
		ExtentManager.getTest().log(Status.INFO, "TC_13 - Step 03: Enter To First Name");
		addressBookPage.inputToTextboxById("firstname", firstName);
		ExtentManager.getTest().log(Status.INFO, "TC_13 - Step 04: Enter To Middle Name");
		addressBookPage.inputToTextboxById("middlename", middleName);
		ExtentManager.getTest().log(Status.INFO, "TC_13 - Step 05: Enter To Last Name");
		addressBookPage.inputToTextboxById("lastname", lastName);
		ExtentManager.getTest().log(Status.INFO, "TC_13 - Step 06: Enter To Company ");
		addressBookPage.inputToTextboxById("company", company);
		ExtentManager.getTest().log(Status.INFO, "TC_13 - Step 07: Enter To Telephone");
		addressBookPage.inputToTextboxById("telephone", telephone);
		ExtentManager.getTest().log(Status.INFO, "TC_13 - Step 08: Enter To Fax");
		addressBookPage.inputToTextboxById("fax", "5555");
		ExtentManager.getTest().log(Status.INFO, "TC_13 - Step 09: Enter To Street Address");
		addressBookPage.inputToTextboxById("street_1", street);
		ExtentManager.getTest().log(Status.INFO, "TC_13 - Step 10: Enter To City");
		addressBookPage.inputToTextboxById("city", city);
		ExtentManager.getTest().log(Status.INFO, "TC_13 - Step 11: Choose The State/Province");
		addressBookPage.selectStateProvince(stateProvince);
		ExtentManager.getTest().log(Status.INFO, "TC_13 - Step 12: Enter To Zip");
		addressBookPage.inputToTextboxById("zip", zip);
		ExtentManager.getTest().log(Status.INFO, "TC_13 - Step 13: Choose The Country");
		addressBookPage.selectCountry(country);
		ExtentManager.getTest().log(Status.INFO, "TC_13 - Step 14: Click To Use as my default billing address ");
		addressBookPage.clickDefaultShippingAddress();
		ExtentManager.getTest().log(Status.INFO, "TC_13 - Step 15: Click To Save Address");
		addressBookPage.clickToSaveAddress();
		assertTrue(addressBookPage.isAddressMessageSavedDisplay());
	}
		
	@Test
	public void TC_14_My_Order(Method method) {
		ExtentManager.startTest(method.getName(), "TC 14  My Oder");
		ExtentManager.getTest().log(Status.INFO, "TC_14 - Step 01: Click to My Oder");
		myOrderPage = addressBookPage.openMyOrderPage();
		ExtentManager.getTest().log(Status.INFO, "TC_14 - Step Assert: verify Message In My Order Page");
		assertTrue(myOrderPage.isTableDisplayed());
	}

	@Test
	public void TC_15_Billing_Argreements(Method method) {
		ExtentManager.startTest(method.getName(), "TC 15  Billing Argreements");
		ExtentManager.getTest().log(Status.INFO, "TC_15 - Step 01: Click to Billing Argreements");
		billingAgreementsPage = myOrderPage.openBillingAgreementsPage();
		ExtentManager.getTest().log(Status.INFO, "TC_15 - Step Assert: verify Message In Billing Argreements");
		assertEquals(billingAgreementsPage.getMessageInBillingAgreementsPage(), "There are no billing agreements yet.");
	}

	@Test
	public void TC_16_Recurring_Profiles(Method method) {
		ExtentManager.startTest(method.getName(), "TC 16  Recurring Profiles");
		ExtentManager.getTest().log(Status.INFO, "TC_16 - Step 01: Click to Recurring Profiles");
		recurringProfilesPage = billingAgreementsPage.openRecurringProfilesPage();
		ExtentManager.getTest().log(Status.INFO, "TC_16 - Step Assert: verify Message In Recurring Profiles");
		assertEquals(recurringProfilesPage.getMessageInRecurringProfiles(), "There are no recurring profiles yet.");
	}

	@Test
	public void TC_17_Product_Reviews(Method method) {
		ExtentManager.startTest(method.getName(), "TC 17 Product Reviews");
		ExtentManager.getTest().log(Status.INFO, "TC_17 - Step 1: Click to Product Reviews");
		myProductReviewPage = recurringProfilesPage.openMyProductReviewPage();
		ExtentManager.getTest().log(Status.INFO, "TC_17 - Step Assert: verify Message In Product Reviews");
		assertEquals(myProductReviewPage.getMessageInPruductReviews(), "You have submitted no reviews.");
	}

	@Test
	public void TC_18_My_Wishlist(Method method) {
		ExtentManager.startTest(method.getName(), "TC 18 My Wishlist");
		ExtentManager.getTest().log(Status.INFO, "TC_18 - Step 1: Click to My Wishlist");
		myWishlistPage = myProductReviewPage.openMyWishlistPage();
		ExtentManager.getTest().log(Status.INFO, "TC_18 - Step Assert: verify Message In My Wishlist");
		assertEquals(myWishlistPage.getMessageInMyWishlist(), "You have no items in your wishlist.");
	}

	@Test
	public void TC_19_My_Application(Method method) {
		ExtentManager.startTest(method.getName(), "TC 19 My Application");
		ExtentManager.getTest().log(Status.INFO, "TC_19 - Step 1: Click to My Application");
		myApplicationPage = myWishlistPage.openMyApplicationPage();
		ExtentManager.getTest().log(Status.INFO, "TC_19 - Step Assert: verify Message In My Application");
		assertEquals(myApplicationPage.getMessageInMyApplicationPage(), "You have no applications.");

	}

	@Test
	public void TC_20_Newsletter_Subscription(Method method) {
		ExtentManager.startTest(method.getName(), "TC 20 Newsletter Subscription");
		ExtentManager.getTest().log(Status.INFO, "TC_20 - Step 1: Click to Newsletter Subscription");
		newsletterSubscriptionPage = myApplicationPage.openNewsletterSubscriptionPage();
		ExtentManager.getTest().log(Status.INFO,
				"TC_15 - Step 2: check generator subscription button is on, if not, turn it on");
		newsletterSubscriptionPage.checkToCheckBoxInNewsletterSubcription();
		ExtentManager.getTest().log(Status.INFO, "TC_20 - Step 3: Click To Save");
		myDashboardPage = newsletterSubscriptionPage.clickToSave();
	}

	@Test
	public void TC_21_My_Downloadable_Products(Method method) {
		ExtentManager.startTest(method.getName(), "TC 21 My Downloadable Products");
		ExtentManager.getTest().log(Status.INFO, "TC_21 - Step 1: Click to My Downloadable Products");
		myDownloadableProductsPage = myDashboardPage.openMyDownloadableProductsPage();
		ExtentManager.getTest().log(Status.INFO, "TC_21 - Step Assert: verify Message In My Downloadable Products");
		assertEquals(myDownloadableProductsPage.getMessageInMyDownloadableProductsPage(),
				"You have not purchased any downloadable products yet.");

	}

	@Test
	public void TC_20_Site_Map_Moblie(Method method) {
		ExtentManager.startTest(method.getName(), "TC 20 Site Map Moblie");
		ExtentManager.getTest().log(Status.INFO, "TC_20 - Step 1: Click to Site Map");
		siteMapPage = myDownloadableProductsPage.getFooterContainerPage(driver).OpenSiteMapPage();
		ExtentManager.getTest().log(Status.INFO, "TC_20 - Step 2: Click to Moblie");
		siteMapPage.clickToMoblie();
		ExtentManager.getTest().log(Status.INFO, "TC_20 - Assert: Verify message Picture and Button in Moblie Page ");
		assertEquals(siteMapPage.getMessageInMobliePage(), "This is root of mobile");
		assertTrue(siteMapPage.isPictureDisplayed("1"));
		assertTrue(siteMapPage.isPictureDisplayed("2"));
		assertTrue(siteMapPage.isPictureDisplayed("3"));
		assertEquals(siteMapPage.getPrice("2"), "$500.00");
		assertEquals(siteMapPage.getPrice("3"), "$130.00");
		assertEquals(siteMapPage.getPrice("1"), "$100.00");
		assertTrue(siteMapPage.isAddtoCartDisplayed("IPhone"));
		assertTrue(siteMapPage.isAddtoCartDisplayed("Samsung Galaxy"));
		assertTrue(siteMapPage.isAddtoCartDisplayed("Sony Xperia"));
	}

	@Test
	public void TC_21_Order_SmartPhone(Method method) {
		ExtentManager.startTest(method.getName(), "TC 21 Order SmartPhone");
		ExtentManager.getTest().log(Status.INFO, "TC_21 - Step 1: Click to Add To Cart");
		siteMapPage.clickToAddToCart("IPhone");
		ExtentManager.getTest().log(Status.INFO, "TC_21 - Step 2: Input Shipping Information");
		siteMapPage.enterShippingInfor();
		ExtentManager.getTest().log(Status.INFO, "TC_21 - Step 3: Click To Proceed to Checkout");
		siteMapPage.clickToProceedToCheckout();
		ExtentManager.getTest().log(Status.INFO, "TC_21 - Step 4: Check Out");
		siteMapPage.checkOut();
		ExtentManager.getTest().log(Status.INFO, "TC_21 - Step 5: click To Continue");
		homePage = siteMapPage.clickToContinue();

	}

	@Test
	public void TC_22_Site_Map_TV(Method method) {
		ExtentManager.startTest(method.getName(), "TC 22 Site Map Moblie");
		ExtentManager.getTest().log(Status.INFO, "TC_22 - Step 1: Click To Site Map");
		siteMapPage = homePage.getFooterContainerPage(driver).OpenSiteMapPage();
		ExtentManager.getTest().log(Status.INFO, "TC_22 - Step 2: Click To TV");
		siteMapPage.clickToTV();
		ExtentManager.getTest().log(Status.INFO, "TC_22 - Step assert: Verify Picture and Button in Moblie Page ");
		assertTrue(siteMapPage.isPictureDisplayed("4"));
		assertTrue(siteMapPage.isPictureDisplayed("5"));
		assertEquals(siteMapPage.getPrice("4"), "$615.00");
		assertEquals(siteMapPage.getPrice("5"), "$700.00");
		assertTrue(siteMapPage.isAddtoCartDisplayed("LG LCD"));
		assertTrue(siteMapPage.isAddtoCartDisplayed("Samsung LCD"));
	}

	@Test
	public void TC_23_Order_TV(Method method) {
		ExtentManager.startTest(method.getName(), "TC 23 Order TV");
		ExtentManager.getTest().log(Status.INFO, "TC_23 - Step 1: Click to Add To Cart");
		siteMapPage.clickToAddToCart("Samsung LCD");
		ExtentManager.getTest().log(Status.INFO, "TC_23 - Step 2: Input Shipping Information");
		siteMapPage.enterShippingInfor();
		ExtentManager.getTest().log(Status.INFO, "TC_23 - Step 3: Click Proceed to Checkout");
		siteMapPage.clickToProceedToCheckout();
		ExtentManager.getTest().log(Status.INFO, "TC_23 - Step 4: Check Out");
		siteMapPage.checkOut();
		ExtentManager.getTest().log(Status.INFO, "TC_23 - Step 5: click To Continue");
		homePage = siteMapPage.clickToContinue();
	}

	@Test
	public void TC_24_Search_Terms(Method method) {
		ExtentManager.startTest(method.getName(), "TC 24 Search Terms");
		ExtentManager.getTest().log(Status.INFO, "TC_24 - Step 1: Click to Search Terms");
		searchTermsPage = homePage.getFooterContainerPage(driver).OpenSearchTermsPage();
		ExtentManager.getTest().log(Status.INFO, "TC_24 - Step 2: Click To 0 to 150");
		searchTermsPage.ClickToPopularSearchTerms("0 to 150");
		ExtentManager.getTest().log(Status.INFO,
				"TC_24 - Step assert: Verify message Picture and Button in Search Terms Page");
		assertEquals(searchTermsPage.getMessageTitle(), "SEARCH RESULTS FOR '0 TO 150'");
		assertTrue(searchTermsPage.isPictureDisplayed("1"));
		assertTrue(searchTermsPage.isPictureDisplayed("2"));
		assertTrue(searchTermsPage.isPictureDisplayed("3"));
		assertTrue(searchTermsPage.isPictureDisplayed("4"));
		assertTrue(searchTermsPage.isPictureDisplayed("5"));
		assertEquals(searchTermsPage.getPrice("2"), "$500.00");
		assertEquals(searchTermsPage.getPrice("3"), "$130.00");
		assertEquals(searchTermsPage.getPrice("1"), "$100.00");
		assertEquals(searchTermsPage.getPrice("4"), "$615.00");
		assertEquals(searchTermsPage.getPrice("5"), "$700.00");
		assertTrue(searchTermsPage.isAddtoCartDisplayed("IPhone"));
		assertTrue(searchTermsPage.isAddtoCartDisplayed("Samsung Galaxy"));
		assertTrue(searchTermsPage.isAddtoCartDisplayed("Sony Xperia"));
		assertTrue(searchTermsPage.isAddtoCartDisplayed("LG LCD"));
		assertTrue(searchTermsPage.isAddtoCartDisplayed("Samsung LCD"));
	}

	@Test
	public void TC_25_Advance_Search(Method method) {
		ExtentManager.startTest(method.getName(), "TC 25 Advance Search");
		ExtentManager.getTest().log(Status.INFO, "TC_25 - Step 1: Click To Advance Search");
		advanceSearchPage = searchTermsPage.getFooterContainerPage(driver).OpenAdvanceSearchPage();
		ExtentManager.getTest().log(Status.INFO, "TC_25 - Step 2: Input To Name Textbox");
		advanceSearchPage.inputToNameTextBox("IPHONE");
		ExtentManager.getTest().log(Status.INFO, "TC_25 - Step 3: Input To Price Textbox");
		advanceSearchPage.inputToPriceTextBox("0", "700");
		ExtentManager.getTest().log(Status.INFO, "TC_25 - Step 4: Click To Search");
		advanceSearchPage.clickToSearch();
		ExtentManager.getTest().log(Status.INFO, "TC_25 - Step assert: Verify Name,Picture and Price Displayed");
		assertEquals(advanceSearchPage.getNameItem("IPhone", "IPhone"), "IPHONE");
		assertTrue(advanceSearchPage.isPictureDisplayed("2"));
		assertEquals(advanceSearchPage.getPrice("2"), "$500.00");

	}

	@Test
	public void TC_26_About_Us(Method method) {
		ExtentManager.startTest(method.getName(), "TC 26 About Us");
		ExtentManager.getTest().log(Status.INFO, "TC_26 - Step 1: Click to About Us");
		aboutUsPage = advanceSearchPage.OpenAboutUsPage();
		ExtentManager.getTest().log(Status.INFO, "TC_26 - Step assert: verify Title Displayed");
		assertEquals(aboutUsPage.getTitleAboutUs(), "ABOUT MAGENTO STORE");

	}

	@Test
	public void TC_27_Customer_Service(Method method) {
		ExtentManager.startTest(method.getName(), "TC 27 Customer Service");
		ExtentManager.getTest().log(Status.INFO, "TC_27 - Step 1: Click to Customer Service");
		customerServicePage = aboutUsPage.OpenCustomerServicePage();
		ExtentManager.getTest().log(Status.INFO, "TC_27 - Step assert: verify Title Displayed");
		assertEquals(customerServicePage.getTitleCustomerService(), "CUSTOMER SERVICE");

	}

	@Test
	public void TC_28_Contact_Us_With_Empty_All(Method method) {
		ExtentManager.startTest(method.getName(), "TC 28 Contact Us Empty All");
		ExtentManager.getTest().log(Status.INFO, "TC_28 - Step 1: Click to Contact Us");
		contactUsPage = customerServicePage.OpenContactUsPage();
		ExtentManager.getTest().log(Status.INFO, "TC_28 - Step 2: Input to Name Textbox");
		contactUsPage.inputDynamicIDTextBox("name", "");
		ExtentManager.getTest().log(Status.INFO, "TC_28 - Step 3: Input to Email Textbox");
		contactUsPage.inputDynamicIDTextBox("email", "");
		ExtentManager.getTest().log(Status.INFO, "TC_28 - Step 3: Input to Telephone Textbox");
		contactUsPage.inputDynamicIDTextBox("telephone", "");
		ExtentManager.getTest().log(Status.INFO, "TC_28 - Step 5: Input to Comment Textarea");
		contactUsPage.inputCommentTextarea("");
		ExtentManager.getTest().log(Status.INFO, "TC_28 - Step 6: Click To Submit");
		contactUsPage.clickToSubmit();
		ExtentManager.getTest().log(Status.INFO, "TC_28 - Step assert: verify Empty Name Error Message  ");
		assertEquals(contactUsPage.getDynamicMessage("name"), "This is a required field.");
		ExtentManager.getTest().log(Status.INFO, "TC_28 - Step assert: verify Empty Email Error Message");
		assertEquals(contactUsPage.getDynamicMessage("email"), "This is a required field.");
		ExtentManager.getTest().log(Status.INFO, "TC_28 - Step assert: verify Empty Comment Error Message");
		assertEquals(contactUsPage.getDynamicMessage("comment"), "This is a required field.");
	}

	@Test
	public void TC_29_Contact_Us_With_Invalid_Email(Method method) {
		ExtentManager.startTest(method.getName(), "TC 29 Contact Us Invalid Email");
		ExtentManager.getTest().log(Status.INFO, "TC_29 - Step 1: Click To Contact Us");
		contactUsPage = customerServicePage.OpenContactUsPage();
		ExtentManager.getTest().log(Status.INFO, "TC_29 - Step 2: Input To Name Textbox");
		contactUsPage.inputDynamicIDTextBox("name", firstName + getRandomNumber());
		ExtentManager.getTest().log(Status.INFO, "TC_29 - Step 3: Input To Email Textbox");
		contactUsPage.inputDynamicIDTextBox("email", invalidEmail);
		ExtentManager.getTest().log(Status.INFO, "TC_29 - Step 3: Input To Telephone Textbox");
		contactUsPage.inputDynamicIDTextBox("telephone", "0123456789");
		ExtentManager.getTest().log(Status.INFO, "TC_29 - Step 5: Input To Comment Textarea");
		contactUsPage.inputCommentTextarea("xin chao");
		ExtentManager.getTest().log(Status.INFO, "TC_29 - Step 6: Click To Submit");
		contactUsPage.clickToSubmit();
		ExtentManager.getTest().log(Status.INFO, "TC_29 - Step assert: verify Error Message Name ");
		assertEquals(contactUsPage.getErrorMessageEmailDisplayed(),
				"Please enter a valid email address. For example johndoe@domain.com.");
		ExtentManager.getTest().log(Status.INFO, "TC_29 - Step assert: verify No Name Error Message  ");
		verifyTrue(contactUsPage.IsMessageNotDisplayed("name"));
		ExtentManager.getTest().log(Status.INFO, "TC_29 - Step assert: verify No Email Error Message  ");
		verifyTrue(contactUsPage.IsMessageNotDisplayed("email"));
		ExtentManager.getTest().log(Status.INFO, "TC_29 - Step assert: verify No Comment Error Message ");
		verifyTrue(contactUsPage.IsMessageNotDisplayed("comment"));

	}

	@Test
	public void TC_30_Contact_Us_Valid_All(Method method) {
		ExtentManager.startTest(method.getName(), "TC 30 Contact Us Incorrect All");
		ExtentManager.getTest().log(Status.INFO, "TC_30 - Step 1: Click To Contact Us");
		contactUsPage = customerServicePage.OpenContactUsPage();
		ExtentManager.getTest().log(Status.INFO, "TC_30 - Step 2: Input To Name Textbox");
		contactUsPage.inputDynamicIDTextBox("name", "Chi Thanh Tu");
		ExtentManager.getTest().log(Status.INFO, "TC_30 - Step 3: Input To Email Textbox");
		contactUsPage.inputDynamicIDTextBox("email", "conchim123@gmail.com");
		ExtentManager.getTest().log(Status.INFO, "TC_30 - Step 3: Input To Telephone Textbox");
		contactUsPage.inputDynamicIDTextBox("telephone", "0123456789");
		ExtentManager.getTest().log(Status.INFO, "TC_30 - Step 5: Input To Comment Textarea");
		contactUsPage.inputCommentTextarea("xin chao moi nguoi");
		ExtentManager.getTest().log(Status.INFO, "TC_30 - Step 6: Click To Submit");
		contactUsPage.clickToSubmit();
		ExtentManager.getTest().log(Status.INFO, "TC_30 - Step assert: verify No Name Error Message ");
		verifyTrue(contactUsPage.IsMessageNotDisplayed("name"));
		ExtentManager.getTest().log(Status.INFO, "TC_30 - Step assert: verify No Email Error Message ");
		verifyTrue(contactUsPage.IsMessageNotDisplayed("email"));
		ExtentManager.getTest().log(Status.INFO, "TC_30 - Step assert: verify No Comment Error Message");
		verifyTrue(contactUsPage.IsMessageNotDisplayed("comment"));
		ExtentManager.getTest().log(Status.INFO, "TC_30 - Step assert: verify Message Title");
		assertEquals(contactUsPage.getMessageTitle(), "Unable to submit your request. Please, try again later");
	}

	@AfterClass
	public void quit() {
		driver.quit();
	}
}
