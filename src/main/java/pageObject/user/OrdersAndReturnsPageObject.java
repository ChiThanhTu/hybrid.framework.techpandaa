package pageObject.user;

import org.openqa.selenium.WebDriver;

import pageObject.navigation.FooterContainerPageObject;

public class OrdersAndReturnsPageObject extends FooterContainerPageObject {
	WebDriver driver;

	public OrdersAndReturnsPageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}
}
