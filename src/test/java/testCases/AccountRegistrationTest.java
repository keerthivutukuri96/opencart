package testCases;

import org.testng.Assert;
//import org.testng.annotations.AfterClass;
//import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class AccountRegistrationTest extends BaseClass {
	
	
	@Test(groups= {"Regression", "Master"})
	public void test_account_Registration() throws InterruptedException
	{	
		logger.debug("application logs.....");
		logger.info("Starting AccountRegistrationTest");
		try
		{
		HomePage hp = new HomePage(driver);
		hp.clickMyAccount();
		logger.info("Clicked on my account link");
		hp.clickRegister();
		logger.info("Clicked on register link");
		
		AccountRegistrationPage regpage = new AccountRegistrationPage(driver);
		logger.info("Providing customer data");
		
		regpage.setFirstName(randomString().toUpperCase());
		regpage.setLastName(randomString().toUpperCase());
		regpage.setEmail(randomString()+"@gmail.com");
		regpage.setPassword(randomAlphaNumeric());
		regpage.setPrivacyPolicy();
		regpage.clickContinue();
		logger.info("Clicked on continue");
		
		String confmsg = regpage.getConfirmationMsg();
		logger.info("Validating expected message");
		
		Assert.assertEquals(confmsg, "Your Account Has Been Created! ","Test failed");
	
		}
		catch(Exception e) {
			logger.error("test failed");
			Assert.fail();
		}
		
	}
	
	
	
}
