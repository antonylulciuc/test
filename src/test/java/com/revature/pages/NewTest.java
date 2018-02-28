package com.revature.pages;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class NewTest {
	private static WebDriver driver;
	private static String url = "http://newtours.demoaut.com/";
	
  @Test(dependsOnMethods="beforeTest", groups= {"smoke"} )
  public void f() {
	  driver.get(url);
	  Assert.assertEquals( driver.getTitle(), "Welcome: Mercury Tours");
  }
  
  @Test(dependsOnMethods = {"f"} ,dataProvider="provideAccountDetailsDynamic", groups = {"regression", "somethingelse"})
  public void f2(String username, String password) {
	  MercuryLoginFactory mlf = new MercuryLoginFactory(driver);
	  mlf.driverLogIntoMercury(username, password);
	  Assert.assertEquals( driver.getTitle(), "Find a Flight: Mercury Tours:");
	  driver.findElement(By.xpath("//a[containers(text(), 'Home']")).click();
  }
  
  
  @BeforeTest(groups= {"smoke", "regression"})
  public void beforeTest() {
	  System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
	  driver = new ChromeDriver();
	  driver.get(url);
  }

  @AfterTest(groups= {"smoke", "regression"})
  public void afterTest() {
	  driver.quit();
  }

  @DataProvider 
  public Object[][] provideAccountDetails() {
	  return new Object[][] {
		  {"bobbert", "bobbert"},
		  {"gar", "gar"},
		  {"bar", "bar"}
	  };
  }
  
  
  @DataProvider
  public Object[][] provideAccountDetailsDynamic() throws IOException {
	  File file = new File("src/test/resources/mercurydata.xlsx");
	  FileInputStream fis = new FileInputStream(file);
	  Workbook book = new XSSFWorkbook(fis);
	  Sheet sheet = book.getSheet("Sheet1");
	  int rowNum = sheet.getLastRowNum() - sheet.getFirstRowNum();
	  
	  Object[][] data = new Object[rowNum][2];
	  
	  for (int i = 1; i <= rowNum; i++) {
		  Row row = sheet.getRow(i);
		  data[i-1] = new Object[] {
				  row.getCell(0).getStringCellValue(),
				  row.getCell(1).getStringCellValue()
		  };
	  }
	  
	  
	  return data;
  }
  
}
