package commons;

import java.time.Duration;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
//import pageObject.admin.AdminLoginPageObject;
//import pageObject.admin.AdminManageCustomerPageObject;
//import pageObject.navigation.FooterContainerPageObject;
//import pageObject.navigation.PageGeneratorManager;
//import pageObject.navigation.SideBarMyAccountPageObject;
//import pageObject.wordpress.AdminDashboardPageObject;
//import pageObject.wordpress.WordPressPageGeneratorManager;
//import pageObject.wordpress.WordPressUserHomePageObject;
//import pageObjects.user.AccountInformationPageObject;
//import pageObjects.user.MyApplicationPageObject;
//import pageObjects.user.MyDashboardPageObject;
//import pageObjects.user.MyOrderPageObject;
//import pageObjects.user.MyProductReviewPageObject;
//import pageObjects.user.UserHomePageObject;
//import pageObjects.user.UserLoginPageObject;
//import pageUI.JQuery.HomePageUI;
//import pageUI.admin.AdminBasePageUI;
//import pageUI.admin.AdminManagerCustomerPageUI;
//import pageUI.admin.UserBasePageUI;
//import pageUI.user.AccountInformationPageUI;
//import pageUI.user.SideBarMyAccountPageUI;
//import pageUI.user.MyApplicationPageUI;
//import pageUI.user.MyDashboradPageUI;
//import pageUI.user.MyOrderPageUI;
//import pageUI.user.MyProductReviewPageUI;

import pageObject.navigation.FooterContainerPageObject;
import pageObject.navigation.SideBarMyAccountPageObject;

public class BasePage {

	private int longTimeout = 3;
	long longTimeoutt = GlobalConstants.getGlobalConstants().getLongTimeout();
	long shortTimeoutt = GlobalConstants.getGlobalConstants().getShortTimeout();

	public static BasePage getBasePageInstance() {
		return new BasePage();
	}

	public Set<Cookie> getCookies(WebDriver driver) {
		return driver.manage().getCookies();
	}

	public void setCookies(WebDriver driver, Set<Cookie> cookies) {
		for (Cookie cookie : cookies) {
			driver.manage().addCookie(cookie);
		}
		sleepInSecond(2);
		driver.navigate().refresh();
	}

	public void openPageUrl(WebDriver driver, String pageUrl) {
		driver.get(pageUrl);
	}

	public String getPageUrl(WebDriver driver) {
		return driver.getCurrentUrl();
	}

	public String getPageTitle(WebDriver driver) {
		return driver.getTitle();
	}

	public String getPageSourceCode(WebDriver driver) {
		return driver.getPageSource();
	}

	public void backToPage(WebDriver driver) {
		driver.navigate().back();
	}

	public void forwardToPage(WebDriver driver) {
		driver.navigate().forward();
	}

	public void refreshCurrentPage(WebDriver driver) {
		driver.navigate().refresh();
	}

	public Alert waitForAlertPressence(WebDriver driver) {
		return new WebDriverWait(driver, 30).until(ExpectedConditions.alertIsPresent());
	}

	public void acceptAlert(WebDriver driver) {
		waitForAlertPressence(driver).accept();
	}

	public void canceltAlert(WebDriver driver) {
		waitForAlertPressence(driver).dismiss();
	}

	public void senkeytAlert(WebDriver driver, String valueToSenkey) {
		waitForAlertPressence(driver).sendKeys(valueToSenkey);
	}

	public String gettAlert(WebDriver driver) {
		return waitForAlertPressence(driver).getText();
	}

	public void SwitchWindowByID(WebDriver driver, String ExpectedTitle) {
		Set<String> AllTabIDs = driver.getWindowHandles();
		for (String ID : AllTabIDs) {
			if (!ID.equals(ExpectedTitle)) {
				driver.switchTo().window(ID);
				break;
			}
		}
	}

	public void SwitchWindowByTitle(WebDriver driver, String ExpectedTitle) {
		Set<String> AllTabIDs = driver.getWindowHandles();
		for (String ID : AllTabIDs) {
			driver.switchTo().window(ID);
			String Actualtitle = driver.getTitle();
			if (Actualtitle.equals(ExpectedTitle)) {
				break;
			}
		}
	}

