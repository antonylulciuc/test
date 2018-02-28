package com.revature.glue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.AssertJUnit;

import com.revature.pages.MercuryLoginFactory;

import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;

public class Glue {
	private static WebDriver driver;
	private static String url = "http://newtours.demoaut.com/";
	
	  @Given("^I am at the landing of Mercury$")
	  public void f() {
		  AssertJUnit.assertEquals( driver.getTitle(), "Welcome: Mercury Tours");
	  }
	  
	  @When("^I login with \"(.*)\" and password \"(.*)\"$")
	  public void f2(String username, String password) {
		  MercuryLoginFactory mlf = new MercuryLoginFactory(driver);
		  mlf.driverLogIntoMercury(username, password);
	  }
	  
	  
	  @When("^I login with \"(.*)\" and \"(.*)\"$")
	  public void f3(String username, String password) {
		  MercuryLoginFactory mlf = new MercuryLoginFactory(driver);
		  mlf.driverLogIntoMercury(username, password);
	  }

	  @Given("^I should be at the find flights page$")
	  public void f4() {
		  String title = driver.getTitle();
		  AssertJUnit.assertEquals( driver.getTitle(), "Sign-on: Mercury Tours");
	  }
	  
	  @Given("^I arrive at the findFlights page$")
	  public void f5() {
		  String title = driver.getTitle();
		  AssertJUnit.assertEquals( driver.getTitle(), "Sign-on: Mercury Tours");
	  }
	  
	  @Given("^Open landing page$")
	  public void beforeTest() {
		  System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		  driver = new ChromeDriver();
		  driver.get(url);
	  }
	
	  @After("@smoke")
	  public void afterTest() {
		  if (driver != null)
		  driver.quit();
	  }
}
