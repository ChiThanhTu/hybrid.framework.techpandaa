package pageObject.user;

import org.openqa.selenium.WebDriver;

import io.qameta.allure.Step;
import pageObject.navigation.PageGeneratorManager;
import pageObject.navigation.SideBarMyAccountPageObject;
import pageUI.user.AccountInformationPageUI;

public class AccountInformationPageObject extends SideBarMyAccountPageObject {
	WebDriver driver;

	public AccountInformationPageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	@Step("Enter To First Name Textbox {0}")
	public void inputToFirstNameTextBox(String firstName) {
		waitForElementVisible(driver, AccountInformationPageUI.FIRST_NAME);
		sendkeyToElement(driver, AccountInformationPageUI.FIRST_NAME, firstName);
	}

	@Step("Enter To Last Name Textbox {0}")
	public void inputToLastNameTextBox(String lastName) {
		waitForElementVisible(driver, AccountInformationPageUI.LAST_NAME);
		sendkeyToElement(driver, AccountInformationPageUI.LAST_NAME, lastName);
	}

	@Step("Enter To Email Textbox {0}")
	public void inputToEmailTextBox(String email) {
		waitForElementVisible(driver, AccountInformationPageUI.EMAIL_TEXTBOX);
		sendkeyToElement(driver, AccountInformationPageUI.EMAIL_TEXTBOX, email);
	}

	@Step("Enter To Password Textbox {0}")
	public void inputToPasswordTextBox(String password) {
		waitForElementVisible(driver, AccountInformationPageUI.CURRENT_PASSWORD);
		sendkeyToElement(driver, AccountInformationPageUI.CURRENT_PASSWORD, password);
	}

	@Step("Click To Save Button And Back MyDashboard {0}")
	public MyDashboardPageObject backMyDashboardPage() {
		waitForElementClickable(driver, AccountInformationPageUI.SAVE_BUTTON);
		clickToElement(driver, AccountInformationPageUI.SAVE_BUTTON);
		return PageGeneratorManager.getMyDashboradPage(driver);
	}

	@Step("get Dynamic Error Message {0}")
	public String getDynamicErrorMessage(String locator) {
		waitForElementVisible(driver, AccountInformationPageUI.DYNAMIC_ERROR_MESSAGE, locator);
		return getElelementText(driver, AccountInformationPageUI.DYNAMIC_ERROR_MESSAGE, locator);
	}

	@Step("get Invalid Email Error Message {0}")
	public String getInvalidEmailErrorMessage() {
		waitForElementVisible(driver, AccountInformationPageUI.INVALID_EMAIL_ERROR_MESSAGE);
		return getElelementText(driver, AccountInformationPageUI.INVALID_EMAIL_ERROR_MESSAGE);
	}

	@Step("get Invalid Password Error Message {0}")
	public String getInvalidPasswordErrorMessage() {
		waitForElementVisible(driver, AccountInformationPageUI.INVALID_PASSWORD_ERROR_MESSAGE);
		return getElelementText(driver, AccountInformationPageUI.INVALID_PASSWORD_ERROR_MESSAGE);
	}

}
