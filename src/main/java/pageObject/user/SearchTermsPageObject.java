package pageObject.user;

import org.openqa.selenium.WebDriver;

import io.qameta.allure.Step;
import pageObject.navigation.FooterContainerPageObject;
import pageUI.user.SearchTermsPageUI;

public class SearchTermsPageObject extends FooterContainerPageObject {
	WebDriver driver;

	public SearchTermsPageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	@Step("Click To Popular Search Terms {0}")
	public void ClickToPopularSearchTerms(String terms) {
		waitForElementClickable(driver, SearchTermsPageUI.DYNAMIC_POLULAR_SEARCH_TERMS, terms);
		clickToElement(driver, SearchTermsPageUI.DYNAMIC_POLULAR_SEARCH_TERMS, terms);
	}

	@Step("is Picture Displayed {0}")
	public boolean isPictureDisplayed(String picture) {
		waitForElementVisible(driver, SearchTermsPageUI.DYNAMIC_PICTURE, picture);
		return isElementDisPlayedInDom(driver, SearchTermsPageUI.DYNAMIC_PICTURE, picture);
	}

	@Step("get Price {0}")
	public String getPrice(String price) {
		waitForElementVisible(driver, SearchTermsPageUI.DYNAMIC_PRICE, price);
		return getElelementText(driver, SearchTermsPageUI.DYNAMIC_PRICE, price);
	}

	@Step("is Add to Cart Displayed {0}")
	public boolean isAddtoCartDisplayed(String name) {
		waitForElementVisible(driver, SearchTermsPageUI.DYNAMIC_ADD_TO_CART_BUTTON, name);
		return isElementDisPlayedInDom(driver, SearchTermsPageUI.DYNAMIC_ADD_TO_CART_BUTTON, name);
	}

	@Step("get Message Title {0}")
	public String getMessageTitle() {
		waitForElementVisible(driver, SearchTermsPageUI.MESSAGE_SEARCH_TERMS);
		return getElelementText(driver, SearchTermsPageUI.MESSAGE_SEARCH_TERMS);
	}
}
