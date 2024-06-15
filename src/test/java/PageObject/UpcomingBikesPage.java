package PageObject;
 
import java.io.IOException;

import java.time.Duration;

import java.util.List;
 
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;

import org.openqa.selenium.support.PageFactory;

import org.openqa.selenium.support.ui.ExpectedConditions;

import org.openqa.selenium.support.ui.Select;

import org.openqa.selenium.support.ui.WebDriverWait;
 
import Utilities.ExcelUtilities;
 
public class UpcomingBikesPage {

	WebDriver driver;

	WebDriverWait wait;

	ExcelUtilities xlUtil;

	Select bikes;

	String checkTitle = "Upcoming Bikes";


	public UpcomingBikesPage(WebDriver driver)

	{

		this.driver = driver;

		PageFactory.initElements(driver, this);

		wait = new WebDriverWait(driver, Duration.ofSeconds(20));

	}

	@FindBy(xpath = "//div[@class='relative']/select")

	WebElement brandDropDown;

	@FindBy(xpath = "//div[@class='flex-center mb-4']")

	WebElement loadMoreBtn;

	@FindBy(xpath = "//div[@class='bg-gray-50 p-2 rounded-md']/div")

	List<WebElement> bikePriceList;

	@FindBy(xpath = "//div[@class='p-4 pt-2 max-w-full']/a")

	List<WebElement> bikeNameList;

	@FindBy(xpath = "//div[@class='bg-gray-50 p-2 rounded-md block']/div")

	List<WebElement> bikeLaunchList;


	public void selectBrand(String brand)

	{

		wait.until(ExpectedConditions.titleContains(checkTitle));

		bikes = new Select(brandDropDown);

		bikes.selectByValue(brand.toLowerCase());

	}

	public void loadMoreResuts() throws InterruptedException

	{

		Thread.sleep(3000);

		if(loadMoreBtn.isDisplayed())

		{

			wait.until(ExpectedConditions.visibilityOf(loadMoreBtn));

			loadMoreBtn.click();

		}

	}

	public void getUpcomeingBikesDetails() throws InterruptedException, IOException

	{

		Thread.sleep(3000);

		String[] bikePriceFinal = new String[bikePriceList.size()];

		for(int i = 0; i<bikePriceList.size(); i++)

		{

			String price = bikePriceList.get(i).getText();


			if(price.contains("-"))

			{

				String[] temp = new String[2];

				temp = price.split(" - ");

				String t = temp[1].replace("Lakh", "");

				String s = t.replace("*", "");

				bikePriceFinal[i] = s.replace("₹", "");

				//System.out.println(bikePriceFinal[i]);

			}

			else

			{

				String t = price.replace("Lakh", "");

				String s = t.replace("*", "");

				bikePriceFinal[i] = s.replace("₹", "");

				//System.out.println(bikePriceFinal[i]);

			}

		}

		int xlIndex = 1;

		for(int j=0; j < bikePriceFinal.length; j++)

		{

			List<WebElement> upBikeList = bikeNameList;

			String temp = bikePriceFinal[j].replace(" ", "");

			Double price = Double.parseDouble(temp);

			if(price < 4)

			{

				ExcelUtilities.updateExcel(String.valueOf(xlIndex), "upcomingBikes", xlIndex, 0);

				ExcelUtilities.updateExcel(upBikeList.get(j).getText(), "upcomingBikes", xlIndex, 1);

				ExcelUtilities.updateExcel(bikePriceList.get(j).getText(), "upcomingBikes", xlIndex, 2);

				ExcelUtilities.updateExcel(bikeLaunchList.get(j).getText(), "upcomingBikes", xlIndex, 3);

				//System.out.println(bikePriceList.size());

				System.out.println(upBikeList.get(j).getText());

				System.out.println("Price: " +bikePriceList.get(j).getText());

				System.out.println("Launch Date: " +bikeLaunchList.get(j).getText());

				System.out.println("\n");

				xlIndex++;

			}

		}

	}


	public boolean checkBrandSeleted(String bikeBrand)

	{

		return(bikes.getAllSelectedOptions().get(0).getText().equals(bikeBrand));

	}


	public boolean checkUpcomingBikesList()

	{

		return (bikeNameList.size() > 0);

	}


}