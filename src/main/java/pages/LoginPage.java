package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.CommonUtils;
import utils.ElementUtils;

public class LoginPage {

	WebDriver driver;
	private ElementUtils elementUtils ;
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	    PageFactory.initElements(driver,this);
	    elementUtils = new ElementUtils (driver);
	}
	
	@FindBy(id="input-email")
	private WebElement enterEmail;
	
	
	@FindBy(id="input-password")
	private WebElement enterPassword;
	
	
	@FindBy (xpath="//input[@value='Login']")
    private WebElement LoginButton;
	
	@FindBy (xpath="//div[contains(@class,'alert-dismissible')]")
	private WebElement warningMessage;


	//Forgotten Password
    @FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")
    private WebElement warningMessageForgottenPassword;

	@FindBy(xpath="//a[text()='Forgotten Password']")
	private WebElement forgottenPasswordbtn;
	
	
	
	public void enterEmailAddress (String emailText) {
		//enterEmail.sendKeys(emailText);
	    elementUtils.typeTextIntoElement(enterEmail, emailText, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
	}
	
	
	public void enterPassword(String passwordText ) {
		//enterPassword.sendKeys(passwordText);	
		 elementUtils.typeTextIntoElement(enterPassword, passwordText, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
		}
	
	
	public AccountPage clicksLoginBtn() {
		//LoginButton.click();
		 elementUtils.clickOnElement(LoginButton, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
		return new AccountPage(driver);
	}
	
	public String getWarningMessageText() {
		//return warningMessage.getText();
		return elementUtils.getTextFromElement( warningMessage, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
	}



   //Forgot

	public ForgotPasswordPage clicksForgottenPasswordBtn() {
		elementUtils.clickOnElement(forgottenPasswordbtn, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
		return new ForgotPasswordPage(driver);
	}


	// message Forgotten Password
		public String getwarningMessageForgottenPassword() {
			return elementUtils.getTextFromElement(warningMessageForgottenPassword, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
			
		}
	

	
	
	
}