package testBase;

import java.time.Duration;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

//Base class contains reusable components
public class BaseClass {

	public  static WebDriver driver; 
	
	public Logger logger; //for logging
	
	
	@BeforeClass
	@Parameters("browser")
	public void setup(String br)
	{	
		
		logger=LogManager.getLogger(this.getClass()); //logging
	//	WebDriverManager.chromedriver().setup();
	//	ChromeOptions options = new ChromeOptions();
	//	options.setExperimentalOption("excludeSwitches", new String[] {"enable-automation"});
	//	options.addArguments("--remote-allow-origins=*");
		
		if(br.equals("chrome"))
		{
			driver = new ChromeDriver();
		}
		else if(br.equals("edge"))
		{	
			driver = new EdgeDriver();
			
		}
		else
		{	
			driver = new FirefoxDriver();
			//driver = new EdgeDriver();
		}
			
		driver.manage().deleteAllCookies();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://demo.opencart.com/");
		driver.manage().window().maximize();
	}
	
	@AfterClass
	public void tearDown()
	{
		driver.quit();
	}
	
	public String randomString() {
		String generatedString = RandomStringUtils.randomAlphabetic(5);
		return (generatedString);
	}
	
	public String randomNumber() {
		String generatedString2 = RandomStringUtils.randomNumeric(10);
		return(generatedString2);
	}

	public String randomAlphaNumeric() {
		String st = RandomStringUtils.randomAlphabetic(4);
		String num = RandomStringUtils.randomNumeric(3);
		return(st+"@"+num);
	}
}
