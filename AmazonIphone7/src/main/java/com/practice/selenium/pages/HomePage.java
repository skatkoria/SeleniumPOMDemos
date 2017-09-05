package com.practice.selenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.practice.selenium.testbase.TestBase;

public class HomePage extends TestBase {

	WebDriver driver;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "#nav-link-yourAccount > span.nav-line-1")
	private WebElement signInBox;

	@FindBy(id = "ap_email")
	private WebElement userName;

	@FindBy(id = "ap_password")
	private WebElement password;

	@FindBy(name = "rememberMe")
	private WebElement rememberMe;

	@FindBy(id = "signInSubmit")
	private WebElement signInSubmit;

	public void clickSignIn() {
		signInBox.click();
	}

	public void signIn(String userName, String password, boolean rememberMe) {

		this.userName.sendKeys(userName);
		this.password.sendKeys(password);
		if (rememberMe)
			this.rememberMe.click();
		log.info("Here you go with login ");
		this.signInSubmit.click();

	}

}
