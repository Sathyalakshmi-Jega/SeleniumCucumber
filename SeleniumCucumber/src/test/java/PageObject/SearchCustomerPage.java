package PageObject;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class SearchCustomerPage {

	WebDriver ldriver;
	public SearchCustomerPage(WebDriver rDriver) {
		ldriver= rDriver;
		PageFactory.initElements(rDriver, this);
	}
	// This is one way of capturing webElements
	@FindBy(how =How.XPATH, using = "//li[contains(text(),'Guest')]")
	@CacheLookup
	WebElement lstitemGuest;
	
	@FindBy(how = How.XPATH, using ="//table[@id='customers-grid']//tbody/tr/td")
	@CacheLookup
	List<WebElement> tableColumn;
	
	@FindBy(how = How.XPATH, using = "//table[@id='customers-grid']//tbody/tr")
	@CacheLookup
	List<WebElement> tablerows;
	
}
