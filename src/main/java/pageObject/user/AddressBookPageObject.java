package pageObject.user;

import org.openqa.selenium.WebDriver;

import io.qameta.allure.Step;
import pageObject.navigation.SideBarMyAccountPageObject;
import pageUI.user.AddressBookPageUI;

public class AddressBookPageObject extends SideBarMyAccountPageObject {
	WebDriver driver;

	public AddressBookPageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	@Step("input To Textbox By Id {0}")
	public void inputToTextboxById(String locator, String text) {
		waitForElementVisible(driver, AddressBookPageUI.DYNAMIC_INFOR_ADDRESS, locator);
		sendkeyToElement(driver, AddressBookPageUI.DYNAMIC_INFOR_ADDRESS, text, locator);
	}

	@Step("select State Province {0}")
	public void selectStateProvince(String Text) {
		waitForElementClickable(driver, AddressBookPageUI.SELECT_STATE_PROVINCE);
		selectItemInDefaultDropdown(driver, AddressBookPageUI.SELECT_STATE_PROVINCE, Text);
	}

	@Step("select Country {0}")
	public void selectCountry(String Text) {
		waitForElementClickable(driver, AddressBookPageUI.SELECT_COUNTRY);
		selectItemInDefaultDropdown(driver, AddressBookPageUI.SELECT_COUNTRY, Text);
	}

	@Step("click Default Shipping Address {0}")
	public void clickDefaultShippingAddress() {
		waitForElementClickable(driver, AddressBookPageUI.DEFAULT_SHIPPING_ADDRESS);
		checkToCheckboxOrRadio(driver, AddressBookPageUI.DEFAULT_SHIPPING_ADDRESS);
	}

	@Step("click To SaveA ddress {0}")
	public void clickToSaveAddress() {
		waitForElementClickable(driver, AddressBookPageUI.SAVE_ADDRESS_BUTTON);
		clickToElement(driver, AddressBookPageUI.SAVE_ADDRESS_BUTTON);
	}

	@Step("is Address Message Saved Display {0}")
	public boolean isAddressMessageSavedDisplay() {
		waitForElementVisible(driver, AddressBookPageUI.MESSAGE_SAVE_DISPLAY);
		return isElementDisPlayedInDom(driver, AddressBookPageUI.MESSAGE_SAVE_DISPLAY);
	}

	@Step("click To Add New Address {0}")
	public void clickToAddNewAddress() {
		waitForElementClickable(driver, AddressBookPageUI.ADD_NEW_ADDRESS_BUTTON);
		clickToElement(driver, AddressBookPageUI.ADD_NEW_ADDRESS_BUTTON);
	}

	@Step("get Dynamic Empty Error Message {0}")
	public String getDynamicEmptyErrorMessage(String locator) {
		waitForElementVisible(driver, AddressBookPageUI.DYNAMIC_EMPTY_ERROR_MESSAGE, locator);
		return getElelementText(driver, AddressBookPageUI.DYNAMIC_EMPTY_ERROR_MESSAGE, locator);
	}

	@Step("get Empty Country Error Message {0}")
	public String getEmptyCountryErrorMessage() {
		waitForElementVisible(driver, AddressBookPageUI.EMPTY_COUNTRY_ERROR_MESSAGE);
		return getElelementText(driver, AddressBookPageUI.EMPTY_COUNTRY_ERROR_MESSAGE);
	}
}
