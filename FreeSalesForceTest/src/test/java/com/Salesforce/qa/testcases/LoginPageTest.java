package com.Salesforce.qa.testcases;

import javax.swing.plaf.ActionMapUIResource;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.Salesforce.qa.base.TestBase;
import com.Salesforce.qa.pages.HomePage;
import com.Salesforce.qa.pages.LoginPage;

import junit.framework.Assert;

public class LoginPageTest extends TestBase {
	
	LoginPage loginPage;
	HomePage homePage;
	
	public LoginPageTest(){
		super();
	}
	
	@BeforeMethod
	public void setUp(){
		initialization();
		
	loginPage = new LoginPage();	
	}
	
	//Test cases should be seperated ---independent with each other
	//before each test case ---launch the browser and login
	//@Test --execute test cases.
	//after each test case  -- close the browser.
	
	@Test(priority=1)
	public void remembermetextBox(){
		loginPage.remembermetextbox(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	
   @Test(priority=2)
   public void loginerrorMessage(){
	   String message= loginPage.loginErrorMessage(prop.getProperty("username"));
	   Assert.assertEquals(message, "Please enter your password.");
	   
   }
	@Test(priority=3)
	public void LoginPageTitleTest(){
		String title = loginPage.validateLoginPageTitle();
		Assert.assertEquals(title, "Login | Salesforce" );
	}
	@Test(priority=4)
	public void SalesforceLogoTest(){
		Boolean flag = loginPage.validateSalesforceLogo();
		Assert.assertTrue(flag);
		}
	
	@Test(priority=5)
	public void loginTest(){
		homePage =loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		
	}
	
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
}
