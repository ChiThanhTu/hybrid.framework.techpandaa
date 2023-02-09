package pageObject.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageObject.navigation.PageGeneratorManager;
import pageUI.user.SiteMapPageUI;
public class SiteMapPageObject extends BasePage{
	WebDriver driver;
	public SiteMapPageObject(WebDriver driver) {
		
		this.driver=driver;
	}
	public void clickToMoblie() {
		waitForElementClickable(driver, SiteMapPageUI.MOBLIE_LINK);
		clickToElement(driver, SiteMapPageUI.MOBLIE_LINK);
	}
	public String getMessageInMobliePage() {
		waitForElementVisible(driver, SiteMapPageUI.MESSAGE_IN_MOBLIE);
		return getElelementText(driver, SiteMapPageUI.MESSAGE_IN_MOBLIE);
	}
	public boolean isPictureDisplayed(String picture) {
		waitForElementVisible(driver, SiteMapPageUI.DYNAMIC_PICTURE, picture);
		return isElementDisPlayedInDom(driver,SiteMapPageUI.DYNAMIC_PICTURE, picture);
	}
	public String getPrice(String price) {
		waitForElementVisible(driver, SiteMapPageUI.DYNAMIC_PRICE, price);
		return getElelementText(driver, SiteMapPageUI.DYNAMIC_PRICE, price);
	}
	public boolean isAddtoCartDisplayed(String name) {
		waitForElementVisible(driver, SiteMapPageUI.DYNAMIC_ADD_TO_CART_BUTTON, name);
		return isElementDisPlayedInDom(driver, SiteMapPageUI.DYNAMIC_ADD_TO_CART_BUTTON, name);
	}
	public void clickToAddToCart(String name) {
		waitForElementClickable(driver, SiteMapPageUI.DYNAMIC_ADD_TO_CART_BUTTON, name);
		clickToElement(driver, SiteMapPageUI.DYNAMIC_ADD_TO_CART_BUTTON, name);
	}
	public void enterShippingInfor() {
		waitForElementClickable(driver, SiteMapPageUI.COUNTRY_SELECT);
		selectItemInDefaultDropdown(driver, SiteMapPageUI.COUNTRY_SELECT, "Vietnam");
		waitForElementVisible(driver, SiteMapPageUI.STATE_PROVINCE_INPUT);
		sendkeyToElement(driver, SiteMapPageUI.STATE_PROVINCE_INPUT, "TP.HCM");
		waitForElementVisible(driver, SiteMapPageUI.ZIP_INPUT);
		sendkeyToElement(driver, SiteMapPageUI.ZIP_INPUT, "700000");
	}
	public void clickToProceedToCheckout() {
		waitForElementClickable(driver, SiteMapPageUI.PROCEED_TO_CHECKOUT_BUTTON);
		clickToElement(driver, SiteMapPageUI.PROCEED_TO_CHECKOUT_BUTTON);
	}
	public void checkOut() {
		waitForElementClickable(driver, SiteMapPageUI.CONTINUE_BILLING_INFORMATION_BUTTON);
		clickToElement(driver, SiteMapPageUI.CONTINUE_BILLING_INFORMATION_BUTTON);
		waitForElementClickable(driver, SiteMapPageUI.CONTINUE_SHIPPING_METHOD_BUTTON);
		clickToElement(driver, SiteMapPageUI.CONTINUE_SHIPPING_METHOD_BUTTON);
		waitForElementClickable(driver, SiteMapPageUI.MONEY_ORDER_RADIO);
		checkToCheckboxOrRadio(driver, SiteMapPageUI.MONEY_ORDER_RADIO);
		waitForElementClickable(driver, SiteMapPageUI.CONTINUE_PAYMENT_INFORMATION_BUTTON);
		clickToElement(driver, SiteMapPageUI.CONTINUE_PAYMENT_INFORMATION_BUTTON);
		waitForElementClickable(driver, SiteMapPageUI.PLACE_ORDER_BUTTON);
		clickToElement(driver, SiteMapPageUI.PLACE_ORDER_BUTTON);

	}
	public void clickToTV() {
		waitForElementClickable(driver, SiteMapPageUI.TV_LINK);
		clickToElement(driver, SiteMapPageUI.TV_LINK);
	}
	public UserHomePageObject clickToContinue() {
		waitForElementClickable(driver, SiteMapPageUI.CONTINUE_BUTTON);
		clickToElement(driver, SiteMapPageUI.CONTINUE_BUTTON);
		return PageGeneratorManager.getUserHomePage(driver);
	}
	
	
	
	}
