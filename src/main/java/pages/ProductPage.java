package pages;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.CommonUtils;
import utils.ElementUtils;

public class ProductPage {
	WebDriver driver;
	private ElementUtils elementUtils ;
	
	public ProductPage(WebDriver driver) {
		this.driver = driver;
	    PageFactory.initElements(driver,this);
	    elementUtils = new ElementUtils (driver);
	}
	
     @FindBy(xpath="//div[@class=\"col-sm-4\"]/h1")
     private WebElement title ;
     
     @FindBy(id="button-cart")
     private WebElement cartBtn; 
    
     @FindBy(xpath="//div[@class=\"alert alert-success alert-dismissible\"]")
     private WebElement messageSuccess;
     
   //direction pop-up
     @FindBy(id="cart")
     private WebElement itemsBtn;
     
    
     
     
     
     
     
     
     public String getTitleInformation() {
    	 return elementUtils.getTextFromElement(title, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
     }
     
     public void clicksCartBtn() {
    	 elementUtils.clickOnElement(cartBtn, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
     }
     
     public String  getMessageSuccessText() {
    	 return elementUtils.getTextFromElement(messageSuccess, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
     }
     
     
     public void clickitemsBtn() {
      	itemsBtn.click();
      }
     
     
     
     
     

}
