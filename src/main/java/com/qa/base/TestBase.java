package com.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import com.qa.util.TestUtil;


public class TestBase{
	
	public static WebDriver driver;
	public static Properties pr;
	
	
	public TestBase() {
		pr= new Properties();
		try {
			FileInputStream ip= new FileInputStream("/Users/diksha/eclipse-workspace/FreeCRMTest/src/main/java/com/qa/config/config.properties");
			pr.load(ip);
			}
		catch(FileNotFoundException e) {
			e.printStackTrace();

		}
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public static void initialization() {
		String browserName=pr.getProperty("browser");
		if(browserName.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
			
		}
		else if(browserName.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver= new FirefoxDriver();
		}
		
        
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(TestUtil.pageLoad));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(TestUtil.implicit_wait) );
		driver.get(pr.getProperty("url"));
		
	}

}
