package com.newtours.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.newtours.pages.FindFlightPage;
import com.newtours.pages.FlightConfirmationPage;
import com.newtours.pages.FlightDetailsPage;
import com.newtours.pages.RegistrationConfirmationPage;
import com.newtours.pages.RegistrationPage;

import tests.BaseTest;

public class BookFlightTest extends BaseTest {
	
	private String noOfPassangers;
	private String expectedPrice;
	
	@BeforeTest
	@Parameters({"noOfPassangers", "expectedPrice"})
	public void stupParameters(String noOfPassangers, String expectedPrice) {
		this.noOfPassangers = noOfPassangers;
		this.expectedPrice = expectedPrice;
	}
	
	@Test
	public void registrationPage() {
		RegistrationPage registrationPage = new RegistrationPage(driver);
		registrationPage.goTo();
		registrationPage.enterUserDetails("Cristian", "Romero");
		registrationPage.enterUserCredentials("cromero", "cromero*12");
		registrationPage.submitPage();
	}
	
	@Test(dependsOnMethods = "registrationPage")
	public void registrationConfirmationPage() {
		RegistrationConfirmationPage registrationConfirmationPage = new RegistrationConfirmationPage(driver);
		registrationConfirmationPage.goToFlightsDetailsPage();
	}
	
	@Test(dependsOnMethods = "registrationConfirmationPage")
	public void flightDetailsPage() {
		FlightDetailsPage flightDetailsPage = new FlightDetailsPage(driver);
		flightDetailsPage.selectPassangers(noOfPassangers);
		flightDetailsPage.goToFindFlightsPage();
	}
	
	@Test(dependsOnMethods = "flightDetailsPage")
	public void findFlightPage() {
		FindFlightPage findFlightPage = new FindFlightPage(driver);
		findFlightPage.submitFindFlightPage();
		findFlightPage.goToFlightConfirmationPage();
	}
	
	@Test(dependsOnMethods = "findFlightPage")
	public void flightConfirmationPage() {
		FlightConfirmationPage flightConfirmationPage = new FlightConfirmationPage(driver);
		String actualPrice = flightConfirmationPage.getPrice();
		Assert.assertEquals(actualPrice, expectedPrice);
	}

}
