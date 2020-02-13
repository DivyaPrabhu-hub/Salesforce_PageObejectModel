package com.Salesforce.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Salesforce.qa.base.TestBase;

public class LoginPage extends TestBase{
	
	//Page Factory or Object Repository
	
	@FindBy(name="username")
	WebElement username;
	
	@FindBy(xpath="//input[@id='password']")
	WebElement password;
	
	@FindBy(xpath="//input[@id='Login']")
	WebElement loginBtn;
	
	@FindBy(xpath="//div[@id='error']")
	WebElement errormessage;
	
	@FindBy(name="logo")
	WebElement salesforcelogo;
	
	@FindBy(xpath="//input[@id='rememberUn']")
	WebElement rememberMe;
	
	@FindBy(xpath ="//div[@id='userNavButton']")
	WebElement userprofile;
	
	@FindBy(xpath ="//a[contains(text(),'Logout')]")
	WebElement Logoutbutton;
	
	@FindBy(xpath ="//span[@id='idcard-identity']")
	WebElement VerifyUsername;
	
	//Initializing the Page Objects:
	public LoginPage(){
		PageFactory.initElements(driver, this);
	}
	
	//Actions:
	public String validateLoginPageTitle(){
		return driver.getTitle();	
	}
	
  public boolean validateSalesforceLogo(){
	return salesforcelogo.isDisplayed();
  }
	public HomePage login(String un, String pwd){
		username.sendKeys(un);
		password.sendKeys(pwd);
		loginBtn.click();
		
		return new HomePage();
	}
	
	public String loginErrorMessage(String un){
		username.sendKeys(un);
		loginBtn.click();
		String ActualErrormessage =errormessage.getText();
		 String ExpectedErrormessage = "Please enter your password.";
		return errormessage.getText();
	}
		
		public LoginPage remembermetextbox(String un, String pwd){
			username.sendKeys(un);
			password.sendKeys(pwd);
			rememberMe.click();
			loginBtn.click(); 
			userprofile.click();
			Logoutbutton.click();
			return new LoginPage();
			
		}
	}

