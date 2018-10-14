package com.revolutionit.PageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class FlightFinderPage
{
	
	// PageFactory Constructor
	public FlightFinderPage(WebDriver driver) 
	{
		PageFactory.initElements(driver, this);
	}
	
	//Page Elements
	
	@FindBy(xpath = "//input[@name='tripType' and @value='oneway']")
	private WebElement radioButton_OneWay;
	
	@FindBy(name = "fromPort")
	private WebElement dropdown_FromPort;
	
	@FindBy(name = "toPort")
	private WebElement dropdown_ToPort;
	
	@FindBy(xpath = "//input[@name='servClass' and @value='First']")
	private WebElement radioButton_FirstClass;
	
	@FindBy(name = "findFlights")
	private WebElement button_Continue;
	
	//	Methods to Access the Page Elements

	public void set_OneWayTripType()
	{
		radioButton_OneWay.click();
	}
	
	public void set_FromPort(String fromPort)
	{
		Select from_Port = new Select(dropdown_FromPort);
		from_Port.selectByValue(fromPort);
	}
	
	public void set_ToPort(String toPort)
	{
		Select from_Port = new Select(dropdown_ToPort);
		from_Port.selectByValue(toPort);
	}
	
	public void set_FirstClass() 
	{
		radioButton_FirstClass.click();
	}
	
	public void click_Continue() 
	{
		button_Continue.click();
	}
		

}
