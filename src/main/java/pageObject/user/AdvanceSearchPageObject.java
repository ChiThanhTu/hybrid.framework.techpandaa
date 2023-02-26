package pageObject.user;

import org.openqa.selenium.WebDriver;

import io.qameta.allure.Step;
import pageObject.navigation.FooterContainerPageObject;
import pageUI.user.AdvanceSearchPageUI;
import pageUI.user.SearchTermsPageUI;

public class AdvanceSearchPageObject extends FooterContainerPageObject {
	WebDriver driver;

	public AdvanceSearchPageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	@Step("input To Name TextBox {0}")
	public void inputToNameTextBox(String name) {
		waitForElementVisible(driver, AdvanceSearchPageUI.NAME_TEXTBOX);
		sendkeyToElement(driver, AdvanceSearchPageUI.NAME_TEXTBOX, name);

	}

	@Step("input To Price TextBox {0}")
	public void inputToPriceTextBox(String pricelow, String pricehigh) {
		waitForElementVisible(driver, AdvanceSearchPageUI.PRICE_TEXTBOX);
		sendkeyToElement(driver, AdvanceSearchPageUI.PRICE_TEXTBOX, pricelow);
		waitForElementVisible(driver, AdvanceSearchPageUI.PRICE_TO_TEXTBOX);
		sendkeyToElement(driver, AdvanceSearchPageUI.PRICE_TO_TEXTBOX, pricehigh);
	}

	@Step("click To Search {0}")
	public void clickToSearch() {
		waitForElementClickable(driver, AdvanceSearchPageUI.SEARCH_BUTTON);
		clickToElement(driver, AdvanceSearchPageUI.SEARCH_BUTTON);
	}

	@Step("get Name Item {0}")
	public String getNameItem(String name, String name2) {
		waitForElementVisible(driver, AdvanceSearchPageUI.DYNAMIC_ITEM_NAME, name, name2);
		return getElelementText(driver, AdvanceSearchPageUI.DYNAMIC_ITEM_NAME, name, name2);
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

}
