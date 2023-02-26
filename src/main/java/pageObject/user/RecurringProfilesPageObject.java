package pageObject.user;

import org.openqa.selenium.WebDriver;

import io.qameta.allure.Step;
import pageObject.navigation.SideBarMyAccountPageObject;
import pageUI.user.RecurringProfilesPageUI;

public class RecurringProfilesPageObject extends SideBarMyAccountPageObject {
	WebDriver driver;

	public RecurringProfilesPageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	@Step("get Message In Recurring Profiles {0}")
	public String getMessageInRecurringProfiles() {
		waitForElementVisible(driver, RecurringProfilesPageUI.MESSAGE_IN_RECURRING_PROFILES);
		return getElelementText(driver, RecurringProfilesPageUI.MESSAGE_IN_RECURRING_PROFILES);
	}
}
