package pageObject.admin;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.google.inject.spi.Element;

import commons.BasePage;
import pageUI.admin.AdminManageCustomerPageUI;
import pageUI.saucelab.InventoryPageUI;

public class AdminManageCustomerPageObject extends BasePage {
	WebDriver driver;
	public AdminManageCustomerPageObject (WebDriver driver) {
		this.driver=driver;
	}
	public boolean isIncomingMessageDisplayed() {
		waitForElementVisible(driver, AdminManageCustomerPageUI.INCOMING_MESSAGE);
		return isElementDisPlayedInDom(driver, AdminManageCustomerPageUI.INCOMING_MESSAGE);
	}
	public void clickToCloseOfIncomingMessage() {
		waitForElementClickable(driver, AdminManageCustomerPageUI.CLOSE_OF_INCOMING_MESSAGE);
		clickToElement(driver, AdminManageCustomerPageUI.CLOSE_OF_INCOMING_MESSAGE);
	}
	public void inputToTextboxByHeaderName(String locator1, String locator2, String text) {
		waitForElementVisible(driver, AdminManageCustomerPageUI.DYNAMIC_TEXTBOX_BY_HEADER_NAME, locator1,locator2);
		sendkeyToElement(driver, AdminManageCustomerPageUI.DYNAMIC_TEXTBOX_BY_HEADER_NAME, text, locator1,locator2);
		pressKeyToElement(driver, AdminManageCustomerPageUI.DYNAMIC_TEXTBOX_BY_HEADER_NAME, Keys.ENTER, locator1,locator2);
		sleepInSecond(10);
	}
	public Object getNoRecordsFoundMessage() {
		waitForElementVisible(driver, AdminManageCustomerPageUI.NO_RECORDS_FOUND_MESSAGE);
		return getElelementText(driver, AdminManageCustomerPageUI.NO_RECORDS_FOUND_MESSAGE);
	}
	public Object getDynamicValidEmailInformation(String locator) {
		waitForElementVisible(driver, AdminManageCustomerPageUI.DYNAMIC_VALID_EMAIL_INFORMATION,locator);
		return getElelementText(driver, AdminManageCustomerPageUI.DYNAMIC_VALID_EMAIL_INFORMATION, locator).trim();
	}
	public boolean isCustomerInforDislayed() {
		waitForElementsVisible(driver, AdminManageCustomerPageUI.CUSTOMERS_INFOR_DISPLAYED);
		return isListElementDisPlayedInDom(driver, AdminManageCustomerPageUI.CUSTOMERS_INFOR_DISPLAYED);
		
	}

}
