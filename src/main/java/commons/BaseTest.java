package commons;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Reporter;
import org.testng.annotations.BeforeSuite;

import factoryEnvironment.BrowserstackFactory;
import factoryEnvironment.CrossbrowserFactory;
import factoryEnvironment.GridFactory;
import factoryEnvironment.LocalFactory;
import factoryEnvironment.SaucelabFactory;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	WebDriver driver;

	protected final Log log;

	public BaseTest() {
		log = LogFactory.getLog(getClass());
	}

	protected WebDriver getBrowserDriver(String browserName) {
		BrowserList browserList = BrowserList.valueOf(browserName.toUpperCase());
		switch (browserList) {
		case CHROME:
			WebDriverManager.chromedriver().setup();
			System.setProperty("webdriver.chrome.args", "--disable-logging");
			System.setProperty("webdriver.chrome.silentOutput", "--disable-logging");

			driver = new ChromeDriver();
//			File extensionFileC = new File(GlobalConstants.PROJECT_PATH + File.separator + "browserExtensions"
//					+ File.separator + "extension_4_6_0_0.crx");
//			ChromeOptions optionsC = new ChromeOptions();
//			optionsC.addExtensions(extensionFileC);
//			driver = new ChromeDriver(optionsC);
			break;
		case H_CHROME:
			WebDriverManager.chromedriver().setup();
			ChromeOptions optionsHC = new ChromeOptions();
			optionsHC.addArguments("--headless");
			optionsHC.addArguments("window-size=1920x1080");
			driver = new ChromeDriver(optionsHC);
			break;
		case H_FIREFOX:
			WebDriverManager.firefoxdriver().setup();
			FirefoxOptions options1 = new FirefoxOptions();
			options1.addArguments("--headless");
			options1.addArguments("window-size=1920x1080");
			driver = new FirefoxDriver(options1);
			break;
		case FIREFOX:
			System.setProperty("webdriver.gecko.driver",
					GlobalConstants.getGlobalConstants().getProjectPath() + "\\browserDrives\\geckodriver.exe");
			System.setProperty(FirefoxDriver.SystemProperty.DRIVER_USE_MARIONETTE, "true");
			System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE,
					GlobalConstants.getGlobalConstants().getProjectPath() + File.separator + "browserLogs"
							+ File.separator + "Firefox.log");
			driver = new FirefoxDriver();

//			FirefoxProfile profile = new FirefoxProfile();
//			File extensionFileF = new File(GlobalConstants.PROJECT_PATH + File.separator + "browserExtensions"
//					+ File.separator + "to_google_translate-4.2.0.xpi");
//			profile.addExtension(extensionFileF);
//			FirefoxOptions optionsF = new FirefoxOptions();
//			optionsF.setProfile(profile);
//			driver = new FirefoxDriver(optionsF);
			/////
//			driver = WebDriverManager.firefoxdriver().create();
			break;
		case EDGE:
			driver = WebDriverManager.edgedriver().create();
			break;
		default:
			throw new RuntimeException("Browser name isn't valid");
		}
		driver.manage().timeouts().implicitlyWait(GlobalConstants.getGlobalConstants().getLongTimeout(),
				TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(GlobalConstants.getGlobalConstants().getLiveUserUrl());
		return driver;
	}

	protected WebDriver getBrowserDriver(String browserName, String url) {
		BrowserList browserList = BrowserList.valueOf(browserName.toUpperCase());
		switch (browserList) {
		case CHROME:
			WebDriverManager.chromedriver().setup();
			System.setProperty("webdriver.chrome.args", "--disable-logging");
			System.setProperty("webdriver.chrome.silentOutput", "--disable-logging");
			driver = new ChromeDriver();
//			File extensionFileC = new File(GlobalConstants.PROJECT_PATH + File.separator + "browserExtensions"
//					+ File.separator + "extension_4_6_0_0.crx");
//			ChromeOptions optionsC = new ChromeOptions();
//			optionsC.addExtensions(extensionFileC);
//			driver = new ChromeDriver(optionsC);
			break;
		case H_CHROME:
			WebDriverManager.chromedriver().setup();
			ChromeOptions optionsHC = new ChromeOptions();
			optionsHC.addArguments("--headless");
			optionsHC.addArguments("window-size=1920x1080");
			driver = new ChromeDriver(optionsHC);
			break;
		case H_FIREFOX:
			WebDriverManager.firefoxdriver().setup();
			FirefoxOptions options1 = new FirefoxOptions();
			options1.addArguments("--headless");
			options1.addArguments("window-size=1920x1080");
			driver = new FirefoxDriver(options1);
			break;
		case FIREFOX:
			System.setProperty("webdriver.gecko.driver",
					GlobalConstants.getGlobalConstants().getProjectPath() + "\\browserDrives\\geckodriver.exe");
			System.setProperty(FirefoxDriver.SystemProperty.DRIVER_USE_MARIONETTE, "true");
			System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE,
					GlobalConstants.getGlobalConstants().getProjectPath() + File.separator + "browserLogs"
							+ File.separator + "Firefox.log");
			driver = new FirefoxDriver();

//			FirefoxProfile profile = new FirefoxProfile();
//			File extensionFileF = new File(GlobalConstants.PROJECT_PATH + File.separator + "browserExtensions"
//					+ File.separator + "to_google_translate-4.2.0.xpi");
//			profile.addExtension(extensionFileF);
//			FirefoxOptions optionsF = new FirefoxOptions();
//			optionsF.setProfile(profile);
//			driver = new FirefoxDriver(optionsF);
			/////
//			driver = WebDriverManager.firefoxdriver().create();
			break;
		case EDGE:
			driver = WebDriverManager.edgedriver().create();
			break;
		default:
			throw new RuntimeException("Browser name isn't valid");
		}
		driver.manage().timeouts().implicitlyWait(GlobalConstants.getGlobalConstants().getLongTimeout(),
				TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(url);
		return driver;
	}

	protected WebDriver getBrowserDriver(String envName, String serverName, String browserName, String ipAddress,
			String port, String osName, String osVersion) {
		switch (envName) {
		case "local":
			driver = new LocalFactory(browserName).createDriver();
			break;
		case "grid":
			driver = new GridFactory(browserName, ipAddress, port).createDriver();
		case "browserStack":
			driver = new BrowserstackFactory(browserName, osName, osVersion).createDriver();
			break;
		case "sauceLab":
			driver = new SaucelabFactory(browserName, osName).createDriver();
			break;
		case "crossbrowser":
			driver = new CrossbrowserFactory(browserName, osName).createDriver();
			break;
		case "lambda":
			driver = new SaucelabFactory(browserName, osName).createDriver();
			break;
		default:
			break;
		}
		driver.manage().timeouts().implicitlyWait(GlobalConstants.getGlobalConstants().getLongTimeout(),
				TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(getEnviromentValue(serverName));
		return driver;
	}

	private String getEnviromentValue(String severName) {
		String envUrl = null;
		EnviromentList enviroment = EnviromentList.valueOf(severName.toUpperCase());
		if (enviroment == EnviromentList.DEV) {
			envUrl = "https://www.saucedemo.com/";
		} else if (enviroment == EnviromentList.TESTING) {
			envUrl = "http://live.techpanda.org/index.php/";

		} else if (enviroment == EnviromentList.STAGING) {
			envUrl = "http://live.techpanda.org/index.php/";

		} else if (enviroment == EnviromentList.PRODUCTION) {
			envUrl = "http://live.techpanda.org/";

		} else if (enviroment == EnviromentList.USER) {
			envUrl = "http://live.techpanda.org/index.php/";

		} else if (enviroment == EnviromentList.ADMIN) {
			envUrl = "https://admin-demo.nopcommerce.com/login?ReturnUrl=/admin/";
		}
		System.out.println(envUrl);
		return envUrl;
	}

	protected void sleepInSecond(int second) {
		try {
			Thread.sleep(second * 1000);
		} catch (Exception e) {
		}
	}

	protected int getRandomNumber() {
		Random randam = new Random();
		return randam.nextInt(999);
	}

	protected static int getRandomNumberGlobal() {
		Random randam = new Random();
		return randam.nextInt(999);
	}

	protected boolean verifyTrue(boolean condition) {
		boolean status = true;
		try {
			assertTrue(condition);
			log.info("------------------------------------Pass------------------------------------");
		} catch (Throwable e) {
			status = false;
			VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
			Reporter.getCurrentTestResult().setThrowable(e);
			log.info("------------------------------------Failed------------------------------------");
		}
		return status;
	}

	protected boolean verifyFalse(boolean condition) {
		boolean status = true;
		try {
			assertFalse(condition);
			log.info("------------------------------------Pass------------------------------------");
		} catch (Throwable e) {
			status = false;
			VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
			Reporter.getCurrentTestResult().setThrowable(e);
			log.info("------------------------------------Failed------------------------------------");

		}
		return status;
	}

	protected boolean verifyEquals(Object actual, Object expected) {
		boolean status = true;
		try {
			assertEquals(actual, expected);
			log.info("------------------------------------Pass------------------------------------");
		} catch (Throwable e) {
			status = false;
			VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
			Reporter.getCurrentTestResult().setThrowable(e);
			log.info("------------------------------------Failed------------------------------------");

		}
		return status;
	}

	public WebDriver getWebDriver() {
		return this.driver;
	}

	@BeforeSuite
	public void beforeSuite() {
		deleteAllFileInFolder();
	}

	private void deleteAllFileInFolder() {
		try {

			File file = new File(GlobalConstants.getGlobalConstants().getReportScreenPath());
			File[] listOfFiles = file.listFiles();
			for (int i = 0; i < listOfFiles.length; i++) {
				if (listOfFiles[i].isFile()) {
					System.out.println(listOfFiles[i].getName());
					new File(listOfFiles[i].toString()).delete();
				}
			}
		} catch (Exception e) {
			System.out.print(e.getMessage());
		}
	}

	protected void closeBrowserAndDriver() {
		String cmd = "";
		try {
			String osName = System.getProperty("os.name").toLowerCase();
			log.info("OS name = " + osName);

			String driverInstanceName = driver.toString().toLowerCase();
			log.info("Driver instance name = " + driverInstanceName);

			if (driverInstanceName.contains("chrome")) {
				if (osName.contains("window")) {
					cmd = "taskkill /F /FI \"IMAGENAME eq chromedriver*\"";
				} else {
					cmd = "pkill chromedriver";
				}
			} else if (driverInstanceName.contains("internetexplorer")) {
				if (osName.contains("window")) {
					cmd = "taskkill /F /FI \"IMAGENAME eq IEDriverServer*\"";
				}
			} else if (driverInstanceName.contains("firefox")) {
				if (osName.contains("windows")) {
					cmd = "taskkill /F /FI \"IMAGENAME eq geckodriver*\"";
				} else {
					cmd = "pkill geckodriver";
				}
			} else if (driverInstanceName.contains("edge")) {
				if (osName.contains("window")) {
					cmd = "taskkill /F /FI \"IMAGENAME eq msedgedriver*\"";
				} else {
					cmd = "pkill msedgedriver";
				}
			} else if (driverInstanceName.contains("opera")) {
				if (osName.contains("window")) {
					cmd = "taskkill /F /FI \"IMAGENAME eq operadriver*\"";
				} else {
					cmd = "pkill operadriver";
				}
			} else if (driverInstanceName.contains("safari")) {
				if (osName.contains("mac")) {
					cmd = "pkill safaridriver";
				}
			}

			if (driver != null) {
				driver.manage().deleteAllCookies();
				driver.quit();
				System.out.println("Close Driver Instance");
			}
		} catch (Exception e) {
			log.info(e.getMessage());
		} finally {
			try {
				Process process = Runtime.getRuntime().exec(cmd);
				process.waitFor();
			} catch (IOException e) {
				e.printStackTrace();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public void showBrowserConsoleLogs(WebDriver driver) {
		if (driver.toString().contains("chrome")) {
			LogEntries logs = driver.manage().logs().get("browser");
			List<LogEntry> logList = logs.getAll();
			for (LogEntry logging : logList) {
				log.info("-------------" + logging.getLevel().toString() + "-------------\n" + logging.getMessage());
			}
		}
	}
}
