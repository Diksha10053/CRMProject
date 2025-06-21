package com.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.base.TestBase;
import com.qa.pages.HomePage;
import com.qa.pages.LoginPage;

public class LoginPageTest extends TestBase {
	
	LoginPage lg;
	HomePage homepage;
	
	
	public LoginPageTest() {
		super();
	}

	@BeforeMethod
	public void setup() {
		initialization();
		lg= new LoginPage();
		homepage=new HomePage();
	}
	
	@Test(enabled=true)
	public void LoginPageTitleTest() {
		String title=lg.validateTitle();
		Assert.assertEquals(title, "Free CRM Software - Customer Relationship Management");
		
	}
	@Test(enabled=false)
	public void LoginPageLogoTest() {
		boolean chk=lg.validateLogo();
		Assert.assertTrue(chk);
	}
	
	@Test
	public void  loginchk() {
		homepage=lg.login(pr.getProperty("user"), pr.getProperty("password"));
	
		}
	
	
	@AfterMethod
	public void teardown() {
		getDriver().quit();
	}	
}
