package pageObject.saucelab;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import commons.BasePage;
import io.qameta.allure.Step;
import pageUI.saucelab.InventoryPageUI;

public class InventoryPageObject extends BasePage {
	WebDriver driver;

	public InventoryPageObject(WebDriver driver) {
		this.driver = driver;
	}

	@Step("select Item In Sort DropDown {0}")
	public void selectItemInSortDropDown(String Text) {
		waitForElementClickable(driver, InventoryPageUI.SORT_DROPDOWN);
		selectItemInDefaultDropdown(driver, InventoryPageUI.SORT_DROPDOWN, Text);

	}

	@Step("is Product Name Sort Ascending {0}")
	public boolean isProductNameSortAscending() {
		List<WebElement> productNameElements = getListWebElement(driver, InventoryPageUI.PRODUCT_NAME_TEXT);
		List<String> productNameText = new ArrayList<String>();
		for (WebElement productName : productNameElements) {
			productNameText.add(productName.getText());
		}
		List<String> productNameTextClone = new ArrayList<String>();
		for (String product : productNameText) {
			productNameTextClone.add(product);
		}
		Collections.sort(productNameTextClone);
		return productNameText.equals(productNameTextClone);
	}

	@Step("is Product Name Sort Descending {0}")
	public boolean isProductNameSortDescending() {
		List<WebElement> productNameElements = getListWebElement(driver, InventoryPageUI.PRODUCT_NAME_TEXT);
		List<String> productNameText = new ArrayList<String>();
		for (WebElement productName : productNameElements) {
			productNameText.add(productName.getText());
		}
		List<String> productNameTextClone = new ArrayList<String>();
		for (String product : productNameText) {
			productNameTextClone.add(product);
		}
		Collections.sort(productNameTextClone);
		System.out.println(productNameTextClone);
		Collections.reverse(productNameTextClone);
		System.out.println(productNameTextClone);
		return productNameText.equals(productNameTextClone);
	}

	@Step("is Product Price Sort Ascending {0}")
	public boolean isProductPriceSortAscending() {
		List<WebElement> productPriceElements = getListWebElement(driver, InventoryPageUI.PRODUCT_PRICE_TEXT);
		List<Float> productPriceValue = new ArrayList<Float>();
		for (WebElement productPrice : productPriceElements) {
			productPriceValue.add(Float.parseFloat(productPrice.getText().replace("$", "")));
		}
		List<Float> productNamePriceClone = new ArrayList<Float>();
		for (Float product : productPriceValue) {
			productNamePriceClone.add(product);
		}
		Collections.sort(productNamePriceClone);
		return productPriceValue.equals(productNamePriceClone);
	}

	@Step("is Product Price Sort Descending {0}")
	public boolean isProductPriceSortDescending() {
		List<WebElement> productPriceElements = getListWebElement(driver, InventoryPageUI.PRODUCT_PRICE_TEXT);
		List<Float> productPriceValue = new ArrayList<Float>();
		for (WebElement productPrice : productPriceElements) {
			productPriceValue.add(Float.parseFloat(productPrice.getText().replace("$", "")));
		}
		List<Float> productNamePriceClone = new ArrayList<Float>();
		for (Float product : productPriceValue) {
			productNamePriceClone.add(product);
		}
		Collections.sort(productNamePriceClone);
		Collections.reverse(productNamePriceClone);
		return productPriceValue.equals(productNamePriceClone);
	}

}
