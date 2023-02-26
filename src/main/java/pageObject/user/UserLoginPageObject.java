package pageObject.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import io.qameta.allure.Step;
import pageObject.navigation.PageGeneratorManager;
import pageUI.user.UserLoginPageUI;

public class UserLoginPageObject extends BasePage{
	WebDriver driver;
	public UserLoginPageObject (WebDriver driver) {
		this.driver=driver;
	}
	@Step("enter email adddress textbox {0}")
	public void inputToEmailAddressTextbox(String email) {
		waitForElementVisible(driver, UserLoginPageUI.EMAIL_ADDRESS_TEXTBOX);
		sendkeyToElement(driver, UserLoginPageUI.EMAIL_ADDRESS_TEXTBOX, email);
	}
	@Step("enter password textbox {0}")
	public void inputToPasswordTextbox(String password) {
		waitForElementVisible(driver, UserLoginPageUI.PASSWORD_TEXTBOX);
		sendkeyToElement(driver, UserLoginPageUI.PASSWORD_TEXTBOX, password);
	}
	@Step("click login button {0}")
	public MyDashboardPageObject clickToLoginButton() {
		waitForElementClickable(driver, UserLoginPageUI.LOGIN_BUTTON);
		clickToElement(driver, UserLoginPageUI.LOGIN_BUTTON);
		return PageGeneratorManager.getMyDashboradPage(driver);
	}
	@Step("get Email Address Empty Error Message {0}")
	public String getEmailAddressEmptyErrorMessage() {
		waitForElementVisible(driver, UserLoginPageUI.EMAIL_ADDRESS_ERROR_MESSAGE);
		return getElelementText(driver, UserLoginPageUI.EMAIL_ADDRESS_ERROR_MESSAGE);
	}
	@Step("get Password Empty Error Message {0}")
	public String getPasswordEmptyErrorMessage() {
		waitForElementVisible(driver, UserLoginPageUI.PASSWORD_ERROR_MESSAGE);
		return getElelementText(driver, UserLoginPageUI.PASSWORD_ERROR_MESSAGE);
	}
	@Step("get Email Address Invalid ErrorMessage {0}")
	public String getEmailAddressInvalidErrorMessage() {
		waitForElementVisible(driver, UserLoginPageUI.EMAIL_ADDRESS_INVALID_ERROR_MESSGE);
		return getElelementText(driver, UserLoginPageUI.EMAIL_ADDRESS_INVALID_ERROR_MESSGE);
	}
	@Step("get Email Address Password Incorrect Message {0}")
	public String getEmailAddressPasswordIncorrectMessage() {
		waitForElementVisible(driver, UserLoginPageUI.EMAIL_ADDRESS_PASSWORD_INCORRECT_ERROR_MESSAGE);
		return getElelementText(driver, UserLoginPageUI.EMAIL_ADDRESS_PASSWORD_INCORRECT_ERROR_MESSAGE);
	}
	@Step("get Password Invalid ErrorMessage {0}")
	public String getPasswordInvalidErrorMessage() {
		waitForElementVisible(driver, UserLoginPageUI.PASSWORD_INVALID_ERROR_MESSGE);
		return getElelementText(driver, UserLoginPageUI.PASSWORD_INVALID_ERROR_MESSGE);
	}
	@Step("click To Create An Account Link {0}")
	public CreateAnAccountPageObject clickToCreateAnAccountLink() {
		waitForElementClickable(driver, UserLoginPageUI.CREATE_AN_ACCOUNT_LINK);
		clickToElement(driver, UserLoginPageUI.CREATE_AN_ACCOUNT_LINK);
		return PageGeneratorManager.getCreateAnAccountPage(driver);
	}
	
}
