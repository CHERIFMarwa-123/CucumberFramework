package StepDefinitions;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import factory.DriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.ForgotPasswordPage;
import pages.HomePage;
import pages.LoginPage;

public class ForgotPassword {
 WebDriver driver;
 private LoginPage loginPage;
 private ForgotPasswordPage forgotPasswordPage;
 

	@Given("User open the login page")
	public void user_open_the_login_page() {
		   driver = DriverFactory.getDriver();
		   System.out.println("Hi I go to forgot password");
		   HomePage homePage = new HomePage(driver);
		   homePage.clickOnMyAccount();
		   loginPage = homePage.selectLoginOption();
	}
	
	@When("User clicks on ForgottenPassword button")
	public void user_clicks_on_forgotten_password_button() {
		forgotPasswordPage = loginPage.clicksForgottenPasswordBtn();
	    
	}

	@When("^User enters email \"([^\"]*)\" into email field$")
	public void user_enters_email_into_email_field(String emailText) {
		 forgotPasswordPage.enterEmailAddress(emailText);
	}

	@When("User clicks on Continue button of forgot your password page")
	public void user_clicks_on_continue_button_of_forgot_your_password_page() {
		loginPage = forgotPasswordPage.continueBtnOFForgotPassword();
	}

	@Then("User should get successfully message of confirmation link")
	public void user_should_get_successfully_message_of_confirmation_link() throws InterruptedException {
		 Assert.assertTrue(loginPage.getwarningMessageForgottenPassword().contains("An email with a confirmation link has been sent your email address."));
	     Thread.sleep(4000);
	}
}
