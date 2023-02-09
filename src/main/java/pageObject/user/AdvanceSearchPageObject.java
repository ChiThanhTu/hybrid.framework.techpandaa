package pageObject.user;

import org.openqa.selenium.WebDriver;

import pageObject.navigation.FooterContainerPageObject;
import pageUI.user.AdvanceSearchPageUI;
import pageUI.user.SearchTermsPageUI;

public class AdvanceSearchPageObject extends FooterContainerPageObject {
	WebDriver driver;
	public AdvanceSearchPageObject(WebDriver driver) {
		super(driver);
		this.driver=driver;
	}
	public void inputToNameTextBox(String name) {
		waitForElementVisible(driver, AdvanceSearchPageUI.NAME_TEXTBOX);
		sendkeyToElement(driver, AdvanceSearchPageUI.NAME_TEXTBOX, name);
		
	}
	public void inputToPriceTextBox(String pricelow,String pricehigh) {
		waitForElementVisible(driver, AdvanceSearchPageUI.PRICE_TEXTBOX);
		sendkeyToElement(driver, AdvanceSearchPageUI.PRICE_TEXTBOX, pricelow);
		waitForElementVisible(driver, AdvanceSearchPageUI.PRICE_TO_TEXTBOX);
		sendkeyToElement(driver, AdvanceSearchPageUI.PRICE_TO_TEXTBOX, pricehigh);
	}
	public void clickToSearch() {
		waitForElementClickable(driver, AdvanceSearchPageUI.SEARCH_BUTTON);
		clickToElement(driver, AdvanceSearchPageUI.SEARCH_BUTTON);
	}
	public String getNameItem(String name, String name2) {
		waitForElementVisible(driver, AdvanceSearchPageUI.DYNAMIC_ITEM_NAME, name, name2);
		return getElelementText(driver, AdvanceSearchPageUI.DYNAMIC_ITEM_NAME, name, name2);
	}
	public boolean isPictureDisplayed(String picture) {
		waitForElementVisible(driver, SearchTermsPageUI.DYNAMIC_PICTURE, picture);
		return isElementDisPlayedInDom(driver,SearchTermsPageUI.DYNAMIC_PICTURE, picture);
	}
	public String getPrice(String price) {
		waitForElementVisible(driver, SearchTermsPageUI.DYNAMIC_PRICE, price);
		return getElelementText(driver, SearchTermsPageUI.DYNAMIC_PRICE, price);
	}

}
