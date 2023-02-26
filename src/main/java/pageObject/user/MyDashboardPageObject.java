package pageObject.user;

import org.openqa.selenium.WebDriver;

import io.qameta.allure.Step;
import pageObject.navigation.PageGeneratorManager;
import pageObject.navigation.SideBarMyAccountPageObject;
import pageUI.user.MyDashboardPageUI;
import pageUI.user.SideBarMyAccountPageUI;

public class MyDashboardPageObject extends SideBarMyAccountPageObject {
	WebDriver driver;

	public MyDashboardPageObject(WebDriver driver) {
		super(driver);

		this.driver = driver;
	}

	@Step("get Contact Infor Text {0}")
	public boolean getContactInforText(String text) {
		waitForElementVisible(driver, MyDashboardPageUI.CONTACT_INFOR_TEXT);
		String actual = getElelementText(driver, MyDashboardPageUI.CONTACT_INFOR_TEXT);
		return actual.contains(text);
	}

	@Step("Open Account Information Page {0}")
	public AccountInformationPageObject openAccountInformationPage() {
		waitForElementClickable(driver, SideBarMyAccountPageUI.ACCOUNT_INFORMATION_LINK);
		clickToElement(driver, SideBarMyAccountPageUI.ACCOUNT_INFORMATION_LINK);
		return PageGeneratorManager.getAccountInformationPage(driver);
	}

	@Step("is Account Information Message Saved Display {0}")
	public boolean isAccountInformationMessageSavedDisplay() {
		waitForElementVisible(driver, MyDashboardPageUI.SAVE_MESSAGE);
		return isElementDisPlayedInDom(driver, MyDashboardPageUI.SAVE_MESSAGE);
	}

	@Step("Open Address Book Page {0}")
	public AddressBookPageObject clickToAddressBook() {
		waitForElementClickable(driver, SideBarMyAccountPageUI.ADDRESS_BOOK_LINK);
		clickToElement(driver, SideBarMyAccountPageUI.ADDRESS_BOOK_LINK);
		return PageGeneratorManager.getAddressBookPage(driver);
	}

	@Step("is Register Message Save Displayed {0}")
	public boolean isRegisterMessageSaveDisplayed() {
		waitForElementVisible(driver, MyDashboardPageUI.REGISTER_MESSAGE);
		return isElementDisPlayedInDom(driver, MyDashboardPageUI.REGISTER_MESSAGE);
	}
}
