package com.newtours.pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegistrationPage {
	
	private WebDriver driver;
	private WebDriverWait wait;
	
	@FindBy(name = "firstName")
	WebElement firstNameInput;
	
	@FindBy(name = "lastName")
	WebElement lastNameInput;
	
	@FindBy(name = "email")
	WebElement userNameInput;
	
	@FindBy(name = "password")
	WebElement passwordInput;
	
	@FindBy(name = "confirmPassword")
	WebElement confirmPasswordInput;
	
	@FindBy(name = "register")
	WebElement registerButton;
	
	public RegistrationPage(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		PageFactory.initElements(driver, this);
	}
	
	public void goTo() {
		this.driver.get("https://vins-udemy.s3.amazonaws.com/docker/docker-book-flight.html");
		this.wait.until(ExpectedConditions.visibilityOf(this.firstNameInput));
	}
	
	public void enterUserDetails(String firstName, String lastName) {
		this.firstNameInput.sendKeys(firstName);
		this.lastNameInput.sendKeys(lastName);

	}
	
	public void enterUserCredentials(String email, String password) {
		this.userNameInput.sendKeys(email);
		this.passwordInput.sendKeys(password);
		this.confirmPasswordInput.sendKeys(password);
	}
	
	public void submitPage () {
		this.registerButton.click();
	}

}
