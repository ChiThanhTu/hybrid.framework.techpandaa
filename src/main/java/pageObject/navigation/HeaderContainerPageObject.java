package pageObject.navigation;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import io.qameta.allure.Step;
import pageObject.admin.AdminAllReviewsPageObject;
import pageObject.admin.AdminManageCustomerPageObject;
import pageObject.admin.AdminOrdersPageObject;
import pageUI.admin.HeaderContainerPageUI;

public class HeaderContainerPageObject extends BasePage {
	WebDriver driver;

	public HeaderContainerPageObject(WebDriver driver) {
		this.driver = driver;
	}
	@Step("Open Admin Manage Customer Page")
	public AdminManageCustomerPageObject OpenAdminManageCustomerPage(String locator,String locator1) {
		
		waitForElementClickable(driver, HeaderContainerPageUI.DYNAMIC_LINK_BY_TEXT,locator1);
		clickToElement(driver, HeaderContainerPageUI.DYNAMIC_LINK_BY_TEXT,locator1);
		return PageGeneratorManager.getAdminManageCustomerPage(driver);
	}
	@Step("Open Admin Sales Order Page")
	public AdminOrdersPageObject OpenAdminSalesOrderPage(String locator,String locator1) {
		hoverMouseToElement(driver, HeaderContainerPageUI.DYNAMIC_LINK_BY_TEXT,locator);
		waitForElementClickable(driver, HeaderContainerPageUI.DYNAMIC_LINK_BY_TEXT,locator1);
		clickToElement(driver, HeaderContainerPageUI.DYNAMIC_LINK_BY_TEXT,locator1);
		return PageGeneratorManager.getAdminSalesOrderPage(driver);
	}
	@Step("Open Admin Sales Order Page")
	public AdminAllReviewsPageObject OpenAdminAllReviewsPage(String locator,String locator1,String locator2,String locator3) {
		hoverMouseToElement(driver, HeaderContainerPageUI.DYNAMIC_LINK_BY_TEXT,locator);
		hoverMouseToElement(driver, HeaderContainerPageUI.DYNAMIC_LINK_BY_TEXT,locator1);
		hoverMouseToElement(driver, HeaderContainerPageUI.DYNAMIC_LINK_BY_TEXT,locator2);
		waitForElementClickable(driver, HeaderContainerPageUI.DYNAMIC_LINK_BY_TEXT,locator3);
		clickToElement(driver, HeaderContainerPageUI.DYNAMIC_LINK_BY_TEXT,locator3);
		return PageGeneratorManager.getAdminAllReviewsPage(driver);
	}
	
	}

