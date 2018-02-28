package com.revature.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;


public class NewTest {
	private static WebDriver driver;
	private static String url = "http://newtours.demoaut.com/";
	int testCount = 0;
	
  @Test
  public void f() {
	  try {
	// Set system variable to point to our chromedriver.exe 
			System.setProperty(System.getenv("webdriver"), System.getenv(System.getenv("mydriver")));
			
			// Have our driver become an instance of a ChromeDriver()
			driver = new ChromeDriver();
			
			// Launch driver are indicated url
			driver.get(url);
			
			checkTitle("Welcome: Mercury Tours");
			
			// sendKeys in order to type in fields 
			driver.findElement(By.name("userName")).sendKeys("bobbert");
			driver.findElement(By.name("password")).sendKeys("bobbert");
			
			// click in order to simlate a mouse click
			driver.findElement(By.name("login")).click();
			
			driver.findElement(By.xpath("//tr")).click();
			// NoSuchElementException 

			
			checkTitle("Find a Flight: Mercury Tours:");
			
			driver.findElement(By.cssSelector("input[value='oneway']")).click();
			
			driver.findElement(By.xpath("//input[@value='roundtrip']")).click();
			
			// Always quit your driver (if exception occurs it will not close automatically)
			driver.quit();
	  } catch (Exception e) {
		  Assert.assertFalse(true);
	  }
  }
  
  public void checkTitle(String expected) {
		String actual = driver.getTitle();
		testCount++;
		String testString = "TEST " + testCount + " : ";
		
		Assert.assertTrue(actual.equals(expected));
		Assert.assertEquals("b", expected);
		Assert.assertEquals(actual, "a");
		
		if (!actual.equals(expected)) {
			System.out.println(testString);
			System.out.println("Expected: \'" + expected + "\'");
			System.out.println("Actual: \'" + actual + "\'");
		} else {
			System.out.println(testString);
			System.out.println("pass");
		}
	}

}
