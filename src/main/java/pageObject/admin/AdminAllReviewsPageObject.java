package pageObject.admin;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUI.admin.AdminAllReviewsPageUI;
import pageUI.admin.AdminSalesOrderPageUI;

public class AdminAllReviewsPageObject  extends BasePage {
	WebDriver driver;

	public AdminAllReviewsPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void inputToTextboxByHeaderName(String locator, String locator1, String text) {
		waitForElementVisible(driver, AdminAllReviewsPageUI.DYNAMIC_TEXTBOX_BY_HEADER_NAME, locator, locator1);
		sendkeyToElement(driver, AdminAllReviewsPageUI.DYNAMIC_TEXTBOX_BY_HEADER_NAME, text, locator, locator1);
		pressKeyToElement(driver, AdminAllReviewsPageUI.DYNAMIC_TEXTBOX_BY_HEADER_NAME, Keys.ENTER, locator, locator1);
		sleepInSecond(2);
	}

	public Object getNoRecordsFoundMessage() {
		waitForElementVisible(driver, AdminAllReviewsPageUI.NO_RECORDS_FOUND_MESSAGE);
		return getElelementText(driver, AdminAllReviewsPageUI.NO_RECORDS_FOUND_MESSAGE);
	}

	public Object getTextByHeaderNameAndRowNummer(String headerName, String rowNumber) {
		int headerIndex = getListElelementSize(driver, AdminAllReviewsPageUI.DYNAMIC_HEADER_INDEX_BY_NAME, headerName)
				+ 1;
		waitForElementVisible(driver, AdminAllReviewsPageUI.DYNAMIC_CEEL_BY_HEADER_INDEX_AND_ROW_INDEX, rowNumber,
				String.valueOf(headerIndex));
		return getElelementText(driver, AdminAllReviewsPageUI.DYNAMIC_CEEL_BY_HEADER_INDEX_AND_ROW_INDEX, rowNumber,
				String.valueOf(headerIndex)).trim();
	}
}
