package PageObject;
 
import java.io.IOException;

import java.time.Duration;

import java.util.List;
 
import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.interactions.Actions;

import org.openqa.selenium.support.FindBy;

import org.openqa.selenium.support.PageFactory;

import org.openqa.selenium.support.ui.ExpectedConditions;

import org.openqa.selenium.support.ui.WebDriverWait;
 
import Utilities.ExcelUtilities;
 
public class UsedCars {

	WebDriver driver;

	Actions act;

	WebDriverWait wait;

	String checkTitle = "Used Cars";

	public UsedCars(WebDriver driver)

	{

		this.driver = driver;	

		PageFactory.initElements(driver, this);

		act  = new Actions(driver);

		wait = new WebDriverWait(driver, Duration.ofSeconds(20));

	}

	@FindBy(xpath = "//li[@id='menuusedcars3']")

	WebElement usedCarsTab;

	@FindBy(xpath = "//li[@id='submenu_4usedcars']")

	WebElement usedCarsChennai;

	@FindBy(xpath = "//span[@class='underline cursor-pointer']")

	WebElement readMore;

	@FindBy(xpath = "//td[1]")

	List<WebElement> popCarNames;

	@FindBy(xpath = "//td[2]")

	List<WebElement> popCarPrices;

	public void navigateUsedCarsChennai()

	{

		wait.until(ExpectedConditions.visibilityOf(usedCarsTab));

		act.moveToElement(usedCarsTab).perform();

		usedCarsChennai.click();

	}

	public void clickReadMore()

	{

		readMore.click();

	}

	public void getPopCars() throws IOException

	{

		int xlIndex = 1;

		for(int i = 0; i<popCarNames.size(); i++ )

		{

			ExcelUtilities.updateExcel(String.valueOf(xlIndex), "usedCars", xlIndex, 0);

			ExcelUtilities.updateExcel(popCarNames.get(i).getText(), "usedCars", xlIndex, 1);

			ExcelUtilities.updateExcel(popCarPrices.get(i).getText(), "usedCars", xlIndex, 2);

			System.out.println(i+1 + "." +popCarNames.get(i).getText());

			System.out.println(popCarPrices.get(i).getText());

			System.out.println("\n");

			xlIndex++;

		}

	}


	public boolean checkPopularCarsList()

	{

		return(popCarNames.size() > 0 && popCarPrices.size() > 0);

	}
 
}