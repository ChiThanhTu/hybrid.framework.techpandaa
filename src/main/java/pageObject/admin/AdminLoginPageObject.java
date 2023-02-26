package pageObject.admin;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import io.qameta.allure.Step;
import pageObject.navigation.PageGeneratorManager;
import pageUI.admin.AdminLoginPageUI;

public class AdminLoginPageObject extends BasePage {
	WebDriver driver;

	public AdminLoginPageObject(WebDriver driver) {
		this.driver = driver;
	}

	@Step("Input Dynamic Textbox By ID {0}")
	public void InputDynamicTextboxByID(String locator, String text) {
		waitForElementVisible(driver, AdminLoginPageUI.DYNAMIC_TEXTBOX_BY_ID, locator);
		sendkeyToElement(driver, AdminLoginPageUI.DYNAMIC_TEXTBOX_BY_ID, text, locator);

	}

	@Step("click To Login {0}")
	public AdminManageCustomerPageObject clickToLogin() {
		waitForElementClickable(driver, AdminLoginPageUI.LOGIN_BUTTON);
		clickToElement(driver, AdminLoginPageUI.LOGIN_BUTTON);
		return PageGeneratorManager.getAdminManageCustomerPage(driver);
	}

	@Step("get Dynamic Empty Error Message {0}")
	public String getDynamicEmptyErrorMessage(String locator) {
		waitForElementVisible(driver, AdminLoginPageUI.DYNAMIC_EMPTY_ERROR_MESSAGE, locator);
		return getElelementText(driver, AdminLoginPageUI.DYNAMIC_EMPTY_ERROR_MESSAGE, locator);
	}

	@Step("is Invalid User Password Displayed {0}")
	public boolean isInvalidUserPasswordDisplayed() {
		waitForElementVisible(driver, AdminLoginPageUI.INVALID_USER_PASSWORD_ERROR_MESSAGE);
		return isElementDisPlayedInDom(driver, AdminLoginPageUI.INVALID_USER_PASSWORD_ERROR_MESSAGE);
	}

}
