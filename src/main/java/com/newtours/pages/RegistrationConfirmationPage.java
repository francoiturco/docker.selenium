package com.newtours.pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegistrationConfirmationPage {
	
	private WebDriver driver;
	private WebDriverWait wait;
	
	@FindBy(partialLinkText = "sign-in")
	private WebElement  signInLink ;
	
	@FindBy(partialLinkText = "Flights")
	private WebElement  flightsLink ;
	
	public RegistrationConfirmationPage(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		PageFactory.initElements(driver, this);
	}
	
	public void goToFlightsDetailsPage() {
		this.wait.until(ExpectedConditions.visibilityOf(this.signInLink));
		this.flightsLink.click();
	}

}
