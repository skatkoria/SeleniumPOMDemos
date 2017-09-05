package com.practice.selenium.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import com.practice.selenium.testbase.TestBase;

public class HomePage extends TestBase {

	WebDriver driver;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = ".//*[@id='webklipper-publisher-widget-container-notification-close-div']")
	private WebElement closePopUp;

	@FindBy(css = "#ch_login_icon>span:nth-child(1)")
	private WebElement loginLink;

	@FindBy(id = "ch_login_email")
	private WebElement userName;

	@FindBy(id = "ch_login_password")
	private WebElement password;

	@FindBy(id = "ch_login_forgetpassword")
	private WebElement linkForgetPassword;

	@FindBy(id = "ch_login_btn")
	private WebElement btnLogIn;

	@FindBy(xpath = ".//*[@id='ch_login_email_error']/span[2]")
	public WebElement errorLogin;

	public void clickLogInLink() throws InterruptedException {

		List<WebElement> iframeElements = driver.findElements(By.tagName("iframe"));
		// if(isElementPresent(By.xpath(".//*[@id='webklipper-publisher-widget-container-notification-close-div']")))
		// driver.switchTo().frame("notification-frame-31764456");
		if (iframeElements.size() > 0) {
			driver.switchTo().frame("webklipper-publisher-widget-container-notification-frame");
			closePopUp.click();
			driver.switchTo().defaultContent();
			Thread.sleep(3000);
		}
		log.info("clicking on login link ");
		loginLink.click();
	}

	public void signIn(String userName, String password) {

		this.userName.sendKeys(userName);
		this.password.sendKeys(password);

		log.info("Here you go with login ");
		this.btnLogIn.click();

	}

	public boolean isElementVisible(String cssLocator) {
		return driver.findElement(By.cssSelector(cssLocator)).isDisplayed();
	}

	public boolean isElementPresent(By locatorKey) {
		try {
			driver.findElement(locatorKey);
			return true;
		} catch (org.openqa.selenium.NoSuchElementException e) {
			return false;
		}
	}
}