	public boolean closeAllWindowWithoutParent(WebDriver driver, String parenID) {
		Set<String> allWindows = driver.getWindowHandles();
		for (String runWindows : allWindows) {
			if (!runWindows.equals(parenID)) {
				driver.switchTo().window(runWindows);
				driver.close();
			}
		}
		driver.switchTo().window(parenID);
		if (driver.getWindowHandles().size() == 1)
			return true;
		else
			return false;
	}

//Web Element
	public String castRestParameter(String locator, String... dymanicLocator) {
		locator = String.format(locator, (Object[]) dymanicLocator);
		return locator;
	}

	public By getByLocator(String locator) {
		By by = null;
		if (locator.startsWith("id=") || (locator.startsWith("ID=") || (locator.startsWith("Id=")))) {
			by = By.id(locator.substring(3));
		} else if (locator.startsWith("class=") || (locator.startsWith("CLASS=") || (locator.startsWith("Class=")))) {
			by = By.className(locator.substring(6));
		} else if (locator.startsWith("name=") || (locator.startsWith("NAME=") || (locator.startsWith("Name=")))) {
			by = By.name(locator.substring(5));
		} else if (locator.startsWith("css=") || (locator.startsWith("CSS=") || (locator.startsWith("Css=")))) {
			by = By.cssSelector(locator.substring(4));
		} else if (locator.startsWith("xpath=")
				|| (locator.startsWith("XPATH=") || (locator.startsWith("Xpath=") || (locator.startsWith("XPath="))))) {
			by = By.xpath(locator.substring(6));
		} else {
			throw new RuntimeException("Locator is not valid");

		}
		return by;
	}
	public WebElement getWebElement(WebDriver driver, String locator) {
		return driver.findElement(getByLocator(locator));
	}

	public WebElement getWebElement(WebDriver driver, String locator, String... dymanicLocator) {
		return driver.findElement(getByLocator(castRestParameter(locator, dymanicLocator)));
	}

	public List<WebElement> getListWebElement(WebDriver driver, String locator) {
		return driver.findElements(getByLocator(locator));
	}
	public List<WebElement> getListWebElement(WebDriver driver, String locator, String... dymanicLocator) {
		return driver.findElements(getByLocator(castRestParameter(locator, dymanicLocator)));
	}

	public void clickToElement(WebDriver driver, String locator) {
		hightLightElement(driver, locator);
		getWebElement(driver, locator).click();
	}

	public void clickToElement(WebDriver driver, String locator, String... dymanicLocator) {
		hightLightElement(driver, locator, dymanicLocator);
		getWebElement(driver, castRestParameter(locator, dymanicLocator)).click();
	}
	
	public void sendkeyToElement(WebDriver driver, String locator, String valueToInput) {
		WebElement element = getWebElement(driver, locator);
		hightLightElement(driver, locator);
		element.clear();
		element.sendKeys(valueToInput);
	}

	public void sendkeyToElement(WebDriver driver, String locator, String valueToInput, String... dymanicLocator) {
		WebElement element = getWebElement(driver, castRestParameter(locator, dymanicLocator));
		hightLightElement(driver, locator, dymanicLocator);
		element.clear();
		element.sendKeys(valueToInput);
	}

	public String getElelementText(WebDriver driver, String locator) {
		hightLightElement(driver, locator);
		return getWebElement(driver, locator).getText();
	}

	public String getElelementText(WebDriver driver, String locator, String... dymanicLocator) {
		hightLightElement(driver, locator, dymanicLocator);
		return getWebElement(driver, castRestParameter(locator, dymanicLocator)).getText();
	}

	public String getElelementAttributeValue(WebDriver driver, String locator, String attrivuteName) {
		return getWebElement(driver, locator).getAttribute(attrivuteName);
	}

	public String getElelementAttributeValue(WebDriver driver, String locator, String attrivuteName,
			String... dymanicLocator) {
		return getWebElement(driver, castRestParameter(locator, dymanicLocator)).getAttribute(attrivuteName);
	}

	public String getElelementCssValue(WebDriver driver, String locator, String properTyName) {
		return getWebElement(driver, locator).getCssValue(properTyName);
	}

	public String getElelementCssValue(WebDriver driver, String locator, String properTyName,
			String... dymanicLocator) {
		return getWebElement(driver, castRestParameter(locator, dymanicLocator)).getCssValue(properTyName);
	}

