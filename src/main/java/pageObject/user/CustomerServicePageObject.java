package pageObject.user;

import org.openqa.selenium.WebDriver;

import io.qameta.allure.Step;
import pageObject.navigation.FooterContainerPageObject;
import pageUI.user.CustomerServicePageUI;

public class CustomerServicePageObject extends FooterContainerPageObject {
	WebDriver driver;

	public CustomerServicePageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	@Step("get Title Customer Service {0}")
	public String getTitleCustomerService() {
		waitForElementVisible(driver, CustomerServicePageUI.TITLE_CUSTOMER_SERCIE);
		return getElelementText(driver, CustomerServicePageUI.TITLE_CUSTOMER_SERCIE);
	}
}
