package com.Salesforce.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.Salesforce.qa.base.TestBase;
import com.Salesforce.qa.pages.ForgotPasswordPage;
import com.Salesforce.qa.pages.LoginPage;

public class FogotPasswordTest extends TestBase{
	
	LoginPage loginPage;
	ForgotPasswordPage ForgotPassword;
	
	public FogotPasswordTest(){
		super();
	}

	@BeforeMethod
	public void setUp(){
		initialization();
		loginPage = new LoginPage();
		ForgotPassword = new ForgotPasswordPage();	
	}
	
	@Test(priority=1)
	public void forgotPassword_4A(){
		ForgotPassword.forgotPassword_4A();
		}
	
	@Test(priority=2)
	public void forgotPassword_4B(){
		loginPage.login("123", "22131");
		
	}
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
}

