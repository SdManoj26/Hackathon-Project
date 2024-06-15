package Factory;
 
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.time.Duration;
import java.util.Properties;
 
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
 
public class BaseClass {
	
	public static WebDriver driver;
	public static Properties prop;
	public static Logger logger;
	
	
	
	public static WebDriver setupDriver() throws Exception
	{
		URL urlObj = new URL("http://localhost:4444/wd/hub");
		String browser = returnPropertyFile().getProperty("browserName").toLowerCase();
		String url = returnPropertyFile().getProperty("applicationUrl").toLowerCase();
		String opSystem = returnPropertyFile().getProperty("operatingSystem").toLowerCase();
		if(returnPropertyFile().getProperty("environment").equalsIgnoreCase("local"))
		{
			switch(browser)
			{
			case("chrome"):
				driver = new ChromeDriver();
				break;
			case("edge"):
				driver = new EdgeDriver();
				break;
			default:
				System.out.println("Invalid");
			}
			
			
		}
		else if(returnPropertyFile().getProperty("environment").equalsIgnoreCase("remote"))
		{
			DesiredCapabilities cap = new DesiredCapabilities();
			
			if (opSystem.equalsIgnoreCase("windows")) {
			    cap.setPlatform(Platform.WIN11);
			} else if (opSystem.equalsIgnoreCase("mac")) {
			    cap.setPlatform(Platform.MAC);
			} else {
			    System.out.println("No matching OS..");
			      }
			
			cap.setBrowserName(browser);
			
			driver = new RemoteWebDriver(urlObj, cap);
			
		}
		
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		return driver;
		
		
	}
	
	public static WebDriver getDriver()
	{
		return driver;
	}
	
	public static String randomEmail()
	{
		String alphabetic = RandomStringUtils.randomAlphabetic(5);
		String numaric = RandomStringUtils.randomNumeric(5);
		
		String email = alphabetic + numaric + "@gmail.com";
		return email;
	}
	
	public static Properties returnPropertyFile() throws Exception
	{
		FileReader file = new FileReader(System.getProperty("user.dir")+"\\src\\test\\resources\\Config.properties");
		prop = new Properties();
		prop.load(file);
		return prop;
	}
	
	public static Logger getLogger()
	{		
		logger=LogManager.getLogger();
		return logger;
	}
 
	
	
 
}