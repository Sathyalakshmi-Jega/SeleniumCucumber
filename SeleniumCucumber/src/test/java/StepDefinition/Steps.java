package StepDefinition;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import PageObject.AddCustomerPage;
import PageObject.LoginPage;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;

public class Steps {

	public WebDriver driver;
	public LoginPage lp;
	public AddCustomerPage cp;
	public static Logger logger;
	public Properties configProp;

	@Before
	public void setUp() throws IOException {
		logger = Logger.getLogger("SeleniumCucumber");
		// logger = Logger.getLogger(Steps.class.getName());
		PropertyConfigurator.configure("log4j.properties");

		
        //Reading config Properties
		configProp = new Properties();
		FileInputStream reader = new FileInputStream("Config.properties");
		configProp.load(reader);
		String browser = configProp.getProperty("browser");
		
		if (browser.equalsIgnoreCase("chrome")) {
			logger.info("**********Launching the chrome broswer**********");
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--remote-allow-origins=*");
			this.driver = new ChromeDriver(options);
		} else if (browser.equalsIgnoreCase("firefox")) {
			logger.info("***********Launching the firefox browser**********");
            this.driver = new FirefoxDriver();
		}
	}

	@Given("Launch the browser")
	public void launch_the_browser() {

		lp = new LoginPage(this.driver);
	}

	@When("User launches the URL {string}")
	public void user_launches_the_url(String string) {
		this.driver.get(string);
	}

	@When("User enter username as {string} and password as {string}")
	public void user_enter_username_as_and_password_as(String emailId, String password) {
		lp.setUserName(emailId);
		lp.setPassWord(password);

	}

	@When("clicks Login button")
	public void clicks_login_button() {
		lp.clickLoginButton();

	}

	@SuppressWarnings("deprecation")
	@Then("Page Title should be {string}")
	public void page_title_should_be(String title) {
		if (driver.getPageSource().contains("Login was unsuccessful")) {
			Assert.assertNotSame(title, "Login was unsuccessful");
			driver.close();
		} else {
			String current_Title = driver.getTitle();
			Assert.assertEquals(current_Title, title);
		}
	}

	@When("User clicks logout link")
	public void user_clicks_logout_link() {
		lp.clickLogoutButton();
	}

	@Then("click Customer menu")
	public void click_customer_menu() {
		cp = new AddCustomerPage(driver);
		cp.clickCustomer_menu();

	}

	@Then("close browser")
	public void close_browser() {
		this.driver.quit();
	}

}
