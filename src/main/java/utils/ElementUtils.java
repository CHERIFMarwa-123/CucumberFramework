package utils;



import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.base.Throwables;

import java.time.Duration;

public class ElementUtils {
	
	WebDriver driver;
	
	public ElementUtils(WebDriver driver) { 
		this.driver=driver;
		
	}
//Methode	
	
	//Wait for element
		public WebElement waitForElement(WebElement element,long durationInSeconds) {
		
			WebElement webElement = null;
		try {
			
		
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(durationInSeconds));
	        return wait.until(ExpectedConditions.elementToBeClickable(element));
	        
		}
		
		catch(Throwable e) {
			e.printStackTrace();
			}
		return webElement;
		}
		
	
    //click on element
		public void clickOnElement(WebElement element,long durationInSeconds) {
		
			
		    WebElement webElement = waitForElement(element,durationInSeconds);
		    webElement.click();
		}
	
	//Remplir champs Type text into element
		public void typeTextIntoElement(WebElement element,String textToBeTyped,long durationInSeconds) {
	    
		 
	     WebElement webElement = waitForElement(element,durationInSeconds);
	     webElement.click();
	     webElement.clear();
	     webElement.sendKeys(textToBeTyped);
		 
		}
	
    //SelectOptionInDropdown
		
	public void selectOptionInDropdown(WebElement element,String dropDownOption,long durationInSeconds) {
		WebElement webElement = waitForElement(element,durationInSeconds);
		Select select = new Select(webElement);
		select.selectByVisibleText(dropDownOption);
	}
	
	
	
	
	
	//WaitForAlert()
	
	public Alert waitForAlert(long durationInSeconds) {
		Alert alert = null;
		try {
		 WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(durationInSeconds));
		 alert = wait.until(ExpectedConditions.alertIsPresent());
		}
		catch(Throwable e) {
		e.printStackTrace();
	}
		return alert;
	}
	
	
	//AcceptAlert
	
	public void acceptAlert (long durationInSeconds) {
		Alert alert = waitForAlert(durationInSeconds);
		alert.accept();
		
	}
	
	//Dismiss alert
	
	public void dismissAlert (long durationInSeconds) {
		Alert alert = waitForAlert(durationInSeconds);
		alert.dismiss();
	}
	
	
	
	
	//waitForVisibilityOfElement
	public WebElement waitForVisibilityOfElement(WebElement element, long durationInSeconds) { 
		WebElement webElement = null;
		try {
			WebDriverWait wait = new WebDriverWait (driver,Duration.ofSeconds(durationInSeconds));
		    webElement =  wait.until(ExpectedConditions.visibilityOf(element));
		}
		catch(Throwable e) {
		  e.printStackTrace();
		}
		return webElement;
	}
	
	
	//mouseHoverAndClicksElement
	
	public void mouseHoverAndClicksElement (WebElement element, long durationInSeconds) {
		
		WebElement webElement =  waitForVisibilityOfElement(element,durationInSeconds);
		
		Actions actions = new Actions(driver);
		actions.moveToElement(webElement).click().build().perform();
	}
	
	//java script click
	
	public void javaScriptClick (WebElement element, long durationInSeconds) {
	
		WebElement webElement =  waitForVisibilityOfElement(element,durationInSeconds);
		JavascriptExecutor jse = ((JavascriptExecutor)driver);
		jse.executeScript("arguments[0].click();", webElement );
	}
	
	
	// java script scroll down
	public void javaScriptscroll () {
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0,450)");
	}
	//java script type
	
	public void javaScriptType (WebElement element, long durationInSeconds,String textToBeTyped) {
		WebElement webElement =  waitForVisibilityOfElement(element,durationInSeconds);
		JavascriptExecutor jse = ((JavascriptExecutor)driver);
		jse.executeScript("arguments[0].value='"+textToBeTyped+"'",webElement );
	}
	
	//Lire le contenu d'un message d'erreur 
	
	public String getTextFromElement(WebElement element, long durationInSeconds) {
		WebElement webElement = waitForElement(element,durationInSeconds);
	    return webElement.getText();
	}
	
	//Disabeliti of status (titre dispo au non )
	
	public boolean displayStatusOfElement(WebElement element, long durationInSeconds) {
		try{
			WebElement webElement =  waitForVisibilityOfElement(element,durationInSeconds);
		    return webElement.isDisplayed();
		}
		catch(Throwable e) {
			return false;
		}
	}
}
	

        