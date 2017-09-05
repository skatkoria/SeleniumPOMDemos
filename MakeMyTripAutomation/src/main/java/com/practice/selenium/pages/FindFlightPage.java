package com.practice.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import com.practice.selenium.testbase.TestBase;

public class FindFlightPage extends TestBase {

	WebDriver driver;

	public FindFlightPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = ".//*[@id='hp-widget__sfrom']")
	private WebElement fromFlight;

	@FindBy(xpath = ".//*[@id='hp-widget__sTo']")
	private WebElement toFlight;

	@FindBy(xpath = ".//*[@id='hp-widget__depart']")
	private WebElement departDate;

	@FindBy(xpath = ".//*[@id='hp-widget__return']")
	private WebElement returnDate;

	@FindBy(xpath = ".//*[@id='hp-widget__paxCounter']")
	private WebElement paxCount;

	@FindBy(xpath = ".//*[@id='hp-widget__class']")
	private WebElement flightClass;

	@FindBy(xpath = ".//*[@id='searchBtn']")
	private WebElement searchFlight;

	@FindBy(xpath = "(.//*[@class='dateFilter hasDatepicker']//tbody//tr[2]//td[7]/a)[2]")
	public WebElement Oct8;

	@FindBy(xpath = "(.//*[@class='dateFilterReturn hasDatepicker']//tbody//tr[3]//td[7]/a)[1]")
	public WebElement Oct15;

	@FindBy(xpath = ".//*[@id='js-adult_counter']/li[2]")
	public WebElement adult;

	@FindBy(xpath = ".//label[@for=\"classBTN__input_1\"]")
	public WebElement economy;

	public void searchFlight(String fromFlight, String toFlight, WebElement departDate, WebElement returnDate,
			int paxCount, WebElement flightClass) throws InterruptedException {
		this.fromFlight.clear();
		this.fromFlight.sendKeys(fromFlight);
		this.toFlight.clear();
		this.toFlight.sendKeys(toFlight);

		// JavascriptExecutor js = (JavascriptExecutor)driver ;
		// js.executeScript("document.getElementById('hp-widget__depart').value='8 Oct,
		// Sun'");

		this.paxCount.click();
		driver.findElement(By.xpath(".//*[@id='js-adult_counter']/li[" + paxCount + "]")).click();

		this.flightClass.click();
		flightClass.click();

		this.departDate.click();
		departDate.click();

		this.returnDate.click();
		returnDate.click();

		// js.executeScript("document.getElementById('hp-widget__return').value=''");
		// js.executeScript("document.querySelector('#hp-widget__return').value='15 Oct,
		// Sun'");
		// js.executeScript("document.querySelector('#searchBtn').click()");
		//
		searchFlight.click();
		Reporter.log("Searching flights");

	}

}
