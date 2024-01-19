package StepDefinitions;


import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import factory.DriverFactory;


import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.OrderPage;
import pages.Popupitems;
import pages.ProductPage;
import pages.SearchResultsPage;
import utils.ElementUtils;


public class Product {
	
WebDriver driver;
private ElementUtils elementUtils; 
private SearchResultsPage searchResultsPage ;
private ProductPage productPage; 
private Popupitems popupitems;

	@When("I add any product to bag and checkout")
	public void i_add_any_product_to_bag_and_checkout() throws InterruptedException {
		driver = DriverFactory.getDriver();
		System.out.println("Hello I'am in the page of order ");
		  elementUtils  = new ElementUtils (driver);
		  elementUtils.javaScriptscroll();
		  searchResultsPage = new SearchResultsPage (driver);
		  productPage = searchResultsPage.clickADDBtn();
		
	}

	@When("Verify the title {string}")
	public void verify_the_title(String string) {
		Assert.assertTrue(productPage.getTitleInformation().contains(string));
	}

	@When("User clicks on Add to cart button")
	public void user_clicks_on_add_to_cart_button() {
		productPage.clicksCartBtn();
	}

	@Then("I should see that the order is placed and get a successfully message")
	public void i_should_see_that_the_order_is_placed_and_get_a_successfully_message() {
	  // Assert.assertTrue(driver.findElement(By.xpath("//div[@class=\"alert alert-success alert-dismissible\"]")).getText().contains("Success: You have added HP LP3065 to your shopping cart!"));
	   Assert.assertTrue(productPage.getMessageSuccessText().contains("Success: You have added HP LP3065 to your shopping cart!"));
	   productPage.clickitemsBtn();
	   //verifier that contenu popup is correct
	   popupitems = new Popupitems (driver);
	   Assert.assertTrue(popupitems.getTotale().contains("$122.00"));
	   
	}

}
