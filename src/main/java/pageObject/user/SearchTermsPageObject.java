package pageObject.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageObject.navigation.FooterContainerPageObject;
import pageUI.user.SearchTermsPageUI;
import pageUI.user.SiteMapPageUI;

public class SearchTermsPageObject extends FooterContainerPageObject {
	WebDriver driver;
	public SearchTermsPageObject(WebDriver driver) {
		super(driver);
		this.driver=driver;
	}
	
	public void ClickToPopularSearchTerms(String terms) {
		waitForElementClickable(driver, SearchTermsPageUI.DYNAMIC_POLULAR_SEARCH_TERMS, terms);
		clickToElement(driver, SearchTermsPageUI.DYNAMIC_POLULAR_SEARCH_TERMS, terms);
	}

	public boolean isPictureDisplayed(String picture) {
		waitForElementVisible(driver, SearchTermsPageUI.DYNAMIC_PICTURE, picture);
		return isElementDisPlayedInDom(driver,SearchTermsPageUI.DYNAMIC_PICTURE, picture);
	}

	public String getPrice(String price) {
		waitForElementVisible(driver, SearchTermsPageUI.DYNAMIC_PRICE, price);
		return getElelementText(driver, SearchTermsPageUI.DYNAMIC_PRICE, price);
	}

	public boolean isAddtoCartDisplayed(String name) {
		waitForElementVisible(driver, SearchTermsPageUI.DYNAMIC_ADD_TO_CART_BUTTON, name);
		return isElementDisPlayedInDom(driver, SearchTermsPageUI.DYNAMIC_ADD_TO_CART_BUTTON, name);
	}

	public String getMessageTitle() {
		waitForElementVisible(driver, SearchTermsPageUI.MESSAGE_SEARCH_TERMS);
		return getElelementText(driver, SearchTermsPageUI.MESSAGE_SEARCH_TERMS);
	}
}
