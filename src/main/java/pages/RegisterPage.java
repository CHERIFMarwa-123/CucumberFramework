package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.CommonUtils;
import utils.ElementUtils;

public class RegisterPage {
	
	WebDriver driver;
	private ElementUtils elementUtils ;
	
	public RegisterPage(WebDriver driver) {
		this.driver =driver;
		PageFactory.initElements(driver, this);
		 elementUtils = new ElementUtils (driver) ;
	}
	
	
	@FindBy(id="input-firstname")
	WebElement firstNameField;	
	
	@FindBy(id="input-lastname")
	WebElement lastNameField;
	
	@FindBy(id="input-email")
	WebElement emailField;
	
	@FindBy(id="input-telephone")
	WebElement telephoneField;
	
	@FindBy(id="input-password")
	WebElement passwordField;
	
	@FindBy (id="input-confirm")
	WebElement confirmPasswordFile;
	
	@FindBy (xpath="//input[@name='agree'][@value='1']")
	private WebElement privacyPolicy;
	
	@FindBy (xpath="//input[@value='Continue']")
	private WebElement continueButton;
	
	@FindBy (name="newsletter")
	private WebElement YesForNewsletter;
	
	@FindBy (xpath="//*[@id=\"account-register\"]/div[1]")
	private WebElement  WarningMessage;
	
    @FindBy (xpath="//input[@id='input-firstname']/following-sibling::div")
	private WebElement MessageErreurForFirstName;
    
    @FindBy (xpath="//input[@id='input-lastname']/following-sibling::div")
    private WebElement  MessageErreurForLastName;
    
    @FindBy(xpath="//input[@id='input-email']/following-sibling::div")
    private WebElement MessageErreurForEmail;
    
    @FindBy (xpath="//input[@id='input-telephone']/following-sibling::div")
    private WebElement MessageErreurForTelephone;
    
    @FindBy (xpath="//input[@id='input-password']/following-sibling::div")
    private WebElement MessageErreurForPassword;
    
	public void enterFirstName(String firstNameText) {
		firstNameField.sendKeys(firstNameText);
	}
	
	public void enterLastName(String lastNameText) {
		//lastNameField.sendKeys(lastNameText);
		elementUtils.typeTextIntoElement(lastNameField, lastNameText, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
		
	}
	
	
	public void enterEmail(String emailText) {
		//emailField.sendKeys(emailText);
		elementUtils.typeTextIntoElement(emailField, emailText, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
	}
	
	public void enterTelephone (String telephoneText) {
		//telephoneField.sendKeys(telephoneText);
		elementUtils.typeTextIntoElement(telephoneField, telephoneText, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
	}
	
	public void enterPassword (String passwordText) {
		//passwordField.sendKeys(passwordText);
		elementUtils.typeTextIntoElement(passwordField, passwordText, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
    }
	
	public void enterconfirmPassword(String confirmPasswordText ) {
	
	    // confirmPasswordFile.sendKeys(confirmPasswordText);
		elementUtils.typeTextIntoElement(confirmPasswordFile, confirmPasswordText, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
    }
	
	public void selectsPrivacyPolicy() {
		//privacyPolicy.click();
		elementUtils.clickOnElement(privacyPolicy, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
		
	}
	
    public AccountSuccessPage clickscontinueButton () {
    	//continueButton.click();
    	 elementUtils.clickOnElement(continueButton, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
    	 return new AccountSuccessPage(driver);
    	
    }
    
    public void ClicksYesForNewsletter() {
		//YesForNewsletter.click();
		 elementUtils.clickOnElement(YesForNewsletter, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
	}
    
    public String getWarningMessageText() {
    	//return WarningMessage.getText();
    	return elementUtils.getTextFromElement(WarningMessage, CommonUtils.EXPLICIT_WAIT_BASIC_TIME); 
    }
    
    public String getWarningMessageTextOfFirstName () {
    	//return MessageErreurForFirstName.getText();
    	return  elementUtils.getTextFromElement(MessageErreurForFirstName, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
    }
    
    public String getWarningMessageTextOfLastName () {
    	//return MessageErreurForLastName.getText();
    	return  elementUtils.getTextFromElement(MessageErreurForLastName, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
    }
    
    public String getWarningMessageTextOfEmail () {
    	//return MessageErreurForEmail.getText();
    	return  elementUtils.getTextFromElement(MessageErreurForEmail, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
    }
    
    public String getWarningMessageTextOfTelephone() {
    	//return  MessageErreurForTelephone.getText(); 
    	return  elementUtils.getTextFromElement(MessageErreurForTelephone, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
    }
    
    public String getWarningMessageTextOfPassword() {
    	//return  MessageErreurForPassword.getText();
    	return  elementUtils.getTextFromElement(MessageErreurForPassword, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
    }
}
