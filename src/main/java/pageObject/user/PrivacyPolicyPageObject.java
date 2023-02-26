package pageObject.user;

import org.openqa.selenium.WebDriver;

import pageObject.navigation.FooterContainerPageObject;

public class PrivacyPolicyPageObject extends FooterContainerPageObject {
	WebDriver driver;

	public PrivacyPolicyPageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}
}
