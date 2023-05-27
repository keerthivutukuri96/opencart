package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;
import utilities.DataProviders;

public class LoginDDT extends BaseClass{
	
	@Test(dataProvider="LoginData",dataProviderClass=DataProviders.class)
	public void test_loginDDT(String email, String password, String exp)
	{	
		
		logger.info("Starting LoginDDT");
		try
		{
		HomePage hp = new HomePage(driver);
		hp.clickMyAccount();
		hp.clickLogin();
		
		 
		LoginPage lp = new LoginPage(driver);
		
		
		lp.setEmail(rb.getString("email")); //valid email,getting it from config.properties file
		lp.setPassword(rb.getString("password")); //valid password, getting it from config.properties file
		lp.clickLogin();
		
		MyAccountPage macc = new MyAccountPage(driver);
		boolean targetpage = macc. isMyAccountPageExists(); 
		
		if(exp.equals("Valid"))
		{
			if(targetpage == true)
			{
				macc.clickLogout();
				Assert.assertTrue(true);
			}
			else
			{
				Assert.assertTrue(false);
			}
		}
		
		if(exp.equals("Invalid"))
		{
			if(targetpage==true)
			{
				macc.clickLogout();
				Assert.assertTrue(false);
			}
			else
			{
				Assert.assertTrue(true);
			}
		}
		}
		catch(Exception e)
		{	
			//logger.info("login page is not working properly");
			Assert.fail();
		}
		
		logger.info("Login DDT Finished");
		
	}
	
}
