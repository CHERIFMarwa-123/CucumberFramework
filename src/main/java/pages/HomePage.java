package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.CommonUtils;
import utils.ElementUtils;

public class HomePage {
	
	WebDriver driver;
	private ElementUtils elementUtils ;
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver,this);
		elementUtils = new ElementUtils (driver);
	}
	
	
	 @FindBy(xpath="/html/body/nav/div/div[2]/ul/li[2]/a/span[1]")
	 private WebElement myAccountDropMenu;
	 
	 @FindBy(xpath="//ul[@class='dropdown-menu dropdown-menu-right']/li/a[contains(text(),'Login')]")
	 private WebElement loginOption;
	 
	 @FindBy(linkText = "Register")
	 private WebElement registerOption;
	 
	 @FindBy (name="search")
	 private WebElement searchBoxField;
	 
	 @FindBy (xpath="//span[@class='input-group-btn']/button[@class='btn btn-default btn-lg']")
	 private WebElement buttonSearch;
	 
	 public void clickOnMyAccount() {
		// myAccountDropMenu.click();
		
		 elementUtils.clickOnElement(myAccountDropMenu,CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
		 
	 }
	 
	 public LoginPage selectLoginOption() {
		 //loginOption.click();
		 elementUtils.clickOnElement(loginOption,CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
		 return new LoginPage(driver);
	 }
	 
	 
	 public RegisterPage selectRegisterOption() {
		 //registerOption.click();
		 elementUtils.clickOnElement(registerOption,CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
		 return new RegisterPage (driver);
	 }
	 
	 public void  entersProductIntoSearchBox(String ProdectText) {
		// searchBoxField.sendKeys(ProdectText);
		 elementUtils.typeTextIntoElement(searchBoxField,ProdectText, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
	 }
	
	 public SearchResultsPage clicksButtonSearch() {
		 //buttonSearch.click();
		 elementUtils.clickOnElement(buttonSearch,CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
		 return new SearchResultsPage (driver);
		 
	 }

}
