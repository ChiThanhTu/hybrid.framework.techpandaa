package pageObject.admin;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import commons.BasePage;
import io.qameta.allure.Step;
import pageUI.admin.AdminManageCustomerPageUI;

public class AdminManageCustomerPageObject extends BasePage {
	WebDriver driver;

	public AdminManageCustomerPageObject(WebDriver driver) {
		this.driver = driver;
	}

	@Step("is Incoming Message Displayed {0}")
	public boolean isIncomingMessageDisplayed() {
		waitForElementVisible(driver, AdminManageCustomerPageUI.INCOMING_MESSAGE);
		return isElementDisPlayedInDom(driver, AdminManageCustomerPageUI.INCOMING_MESSAGE);
	}

	@Step("click To Close Of Incoming Message {0}")
	public void clickToCloseOfIncomingMessage() {
		waitForElementClickable(driver, AdminManageCustomerPageUI.CLOSE_OF_INCOMING_MESSAGE);
		clickToElement(driver, AdminManageCustomerPageUI.CLOSE_OF_INCOMING_MESSAGE);
	}

	@Step("input To Textbox By Header Name {0}")
	public void inputToTextboxByHeaderName(String locator1, String locator2, String text) {
		waitForElementVisible(driver, AdminManageCustomerPageUI.DYNAMIC_TEXTBOX_BY_HEADER_NAME, locator1, locator2);
		sendkeyToElement(driver, AdminManageCustomerPageUI.DYNAMIC_TEXTBOX_BY_HEADER_NAME, text, locator1, locator2);
		pressKeyToElement(driver, AdminManageCustomerPageUI.DYNAMIC_TEXTBOX_BY_HEADER_NAME, Keys.ENTER, locator1,
				locator2);
		sleepInSecond(4);
	}

	@Step("get No Records Found Message {0}")
	public Object getNoRecordsFoundMessage() {
		waitForElementVisible(driver, AdminManageCustomerPageUI.NO_RECORDS_FOUND_MESSAGE);
		return getElelementText(driver, AdminManageCustomerPageUI.NO_RECORDS_FOUND_MESSAGE);
	}

	@Step("get Dynamic Valid Email Information {0}")
	public Object getDynamicValidEmailInformation(String locator) {
		waitForElementVisible(driver, AdminManageCustomerPageUI.DYNAMIC_VALID_EMAIL_INFORMATION, locator);
		return getElelementText(driver, AdminManageCustomerPageUI.DYNAMIC_VALID_EMAIL_INFORMATION, locator).trim();
	}

	@Step("is Customer Infor Dislayed {0}")
	public boolean isCustomerInforDislayed() {
		waitForElementsVisible(driver, AdminManageCustomerPageUI.CUSTOMERS_INFOR_DISPLAYED);
		return isListElementDisPlayedInDom(driver, AdminManageCustomerPageUI.CUSTOMERS_INFOR_DISPLAYED);

	}

}
