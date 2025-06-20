package com.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.base.TestBase;
import com.qa.pages.ContactPage;
import com.qa.pages.HomePage;
import com.qa.pages.LoginPage;
import com.qa.pages.TaskPage;

public class HomePageTest extends TestBase{

	LoginPage loginpage;
	HomePage homepage;
	ContactPage contact;
	TaskPage task;

	
	public HomePageTest() {
		super();
	}
	
	@BeforeMethod
	public void setup() {
	initialization();
	loginpage= new LoginPage();
	contact=new ContactPage();
	task= new TaskPage();
	homepage=loginpage.login(pr.getProperty("user"), pr.getProperty("password"));
	
	}
	
	@Test(priority=3)
	public void validateTitle() {
		String title=homepage.validateTitle();
		Assert.assertEquals(title, "Cogmento CRM");
		
	}
	
	@Test
	public void ValidateName() {
		String vname= homepage.validateName();
		Assert.assertEquals(vname, "Diksha Sharma");
	}
	
	@Test(priority=1)
	public void validateContact() {
		contact=homepage.checkContact();
	}
	
	@Test(priority=2)
	public void validateTask() {
		task=homepage.validateTaskPage();
	}
	
	@AfterMethod
	public void teardown() {
		driver.quit();
	}
}
