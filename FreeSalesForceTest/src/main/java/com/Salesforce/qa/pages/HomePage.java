package com.Salesforce.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Salesforce.qa.base.TestBase;

public class HomePage extends TestBase{
	
	@FindBy(xpath=("//span[@id='userNavLabel']"))
	WebElement userdropdown;
	

	//Initializing the Page Objects:
	public HomePage(){
		PageFactory.initElements(driver, this);
	}
	
	//Actions .. methods
	
	public boolean UserMenu(){
		userdropdown.click();
		return userdropdown.isDisplayed();
	}

}
