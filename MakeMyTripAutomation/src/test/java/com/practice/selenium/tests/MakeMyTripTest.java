package com.practice.selenium.tests;

import org.testng.annotations.Test;

import com.practice.selenium.pages.HomePage;
import com.practice.selenium.pages.SearchResultPage;
import com.practice.selenium.pages.FindFlightPage;
import com.practice.selenium.testbase.TestBase;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeClass;

import java.io.IOException;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;

public class MakeMyTripTest extends TestBase {

	@BeforeMethod
	public void setUp() throws IOException {
		initializeTestBaseSetup();
	}

	@Test
	public void Login_Positive() throws InterruptedException {
		HomePage homePage = new HomePage(driver);
		homePage.clickLogInLink();
		homePage.signIn("rohit.ware@clariontechnologies.co.in", "makemytrip13");
		Reporter.log("Logged In successfully");

	}

	@Test
	public void Login_Negative() throws InterruptedException {
		HomePage homePage = new HomePage(driver);
		homePage.clickLogInLink();
		homePage.signIn("", "makemytrip13");
		Assert.assertEquals(homePage.errorLogin.getText(), "Please enter an Email Address");
	}

	@Test
	public void SearchFlightTest() throws InterruptedException {
		log.info("Executing TC_AddIPhone");
		HomePage homePage = new HomePage(driver);
		homePage.clickLogInLink();
		homePage.signIn("rohit.ware@clariontechnologies.co.in", "makemytrip13");
		Reporter.log("Logged In successfully");

		FindFlightPage flightPage = new FindFlightPage(driver);
		flightPage.searchFlight("Pune, India", "Ahmedabad, India ", flightPage.Oct8, flightPage.Oct15, 2,
				flightPage.economy);

		SearchResultPage searchResultPage = new SearchResultPage(driver);
		searchResultPage.modifySearch();
		searchResultPage.bookFLight();

	}

	@AfterMethod
	public void afterMethod() {
		driver.close();
	}
}
