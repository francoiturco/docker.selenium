package com.newtours.pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FlightDetailsPage {
	
	private WebDriver driver;
	private WebDriverWait wait;
	
	@FindBy(name = "passCount")
	private WebElement  passangersField ;
	
	@FindBy(name = "findFlights")
	private WebElement  continueButton ;
	
	public FlightDetailsPage(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		PageFactory.initElements(driver, this);
	}
	
	public void selectPassangers (String noOfPassangers) {
		this.wait.until(ExpectedConditions.elementToBeClickable(this.passangersField));
		Select select = new Select(passangersField);
		select.selectByValue(noOfPassangers);
	}
	
	public void goToFindFlightsPage () {
		this.continueButton.click();
	}

}