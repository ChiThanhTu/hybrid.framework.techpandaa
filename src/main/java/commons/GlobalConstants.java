package commons;

import java.io.File;

import lombok.Getter;
@Getter
public class GlobalConstants {
	private static GlobalConstants globalInstance;

	private GlobalConstants() {

	}

	public static synchronized GlobalConstants getGlobalConstants() {
		if (globalInstance == null) {
			globalInstance = new GlobalConstants();
		}
		return globalInstance;
	}

	
private final String projectPath = System.getProperty("user.dir");
private final String osName = System.getProperty("os.name");
private final String javaVersion = System.getProperty("java.version");

private final String devUserUrl = "http://dev.techpanda.org/";
private final String stagingUserUrl = "http://staging.techpanda.org/";
private final String liveUserUrl = "http://live.techpanda.org/";
private final String devaDminrUrl = "http://dev.techpanda.org/index.php/backendlogin";
private final String stagingAdminUrl = "http://staging.techpanda.org/index.php/backendlogin";
private final String liveAdminUrl = "http://live.techpanda.org/index.php/backendlogin";

private final String adminUser = "user01";
private final String adminPasswod = "guru99com";

private final long shortTimeout = 3;
private final long longTimeout = 15;

private final String uploadFiles = projectPath + "/uploadFiles/";
private final String downloadFiles = projectPath + "/downloadFiles/";

private final int retryNumber = 3;

private final String browserLogPath = projectPath + File.separator +"bowserLogs"+ File.separator;
private final String browserExtensionPath = projectPath + File.separator + "bowserExtension"+ File.separator;

private final String reportScreenPath = projectPath + "/ReportNGScreenShots";
private final String extentPath = projectPath + "/htmlExtentScreenShots";
private final String allurePath = projectPath + "/htmlAllure";

private final String browserStackUserName = "tuschi_CGaPXQ";
private final String browserStackAutomateKey = "NtK9PRudRusn9wenJxNF";
private final String browserStackUrl = "https://" + browserStackUserName + ":" + browserStackAutomateKey + "@hub-cloud.browserstack.com/wd/hub";
private final String sauceUserName = "oauth-tuemm1976-07d9b";
private final String sauceAutomateKey = "b4c2bc67-38eb-45a9-b8c4-a2955409d462";
private final String sauceLabUrl = "https://" + sauceUserName + ":" + sauceAutomateKey + "@ondemand.us-west-1.saucelabs.com:443/wd/hub";
private final String lambdaUserName = "tuemm1976";
private final String lambdaAutomateKey = "A7afic11QJNR8dRDIpeKaUFe2FXRqxmZyul6SaHqdNTyIihTAb";
private final String lambdabUrl = "https://" + lambdaUserName + ":" + lambdaAutomateKey + "@hub.lambdatest.com/wd/hub";
}