package com.techpanda.admin;

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
import pageObject.admin.AdminAllReviewsPageObject;
import pageObject.admin.AdminLoginPageObject;
import pageObject.admin.AdminManageCustomerPageObject;
import pageObject.admin.AdminOrdersPageObject;
import pageObject.navigation.PageGeneratorManager;
import reportConfig.ExtentManager;

public class Admin extends BaseTest {
	WebDriver driver;
	AdminLoginPageObject adminLoginPage;
	AdminManageCustomerPageObject adminManageCustomerPage;
	AdminOrdersPageObject adminOrderPage;
	AdminAllReviewsPageObject adminAllReviewsPage;
	static String userName, password,email,invalidUserName,invalidEmail,invalidPassword,invalidName,name,ID,telephone,zip,country,stateProvince,customerSince,billToName;
	@Parameters({ "envName", "serverName", "browserName", "ipAddress", "port", "osName", "osVersion" })
	@BeforeClass
	public void beforeClass(@Optional("local") String envName, @Optional("ADMIN") String serverName,
			@Optional("Chrome") String browserName, @Optional("localhost") String ipAddress,
			@Optional("5555") String port, @Optional("Windows") String osName, @Optional("10") String osVersion) {
		driver = getBrowserDriver(envName, serverName, browserName, ipAddress, port, osName, osVersion);
		adminLoginPage= PageGeneratorManager.getAdminLoginPage(driver);
		userName="user01";
		invalidUserName="user011";
		password="guru99com";
		invalidPassword="guru9999com";
		email="tuem1111@gmail.com";
		invalidEmail="tuem111111@gmail.com";
		ID="77048";
		billToName="Tu Thanh Chi";
		name="cuong";
		invalidName="khong co";
		telephone="0123456789";
		zip="700000";
		country= "United States";
		stateProvince="Texas";
		customerSince="Feb 8, 2023 3:32:13 AM";
	}
	@Test
	public void TC_01_Login_With_Empty_User_Password(Method method) {
		ExtentManager.startTest(method.getName(), "TC 01 Empty User Password");
		ExtentManager.getTest().log(Status.INFO, "TC_01 - Step 01: Enter To Valid User");
		adminLoginPage.InputDynamicTextboxByID("username","");
		ExtentManager.getTest().log(Status.INFO, "TC_01 - Step 02: Enter To Valid Password");
		adminLoginPage.InputDynamicTextboxByID("login","");
		ExtentManager.getTest().log(Status.INFO, "TC_01 - Step 03: Click To Login");
		adminLoginPage.clickToLogin();
		ExtentManager.getTest().log(Status.INFO, "TC_01 - Step assert: Verify Empty User Error Message");
		verifyEquals(adminLoginPage.getDynamicEmptyErrorMessage("username"), "This is a required field.");
		ExtentManager.getTest().log(Status.INFO, "TC_01 - Step assert: Verify Empty Password Error Message");
		verifyEquals(adminLoginPage.getDynamicEmptyErrorMessage("login"), "This is a required field.");


	}
	@Test
	public void TC_02_Login_With_Invalid_User_Password(Method method) {
		ExtentManager.startTest(method.getName(), "TC 02 Invalid User Password");
		ExtentManager.getTest().log(Status.INFO, "TC_02 - Step 01: Enter  To '"+invalidUserName+"' Valid User");
		adminLoginPage.InputDynamicTextboxByID("username",invalidUserName);
		ExtentManager.getTest().log(Status.INFO, "TC_02 - Step 02: Enter To '"+invalidPassword+"'Valid Password");
		adminLoginPage.InputDynamicTextboxByID("login",invalidPassword);
		ExtentManager.getTest().log(Status.INFO, "TC_02 - Step 03: Click To Login");
		adminLoginPage.clickToLogin();
		ExtentManager.getTest().log(Status.INFO, "TC_02 - Step assert: Verify Invalid User Password Error Message");
		verifyTrue(adminLoginPage.isInvalidUserPasswordDisplayed());


	}
	@Test
	public void TC_03_Login_With_Valid_User_Password(Method method) {
		ExtentManager.startTest(method.getName(), "TC 03 Valid User Password");
		ExtentManager.getTest().log(Status.INFO, "TC_03 - Step 01: Enter To '"+userName+"' Valid User");
		adminLoginPage.InputDynamicTextboxByID("username",userName);
		ExtentManager.getTest().log(Status.INFO, "TC_03 - Step 02: Enter To '"+password+"' Valid Password");
		adminLoginPage.InputDynamicTextboxByID("login",password);
		ExtentManager.getTest().log(Status.INFO, "TC_03 - Step 03: Click To Login");
		adminManageCustomerPage=adminLoginPage.clickToLogin();
		ExtentManager.getTest().log(Status.INFO, "TC_03 - Step assert: Verify Incoming Message");
		verifyTrue(adminManageCustomerPage.isIncomingMessageDisplayed());
		ExtentManager.getTest().log(Status.INFO, "TC_03 - Step 04: Click To Close Of Incoming Message");
		adminManageCustomerPage.clickToCloseOfIncomingMessage();
	}
	@Test
	public void TC_04_Search_With_Emty_All_Of_Customer(Method method) {
		ExtentManager.startTest(method.getName(), "TC 04 Empty All of Customer");
		ExtentManager.getTest().log(Status.INFO, "TC_04 - Step 01: Enter To Empty Email");
		adminManageCustomerPage.inputToTextboxByHeaderName("Email","customerGrid_filter_email","");
		ExtentManager.getTest().log(Status.INFO, "TC_04 - Step assert: Verify Customer Information Displayed");
		verifyTrue(adminManageCustomerPage.isCustomerInforDislayed());
	}
	@Test
	public void TC_05_Search_With_Invalid_Email_Of_Customer(Method method) {
		ExtentManager.startTest(method.getName(), "TC 05 Invalid Email of Customers");
		ExtentManager.getTest().log(Status.INFO, "TC_05 - Step 01: Enter To '"+invalidEmail+"' Invalid Email");
		adminManageCustomerPage.inputToTextboxByHeaderName("Email","customerGrid_filter_email",invalidEmail);
		ExtentManager.getTest().log(Status.INFO, "TC_05 - Step assert: Verify No records found Message");
		verifyEquals(adminManageCustomerPage.getNoRecordsFoundMessage(), "No records found.");
	}
	@Test
	public void TC_06_Search_With_Valid_Email_Of_Customer(Method method) {
		ExtentManager.startTest(method.getName(), "TC 06 Valid Email of Customers");
		ExtentManager.getTest().log(Status.INFO, "TC_06 - Step 01: Enter To '"+email+"' valid Email");
		adminManageCustomerPage.inputToTextboxByHeaderName("Email","customerGrid_filter_email",email);
		ExtentManager.getTest().log(Status.INFO, "TC_06 - Step assert: Verify Valid Email Information ");
		verifyEquals(adminManageCustomerPage.getDynamicValidEmailInformation("77048"),ID);
		verifyEquals(adminManageCustomerPage.getDynamicValidEmailInformation("tuem1111@gmail.com"),email);
	}
	@Test
	public void TC_07_Search_With_Empty_All_Of_Orders(Method method) {
		ExtentManager.startTest(method.getName(), "TC 07 Valid Bill To Name Of Orders");
		ExtentManager.getTest().log(Status.INFO, "TC_07 - Step 01: Click To Order Link");
		adminOrderPage= adminManageCustomerPage.getHeaderContainerPage(driver).OpenAdminSalesOrderPage("Sales","Orders");
		ExtentManager.getTest().log(Status.INFO, "TC_07 - Step 02: Enter To Empty Bill to Name");
		adminOrderPage.inputToTextboxByHeaderName("Bill to Name","sales_order_grid_filter_billing_name","");
		ExtentManager.getTest().log(Status.INFO, "TC_07 - Step assert: Verify Orders Information Displayed");
		verifyTrue(adminOrderPage.isCustomerInforDislayed());
	}

