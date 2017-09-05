package com.practice.selenium.testbase;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestBase {

	public static final Logger log = Logger.getLogger(TestBase.class.getName());

	public WebDriver driver = null;

	public static Properties CONFIG = new Properties();

	public void initializeTestBaseSetup() {
		loadData();
		System.out.println(CONFIG.getProperty("browser"));
		setBrowser(CONFIG.getProperty("browser"));
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		getUrl(CONFIG.getProperty("url"));
	}

	public WebDriver getDriver() {
		return driver;
	}

	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}

	public void loadData() {
		try {
			System.out.println(System.getProperty("user.dir") +"\\src\\main\\resources\\config.properties");
			FileInputStream fs = new FileInputStream(
					System.getProperty("user.dir") +"\\src\\main\\resources\\config.properties");
			CONFIG.load(fs);
			System.out.println("file is loaded");

		} catch (Exception e) {
			System.out.println("file is not loaded");

		}
	}

	public void setBrowser(String browserType) {
		switch (browserType) {
		case "chrome":
			driver = initChromeDriver();
			break;
		case "firefox":
			driver = initFirefoxDriver();
			break;
		default:	
			System.out.println("browser : " + browserType + " is invalid, Launching Firefox as browser of choice..");
			driver = initFirefoxDriver();
		}
	}

	private WebDriver initChromeDriver() {
		System.out.println("Launching Firefox browser..");
			System.out.println(System.getProperty("user.dir"));
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\src\\main\\resources\\chromedriver.exe");
			WebDriver driver = new ChromeDriver();
			driver.manage().window().maximize();
		return driver;
	}

	private WebDriver initFirefoxDriver() {
		System.out.println("Launching Firefox browser..");
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		// driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;
	}

	public void getUrl(String url) {
		System.out.println("navigating to :-" + url);
		driver.get(url);
		driver.manage().window().maximize();
	}

	// @AfterClass
	// public void tearDown() {
	// driver.quit();
	// }
	
	
	

}
