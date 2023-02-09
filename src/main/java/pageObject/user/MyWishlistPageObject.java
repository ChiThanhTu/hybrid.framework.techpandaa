package pageObject.user;

import org.openqa.selenium.WebDriver;

import pageObject.navigation.SideBarMyAccountPageObject;
import pageUI.user.MyWishlistPageUI;

public class MyWishlistPageObject extends SideBarMyAccountPageObject {
	WebDriver driver;

	public MyWishlistPageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	public String getMessageInMyWishlist() {
		waitForElementVisible(driver, MyWishlistPageUI.MESSAGE_IN_MY_WISHLIST);
		return getElelementText(driver, MyWishlistPageUI.MESSAGE_IN_MY_WISHLIST);
	}

	
}