	public int getListElelementSize(WebDriver driver, String locator) {
		return getListWebElement(driver, locator).size();
	}

	public int getListElelementSize(WebDriver driver, String locator, String... dymanicLocator) {
		return getListWebElement(driver, castRestParameter(locator, dymanicLocator)).size();
	}

	public void selectItemInDefaultDropdown(WebDriver driver, String locator, String itemText,
			String... dymanicLocator) {
		Select select = new Select(getWebElement(driver, castRestParameter(locator, dymanicLocator)));
		select.selectByVisibleText(itemText);
	}

	public void selectItemInDefaultDropdown(WebDriver driver, String locator, String itemText) {
		Select select = new Select(getWebElement(driver, locator));
		select.selectByVisibleText(itemText);
	}

	public String getFirstSelectedTextItem(WebDriver driver, String locator) {
		Select select = new Select(getWebElement(driver, locator));
		return select.getFirstSelectedOption().getText();
	}

	public String getFirstSelectedTextItem(WebDriver driver, String locator, String... dymanicLocator) {
		Select select = new Select(getWebElement(driver, castRestParameter(locator, dymanicLocator)));
		return select.getFirstSelectedOption().getText();
	}

	public boolean isDropdownMultiple(WebDriver driver, String locator) {
		Select select = new Select(getWebElement(driver, locator));
		return select.isMultiple();
	}

