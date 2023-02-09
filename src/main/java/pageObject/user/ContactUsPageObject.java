package pageObject.user;

import org.openqa.selenium.WebDriver;

import pageObject.navigation.FooterContainerPageObject;
import pageUI.user.ContactUsPageUI;

public class ContactUsPageObject extends FooterContainerPageObject {
	WebDriver driver;
	public ContactUsPageObject(WebDriver driver) {
		super(driver);
		this.driver=driver;
	}
	public void inputDynamicIDTextBox(String id, String text) {
		waitForElementVisible(driver, ContactUsPageUI.DYNAMIC_ID_TEXTBOX, id);
		sendkeyToElement(driver, ContactUsPageUI.DYNAMIC_ID_TEXTBOX, text, id);	
	}
	public void inputCommentTextarea(String text) {
		waitForElementVisible(driver, ContactUsPageUI.COMMENT_TEXTAREA);
		sendkeyToElement(driver, ContactUsPageUI.COMMENT_TEXTAREA, text);	
	}
	public String getDynamicMessage(String name) {
		waitForElementVisible(driver, ContactUsPageUI.DYNAMIC_MESSAGE, name);
		return getElelementText(driver, ContactUsPageUI.DYNAMIC_MESSAGE, name);
	}
	public String getMessageTitle() {
		waitForElementVisible(driver, ContactUsPageUI.MESSAGE_TITLE);
		return getElelementText(driver, ContactUsPageUI.MESSAGE_TITLE);
	}
	public boolean IsMessageNotDisplayed(String name) {
		waitForElementInvisibleIndom(driver, ContactUsPageUI.DYNAMIC_MESSAGE, name);
		return isElementUnDisPlayed(driver, ContactUsPageUI.DYNAMIC_MESSAGE, name);
	}
	public void clickToSubmit() {
		waitForElementClickable(driver, ContactUsPageUI.SUBMIT_BUTTON);
		clickToElement(driver, ContactUsPageUI.SUBMIT_BUTTON);
	}
	public String getErrorMessageEmailDisplayed() {
		waitForElementVisible(driver, ContactUsPageUI.ERROR_MESSAGE_INVALID_EMAIL);
		return getElelementText(driver, ContactUsPageUI.ERROR_MESSAGE_INVALID_EMAIL);
	}
}
