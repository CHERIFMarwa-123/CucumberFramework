package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.CommonUtils;
import utils.ElementUtils;

public class ForgotPasswordPage {
	WebDriver driver;
	private ElementUtils elementUtils ;
	
	public ForgotPasswordPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver,this);
		elementUtils = new ElementUtils (driver);
	}
	
	@FindBy(id="input-email")
	private WebElement enterEmail;
	
	@FindBy(xpath="//input[@class='btn btn-primary']")
	private WebElement continueBtn;
	
	
	public void enterEmailAddress (String emailText) {
		//enterEmail.sendKeys(emailText);
	    elementUtils.typeTextIntoElement(enterEmail, emailText, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
	}
	
	public LoginPage continueBtnOFForgotPassword() {
		elementUtils.clickOnElement(continueBtn, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
	    return new LoginPage (driver) ;
	}
	
	
	
}