	public void selectItemInCusTomDropDown(WebDriver driver, String parentXpath, String childXpath,
			String expectItemText) {
		getWebElement(driver, parentXpath).click();
		sleepInSecond(2);
		List<WebElement> childItems = new WebDriverWait(driver, 30)
				.until(ExpectedConditions.presenceOfAllElementsLocatedBy(getByLocator(childXpath)));
		for (WebElement tempElement : childItems) {
			if (tempElement.getText().trim().equals(expectItemText)) {
				((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(false);", tempElement);
				sleepInSecond(1);
				tempElement.click();
				sleepInSecond(1);
				break;
			}

		}
	}

	public void checkToCheckboxOrRadio(WebDriver driver, String locator) {
		WebElement element = getWebElement(driver, locator);
		if (!element.isSelected()) {
			element.click();
		}
	}
	public void checkToCheckboxOrRadio(WebDriver driver, String locator, String... dymanicLocator) {
		WebElement element = getWebElement(driver, castRestParameter(locator, dymanicLocator));
		if (!element.isSelected()) {
			element.click();
		}
	}

	public void unCheckToCheckbox(WebDriver driver, String locator) {
		WebElement element = getWebElement(driver, locator);
		if (element.isSelected()) {
			element.click();
		}
	}
	public void unCheckToCheckbox(WebDriver driver, String locator,  String... dymanicLocator) {
		WebElement element = getWebElement(driver, castRestParameter(locator, dymanicLocator));
		if (element.isSelected()) {
			element.click();
		}
	}

	public boolean isElementDisPlayedInDom(WebDriver driver, String locator) {
		return getWebElement(driver, locator).isDisplayed();
	}

	public boolean isElementDisPlayedInDom(WebDriver driver, String locator, String... dymanicLocator) {
		return getWebElement(driver, castRestParameter(locator, dymanicLocator)).isDisplayed();
	}

	public boolean isElementUnDisPlayed(WebDriver driver, String locator) {
		setImplicitTime(driver, shortTimeoutt);
		List<WebElement> elements = getListWebElement(driver, locator);
		setImplicitTime(driver, longTimeoutt);

		if (elements.size() == 0) {
			System.out.println("Element not in DOM");
			return true;

		} else if (elements.size() > 0 && !elements.get(0).isDisplayed()) {
			System.out.println("Element in DOM but not visible/ displayed");
			return true;
		} else {
			System.out.println("Element in DOM and visible");
			return false;
		}
	}
	public boolean isElementUnDisPlayed(WebDriver driver, String locator, String...dymanicLocator) {
		setImplicitTime(driver, shortTimeoutt);
		List<WebElement> elements = getListWebElement(driver, castRestParameter(locator, dymanicLocator));
		setImplicitTime(driver, longTimeoutt);

		if (elements.size() == 0) {
			System.out.println("Element not in DOM");
			return true;

		} else if (elements.size() > 0 && !elements.get(0).isDisplayed()) {
			System.out.println("Element in DOM but not visible/ displayed");
			return true;
		} else {
			System.out.println("Element in DOM and visible");
			return false;
		}
	}

	public void setImplicitTime(WebDriver driver, long time) {
		driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
	}

	public boolean isElementEnabled(WebDriver driver, String locator) {
		return getWebElement(driver, locator).isEnabled();
	}

	public boolean isElementEnabled(WebDriver driver, String locator, String... dymanicLocator) {
		return getWebElement(driver, castRestParameter(locator, dymanicLocator)).isEnabled();
	}

	public boolean isElementSelected(WebDriver driver, String locator) {
		return getWebElement(driver, locator).isSelected();
	}

	public boolean isElementSelected(WebDriver driver, String locator, String... dymanicLocator) {
		return getWebElement(driver, castRestParameter(locator, dymanicLocator)).isSelected();
	}

	public void switchToIframe(WebDriver driver, String locator) {
		driver.switchTo().frame(getWebElement(driver, locator));
	}

	public void switchToDefault(WebDriver driver) {
		driver.switchTo().defaultContent();
	}

	public void hoverMouseToElement(WebDriver driver, String locator) {
		Actions action = new Actions(driver);
		action.moveToElement(getWebElement(driver, locator)).perform();
	}
	public void hoverMouseToElement(WebDriver driver, String locator,  String... dymanicLocator) {
		Actions action = new Actions(driver);
		action.moveToElement(getWebElement(driver, castRestParameter(locator, dymanicLocator))).perform();
	}

	public void rightClickToElement(WebDriver driver, String locator) {
		Actions action = new Actions(driver);
		action.contextClick(getWebElement(driver, locator));
	}

	public void doubleClickToElement(WebDriver driver, String locator) {
		Actions action = new Actions(driver);
		action.doubleClick(getWebElement(driver, locator)).perform();
	}

	public void dragAndDropElement(WebDriver driver, String sourceLocator, String targetLocator) {
		Actions action = new Actions(driver);
		action.dragAndDrop(getWebElement(driver, sourceLocator), getWebElement(driver, targetLocator)).perform();
	}

	public void pressKeyToElement(WebDriver driver, String locator, Keys key) {
		Actions action = new Actions(driver);
		action.sendKeys(getWebElement(driver, locator), key).perform();
	}

	public void pressKeyToElement(WebDriver driver, String locator, Keys key, String... dymanicLocator) {
		Actions action = new Actions(driver);
		action.sendKeys(getWebElement(driver, castRestParameter(locator, dymanicLocator)), key).perform();
	}

	public void hightLightElement(WebDriver driver, String locator) {
		WebElement element = getWebElement(driver, locator);
		String originalStyle = element.getAttribute("style");
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].setAttribute('style', arguments[1])", element,
				"border: 2px solid red; border-style: dashed;");
		sleepInSecond(1);
		jsExecutor.executeScript("arguments[0].setAttribute('style', arguments[1])", element, originalStyle);
	}

