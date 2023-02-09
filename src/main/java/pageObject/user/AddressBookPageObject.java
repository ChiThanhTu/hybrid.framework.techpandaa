package pageObject.user;

import org.openqa.selenium.WebDriver;

import pageObject.navigation.SideBarMyAccountPageObject;
import pageUI.user.AddressBookPageUI;

public class AddressBookPageObject extends SideBarMyAccountPageObject {
	WebDriver driver;
	public AddressBookPageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
}
	public void inputToTextboxById(String locator, String text) {
		waitForElementVisible(driver, AddressBookPageUI.DYNAMIC_INFOR_ADDRESS, locator);
		sendkeyToElement(driver, AddressBookPageUI.DYNAMIC_INFOR_ADDRESS, text, locator);
	}

	public void selectStateProvince(String Text) {
		waitForElementClickable(driver, AddressBookPageUI.SELECT_STATE_PROVINCE);
		selectItemInDefaultDropdown(driver,  AddressBookPageUI.SELECT_STATE_PROVINCE, Text);
	}
	public void selectCountry(String Text) {
		waitForElementClickable(driver, AddressBookPageUI.SELECT_COUNTRY);
		selectItemInDefaultDropdown(driver,  AddressBookPageUI.SELECT_COUNTRY, Text);
	}
	public void clickDefaultShippingAddress() {
		waitForElementClickable(driver, AddressBookPageUI.DEFAULT_SHIPPING_ADDRESS);
		checkToCheckboxOrRadio(driver, AddressBookPageUI.DEFAULT_SHIPPING_ADDRESS);
	}
	public void clickToSaveAddress() {
		waitForElementClickable(driver, AddressBookPageUI.SAVE_ADDRESS_BUTTON);
		clickToElement(driver, AddressBookPageUI.SAVE_ADDRESS_BUTTON);
	}
	public boolean isAddressMessageSavedDisplay() {
		waitForElementVisible(driver, AddressBookPageUI.MESSAGE_SAVE_DISPLAY);
		return isElementDisPlayedInDom(driver, AddressBookPageUI.MESSAGE_SAVE_DISPLAY);
	}
	public void clickToAddNewAddress() {
		waitForElementClickable(driver, AddressBookPageUI.ADD_NEW_ADDRESS_BUTTON);
		clickToElement(driver,  AddressBookPageUI.ADD_NEW_ADDRESS_BUTTON);
	}
	public String getDynamicEmptyErrorMessage(String locator) {
		waitForElementVisible(driver, AddressBookPageUI.DYNAMIC_EMPTY_ERROR_MESSAGE,locator);
		return getElelementText(driver, AddressBookPageUI.DYNAMIC_EMPTY_ERROR_MESSAGE, locator);
	}
	public String getEmptyCountryErrorMessage() {
		waitForElementVisible(driver, AddressBookPageUI.EMPTY_COUNTRY_ERROR_MESSAGE);
		return getElelementText(driver, AddressBookPageUI.EMPTY_COUNTRY_ERROR_MESSAGE);
	}
}
