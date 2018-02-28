package com.revature.mercury;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.revature.pages.MercuryLogin;

public class Driver {
	static WebDriver driver;
	static String url = "http://newtours.demoaut.com/";
	static int testCount = 0;
	
	public static void main(String[] args) {
		MercuryLogin md;
		WebDriverWait web;
		// Set system variable to point to our chromedriver.exe 
		System.setProperty("webdriver.chrome.driver", System.getenv("mydriver"));
		
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
	}
	
	
	public static void checkTitle(String expected) {
		String actual = driver.getTitle();
		testCount++;
		String testString = "TEST " + testCount + " : ";
		
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
