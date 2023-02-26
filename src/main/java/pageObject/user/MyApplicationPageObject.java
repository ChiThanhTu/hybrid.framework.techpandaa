package pageObject.user;

import org.openqa.selenium.WebDriver;

import io.qameta.allure.Step;
import pageObject.navigation.SideBarMyAccountPageObject;
import pageUI.user.MyApplicationPageUI;

public class MyApplicationPageObject extends SideBarMyAccountPageObject {
	WebDriver driver;

	public MyApplicationPageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	@Step("get Message In My Application Page {0}")
	public String getMessageInMyApplicationPage() {
		waitForElementVisible(driver, MyApplicationPageUI.MESSAGE_IN_MY_APPLICATION);
		return getElelementText(driver, MyApplicationPageUI.MESSAGE_IN_MY_APPLICATION);
	}

}
