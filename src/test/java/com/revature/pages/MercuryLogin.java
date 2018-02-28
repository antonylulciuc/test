package com.revature.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MercuryLogin {
	/**
	 * Page object model is a design pattern used within test automation. it stems from creating a class to represent 
	 * each and ecery page of the application.  One class per page the class will server as an object repository for that page, that is, every
	 * interacable element for that page should be identified and given an instance within this class
	 * 
	 */
	
	//You will always pass in the current drive
	private WebDriver driver;
	
	By username = By.xpath("//input[@name='userName']");
	By password = By.xpath("//input[@name='password']");
	By login = By.xpath("//input[@name='login']");

	public MercuryLogin(WebDriver driver) {
	
		this.driver = driver;
	}
	
	public void inputUsername(String username) {
		driver.findElement(this.username).sendKeys(username);
	}

	public void inputPassword(String password) {
		driver.findElement(this.password).sendKeys(password);
	}
	
	
	public void submitLogin() {
		driver.findElement(login).click();
	}
	
	public void driverLogIntoMercury(String username, String password) {
		inputUsername(username);
		inputPassword(password);
		submitLogin();
	}
	
	
}
