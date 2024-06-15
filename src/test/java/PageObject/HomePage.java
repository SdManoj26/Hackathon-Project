package PageObject;
 
import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.interactions.Actions;

import org.openqa.selenium.support.FindBy;

import org.openqa.selenium.support.PageFactory;
 
public class HomePage {

	WebDriver driver;

	Actions act;

	public HomePage(WebDriver driver)

	{

		this.driver = driver;

		PageFactory.initElements(driver, this);

		act = new Actions(driver);

	}


	@FindBy(xpath = "//div[@class='grid grid-cols-2 gap-4']/span[1]")

	WebElement mayBeLater;

	@FindBy(xpath = "//li[@id='menubike1']")

	WebElement bikesTab;

	@FindBy(xpath = "//li[@id='menubike1']/ul/li[@id='submenu_5bike']")

	WebElement upcomingBikesTab;

	@FindBy(xpath = "//div[@class='relative flex items-center justify-center cursor-pointer']")

	WebElement logInIcon;


	public void disagreeNotifications()

	{

		try

		{

			mayBeLater.click();

		}

		catch(Exception e)

		{

			System.out.println("No notification access pop up appeared");

		}

	}

	public void moveToBikesTab()

	{

		act.moveToElement(bikesTab).perform();

	}

	public void clickUpcomingBikes()

	{

		upcomingBikesTab.click();

	}
 
	public void clickLoginBtn()

	{

		logInIcon.click();

	}

	public boolean checkOpenApplication()

	{

		String pageTitle = "New Cars, New Bikes";

		return(driver.getTitle().contains(pageTitle));

	}



}