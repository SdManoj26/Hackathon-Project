package Hooks;
 
 
import org.openqa.selenium.OutputType;

import org.openqa.selenium.TakesScreenshot;

import org.openqa.selenium.WebDriver;
 
import Factory.BaseClass;

import Utilities.ExcelUtilities;

import io.cucumber.java.After;

import io.cucumber.java.AfterStep;

import io.cucumber.java.Before;

import io.cucumber.java.Scenario;
 
public class Hooks {

	WebDriver driver;


	@Before

	public void startDriver() throws Exception

	{

		BaseClass.setupDriver();

		driver = BaseClass.getDriver();

	}

	@After

	public void tearDown()

	{

		driver.quit();

	}

	 @AfterStep

	    public void addScreenshot(Scenario scenario) {
 
		        TakesScreenshot ts=(TakesScreenshot) driver;

		        byte[] screenshot=ts.getScreenshotAs(OutputType.BYTES);

		        scenario.attach(screenshot, "image/png",scenario.getName());

	        }
 
 
}