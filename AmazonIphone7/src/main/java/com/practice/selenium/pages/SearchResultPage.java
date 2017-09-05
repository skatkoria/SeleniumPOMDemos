package com.practice.selenium.pages;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.practice.selenium.testbase.TestBase;

public class SearchResultPage extends TestBase {

	WebDriver driver;

	public SearchResultPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "twotabsearchtextbox")
	private WebElement searchBar;

	@FindBy(css = "input.nav-input")
	private WebElement searchButton;

	@FindBy(id = "buy-now-button")
	private WebElement buyButton;

	public void searchData(String searchItem) {
		searchBar.sendKeys(searchItem);
		searchButton.click();
	}

	public void getProduct() throws InterruptedException {
		driver.findElement(By.xpath(".//*[@id='result_0']//h2")).click();

		ArrayList<String> tabHandles = new ArrayList<String>(driver.getWindowHandles());
		log.debug("Switched to handle" + tabHandles.get(1));

		driver.switchTo().window(tabHandles.get(1));
		while (!buyButton.isDisplayed()) {
			Thread.sleep(1000);
		}
		buyButton.click();
	}

}