	public void hightLightElement(WebDriver driver, String locator, String... dymanicLocator) {
		WebElement element = getWebElement(driver, castRestParameter(locator, dymanicLocator));
		String originalStyle = element.getAttribute("style");
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].setAttribute('style', arguments[1])", element,
				"border: 2px solid red; border-style: dashed;");
		sleepInSecond(1);
		jsExecutor.executeScript("arguments[0].setAttribute('style', arguments[1])", element, originalStyle);
	}

	public void clickToElementByJS(WebDriver driver, String locator) {
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", getWebElement(driver, locator));
	}

	public void clickToElementByJS(WebDriver driver, String locator, String... dymanicLocator) {
		((JavascriptExecutor) driver).executeScript("arguments[0].click();",
				getWebElement(driver, castRestParameter(locator, dymanicLocator)));
	}

	public void scrollToElementOnTop(WebDriver driver, String locator) {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",
				getWebElement(driver, locator));
	}

	public void scrollToElementOnDown(WebDriver driver, String locator) {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(false);",
				getWebElement(driver, locator));
	}

	public void senkeyElementByJS(WebDriver driver, String locator, String value) {
		((JavascriptExecutor) driver).executeScript("arguments[0].setAttribute('value','" + value + "')",
				getWebElement(driver, locator));
	}
	
	public void removeAttributeIndDom(WebDriver driver, String locator, String attributeRemove) {
		((JavascriptExecutor) driver).executeScript("arguments[0].removeAttribute('" + attributeRemove + "');",
				getWebElement(driver, locator));
	}
	public void removeAttributeIndDom(WebDriver driver, String locator, String attributeRemove,  String... dymanicLocator) {
		((JavascriptExecutor) driver).executeScript("arguments[0].removeAttribute('" + attributeRemove + "');",
				getWebElement(driver, castRestParameter(locator, dymanicLocator)));
	}
	public String getElementValidatetionMessage(WebDriver driver, String locator) {
		return (String) ((JavascriptExecutor) driver).executeScript("return arguments[0].validationMessage;",
				getWebElement(driver, locator));
	}

	public boolean isImageLoaded(WebDriver driver, String locator) {
		boolean status = (Boolean) ((JavascriptExecutor) driver).executeScript(
				"return arguments[0].complete && typeof arguments[0].naturalWidth != 'undefined' && arguments[0].naturalWidth > 0",
				getWebElement(driver, locator));
		if (status) {
			return true;
		}
		return false;
	}

	public void waitForElementVisible(WebDriver driver, String locator) {
		new WebDriverWait(driver, longTimeout)
				.until(ExpectedConditions.visibilityOfElementLocated(getByLocator(locator)));

	}

	public void waitForElementVisible(WebDriver driver, String locator, String... dymanicLocator) {
		new WebDriverWait(driver, longTimeout).until(ExpectedConditions
				.visibilityOfElementLocated(getByLocator(castRestParameter(locator, dymanicLocator))));

	}

	public void waitForElementInvisibleInDom(WebDriver driver, String locator) {
		new WebDriverWait(driver, shortTimeoutt)
				.until(ExpectedConditions.invisibilityOfElementLocated(getByLocator(locator)));
	}

	public void waitForElementInvisibleIndom(WebDriver driver, String locator, String... dymanicLocator) {
		new WebDriverWait(driver, longTimeout).until(ExpectedConditions
				.invisibilityOfElementLocated(getByLocator(castRestParameter(locator, dymanicLocator))));
	}

	public void waitForElementInvisibleNotInDom(WebDriver driver, String locator) {
		setImplicitTime(driver, shortTimeoutt);
		new WebDriverWait(driver, shortTimeoutt)
				.until(ExpectedConditions.invisibilityOfElementLocated(getByLocator(locator)));
		setImplicitTime(driver, longTimeoutt);

	}
	public void waitForElementInvisibleNotInDom(WebDriver driver, String locator, String... dymanicLocator) {
		setImplicitTime(driver, shortTimeoutt);
		new WebDriverWait(driver, shortTimeoutt)
				.until(ExpectedConditions.invisibilityOfElementLocated(getByLocator(castRestParameter(locator, dymanicLocator))));
		setImplicitTime(driver, longTimeoutt);
	}

	public void waitForElementClickable(WebDriver driver, String locator) {
		new WebDriverWait(driver, longTimeout).until(ExpectedConditions.elementToBeClickable(getByLocator(locator)));
	}

	public void waitForElementClickable(WebDriver driver, WebElement element) {
		new WebDriverWait(driver, longTimeout).until(ExpectedConditions.elementToBeClickable(element));
	}

	public void waitForElementClickable(WebDriver driver, String locator, String... dymanicLocator) {
		new WebDriverWait(driver, longTimeout).until(
				ExpectedConditions.elementToBeClickable(getByLocator(castRestParameter(locator, dymanicLocator))));
	}

//	public void uploadMutipleFiles(WebDriver driver, String... fileNames) {
//		String uploadFilePath = GlobalConstants.getGlobalConstants().getUploadFiles();
//		String fullFileName = "";
//		for (String file : fileNames) {
//			fullFileName = fullFileName + uploadFilePath + file + "\n";
//		}
//		fullFileName = fullFileName.trim();
//		getWebElement(driver, HomePageUI.UPLOAD_FILE_TYPE).sendKeys(fullFileName);
//	}
//
	public FooterContainerPageObject getFooterContainerPage(WebDriver driver) {
		return new FooterContainerPageObject(driver);

	}

	public SideBarMyAccountPageObject getSideBarMyAccountPage(WebDriver driver) {
		return new SideBarMyAccountPageObject(driver);

	}
