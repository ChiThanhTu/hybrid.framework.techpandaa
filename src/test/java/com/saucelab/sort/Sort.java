package com.saucelab.sort;


import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import commons.BaseTest;
import pageObject.saucelab.InventoryPageObject;
import pageObject.saucelab.LoginPageObject;
import pageObject.saucelab.PageGeneratorManager;
import reportConfig.ExtentManager;



public class Sort extends BaseTest {
	WebDriver driver;
	LoginPageObject loginPage;
	InventoryPageObject inventoryPage;
	@Parameters({ "envName","serverName","browserName","ipAddress","port","osName","osVersion"})
	@BeforeClass
	public void beforeClass(@Optional("local")String envName, @Optional("DEV")String serverName, @Optional("Chrome")String browserName, @Optional("localhost")String ipAddress, @Optional("5555")String port,  @Optional("Windows")String osName, @Optional("10")String osVersion) {
		driver = getBrowserDriver(envName, serverName, browserName, ipAddress, port, osName, osVersion);
		loginPage = PageGeneratorManager.getLoginPage(driver);
		loginPage.enterToUserNameTextBox("standard_user");
		loginPage.enterToPasswordTextBox("secret_sauce");
		inventoryPage= loginPage.clickToLoginButton();	
	}

	@Test
	public void Sort_01_Name_Ascending(Method method) {
		ExtentManager.startTest(method.getName(), "Sort 01 Name Ascending");
		ExtentManager.getTest().log(Status.INFO, "Sort_01 - Step 01: Select Item In Short DropDown");
		inventoryPage.selectItemInSortDropDown("Name (A to Z)");
		ExtentManager.getTest().log(Status.INFO, "Sort_01 - Step 02: Verify Product Name Sort Ascending");
		verifyTrue(inventoryPage.isProductNameSortAscending());
		

	}
	@Test
	public void Sort_02_Name_Descending(Method method) {
		ExtentManager.startTest(method.getName(), "Sort 02 Name Descending");
		ExtentManager.getTest().log(Status.INFO, "Sort_02 - Step 01: Select Item In Short DropDown");
		inventoryPage.selectItemInSortDropDown("Name (Z to A)");
		ExtentManager.getTest().log(Status.INFO, "Sort_01 - Step 02: Verify Product Name Sort Descending");
		verifyTrue(inventoryPage.isProductNameSortDescending());

	}
	@Test
	public void Sort_03_Price_Ascending(Method method) {
		ExtentManager.startTest(method.getName(), "TC 03 Price Ascending");
		ExtentManager.getTest().log(Status.INFO, "Sort_03 - Step 01: Select Item In Short DropDown");
		inventoryPage.selectItemInSortDropDown("Price (low to high)");
		ExtentManager.getTest().log(Status.INFO, "Sort_03 - Step 02: Verify Product Price Sort Ascending");
		verifyTrue(inventoryPage.isProductPriceSortAscending());

	}	
	@Test
	public void Sort_04_Price_Descending(Method method) {
		ExtentManager.startTest(method.getName(), "TC 04 Price Descending");
		ExtentManager.getTest().log(Status.INFO, "Sort_04 - Step 01: Select Item In Short DropDown");
		inventoryPage.selectItemInSortDropDown("Price (high to low)");
		ExtentManager.getTest().log(Status.INFO, "Sort_04 - Step 02: Verify Product Price Sort Descending");
		verifyTrue(inventoryPage.isProductPriceSortDescending());
	}	
	
	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}
