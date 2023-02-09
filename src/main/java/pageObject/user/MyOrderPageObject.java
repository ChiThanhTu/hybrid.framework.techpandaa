package pageObject.user;

import org.openqa.selenium.WebDriver;
import pageObject.navigation.SideBarMyAccountPageObject;
import pageUI.user.BillingArgreementsPageUI;
import pageUI.user.MyOrderPageUI;

public class MyOrderPageObject extends SideBarMyAccountPageObject {
	WebDriver driver;
	public MyOrderPageObject(WebDriver driver) {
		super(driver);
		this.driver=driver;
	}
	public boolean isTableDisplayed() {
		waitForElementVisible(driver, MyOrderPageUI.TABLE_IN_MY_ORDER);
		return isElementDisPlayedInDom(driver, MyOrderPageUI.TABLE_IN_MY_ORDER);
	}

	
	}