//
//	public AdminLoginPageObject openAdminLoginPage(WebDriver driver, String pageUrl) {
//		openPageUrl(driver, pageUrl);
//		return PageGeneratorManager.getAdminLoginPage(driver);
//	}
//	public AdminDashboardPageObject OpenAdminDashboardPage(WebDriver driver, String adminUrl) {
//		openPageUrl(driver, adminUrl);
//		return WordPressPageGeneratorManager.getAdminDashboardPage(driver);
//	}
//	public WordPressUserHomePageObject openWordPressUserHomePage(WebDriver driver, String userUrl) {
//		openPageUrl(driver,userUrl);
//		return WordPressPageGeneratorManager.getUserHomePage(driver);
//	}
//	public UserHomePageObject openUserHomePage(WebDriver driver, String pageUrl) {
//		openPageUrl(driver, pageUrl);
//		return PageGeneratorManager.getUserHomePage(driver);
//	}
//	
//	public AdminLoginPageObject clickAdminLogOutLink(WebDriver driver) {
//		waitForElementClickable(driver, AdminBasePageUI.CLICK_LOGOUT);
//		clickToElement(driver, AdminBasePageUI.CLICK_LOGOUT);
//		return PageGeneratorManager.getAdminLoginPage(driver);
//	}
//
//	public UserHomePageObject clickUserLogOutLink(WebDriver driver) {
//		waitForElementClickable(driver, UserBasePageUI.HEADER_ACCOUNT);
//		clickToElement(driver, UserBasePageUI.HEADER_ACCOUNT);
//		waitForElementClickable(driver, UserBasePageUI.HEADER_LOGOUT);
//		clickToElement(driver, UserBasePageUI.HEADER_LOGOUT);
//		return PageGeneratorManager.getUserHomePage(driver);
//	}

	public int randomNumber() {
		Random randam = new Random();
		return randam.nextInt(999999);
	}

	public void sleepInSecond(int second) {
		try {
			Thread.sleep(second * 1000);
		} catch (Exception e) {
		}
	}

//	/// common function for web component
//	public void enterToTextboxById(WebDriver driver, String textboxID, String inputValue) {
//		waitForElementVisible(driver, AdminBasePageUI.DYNAMIC_TEXTBOX_BY_ID, textboxID);
//		sendkeyToElement(driver, AdminBasePageUI.DYNAMIC_TEXTBOX_BY_ID, inputValue, textboxID);
//	}
//
//	public void clickToButtonByTitle(WebDriver driver, String titleValue) {
//		waitForElementClickable(driver, AdminBasePageUI.DYNAMIC_BUTTON_BY_TITLE, titleValue);
//		clickToElement(driver, AdminBasePageUI.DYNAMIC_BUTTON_BY_TITLE);
//	}
//
//	public String getFieldErrorMessageByID(WebDriver driver, String FieldID) {
//		waitForElementVisible(driver, AdminBasePageUI.DYNAMIC_FIELD_ERROR_MESSAGE_BY_ID, FieldID);
//		return getElelementText(driver, AdminBasePageUI.DYNAMIC_FIELD_ERROR_MESSAGE_BY_ID, FieldID);
//	}
//
//	public String getPageErrorMessageByID(WebDriver driver) {
//		waitForElementVisible(driver, AdminBasePageUI.PAGE_ERROR_MESSAGE);
//		return getElelementText(driver, AdminBasePageUI.PAGE_ERROR_MESSAGE);
//	}
//
//	public String getPageSuccessMessageByID(WebDriver driver) {
//		waitForElementVisible(driver, AdminBasePageUI.PAGE_SUCCESS_MESSAGE);
//		return getElelementText(driver, AdminBasePageUI.PAGE_SUCCESS_MESSAGE);
//	}
//
//	public void selectDropdownByID(WebDriver driver, String dropdownID, String dropdownItem) {
//		waitForElementClickable(driver, AdminBasePageUI.DYNAMIC_DROPDOWN_BY_ID, dropdownID);
//		selectItemInDefaultDropdown(driver, AdminBasePageUI.DYNAMIC_DROPDOWN_BY_ID, dropdownItem, dropdownID);
//	}
}
