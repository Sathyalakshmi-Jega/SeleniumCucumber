package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	WebDriver lDriver;

	public LoginPage(WebDriver rDriver) {
		lDriver = rDriver;
		PageFactory.initElements(rDriver, this);
	}

	@FindBy(id = "Email")
	@CacheLookup
	WebElement txtEmail;

	@FindBy(id = "Password")
	@CacheLookup
	WebElement txtPassword;
	
	@FindBy(xpath = "/html/body/div[6]/div/div/div/div/div[2]/div[1]/div/form/div[3]/button")
	@CacheLookup
	WebElement btnLogin;
	
	@FindBy(linkText = "Logout")
    @CacheLookup
    WebElement lnkLogout;
	
	public void setUserName(String pUserName) {
		txtEmail.clear();
		txtEmail.sendKeys(pUserName);
		
	}
	
	public void setPassWord(String pPassWord) {
		txtPassword.clear();
		txtPassword.sendKeys(pPassWord);
	}
	
	public void clickLoginButton() {
		btnLogin.isDisplayed();
		btnLogin.click();
	}
	
	public void clickLogoutButton() {
		lnkLogout.isDisplayed();
		lnkLogout.click();
	}

}
