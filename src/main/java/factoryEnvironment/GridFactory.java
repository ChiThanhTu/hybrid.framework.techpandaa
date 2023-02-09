package factoryEnvironment;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import commons.GlobalConstants;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GridFactory {
	private WebDriver driver;
	private String browserName;
	private String ipAddress;
	private String port;

	public GridFactory(String browserName, String ipAddress, String port) {
		this.browserName = browserName;
		this.ipAddress = ipAddress;
		this.port = port;
		
	}

	public WebDriver createDriver() {
		BrowserList browserList = BrowserList.valueOf(browserName.toUpperCase());
		DesiredCapabilities capability = null;

		switch (browserList) {
		case CHROME:
			WebDriverManager.chromedriver().setup();
			capability = DesiredCapabilities.chrome();
			capability.setBrowserName("chrome");
			capability.setPlatform(Platform.ANY);
			ChromeOptions COptions = new ChromeOptions();
			COptions.merge(capability);
//			driver = new ChromeDriver();

//			File file = new File(GlobalConstants.PROJECT_PATH + File.separator + "browserExtensions" + File.separator
//					+ "extension_4_6_0_0.crx");
//			ChromeOptions optionsC = new ChromeOptions();
//			optionsC.addExtensions(file);
//			driver = new ChromeDriver(optionsC);
			break;
		case H_CHROME:
			WebDriverManager.chromedriver().setup();
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--headless");
			options.addArguments("window-size=1920x1080");
			driver = new ChromeDriver(options);
			break;
		case H_FIREFOX:
			WebDriverManager.firefoxdriver().setup();
			FirefoxOptions options1 = new FirefoxOptions();
			options1.addArguments("--headless");
			options1.addArguments("window-size=1920x1080");
			driver = new FirefoxDriver(options1);
			break;
		case FIREFOX:
			System.setProperty("webdriver.gecko.driver", GlobalConstants.getGlobalConstants().getProjectPath() + "\\browserDrives\\geckodriver.exe");
			System.setProperty(FirefoxDriver.SystemProperty.DRIVER_USE_MARIONETTE, "true");
			System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE,
					GlobalConstants.getGlobalConstants().getProjectPath() + File.separator + "browserLogs" + File.separator + "Firefox.log");
			capability = DesiredCapabilities.firefox();
			capability.setBrowserName("firefox");
			capability.setPlatform(Platform.ANY);
			FirefoxOptions fOptions = new FirefoxOptions();
			fOptions.merge(capability);
//			driver = new FirefoxDriver();

//			FirefoxProfile profile = new FirefoxProfile();
//			File extensionFile = new File(GlobalConstants.PROJECT_PATH + File.separator + "browserExtensions"
//					+ File.separator + "to_google_translate-4.2.0.xpi");
//			profile.addExtension(extensionFile);
//			FirefoxOptions optionsF = new FirefoxOptions();
//			optionsF.setProfile(profile);
//			driver = new FirefoxDriver(optionsF);
			///
//			driver = WebDriverManager.firefoxdriver().create();
			break;
		case EDGE:
			driver = WebDriverManager.edgedriver().create();
			break;
		default:
			throw new RuntimeException("Browser name isn't valid");

		}
		try {
			driver = new RemoteWebDriver(new URL(String.format("http://%s:%s/wd/hub", ipAddress, port)), capability);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		return driver;
	}
}
