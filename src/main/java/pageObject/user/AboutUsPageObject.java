package pageObject.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageObject.navigation.FooterContainerPageObject;
import pageUI.user.AboutUsPageUI;

public class AboutUsPageObject extends FooterContainerPageObject {
	WebDriver driver;

	public AboutUsPageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
}

	public String getTitleAboutUs() {
		waitForElementVisible(driver, AboutUsPageUI.TITLE_ABOUT_US);
		return getElelementText(driver, AboutUsPageUI.TITLE_ABOUT_US);
	}

	}
