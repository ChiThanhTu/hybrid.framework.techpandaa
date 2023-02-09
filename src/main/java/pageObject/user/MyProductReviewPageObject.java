package pageObject.user;

import org.openqa.selenium.WebDriver;

import pageObject.navigation.SideBarMyAccountPageObject;
import pageUI.user.MyProductReviewPageUI;
import pageUI.user.RecurringProfilesPageUI;

public class MyProductReviewPageObject extends SideBarMyAccountPageObject {
	WebDriver driver;
	public MyProductReviewPageObject(WebDriver driver) {
		super(driver);
		this.driver=driver;
	}
	public String getMessageInPruductReviews() {
		waitForElementVisible(driver, MyProductReviewPageUI.MESSAGE_IN_PRODUCT_REVIEWS);
		return getElelementText(driver, MyProductReviewPageUI.MESSAGE_IN_PRODUCT_REVIEWS);
	}

}
