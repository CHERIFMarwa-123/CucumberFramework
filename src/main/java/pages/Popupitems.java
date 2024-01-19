package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.CommonUtils;
import utils.ElementUtils;

public class Popupitems {
	
	WebDriver driver;
	private ElementUtils elementUtils ;
	
	public Popupitems(WebDriver driver) {
		this.driver = driver;
	    PageFactory.initElements(driver,this);
	    elementUtils = new ElementUtils (driver);
	}
	
	@FindBy(xpath="//tr/td[@class=\"text-right\"][text()=\"$122.00\"]")
	private WebElement Totale;
	
	public String getTotale() {
		return elementUtils.getTextFromElement(Totale, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
	}
	
	
}
