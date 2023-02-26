package pageObject.user;

import org.openqa.selenium.WebDriver;

import io.qameta.allure.Step;
import pageObject.navigation.FooterContainerPageObject;
import pageUI.user.AboutUsPageUI;

public class AboutUsPageObject extends FooterContainerPageObject {
	WebDriver driver;

	public AboutUsPageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	@Step("get Title About Us {0}")
	public String getTitleAboutUs() {
		waitForElementVisible(driver, AboutUsPageUI.TITLE_ABOUT_US);
		return getElelementText(driver, AboutUsPageUI.TITLE_ABOUT_US);
	}

}
