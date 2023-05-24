package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountRegistrationPage extends BasePage {

	public AccountRegistrationPage(WebDriver driver) {
		super(driver);
	}
	
	//Elements
		@FindBy(css = "#input-firstname")
		WebElement txtFirstname;
		
		@FindBy(css = "#input-lastname")
		WebElement txtLastname;
		
		@FindBy(css = "#input-email")
		WebElement txtEmail;
		
		@FindBy(css = "#input-password")
		WebElement txtPassword;
		
		@FindBy(xpath = "//input[@name='agree']")
		WebElement chkdPolicy;
		
		@FindBy(xpath = "//button[normalize-space()='Continue']")
		WebElement btnContinue;
		
		@FindBy(xpath = "//h1[normalize-space()='Your Account Has Been Created!']")
		WebElement msgConfirmation;
		
		public void setFirstName(String fname) {
			txtFirstname.sendKeys(fname);
		}
		
		public void setLastName(String lname) {
			txtLastname.sendKeys(lname);
		}
		
		public void setEmail(String email) {
			txtEmail.sendKeys(email);
		}
		
		public void setPassword(String pwd) {
			txtPassword.sendKeys(pwd);
		}
		
		public void setPrivacyPolicy() {
			chkdPolicy.click();
		}
		
		public void clickContinue() {
			btnContinue.click();
		}
		
		public String getConfirmationMsg() {
			try {
				return (msgConfirmation.getText());
			}catch (Exception e) {
				return (e.getMessage());
			}
			
			
		}
}
