package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class AddCustomerPage {
	
	WebDriver lDriver;
	public AddCustomerPage(WebDriver rDriver) {
		lDriver = rDriver;
		PageFactory.initElements(rDriver, this);
	}
	
	By lnkCustomer_menu = By.xpath("//nav[@class='mt-2']/ul/li[4]/a");
	                      //By.xpath("//a[@href = '#']//p[contains(text(),'Customers')]");


	public void clickCustomer_menu() {
		lDriver.findElement(lnkCustomer_menu).click();
	}
}
