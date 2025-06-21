package com.qa.pages;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.base.TestBase;

public class LoginPage extends TestBase{

	//Page factory or OR
	@FindBy(name="email")
	@CacheLookup
	WebElement username;
	
	@FindBy(name="password")
	@CacheLookup
	WebElement password;
	
	@FindBy(xpath="//a[contains(text(),'Login')]")
	WebElement loginbtn;
	
	@FindBy(xpath= "//div[contains(text(),'Login')]")
	WebElement submit;
	
	@FindBy(xpath="//[@className='MuiBox-root mui-18l9bu3']")
	WebElement logo;
	
	//Initialization
	public LoginPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	//actions
	public String validateTitle() {
		return getDriver().getTitle();
		
	}
	public boolean validateLogo() {
		return logo.isDisplayed();
	}
	public HomePage login(String un, String pwd) {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(loginbtn)).click(); //explicit wait
        getDriver().navigate().to("https://ui.cogmento.com/?lang=en");
        username.sendKeys(un);
		password.sendKeys(pwd);
		submit.click();
		return new HomePage();
	}
}
