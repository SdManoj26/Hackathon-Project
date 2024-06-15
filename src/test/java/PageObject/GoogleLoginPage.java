package PageObject;
 
import java.io.IOException;

import java.util.ArrayList;

import java.util.List;

import java.util.Set;
 
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;

import org.openqa.selenium.support.PageFactory;
 
import Utilities.ExcelUtilities;
 
public class GoogleLoginPage {

	WebDriver driver;

	public GoogleLoginPage(WebDriver driver)

	{

		this.driver = driver;

		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//div[@class='S9gUrf-YoZ4jf']")

	WebElement googleSignInBtn;

	@FindBy(xpath = "//input[@type='email']")

	WebElement emailInput;

	@FindBy(xpath = "//div[@class='TNTaPb']//button")

	WebElement nextBtn;

	@FindBy(xpath = "//div[@class='Ekjuhf Jj6Lae']")

	WebElement errorMsg;


	public void clickGoogleSignIn()

	{

		googleSignInBtn.click();

	}

	public void swithtoWindow()

	{

		Set<String> windowHandles = driver.getWindowHandles();

		List<String> windowHandlesList = new ArrayList(windowHandles);

		driver.switchTo().window(windowHandlesList.get(1));

	}

	public void enterEmail(String email)

	{

		emailInput.sendKeys(email);

	}

	public void clickNext()

	{

		nextBtn.click();

	}

	public void getErrorMsg() throws IOException

	{

		ExcelUtilities.updateExcel(errorMsg.getText(), "errorMsg", 1, 0);

		System.out.println(errorMsg.getText());

	}

	public boolean checkErrorMsg()

	{

		return(errorMsg!=null);

	}
 
}