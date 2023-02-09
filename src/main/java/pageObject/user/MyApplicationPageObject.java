package pageObject.user;

import org.openqa.selenium.WebDriver;
import pageObject.navigation.SideBarMyAccountPageObject;
import pageUI.user.MyApplicationPageUI;
public class MyApplicationPageObject extends SideBarMyAccountPageObject {
	WebDriver driver;
	public MyApplicationPageObject(WebDriver driver) {
		super(driver);
		this.driver=driver;
	}
	public String getMessageInMyApplicationPage() {
		waitForElementVisible(driver, MyApplicationPageUI.MESSAGE_IN_MY_APPLICATION);
		return getElelementText(driver, MyApplicationPageUI.MESSAGE_IN_MY_APPLICATION);
	}

}
