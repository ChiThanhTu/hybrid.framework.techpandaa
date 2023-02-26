package pageObject.navigation;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import io.qameta.allure.Step;
import pageObject.user.AboutUsPageObject;
import pageObject.user.AdvanceSearchPageObject;
import pageObject.user.ContactUsPageObject;
import pageObject.user.CustomerServicePageObject;
import pageObject.user.MyAccountPageObject;
import pageObject.user.SearchTermsPageObject;
import pageObject.user.SiteMapPageObject;
import pageObject.user.UserLoginPageObject;
import pageUI.user.FooterContainerPageUI;

public class FooterContainerPageObject extends BasePage {
	WebDriver driver;

	public FooterContainerPageObject(WebDriver driver) {
		this.driver = driver;
	}

	@Step("Open About Us Page")
	public AboutUsPageObject OpenAboutUsPage() {
		waitForElementClickable(driver, FooterContainerPageUI.ABOUT_US_LINK);
		clickToElement(driver, FooterContainerPageUI.ABOUT_US_LINK);
		return PageGeneratorManager.getAboutUsPageObject(driver);
	}

	@Step("Open Search Terms Page")
	public SearchTermsPageObject OpenSearchTermsPage() {
		waitForElementClickable(driver, FooterContainerPageUI.SEARCH_TERMS_LINK);
		clickToElement(driver, FooterContainerPageUI.SEARCH_TERMS_LINK);
		return PageGeneratorManager.getSearchTermsPage(driver);
	}

	@Step("Open My Account Page")
	public MyAccountPageObject OpenMyAccountPageLogged() {
		waitForElementClickable(driver, FooterContainerPageUI.MY_ACCOUNT_LINK);
		clickToElement(driver, FooterContainerPageUI.MY_ACCOUNT_LINK);
		return PageGeneratorManager.getMyAccountPage(driver);
	}

	@Step("Open User Login Page")
	public UserLoginPageObject OpenMyAccountPageNotLogged() {
		waitForElementClickable(driver, FooterContainerPageUI.MY_ACCOUNT_LINK);
		clickToElement(driver, FooterContainerPageUI.MY_ACCOUNT_LINK);
		return PageGeneratorManager.getUserLoginPage(driver);
	}

	@Step("Open About Us Page")
	public SiteMapPageObject OpenSiteMapPage() {
		waitForElementClickable(driver, FooterContainerPageUI.SITE_MAP_LINK);
		clickToElement(driver, FooterContainerPageUI.SITE_MAP_LINK);
		return PageGeneratorManager.getSiteMapPage(driver);
	}

	@Step("Open Advance Search Page")
	public AdvanceSearchPageObject OpenAdvanceSearchPage() {
		waitForElementClickable(driver, FooterContainerPageUI.ADVANCED_SEARCH_LINK);
		clickToElement(driver, FooterContainerPageUI.ADVANCED_SEARCH_LINK);
		return PageGeneratorManager.getAdvanceSearchPage(driver);
	}

	@Step("Open Customer Service Page")
	public CustomerServicePageObject OpenCustomerServicePage() {
		waitForElementClickable(driver, FooterContainerPageUI.CUSTOMER_SERVICE_LINK);
		clickToElement(driver, FooterContainerPageUI.CUSTOMER_SERVICE_LINK);
		return PageGeneratorManager.getCustomerServicePage(driver);
	}

	@Step("Open Customer Service Page")
	public ContactUsPageObject OpenContactUsPage() {
		waitForElementClickable(driver, FooterContainerPageUI.CONTACT_US_LINK);
		clickToElement(driver, FooterContainerPageUI.CONTACT_US_LINK);
		return PageGeneratorManager.getContactUsPage(driver);
	}

}
