package pageObject.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import io.qameta.allure.Step;
import pageObject.navigation.PageGeneratorManager;
import pageUI.user.SiteMapPageUI;

public class SiteMapPageObject extends BasePage {
	WebDriver driver;

	public SiteMapPageObject(WebDriver driver) {

		this.driver = driver;
	}

	@Step("click To Moblie {0}")
	public void clickToMoblie() {
		waitForElementClickable(driver, SiteMapPageUI.MOBLIE_LINK);
		clickToElement(driver, SiteMapPageUI.MOBLIE_LINK);
	}

	@Step("get Message In Moblie Page {0}")
	public String getMessageInMobliePage() {
		waitForElementVisible(driver, SiteMapPageUI.MESSAGE_IN_MOBLIE);
		return getElelementText(driver, SiteMapPageUI.MESSAGE_IN_MOBLIE);
	}

	@Step("is Picture Displayed {0}")
	public boolean isPictureDisplayed(String picture) {
		waitForElementVisible(driver, SiteMapPageUI.DYNAMIC_PICTURE, picture);
		return isElementDisPlayedInDom(driver, SiteMapPageUI.DYNAMIC_PICTURE, picture);
	}

	@Step("get Price {0}")
	public String getPrice(String price) {
		waitForElementVisible(driver, SiteMapPageUI.DYNAMIC_PRICE, price);
		return getElelementText(driver, SiteMapPageUI.DYNAMIC_PRICE, price);
	}

	@Step("is Add to Cart Displayed {0}")
	public boolean isAddtoCartDisplayed(String name) {
		waitForElementVisible(driver, SiteMapPageUI.DYNAMIC_ADD_TO_CART_BUTTON, name);
		return isElementDisPlayedInDom(driver, SiteMapPageUI.DYNAMIC_ADD_TO_CART_BUTTON, name);
	}

	@Step("click To Add To Cart {0}")
	public void clickToAddToCart(String name) {
		waitForElementClickable(driver, SiteMapPageUI.DYNAMIC_ADD_TO_CART_BUTTON, name);
		clickToElement(driver, SiteMapPageUI.DYNAMIC_ADD_TO_CART_BUTTON, name);
	}

	@Step("enter Shipping Infor {0}")
	public void enterShippingInfor() {
		waitForElementClickable(driver, SiteMapPageUI.COUNTRY_SELECT);
		selectItemInDefaultDropdown(driver, SiteMapPageUI.COUNTRY_SELECT, "Vietnam");
		waitForElementVisible(driver, SiteMapPageUI.STATE_PROVINCE_INPUT);
		sendkeyToElement(driver, SiteMapPageUI.STATE_PROVINCE_INPUT, "TP.HCM");
		waitForElementVisible(driver, SiteMapPageUI.ZIP_INPUT);
		sendkeyToElement(driver, SiteMapPageUI.ZIP_INPUT, "700000");
	}

	@Step("click To Proceed To Checkout {0}")
	public void clickToProceedToCheckout() {
		waitForElementClickable(driver, SiteMapPageUI.PROCEED_TO_CHECKOUT_BUTTON);
		clickToElement(driver, SiteMapPageUI.PROCEED_TO_CHECKOUT_BUTTON);
	}

	@Step("check Out {0}")
	public void checkOut() {
		waitForElementClickable(driver, SiteMapPageUI.CONTINUE_BILLING_INFORMATION_BUTTON);
		clickToElement(driver, SiteMapPageUI.CONTINUE_BILLING_INFORMATION_BUTTON);
		checkToCheckboxOrRadio(driver, SiteMapPageUI.SHIP_TO_THIS_ADDRESS);
		waitForElementClickable(driver, SiteMapPageUI.CONTINUE_SHIPPING_METHOD_BUTTON);
		clickToElement(driver, SiteMapPageUI.CONTINUE_SHIPPING_METHOD_BUTTON);
		waitForElementClickable(driver, SiteMapPageUI.MONEY_ORDER_RADIO);
		checkToCheckboxOrRadio(driver, SiteMapPageUI.MONEY_ORDER_RADIO);
		waitForElementClickable(driver, SiteMapPageUI.CONTINUE_PAYMENT_INFORMATION_BUTTON);
		clickToElement(driver, SiteMapPageUI.CONTINUE_PAYMENT_INFORMATION_BUTTON);
		waitForElementClickable(driver, SiteMapPageUI.PLACE_ORDER_BUTTON);
		clickToElement(driver, SiteMapPageUI.PLACE_ORDER_BUTTON);

	}

	@Step("click To TV {0}")
	public void clickToTV() {
		waitForElementClickable(driver, SiteMapPageUI.TV_LINK);
		clickToElement(driver, SiteMapPageUI.TV_LINK);
	}

	@Step("click To Continue {0}")
	public UserHomePageObject clickToContinue() {
		waitForElementClickable(driver, SiteMapPageUI.CONTINUE_BUTTON);
		clickToElement(driver, SiteMapPageUI.CONTINUE_BUTTON);
		return PageGeneratorManager.getUserHomePage(driver);
	}

}
