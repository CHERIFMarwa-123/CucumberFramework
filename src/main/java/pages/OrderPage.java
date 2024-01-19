package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.CommonUtils;
import utils.ElementUtils;

public class OrderPage {
	
	WebDriver driver;
	private ElementUtils elementUtils ;
	
	public OrderPage(WebDriver driver) {
		this.driver = driver;
	    PageFactory.initElements(driver,this);
	    elementUtils = new ElementUtils (driver);
	}
	
	    @FindBy (xpath="/html/body/div[2]/div/div/div[3]/div/div/div[2]/div[2]/button[1]")
	    private WebElement  ADDbtn;
	    // yhezek l prodect page 
	    
	    public void clickADDBtn() {
	    	//elementUtils.clickOnElement(ADDbtn, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
	    	//return new ProductPage(driver);
	    	ADDbtn.click();
	    	
	    }
	    
	    
	    
	    
	   
    
	
}
