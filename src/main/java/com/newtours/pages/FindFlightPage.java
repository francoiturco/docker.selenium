package com.newtours.pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FindFlightPage {
	
	private WebDriver driver;
	private WebDriverWait wait;
	
	@FindBy(name = "reserveFlights")
	private WebElement  continueButton ;
	
	@FindBy(name = "buyFlights")
	private WebElement  continueButton2 ;
	
	public FindFlightPage(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		PageFactory.initElements(driver, this);
	}
	
	public void submitFindFlightPage () {
		this.wait.until(ExpectedConditions.elementToBeClickable(this.continueButton));
		this.continueButton.click();
	}
	
	public void goToFlightConfirmationPage () {
		this.wait.until(ExpectedConditions.elementToBeClickable(this.continueButton2));
		this.continueButton2.click();
	}

}
