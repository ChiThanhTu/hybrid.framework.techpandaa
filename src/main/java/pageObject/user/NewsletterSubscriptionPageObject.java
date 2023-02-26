package pageObject.user;

import org.openqa.selenium.WebDriver;

import io.qameta.allure.Step;
import pageObject.navigation.PageGeneratorManager;
import pageObject.navigation.SideBarMyAccountPageObject;
import pageUI.user.NewsletterSubscriptionPageUI;

public class NewsletterSubscriptionPageObject extends SideBarMyAccountPageObject {
	WebDriver driver;

	public NewsletterSubscriptionPageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	@Step("check To CheckBox In Newsletter Subcription {0}")
	public void checkToCheckBoxInNewsletterSubcription() {
		waitForElementClickable(driver, NewsletterSubscriptionPageUI.GENERAL_SUBSCRIPTION_CHECKBOX);
		checkToCheckboxOrRadio(driver, NewsletterSubscriptionPageUI.GENERAL_SUBSCRIPTION_CHECKBOX);
	}

	@Step("click To Save {0}")
	public MyDashboardPageObject clickToSave() {
		waitForElementClickable(driver, NewsletterSubscriptionPageUI.SAVE_BUTTON);
		clickToElement(driver, NewsletterSubscriptionPageUI.SAVE_BUTTON);
		return PageGeneratorManager.getMyDashboradPage(driver);
	}
}
