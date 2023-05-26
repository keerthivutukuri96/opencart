package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class LoginTest extends BaseClass {
	
	@Test
	public void test_login() 
	{	
		try 
		{
			
		logger.info("Starting LoginTest");
		
		HomePage hp = new HomePage(driver);
		
		hp.clickMyAccount();
		logger.info("Clicked on myaccount");
		
		hp.clickLogin();
		logger.info("Clicked on Login Link");
		
		LoginPage lp = new LoginPage(driver);
		logger.info("Providing Login details");
		
		lp.setEmail(rb.getString("email")); //valid email,getting it from config.properties file
		lp.setPassword(rb.getString("password")); //valid password, getting it from config.properties file
		
		lp.clickLogin();
		logger.info("Clicked on login button");
		
		MyAccountPage macc = new MyAccountPage(driver);
		boolean targetpage = macc. isMyAccountPageExists();
		Assert.assertEquals(targetpage,true, "Invalid login data");
		}
		catch(Exception e)
		{
			Assert.fail("Couldn't find myaccount button");
		}
		
		logger.info("Finished loginTest");
	}
}
