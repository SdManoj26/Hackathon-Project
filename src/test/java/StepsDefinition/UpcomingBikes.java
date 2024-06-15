package StepsDefinition;
 
import java.io.IOException;
 
import org.junit.Assert;

import org.openqa.selenium.WebDriver;
 
import Factory.BaseClass;

import PageObject.HomePage;

import PageObject.UpcomingBikesPage;

import Utilities.ExcelUtilities;

import io.cucumber.java.en.Given;

import io.cucumber.java.en.Then;

import io.cucumber.java.en.When;
 
public class UpcomingBikes {

	WebDriver driver;

	HomePage hp;

	UpcomingBikesPage upBike;
 
	


	@Given("application is opened \\(91Wheels)")

	public void openApplication(){

		driver = BaseClass.getDriver();

		BaseClass.getLogger().info("Opened Application");

		hp = new HomePage(driver);

		upBike = new UpcomingBikesPage(driver);

		hp.disagreeNotifications();

		BaseClass.getLogger().info("Clicked on May be later");

		Assert.assertEquals(true , hp.checkOpenApplication());

	}
 
	@Given("navigated to upcoming bikes page")

	public void naviagteUpcomingBikes() throws IOException {

		ExcelUtilities.createExcelFile();

		hp.moveToBikesTab();

		BaseClass.getLogger().info("Moved to Bikes Tab");

		hp.clickUpcomingBikes();

		BaseClass.getLogger().info("Clicked on Upcoming Bikes");


	}
 
	@When("Honda is selected from the bike brands")

	public void selectBrand() {

		String bikeBrand = "Honda";

		upBike.selectBrand(bikeBrand);

		BaseClass.getLogger().info("Selected the Brand:" +bikeBrand);

		Assert.assertEquals(true, upBike.checkBrandSeleted(bikeBrand));

	}
 
	@When("Load more is clicked")

	public void clickLoadMore() throws InterruptedException {

		upBike.loadMoreResuts();

		BaseClass.getLogger().info("Clicked on Load More Button");

	}
 
	@Then("print bike name, expected price and launch date of bikes priced below 4Lakhs")

	public void getBikesDetails() throws InterruptedException, IOException {

		upBike.getUpcomeingBikesDetails();

		BaseClass.getLogger().info("Retrived the Upcoming bikes");

		Assert.assertEquals(true, upBike.checkUpcomingBikesList());

	}
 
 
 
}
