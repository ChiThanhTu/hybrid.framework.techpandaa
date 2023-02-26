package pageObject.admin;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import commons.BasePage;
import io.qameta.allure.Step;
import pageUI.admin.AdminSalesOrderPageUI;

public class AdminOrdersPageObject extends BasePage {
	WebDriver driver;

	public AdminOrdersPageObject(WebDriver driver) {
		this.driver = driver;
	}

	@Step("input To Textbox By Header Name {0}")
	public void inputToTextboxByHeaderName(String locator, String locator1, String text) {
		waitForElementVisible(driver, AdminSalesOrderPageUI.DYNAMIC_TEXTBOX_BY_HEADER_NAME, locator, locator1);
		sendkeyToElement(driver, AdminSalesOrderPageUI.DYNAMIC_TEXTBOX_BY_HEADER_NAME, text, locator, locator1);
		pressKeyToElement(driver, AdminSalesOrderPageUI.DYNAMIC_TEXTBOX_BY_HEADER_NAME, Keys.ENTER, locator, locator1);
		sleepInSecond(2);
	}

	@Step("get Text By Header Name And Row Nummer {0}")
	public String getTextByHeaderNameAndRowNummer(String headerName, String rowNumber) {
		int headerIndex = getListElelementSize(driver, AdminSalesOrderPageUI.DYNAMIC_HEADER_INDEX_BY_NAME, headerName)
				+ 1;
		waitForElementVisible(driver, AdminSalesOrderPageUI.DYNAMIC_CEEL_BY_HEADER_INDEX_AND_ROW_INDEX, rowNumber,
				String.valueOf(headerIndex));
		return getElelementText(driver, AdminSalesOrderPageUI.DYNAMIC_CEEL_BY_HEADER_INDEX_AND_ROW_INDEX, rowNumber,
				String.valueOf(headerIndex)).trim();
	}

	@Step("get No Records Found Message {0}")
	public Object getNoRecordsFoundMessage() {
		waitForElementVisible(driver, AdminSalesOrderPageUI.NO_RECORDS_FOUND_MESSAGE);
		return getElelementText(driver, AdminSalesOrderPageUI.NO_RECORDS_FOUND_MESSAGE);
	}

	@Step("is Customer Infor Dislayed {0}")
	public boolean isCustomerInforDislayed() {
		waitForElementsVisible(driver, AdminSalesOrderPageUI.ORDER_INFOR_DISPLAYED);
		return isListElementDisPlayedInDom(driver, AdminSalesOrderPageUI.ORDER_INFOR_DISPLAYED);
	}
}
