package pageObject.navigation;

import org.openqa.selenium.WebDriver;

import pageObject.admin.AdminAllReviewsPageObject;
import pageObject.admin.AdminLoginPageObject;
import pageObject.admin.AdminManageCustomerPageObject;
import pageObject.admin.AdminOrdersPageObject;
import pageObject.user.AboutUsPageObject;
import pageObject.user.AccountInformationPageObject;
import pageObject.user.AddressBookPageObject;
import pageObject.user.AdvanceSearchPageObject;
import pageObject.user.BillingAgreementsPageObject;
import pageObject.user.ContactUsPageObject;
import pageObject.user.CreateAnAccountPageObject;
import pageObject.user.CustomerServicePageObject;
import pageObject.user.MyAccountPageObject;
import pageObject.user.MyApplicationPageObject;
import pageObject.user.MyDashboardPageObject;
import pageObject.user.MyDownloadableProductsPageObject;
import pageObject.user.MyOrderPageObject;
import pageObject.user.MyProductReviewPageObject;
import pageObject.user.MyWishlistPageObject;
import pageObject.user.NewsletterSubscriptionPageObject;
import pageObject.user.RecurringProfilesPageObject;
import pageObject.user.SearchTermsPageObject;
import pageObject.user.SiteMapPageObject;
import pageObject.user.UserHomePageObject;
import pageObject.user.UserLoginPageObject;

public class PageGeneratorManager {
	public static UserHomePageObject getUserHomePage(WebDriver driver) {
		return new UserHomePageObject(driver);
	}

	public static UserLoginPageObject getUserLoginPage(WebDriver driver) {
		return new UserLoginPageObject(driver);
	}

	public static MyDashboardPageObject getMyDashboradPage(WebDriver driver) {
		return new MyDashboardPageObject(driver);
	}

	public static AccountInformationPageObject getAccountInformationPage(WebDriver driver) {
		return new AccountInformationPageObject(driver);
	}

	public static MyApplicationPageObject getMyApplicationPage(WebDriver driver) {
		return new MyApplicationPageObject(driver);
	}

	public static BillingAgreementsPageObject getBillingAgreementsPage(WebDriver driver) {
		return new BillingAgreementsPageObject(driver);
	}

	public static MyOrderPageObject getMyOrderPage(WebDriver driver) {
		return new MyOrderPageObject(driver);
	}

	public static MyProductReviewPageObject getMyProductReviewPage(WebDriver driver) {
		return new MyProductReviewPageObject(driver);
	}

	public static AboutUsPageObject getAboutUsPageObject(WebDriver driver) {
		return new AboutUsPageObject(driver);
	}

	public static SearchTermsPageObject getSearchTermsPage(WebDriver driver) {
		return new SearchTermsPageObject(driver);
	}

	public static MyAccountPageObject getMyAccountPage(WebDriver driver) {
		return new MyAccountPageObject(driver);
	}

	public static AddressBookPageObject getAddressBookPage(WebDriver driver) {
		return new AddressBookPageObject(driver);
	}

	public static RecurringProfilesPageObject getRecurringProfilesPage(WebDriver driver) {
		return new RecurringProfilesPageObject(driver);
	}

	public static MyWishlistPageObject getMyWishlistPage(WebDriver driver) {
		return new MyWishlistPageObject(driver);
	}

	public static NewsletterSubscriptionPageObject getNewsletterSubscriptionPage(WebDriver driver) {
		return new NewsletterSubscriptionPageObject(driver);
	}

	public static MyDownloadableProductsPageObject getMyDownloadableProductsPage(WebDriver driver) {
		return new MyDownloadableProductsPageObject(driver);
	}

	public static SiteMapPageObject getSiteMapPage(WebDriver driver) {
		return new SiteMapPageObject(driver);
	}

	public static AdvanceSearchPageObject getAdvanceSearchPage(WebDriver driver) {
		return new AdvanceSearchPageObject(driver);
	}

	public static CustomerServicePageObject getCustomerServicePage(WebDriver driver) {
		return new CustomerServicePageObject(driver);
	}

	public static ContactUsPageObject getContactUsPage(WebDriver driver) {
		return new ContactUsPageObject(driver);
	}
	public static CreateAnAccountPageObject getCreateAnAccountPage(WebDriver driver) {
		return new CreateAnAccountPageObject(driver);
	}
	public static AdminLoginPageObject getAdminLoginPage(WebDriver driver) {
		return new AdminLoginPageObject(driver);
	}
	//
	public static AdminManageCustomerPageObject getAdminManageCustomerPage(WebDriver driver) {
		return new AdminManageCustomerPageObject(driver);
	}
	public static AdminOrdersPageObject getAdminSalesOrderPage(WebDriver driver) {
		return new AdminOrdersPageObject(driver);
	}
	public static AdminAllReviewsPageObject getAdminAllReviewsPage(WebDriver driver) {
		return new AdminAllReviewsPageObject(driver);
	}
	
	}
