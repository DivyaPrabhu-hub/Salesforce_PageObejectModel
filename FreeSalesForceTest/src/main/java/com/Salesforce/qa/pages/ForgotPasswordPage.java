package com.Salesforce.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Salesforce.qa.base.TestBase;

import junit.framework.Assert;

public class ForgotPasswordPage extends TestBase {
	
	//Page Factory or Object Repository
	
	@FindBy(xpath="//a[@id='forgot_password_link']")
	WebElement forgotPassword;
	
	@FindBy(xpath=("//input[@id='un']"))
	WebElement forgotpageusername;
	
	@FindBy(xpath="//input[@id='continue']")
	WebElement continueButton;

	@FindBy(xpath="//p[contains(text(),'ve sent you an email with a link to finish rese')]")
	WebElement resetMessagePage;
	
//	@FindBy(xpath=("//input[@id='username']"))
//	WebElement username;
//	
//	@FindBy(xpath=("//input[@id='password']"))
//	WebElement password;
	
	@FindBy(xpath="//div[@id='error']")
	WebElement userErrormessage;


//Initializing the Page Objects:
	public ForgotPasswordPage(){
		PageFactory.initElements(driver, this);
	}

	public void forgotPassword_4A(){
		forgotPassword.click();
		forgotpageusername.sendKeys(prop.getProperty("username"));
		continueButton.click();
		resetMessagePage.isDisplayed();
		Assert.assertTrue(resetMessagePage.isDisplayed());
		
	}
	
	public String forgotPassword_4B(){
		userErrormessage.getText();
		String actualMessage = userErrormessage.getText();
		String expectedMessage = "Your login attempt has failed. The username or password may be incorrect, "
				+ "or your location or login time may be restricted. Please contact the administrator at your company for help";
		Assert.assertEquals(actualMessage, expectedMessage);
		return userErrormessage.getText();
	}
}