	@Test
	public void TC_08_Search_With_Valid_Bill_To_Name_Of_Orders(Method method) {
		ExtentManager.startTest(method.getName(), "TC 08 Valid Bill To Name Of Orders");
		ExtentManager.getTest().log(Status.INFO, "TC_08 - Step 01: Input To '"+billToName+"'valid Bill to Name of orders");
		adminOrderPage.inputToTextboxByHeaderName("Bill to Name","sales_order_grid_filter_billing_name",billToName);
		ExtentManager.getTest().log(Status.INFO, "TC_08 - Step assert: Verify Order Information");
		verifyEquals(adminOrderPage.getTextByHeaderNameAndRowNummer("Bill to Name","1"), "Tu Thanh Chi");
		verifyEquals(adminOrderPage.getTextByHeaderNameAndRowNummer("Ship to Name","1"), "Tu Thanh Chi");
		verifyEquals(adminOrderPage.getTextByHeaderNameAndRowNummer("G.T. (Base)","1"), "$705.00");
		verifyEquals(adminOrderPage.getTextByHeaderNameAndRowNummer("G.T. (Purchased)","1"), "$705.00");

	}
	@Test
	public void TC_09_Search_With_Invalid_Bill_To_Name_Of_Orders(Method method) {
		ExtentManager.startTest(method.getName(), "TC 09 Invalid Bill To Name Of Orders");
		ExtentManager.getTest().log(Status.INFO, "TC_09 - Step 01: Input To '"+invalidName+"'Invalid Bill to Name of orders");
		adminOrderPage.inputToTextboxByHeaderName("Bill to Name","sales_order_grid_filter_billing_name",invalidName);
		ExtentManager.getTest().log(Status.INFO, "TC_09 - Step assert: Verify Order Information");
		verifyEquals(adminOrderPage.getNoRecordsFoundMessage(), "No records found.");
	}
	@Test
	public void TC_10_Search_With_Empty_All_Of_All_Reviews(Method method) {
		ExtentManager.startTest(method.getName(), "TC 10 Empty All Of All Reviews");
		ExtentManager.getTest().log(Status.INFO, "TC_10 - Step 01: Click To All Reciews Link");
		adminAllReviewsPage=adminOrderPage.getHeaderContainerPage(driver).OpenAdminAllReviewsPage("Catalog", "Reviews and Ratings", "Customer Reviews", "All Reviews");
		ExtentManager.getTest().log(Status.INFO, "TC_10 - Step 02: Input Invalid Nick Name of All Reviews");
		adminAllReviewsPage.inputToTextboxByHeaderName("Nickname","reviwGrid_filter_nickname","");
		ExtentManager.getTest().log(Status.INFO, "TC_10 - Step assert: Verify All Rieviews Information Displayed");
		verifyTrue(adminAllReviewsPage.isCustomerInforDislayed());
	}
	@Test
	public void TC_11_Search_With_Invalid_Nick_Name_Of_All_Reviews(Method method) {
		ExtentManager.startTest(method.getName(), "TC 11 Invalid Nick Name Of All Reviews");
		ExtentManager.getTest().log(Status.INFO, "TC_11 - Step 01: Input To Invalid '"+invalidName+"' Nick Name of All Reviews");
		adminAllReviewsPage.inputToTextboxByHeaderName("Nickname","reviwGrid_filter_nickname",invalidName);
		ExtentManager.getTest().log(Status.INFO, "TC_1 - Step assert: Verify All Rieviews Information");
		verifyEquals(adminAllReviewsPage.getNoRecordsFoundMessage(), "No records found.");
	}
	@Test
	public void TC_12_Search_With_Valid_Nick_Name_Of_All_Reviews(Method method) {
		ExtentManager.startTest(method.getName(), "TC 12 Valid Nick Name Of All Reviews");
		ExtentManager.getTest().log(Status.INFO, "TC_12 - Step 01: Input To Valid '"+name+"' Nick Name of All Reviews");
		adminAllReviewsPage.inputToTextboxByHeaderName("Nickname","reviwGrid_filter_nickname",name);
		ExtentManager.getTest().log(Status.INFO, "TC_12 - Step assert: Verify All Rieviews Information");
		verifyEquals(adminAllReviewsPage.getTextByHeaderNameAndRowNummer("ID","1"), "4227");
		verifyEquals(adminAllReviewsPage.getTextByHeaderNameAndRowNummer("Created On","1"), "Feb 9, 2023 11:44:38 AM");
		verifyEquals(adminAllReviewsPage.getTextByHeaderNameAndRowNummer("Status","1"), "Pending");
		verifyEquals(adminAllReviewsPage.getTextByHeaderNameAndRowNummer("Title","1"), "good");
		verifyEquals(adminAllReviewsPage.getTextByHeaderNameAndRowNummer("Nickname","1"), "Cuong");
		verifyEquals(adminAllReviewsPage.getTextByHeaderNameAndRowNummer("Type","1"), "Customer");
		verifyEquals(adminAllReviewsPage.getTextByHeaderNameAndRowNummer("Product Name","1"), "Sony Xperia");
		verifyEquals(adminAllReviewsPage.getTextByHeaderNameAndRowNummer("Product SKU","1"), "MOB001");
	}
	
	@AfterClass
	public void afterClass() {
		driver.quit();
	}
	
	
	
	
	
}
