package com.revolutionit.PageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SelectFlightPage 
{
	// Page Factory Constructor 
	public SelectFlightPage(WebDriver driver) 
	{
		PageFactory.initElements(driver, this);
	}
	
	//	Page Elements
	@FindBy(name="reserveFlights")
	private WebElement button_Contunue;
	
	//	Methods to Access the Page Elements

	public void click_Continue() 
	{
		button_Contunue.click();
	}


}
