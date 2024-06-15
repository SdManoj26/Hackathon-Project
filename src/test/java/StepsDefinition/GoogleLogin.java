package StepsDefinition;
 
import java.io.IOException;
 
import org.junit.Assert;

import org.openqa.selenium.WebDriver;
 
import Factory.BaseClass;

import PageObject.GoogleLoginPage;

import PageObject.HomePage;

import io.cucumber.java.en.Given;

import io.cucumber.java.en.Then;

import io.cucumber.java.en.When;
 
public class GoogleLogin {

	WebDriver driver;

	HomePage hp;

	GoogleLoginPage gLog;

	@Given("navigated login Window")

	public void navigateLoginWindow() {

		driver = BaseClass.getDriver();

	    hp = new HomePage(driver);

	    gLog = new GoogleLoginPage(driver);

	    hp.clickLoginBtn();

	    BaseClass.getLogger().info("Clicked on Login button");

	}
 
	@When("sign in with google button clicked")

	public void signInWithGoogle() {

		gLog.clickGoogleSignIn();

		BaseClass.getLogger().info("Click on sign in using Google option");

	}
 
	@When("entered email and clicked next")

	public void putMail() {

		String email = BaseClass.randomEmail();

		gLog.swithtoWindow();

		BaseClass.getLogger().info("Swithched to Google window");

		gLog.enterEmail(email);

		BaseClass.getLogger().info("Entered Email");

		gLog.clickNext();

		BaseClass.getLogger().info("Clicked on Next Button");

	}
 
	@Then("print the error message")

	public void printErrorMsg() throws IOException {

	    gLog.getErrorMsg();

	    BaseClass.getLogger().info("Retrived Error Message");

	    Assert.assertEquals(gLog.checkErrorMsg(), true);

	}
 
 
	

 
}
