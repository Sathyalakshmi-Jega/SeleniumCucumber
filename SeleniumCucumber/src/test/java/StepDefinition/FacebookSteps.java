package StepDefinition;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class FacebookSteps {
	WebDriver driver;

	@Given("I launched firefox browser")
	public void i_launched_firefox_browser() {
		
		  ChromeOptions options = new ChromeOptions();
		  options.addArguments("--remote-allow-origins=*"); 
		  driver = new ChromeDriver(options);
		
		//driver = new FirefoxDriver();
	}

	@When("I open facebook page")
	public void i_open_facebook_page() {
		driver.get("https://www.facebook.com/");
		
	}

	@Then("I validate the presence of Username textbox")
	public void i_validate_the_presence_of_username_textbox() {
		driver.findElement(By.name("email")).isDisplayed();
		
	}

	@Then("I validate the presence of password textbox")
	public void i_validate_the_presence_of_password_textbox() {
		driver.findElement(By.name("pass")).isDisplayed();
		
	}

	@Then("Close browser")
	public void close_browser() {
		driver.quit();
		
	}

}
