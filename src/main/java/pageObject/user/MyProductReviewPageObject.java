package pageObject.user;

import org.openqa.selenium.WebDriver;

import io.qameta.allure.Step;
import pageObject.navigation.SideBarMyAccountPageObject;
import pageUI.user.MyProductReviewPageUI;

public class MyProductReviewPageObject extends SideBarMyAccountPageObject {
	WebDriver driver;

	public MyProductReviewPageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	@Step("get Message In Product Reviews {0}")
	public String getMessageInProductReviews() {
		waitForElementVisible(driver, MyProductReviewPageUI.MESSAGE_IN_PRODUCT_REVIEWS);
		return getElelementText(driver, MyProductReviewPageUI.MESSAGE_IN_PRODUCT_REVIEWS);
	}

}
