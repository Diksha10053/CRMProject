package com.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.base.TestBase;
import com.qa.pages.ContactPage;
import com.qa.pages.HomePage;
import com.qa.pages.LoginPage;
import com.qa.util.TestUtil;

public class ContactPageTest extends TestBase{
	LoginPage loginpage;
	ContactPage contactpage;
	HomePage homepage;
	String sheetName= "Sheet1";
	
	public ContactPageTest() {
		super();
		
	}
	
	@BeforeMethod
	public void setup() {
		initialization();
		loginpage=new LoginPage();
		contactpage= new ContactPage();
		homepage= new HomePage();
		
		loginpage.login(pr.getProperty("user"), pr.getProperty("password"));
		homepage.checkContact();
	}

	@Test(priority=2)
	public void checkContactName() {
		boolean logo=contactpage.validateContactLogo();
		Assert.assertTrue(logo);
	}
	
	@DataProvider
	public Object[][] getTestData() {
		Object data[][]=TestUtil.getTestData(sheetName);
		return data;
		
	}
	@Test(priority=1, dataProvider= "getTestData")
	public void createContact(String Firstname, String Lastname, String status, String category ) {
		contactpage.createNewContact(Firstname, Lastname, status, category);
	}

//	@Test
//	public void createContact() {
//		contactpage.createNewContact("Diksha", "Sharma" ,"Active", "Lead");
//	}
	
	@AfterMethod
	public void quit() {
		driver.quit();
	}
	
}
