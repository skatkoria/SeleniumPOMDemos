package com.practice.selenium.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;

import com.practice.selenium.testbase.TestBase;

public class SearchResultPage extends TestBase {

	WebDriver driver;

	public SearchResultPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "a[class*='modify_search_toggle']")
	private WebElement modifySearch;

	@FindBy(id = "retDay")
	private WebElement dayReturn;

	@FindBy(xpath = ".//*[@id='ui-datepicker-div']//tr[3]/td[5]/a")
	private WebElement Oct13;

	@FindBy(css = "div[class='col-sm-6 col-xs-6'] a")
	private WebElement classBusiness;

	@FindBy(xpath = "//a[text()='Search']")
	private WebElement searchButton;

	@FindBy(xpath = "//a[text()='Book']")
	private WebElement bookFlight;

	@FindBy(xpath = ".//*[@id='content']/div[2]/div[4]/div[1]/div[2]/div[1]/div/p//strong")
	public List<WebElement> fareList;

//	@FindBy(xpath = "(.//*[contains(text(), 'GRAND TOTAL')]//following-sibling::span)[1]")
	@FindBy(xpath = "(.//span[contains(@class,'text-right review_red ng-binding')])[2]")
	public WebElement grandTotal;

	public void modifySearch() {
		modifySearch.click();
		dayReturn.click();
		Oct13.click();
		classBusiness.click();
		searchButton.click();
	}

	public void bookFLight() {
		bookFlight.click();
		int actualAmount = 0;
		for (WebElement fare : fareList) {
			String[] f = fare.getText().split("Rs. ");
			actualAmount += Integer.parseInt(f[1].replace(",", ""));

		}

		String[] amount = grandTotal.getText().split("Rs. ");
		int expectedAmount = Integer.parseInt(amount[1].replace(",", ""));
		Reporter.log("expected Amount "+expectedAmount);
		Reporter.log("actual Amount "+actualAmount);
		Assert.assertEquals(actualAmount, expectedAmount);
	}
}