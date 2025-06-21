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

import com.aventstack.extentreports.ExtentReports;
import com.qa.util.ExtentReportManager;
import com.qa.util.TestUtil;

public class TestBase {


   

    public static WebDriver driver;
	public static ThreadLocal<WebDriver> tdriver = new ThreadLocal<>();

    public static Properties pr;
    public static ExtentReports extent;
    
    public static WebDriver getDriver() {
        return tdriver.get();
    }
    public TestBase() {
        pr = new Properties();
        try {
            FileInputStream ip = new FileInputStream("/Users/diksha/eclipse-workspace/FreeCRMTest/src/main/java/com/qa/config/config.properties");
            pr.load(ip); // throws IOException
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void initialization() {
        // Start ExtentReports
        extent = ExtentReportManager.getReportInstance();

        // Launch browser
        String browserName = pr.getProperty("browser");
        if (browserName.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            tdriver.set(driver);

        } else if (browserName.equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver= new FirefoxDriver();
            tdriver.set(driver);

        }

        getDriver().manage().window().maximize();
        getDriver().manage().deleteAllCookies();
        getDriver().manage().timeouts().pageLoadTimeout(Duration.ofSeconds(TestUtil.pageLoad));
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(TestUtil.implicit_wait));
        getDriver().get(pr.getProperty("url"));
    }

}