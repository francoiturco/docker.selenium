package com.newtours.pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FlightConfirmationPage {
	
	private WebDriver driver;
	private WebDriverWait wait;
	
	@FindBy(xpath = "//font[contains(text(),'Flight Confirmation')]")
	private WebElement  flightConfirmationText ;
	
	@FindBy(xpath = "//font[contains(text(),'USD')]")
	private List<WebElement> totalPriceText ;
	
	@FindBy(how = How.LINK_TEXT, using = "SIGN-OFF")
	private WebElement  signOffLink ;
	
	public FlightConfirmationPage(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		PageFactory.initElements(driver, this);
	}
	
	public String getPrice () {
		this.wait.until(ExpectedConditions.visibilityOf(this.flightConfirmationText));
		System.out.println(this.flightConfirmationText.getText());
		System.out.println(this.totalPriceText.get(1).getText());
		String price = this.totalPriceText.get(1).getText();
		this.signOffLink.click();
		return price;
	}

}
