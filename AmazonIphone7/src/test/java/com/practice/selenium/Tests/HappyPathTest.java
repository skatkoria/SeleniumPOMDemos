package com.practice.selenium.Tests;

import java.io.IOException;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.practice.selenium.pages.HomePage;
import com.practice.selenium.pages.SearchResultPage;
import com.practice.selenium.testbase.TestBase;

public class HappyPathTest extends TestBase {

	@BeforeClass
	public void setUp() throws IOException {
		initializeTestBaseSetup();
	}

	@Test
	public void TC_AddIPhone() throws InterruptedException {
		log.info("Executing TC_AddIPhone");
		HomePage homePage = new HomePage(driver);
		homePage.clickSignIn();
		homePage.signIn("bharatkatkoria@gmail.com", "bharat123#", true);

		SearchResultPage searchResultPage = new SearchResultPage(driver);
		log.info("searching product");
		searchResultPage.searchData("iphone 7 jet black 128 gb");

		searchResultPage.getProduct();

	}
	
	@AfterClass
	void cleanUp()
	{
	driver.quit();
	}
	}

