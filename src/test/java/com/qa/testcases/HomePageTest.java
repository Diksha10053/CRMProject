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
	
	  try {
          homepage = loginpage.login(pr.getProperty("user"), pr.getProperty("password"));
          Assert.assertNotNull(homepage, "Login failed. HomePage object is null.");
      } catch (Exception e) {
          e.printStackTrace();
          Assert.fail("Exception during login: " + e.getMessage());
      }

      System.out.println("Thread ID: " + Thread.currentThread().getId()+ " - Setup complete");
  }
	
	
	@Test(enabled=false)
	public void validateTitle() {
		String title=homepage.validateTitle();
		Assert.assertEquals(title, "Cogmento CRM");
		
	}
	
	@Test
	public void ValidateName() {
		String vname= homepage.validateName();
		Assert.assertEquals(vname, "Diksha Sharma");
	}
	
	@Test
	public void validateContact() {
		contact=homepage.checkContact();
		Assert.assertEquals(getDriver().getCurrentUrl(),"https://ui.cogmento.com/contacts");
	}
	
	@Test(enabled=false)
	public void validateTask() {
		task=homepage.validateTaskPage();
		Assert.assertEquals(getDriver().getCurrentUrl(),"https://ui.cogmento.com/tasks");
	}
	
	@AfterMethod
	public void teardown() {
		getDriver().quit();
	}
}
