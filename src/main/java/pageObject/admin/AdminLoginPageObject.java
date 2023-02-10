package pageObject.admin;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageObject.navigation.PageGeneratorManager;
import pageUI.admin.AdminLoginPageUI;

public class AdminLoginPageObject extends BasePage {
	WebDriver driver;
	public AdminLoginPageObject (WebDriver driver) {
		this.driver=driver;
	}
	public void InputDynamicTextboxByID(String locator, String text) {
		waitForElementVisible(driver, AdminLoginPageUI.DYNAMIC_TEXTBOX_BY_ID,locator);
		sendkeyToElement(driver, AdminLoginPageUI.DYNAMIC_TEXTBOX_BY_ID, text, locator);
		
	}
	public AdminManageCustomerPageObject clickToLogin() {
		waitForElementClickable(driver, AdminLoginPageUI.LOGIN_BUTTON);
		clickToElement(driver, AdminLoginPageUI.LOGIN_BUTTON);
		return PageGeneratorManager.getAdminManageCustomerPage(driver);
	}
	
	public String getDynamicEmptyErrorMessage(String locator) {
		waitForElementVisible(driver, AdminLoginPageUI.DYNAMIC_EMPTY_ERROR_MESSAGE, locator);
		return getElelementText(driver, AdminLoginPageUI.DYNAMIC_EMPTY_ERROR_MESSAGE, locator);
	}
	public boolean isInvalidUserPasswordDisplayed() {
		waitForElementVisible(driver, AdminLoginPageUI.INVALID_USER_PASSWORD_ERROR_MESSAGE);
		return isElementDisPlayedInDom(driver, AdminLoginPageUI.INVALID_USER_PASSWORD_ERROR_MESSAGE);
	}
	

}
