package com.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.TestBase;

public class LoginPage extends TestBase{

	//Page factory or OR
	@FindBy(name="email")
	@CacheLookup
	WebElement username;
	
	@FindBy(name="password")
	@CacheLookup
	WebElement password;
	
	@FindBy(xpath="//a[@class='btn btn-primary btn-xs-2 btn-shadow btn-rect btn-icon btn-icon-left']")
	WebElement startHere;
	
	@FindBy(xpath= "//div[contains(text(),'Login')]")
	WebElement submit;
	
	@FindBy(xpath= "//a[@class='brand-name']")
	WebElement logo;
	
	//Initialization
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	//actions
	public String validateTitle() {
		return driver.getTitle();
		
	}
	public boolean validateLogo() {
		return logo.isDisplayed();
	}
	public HomePage login(String un, String pwd) {
		startHere.click();
		username.sendKeys(un);
		password.sendKeys(pwd);
		submit.click();
		return new HomePage();
	}
}
