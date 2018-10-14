package com.revolutionit.PageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BookFlightPage 
{
	//	Page Factory Constructor
	public BookFlightPage(WebDriver driver) 
	{
		PageFactory.initElements(driver, this);
	}
	
	// Page Elements
	@FindBy(name = "passFirst0")
	private WebElement textBox_FirstName;
	
	@FindBy(name = "passLast0")
	private WebElement textBox_LasName;
	
	@FindBy(name = "creditnumber")
	private WebElement textBox_CreditCard;
	
	@FindBy(name = "ticketLess")
	private WebElement checkBox_TicketLessTravel;
	
	@FindBy(name = "buyFlights")
	private WebElement button_SecurePurchase;
	
	
	//	Methods to Access the Page Elements
	
	public void set_FirstName(String firstname) 
	{
		textBox_FirstName.sendKeys(firstname);
	}
	
	public void set_LastName(String lastname) 
	{
		textBox_LasName.sendKeys(lastname);
	}
	
	public void set_CreditCardNumber(String cardnumber) 
	{
		textBox_CreditCard.sendKeys(cardnumber);
	}
	
	public void click_TicketLessTravel() 
	{
		checkBox_TicketLessTravel.click();
	}
	
	public void click_SecurePurchase() 
	{
		button_SecurePurchase.click();
	}
	

}
