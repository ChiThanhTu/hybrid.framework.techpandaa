package pageObject.navigation;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import io.qameta.allure.Step;
import pageObject.user.AccountInformationPageObject;
import pageObject.user.BillingAgreementsPageObject;
import pageObject.user.MyApplicationPageObject;
import pageObject.user.MyDashboardPageObject;
import pageObject.user.MyDownloadableProductsPageObject;
import pageObject.user.MyOrderPageObject;
import pageObject.user.MyProductReviewPageObject;
import pageObject.user.MyWishlistPageObject;
import pageObject.user.NewsletterSubscriptionPageObject;
import pageObject.user.RecurringProfilesPageObject;
import pageUI.user.SideBarMyAccountPageUI;

public class SideBarMyAccountPageObject extends BasePage {
	WebDriver driver;

	public SideBarMyAccountPageObject(WebDriver driver) {
		this.driver = driver;
	}

	@Step("Open My Product Review Page")
	public MyProductReviewPageObject openMyProductReviewPage() {
		waitForElementClickable(driver, SideBarMyAccountPageUI.MY_PRODUCT_REVIEWS);
		clickToElement(driver, SideBarMyAccountPageUI.MY_PRODUCT_REVIEWS);
		return PageGeneratorManager.getMyProductReviewPage(driver);
	}

	@Step("Open My Application Page")
	public MyApplicationPageObject openMyApplicationPage() {
		waitForElementClickable(driver, SideBarMyAccountPageUI.MY_APPLICATION_LINK);
		clickToElement(driver, SideBarMyAccountPageUI.MY_APPLICATION_LINK);
		return PageGeneratorManager.getMyApplicationPage(driver);
	}

	@Step("Open Account Information Page")
	public AccountInformationPageObject openAccountInformationPage() {
		waitForElementClickable(driver, SideBarMyAccountPageUI.ACCOUNT_INFORMATION_LINK);
		clickToElement(driver, SideBarMyAccountPageUI.ACCOUNT_INFORMATION_LINK);
		return PageGeneratorManager.getAccountInformationPage(driver);
	}

	@Step("Open My Order Page")
	public MyOrderPageObject openMyOrderPage() {
		waitForElementClickable(driver, SideBarMyAccountPageUI.MYORDER_LINK);
		clickToElement(driver, SideBarMyAccountPageUI.MYORDER_LINK);
		return PageGeneratorManager.getMyOrderPage(driver);
	}

	@Step("Open My Dashboard Page")
	public MyDashboardPageObject openMyDashboardPage() {
		waitForElementClickable(driver, SideBarMyAccountPageUI.MY_DASHBOARD_LINK);
		clickToElement(driver, SideBarMyAccountPageUI.MY_DASHBOARD_LINK);
		return PageGeneratorManager.getMyDashboradPage(driver);
	}

	@Step("Open Billing Agreements Page")
	public BillingAgreementsPageObject openBillingAgreementsPage() {
		waitForElementClickable(driver, SideBarMyAccountPageUI.BILLING_AGREEMENTS_LINK);
		clickToElement(driver, SideBarMyAccountPageUI.BILLING_AGREEMENTS_LINK);
		return PageGeneratorManager.getBillingAgreementsPage(driver);
	}

	@Step("Open Recurring Profiles Page")
	public RecurringProfilesPageObject openRecurringProfilesPage() {
		waitForElementClickable(driver, SideBarMyAccountPageUI.RECURRING_PROFILES_LINK);
		clickToElement(driver, SideBarMyAccountPageUI.RECURRING_PROFILES_LINK);
		return PageGeneratorManager.getRecurringProfilesPage(driver);
	}

	@Step("Open My Wishlist Page")
	public MyWishlistPageObject openMyWishlistPage() {
		waitForElementClickable(driver, SideBarMyAccountPageUI.MY_WISHLIST_LINK);
		clickToElement(driver, SideBarMyAccountPageUI.MY_WISHLIST_LINK);
		return PageGeneratorManager.getMyWishlistPage(driver);
	}

	@Step("Open Newsletter Subscription Page")
	public NewsletterSubscriptionPageObject openNewsletterSubscriptionPage() {
		waitForElementClickable(driver, SideBarMyAccountPageUI.NEWSLETTER_SUBSCRIPTION_LINK);
		clickToElement(driver, SideBarMyAccountPageUI.NEWSLETTER_SUBSCRIPTION_LINK);
		return PageGeneratorManager.getNewsletterSubscriptionPage(driver);
	}

	@Step("Open My Downloadable Products Page")
	public MyDownloadableProductsPageObject openMyDownloadableProductsPage() {
		waitForElementClickable(driver, SideBarMyAccountPageUI.MY_DOWNLOADABLE_PRODUCTS_LINK);
		clickToElement(driver, SideBarMyAccountPageUI.MY_DOWNLOADABLE_PRODUCTS_LINK);
		return PageGeneratorManager.getMyDownloadableProductsPage(driver);
	}

	public SideBarMyAccountPageObject openSideBarLinkByPageNames(String pageName) {
		waitForElementClickable(driver, SideBarMyAccountPageUI.DYNAMIC_SIDE_BAR_LINK, pageName);
		clickToElement(driver, SideBarMyAccountPageUI.DYNAMIC_SIDE_BAR_LINK, pageName);
		if (pageName.equals("My Product Reviews")) {
			return PageGeneratorManager.getMyProductReviewPage(driver);
		} else if (pageName.equals("My Orders")) {
			return PageGeneratorManager.getMyOrderPage(driver);
		} else if (pageName.equals("My Applications")) {
			return PageGeneratorManager.getMyApplicationPage(driver);
		} else if (pageName.equals("Account Information")) {
			return PageGeneratorManager.getAccountInformationPage(driver);
		} else if (pageName.equals("Account Dashboard")) {
			return PageGeneratorManager.getMyDashboradPage(driver);
		} else
			return null;
	}

	public void openSideBarLinkByPageName(String pageName) {
		waitForElementClickable(driver, SideBarMyAccountPageUI.DYNAMIC_SIDE_BAR_LINK, pageName);
		clickToElement(driver, SideBarMyAccountPageUI.DYNAMIC_SIDE_BAR_LINK, pageName);

	}
}
