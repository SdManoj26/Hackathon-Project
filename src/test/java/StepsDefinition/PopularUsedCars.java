package StepsDefinition;
 
import java.io.IOException;
 
import org.openqa.selenium.WebDriver;

import org.junit.Assert;
 
import Factory.BaseClass;

import PageObject.HomePage;

import PageObject.UsedCars;

import io.cucumber.java.en.Given;

import io.cucumber.java.en.Then;

import io.cucumber.java.en.When;
 
 
public class PopularUsedCars {

	WebDriver driver;

	UsedCars usedCars;

	HomePage hp;

	@Given("navigated to used Cars in chennai page")

	public void naviagteUsedCarsPage() {


		driver = BaseClass.getDriver();

		usedCars = new UsedCars(driver);

		usedCars.navigateUsedCarsChennai();

		BaseClass.getLogger().info("Navigated to Used Cars in Chennai page");


	}
 
	@When("Clicked on read more button")

	public void readMore() {

	    usedCars.clickReadMore();

	    BaseClass.getLogger().info("Clicked on Read More Button");


	}
 
	@Then("print the popular cars details")

	public void printPopularCarsChennai() throws IOException {

	   usedCars.getPopCars();

	   BaseClass.getLogger().info("Retrived Popular Cars in Chennai");

	   Assert.assertEquals(true, usedCars.checkPopularCarsList());

	}
 
}