package pageObject.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import io.qameta.allure.Step;
import pageObject.navigation.PageGeneratorManager;
import pageUI.user.CreateAnAccountPageUI;

public class CreateAnAccountPageObject extends BasePage {
	WebDriver driver;

	public CreateAnAccountPageObject(WebDriver driver) {
		this.driver = driver;
	}

	@Step("input Dynamic Textbox By Id {0}")
	public void inputDynamicTextboxById(String locator, String text) {
		waitForElementVisible(driver, CreateAnAccountPageUI.DYNAMIC_TEXTBOX_BY_ID, locator);
		sendkeyToElement(driver, CreateAnAccountPageUI.DYNAMIC_TEXTBOX_BY_ID, text, locator);
	}

	@Step("click To Sign Up For Newsletter Checkbox {0}")
	public void clickToSignUpForNewsletterCheckbox() {
		waitForElementClickable(driver, CreateAnAccountPageUI.SIGN_UP_NEWSLETTER_CHECKBOX);
		checkToCheckboxOrRadio(driver, CreateAnAccountPageUI.SIGN_UP_NEWSLETTER_CHECKBOX);
	}

	@Step("get Dynamic Error Message By Id")
	public String getDynamicErrorMessageById(String locator) {
		waitForElementVisible(driver, CreateAnAccountPageUI.DYNAMIC_ERROR_MESSAGE_BY_ID, locator);
		return getElelementText(driver, CreateAnAccountPageUI.DYNAMIC_ERROR_MESSAGE_BY_ID, locator);
	}

	@Step("get Email Invalid Error Message {0}")
	public String getEmailInvalidErrorMessage(String text) {
		waitForElementVisible(driver, CreateAnAccountPageUI.EMAIL_INVALID_ERROR_MESSAGE);
		return getElelementText(driver, CreateAnAccountPageUI.EMAIL_INVALID_ERROR_MESSAGE);
	}

	@Step("get Password Invalid Error Message {0}")
	public String getPasswordInvalidErrorMessage(String text) {
		waitForElementVisible(driver, CreateAnAccountPageUI.PASSWORD_INVALID_ERROR_MESSAGE);
		return getElelementText(driver, CreateAnAccountPageUI.PASSWORD_INVALID_ERROR_MESSAGE);
	}

	@Step("get Confirm Password Invalid Error Message {0}")
	public String getConfirmPasswordInvalidErrorMessage(String text) {
		waitForElementVisible(driver, CreateAnAccountPageUI.COMFIRMPASSWORD_INVALID_ERROR_MESSAGE);
		return getElelementText(driver, CreateAnAccountPageUI.COMFIRMPASSWORD_INVALID_ERROR_MESSAGE);
	}

	@Step("click To Register Button {0}")
	public MyDashboardPageObject clickToRegisterButton() {
		waitForElementClickable(driver, CreateAnAccountPageUI.REGISTER_BUTTON);
		clickToElement(driver, CreateAnAccountPageUI.REGISTER_BUTTON);
		return PageGeneratorManager.getMyDashboradPage(driver);
	}

	@Step("is Existing Email Error Message Displayed {0}")
	public boolean isExistingEmailErrorMessageDisplayed() {
		waitForElementVisible(driver, CreateAnAccountPageUI.EXISTING_EMAIL_ERROR_MESSAGE);
		return isElementDisPlayedInDom(driver, CreateAnAccountPageUI.EXISTING_EMAIL_ERROR_MESSAGE);
	}

}
