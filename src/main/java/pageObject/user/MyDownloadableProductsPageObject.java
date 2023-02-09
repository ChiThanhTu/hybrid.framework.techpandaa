package pageObject.user;

import org.openqa.selenium.WebDriver;

import pageObject.navigation.SideBarMyAccountPageObject;
import pageUI.user.MyDownloadableProductsPageUI;

public class MyDownloadableProductsPageObject  extends SideBarMyAccountPageObject {
	WebDriver driver;

	public MyDownloadableProductsPageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	public String getMessageInMyDownloadableProductsPage() {
		waitForElementVisible(driver, MyDownloadableProductsPageUI.MESSAGE_IN_MY_DOWNLOADABLE_PRODUCTS);
		return getElelementText(driver, MyDownloadableProductsPageUI.MESSAGE_IN_MY_DOWNLOADABLE_PRODUCTS);
	}


}
