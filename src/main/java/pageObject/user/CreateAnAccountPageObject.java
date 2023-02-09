package pageObject.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageObject.navigation.PageGeneratorManager;
import pageUI.user.CreateAnAccountPageUI;

public class CreateAnAccountPageObject extends BasePage{
	WebDriver driver;
	public CreateAnAccountPageObject(WebDriver driver) {
		this.driver=driver;
	}
	public void inputDynamicTextboxById(String locator, String text) {
		waitForElementVisible(driver, CreateAnAccountPageUI.DYNAMIC_TEXTBOX_BY_ID, locator);
		sendkeyToElement(driver, CreateAnAccountPageUI.DYNAMIC_TEXTBOX_BY_ID, text, locator);
	}
	public void clickToSignUpForNewsletterCheckbox() {
	waitForElementClickable(driver, CreateAnAccountPageUI.SIGN_UP_NEWSLETTER_CHECKBOX);
	checkToCheckboxOrRadio(driver, CreateAnAccountPageUI.SIGN_UP_NEWSLETTER_CHECKBOX);
	}
	public String getDynamicErrorMessageById(String locator) {
		waitForElementVisible(driver, CreateAnAccountPageUI.DYNAMIC_ERROR_MESSAGE_BY_ID, locator);
		return getElelementText(driver, CreateAnAccountPageUI.DYNAMIC_ERROR_MESSAGE_BY_ID, locator);
	}
	public String getEmailInvalidErrorMessage(String text) {
		waitForElementVisible(driver, CreateAnAccountPageUI.EMAIL_INVALID_ERROR_MESSAGE);
		return getElelementText(driver, CreateAnAccountPageUI.EMAIL_INVALID_ERROR_MESSAGE);
	}
	public String getPasswordInvalidErrorMessage(String text) {
		waitForElementVisible(driver, CreateAnAccountPageUI.PASSWORD_INVALID_ERROR_MESSAGE);
		return getElelementText(driver, CreateAnAccountPageUI.PASSWORD_INVALID_ERROR_MESSAGE);
	}
	public String getConfirmPasswordInvalidErrorMessage(String text) {
		waitForElementVisible(driver, CreateAnAccountPageUI.COMFIRMPASSWORD_INVALID_ERROR_MESSAGE);
		return getElelementText(driver, CreateAnAccountPageUI.COMFIRMPASSWORD_INVALID_ERROR_MESSAGE);
	}
	public MyDashboardPageObject clickToRegisterButton() {
		waitForElementClickable(driver, CreateAnAccountPageUI.REGISTER_BUTTON);
		clickToElement(driver, CreateAnAccountPageUI.REGISTER_BUTTON);
		return PageGeneratorManager.getMyDashboradPage(driver);
	}
	public boolean isExistingEmailErrorMessageDisplayed() {
		waitForElementVisible(driver, CreateAnAccountPageUI.EXISTING_EMAIL_ERROR_MESSAGE);
		return isElementDisPlayedInDom(driver, CreateAnAccountPageUI.EXISTING_EMAIL_ERROR_MESSAGE);
	}

}
