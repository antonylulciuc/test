package com.revature.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MercuryLoginFactory {
	/**
	 * Page object model is a design pattern used within test automation. it stems from creating a class to represent 
	 * each and ecery page of the application.  One class per page the class will server as an object repository for that page, that is, every
	 * interacable element for that page should be identified and given an instance within this class
	 * 
	 */
	
	/*
	 * PageFactory is a class that aids in implementing page object model design pattern. it 
	 * seeks to inject the proper instances of webelements upon instantiation of a class.
	 * it provieds are moreefficient way to implement pom
	 * as opposed to implementing 
	 */
	@FindBy(xpath="//input[@name='userName']")
	WebElement username;
	

	@FindBy(xpath="//input[@name='password']")
	WebElement password;

	@FindBy(xpath="//input[@name='login']")
	WebElement login;
	
	
	public MercuryLoginFactory(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void inputUsername(String username) {
		this.username.sendKeys(username);
	}

	public void inputPassword(String password) {
		this.password.sendKeys(password);
	}
	
	
	public void submitLogin() {
		login.click();
	}
	
	public void driverLogIntoMercury(String username, String password) {
		inputUsername(username);
		inputPassword(password);
		submitLogin();
	}
	
	
}
