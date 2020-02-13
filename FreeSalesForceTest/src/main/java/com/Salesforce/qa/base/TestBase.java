package com.Salesforce.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.Salesforce.qa.util.TestUtil;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class TestBase {

	public static WebDriver driver;
	public static Properties prop;
	static ExtentReports reports;
	static ExtentTest logger;
	
	 public TestBase(){
		 
		 
		 try{
			 prop = new Properties();
			 FileInputStream ip = new FileInputStream(System.getProperty("user.dir") +  "/src/main/java/com/Salesforce/qa"
			 		+ "/config/config.Properties");
					 prop.load(ip);
		
		 } catch (FileNotFoundException e){
			 e.printStackTrace();
			 
		 }catch (IOException e){
			 e.printStackTrace();	 
		 }	
		 
		 
	 }	
	 
	 
	 
	 public static void initialization(){
		 String browserName = prop.getProperty("browser");
		 if(browserName.equals("chrome")){
			 System.setProperty("webdriver.chrome.driver", "//Users//divya//Documents//chromedriver");
			 driver = new ChromeDriver();
		 }
		 else if(browserName.equals("firefox")){
			 System.setProperty("webdriver.gecko.driver", "//Users//divya//Documents//geckodriver");
			 driver = new FirefoxDriver();
		 }
	 
		 driver.manage().window().maximize();
		 driver.manage().deleteAllCookies();
		 driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		 driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		
		 //Launch the url
		 driver.get(prop.getProperty("url"));
		 
	 }
}
	
	
