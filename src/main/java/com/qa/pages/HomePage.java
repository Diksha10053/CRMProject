package com.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.TestBase;

public class HomePage extends TestBase{
	
	//page factory
	
	@FindBy(xpath="//span[@class='user-display']")
	WebElement nameDisplay;
	
	
	@FindBy(xpath="//i[@class= 'users icon']")
	WebElement contacts;
	
	@FindBy(xpath="//i[@class= 'tasks icon']")
	WebElement tasks;
	
	//Actions
	public HomePage() {
		PageFactory.initElements(getDriver(), this);
		
	}
	public String validateName() {
		return nameDisplay.getText();
	}
	public String validateTitle() {
		return getDriver().getTitle();
	}
	public ContactPage checkContact() {
		contacts.click();
		return new ContactPage();
	}
	
	public TaskPage validateTaskPage() {
		tasks.click();
		return new TaskPage();
	}
	
}
