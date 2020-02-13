package com.Salesforce.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.Salesforce.qa.base.TestBase;
import com.Salesforce.qa.pages.HomePage;
import com.Salesforce.qa.pages.LoginPage;

import junit.framework.Assert;

public class HomePageTest extends TestBase{
	LoginPage loginPage;
	HomePage homePage;
	
	public HomePageTest(){
		super();
	}

	@BeforeMethod
	public void setUp(){
		initialization();
		
	loginPage = new LoginPage();
	homePage =loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@Test
	public void Userdropdown(){
		homePage.UserMenu();
		Boolean flag = homePage.UserMenu();
		Assert.assertTrue(flag);
	}
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
}
}