package pageObject.user;

import org.openqa.selenium.WebDriver;

import pageObject.navigation.SideBarMyAccountPageObject;
import pageUI.user.BillingArgreementsPageUI;

public class BillingAgreementsPageObject extends SideBarMyAccountPageObject {
	WebDriver driver;

	public BillingAgreementsPageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
}
	public String getMessageInBillingAgreementsPage() {
		waitForElementVisible(driver, BillingArgreementsPageUI.MESSAGE_IN_BILLING_AGREEMENTS);
		return getElelementText(driver, BillingArgreementsPageUI.MESSAGE_IN_BILLING_AGREEMENTS);
	}
}