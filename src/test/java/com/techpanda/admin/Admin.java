package com.techpanda.admin;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import commons.BaseTest;

public class Admin extends BaseTest {
	WebDriver driver;
	@Parameters({ "envName", "serverName", "browserName", "ipAddress", "port", "osName", "osVersion" })
	@BeforeClass
	public void beforeClass(@Optional("local") String envName, @Optional("DEV") String serverName,
			@Optional("Chrome") String browserName, @Optional("localhost") String ipAddress,
			@Optional("5555") String port, @Optional("Windows") String osName, @Optional("10") String osVersion) {
		driver = getBrowserDriver(envName, serverName, browserName, ipAddress, port, osName, osVersion);
		
	}
}
