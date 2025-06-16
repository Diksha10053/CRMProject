package com.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import com.qa.base.TestBase;

public class ContactPage extends TestBase {
	
	@FindBy(xpath=" //span[@class=\"selectable \"]")
	WebElement contactlogo;
	
	@FindBy(xpath="//i[@class=\"edit icon\"]")
	WebElement create;
	
	@FindBy(name="first_name")
	WebElement fname;
	
	@FindBy(name="last_name")
	WebElement lname;
	
	@FindBy(xpath="//div[@name=\"status\"]//preceding-sibling::div[@class=\"divider default text\"]")
	WebElement status;
	
	@FindBy(xpath="//div[@name=\"category\"]//preceding-sibling::div[@class=\"divider default text\"]")
	WebElement category;
	
	@FindBy(xpath="//button[contains(text(),'Save')]")
	WebElement save;
	
	public ContactPage() {
		PageFactory.initElements(driver, this);
	}

	public boolean validateContactLogo() {
		return contactlogo.isDisplayed();
	}
	
	public void createNewContact(String FName, String LName , String sselect , String cselect ) {
		create.click();
		fname.sendKeys(FName);
		lname.sendKeys(LName);
		status.click();
		String xpathSelect=String.format("//span[contains(text(),'%s')]", sselect); 				//dynamic xpath
		driver.findElement(By.xpath(xpathSelect)).click();  										//selecting dropdown
		category.click();
		String xpathCategory=String.format("//span[contains(text(),'%s')]", cselect); 				//dynamic xpath
		driver.findElement(By.xpath(xpathCategory)).click(); 									    //selecting dropdown for category
		save.click();
	}
}
