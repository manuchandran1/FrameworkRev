package com.revolutionit.PageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WelcomePage 
{
	
	//Page Factory Constructor
	public WelcomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//	Page Elements
	@FindBy(name = "userName")
	private WebElement textBox_UserName;
	
	@FindBy(name = "password")
	private WebElement textBox_Password;
	
	@FindBy(name = "login")
	private WebElement button_SignIn;
	
	
	//	Methods to Access the Page Elements
	public void CommonLogic_Login(String userName, String password )
	{
		textBox_UserName.sendKeys(userName);
		textBox_Password.sendKeys(password);
		button_SignIn.click();
	}
	
	

}
