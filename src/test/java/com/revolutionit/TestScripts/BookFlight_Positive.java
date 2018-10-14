package com.revolutionit.TestScripts;

import org.testng.annotations.Test;
import org.testng.Assert;
import java.io.IOException;
import java.util.Map;

import org.testng.asserts.SoftAssert;

import com.relevantcodes.extentreports.LogStatus;
import com.revolutionit.Generic.Base;
import com.revolutionit.PageFactory.BookFlightPage;
import com.revolutionit.PageFactory.FlightFinderPage;
import com.revolutionit.PageFactory.SelectFlightPage;
import com.revolutionit.PageFactory.WelcomePage;

public class BookFlight_Positive extends Base
{
	
	@Test(dataProvider = "DataProvider_BookFlightPositive", dataProviderClass = com.revolutionit.Dataprovider.Dataprovider_Class.class)
	public void Test_BookFlight_Positive(Map<String, String> TestData) throws IOException 
	{
		
		// Assigning the Test Data & Expected Result from the Test Data Sheet to local variables
		String TestCaseID = TestData.get("TestCase_ID");
		String userName = TestData.get("UserName");
		String password = TestData.get("Password");
		String ExpectedTitle_Welcome= TestData.get("ExpectedTitle_Welcome");
		String ExpectedTitle_FlightFinder = TestData.get("ExpectedTitle_FindFlight");
		String ExpectedTitle_SelectFlight = TestData.get("ExpectedTitle_SelectFlight");
		String ExpectedTitle_BookFlight = TestData.get("ExpectedTitle_BookFlight");
		String ExpectedTitle_Confirmation = TestData.get("ExpectedTitle_Confirmation");
		
		//Assert for TestNG Report & extentTest for Extent Report
		SoftAssert sAssert = new SoftAssert();
		extentTest = extentReport.startTest(TestCaseID);
		
		// Logging the Beginning of the test execution in the Extent report
		extentTest.log(LogStatus.PASS, "Test Case ID : " + TestCaseID + ",   Status: Execution Started");

		
		String fromPort = TestData.get("FromPort");
		String toPort = TestData.get("ToPort");
		String firstname= TestData.get("FirstName");
		String lastname=TestData.get("LastName");
		String cardnumber=TestData.get("CardNumber");
		
		//	STEP :'Welcome Page' : Title Validation
		String currentTitle = driver.getTitle();
		if(currentTitle.equalsIgnoreCase(ExpectedTitle_Welcome)) 
		{
			extentTest.log(LogStatus.PASS, " Welcome Page is Displayed");
		}
		else 
		{
			extentTest.log(LogStatus.FAIL, "Status = FAILED, Actual Title= '"+currentTitle+ "'  & Expected =  '"+ExpectedTitle_Welcome+"'");
			extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(utility_Object.CaptureScreenshot(driver, TestCaseID)));
			Assert.fail("STATUS: FAILED,  Page Title = "+currentTitle+"  & Expected Page Title = '"+ExpectedTitle_Welcome);
		}
		
		//STEPS 1-2: Login to Find a Flight using credentials from the Test Data sheet
		WelcomePage page_welcome = new WelcomePage(driver);
		page_welcome.CommonLogic_Login(userName, password);
		
		//STEP : 'Flight Finder Page' : Title Validation
		currentTitle = driver.getTitle();
		if(currentTitle.equalsIgnoreCase(ExpectedTitle_FlightFinder)) 
		{
			extentTest.log(LogStatus.PASS, " Flight Finder Page is Displayed");
		}
		else 
		{
			extentTest.log(LogStatus.FAIL, "Status = FAILED , Actual Title= '"+currentTitle+ "'  & Expected = '"+ExpectedTitle_FlightFinder+"'");
			extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(utility_Object.CaptureScreenshot(driver, TestCaseID)));
			Assert.fail("Status: FAILED, Reason: Actual Page Title =  "+currentTitle+"  & Expected Page Title ="+ExpectedTitle_FlightFinder );
		}

		//	STEPS 3-7 : 'Flight Finder Page' : Enter details & click the continue button
		FlightFinderPage page_FlightFinder = new FlightFinderPage(driver);
		page_FlightFinder.set_OneWayTripType();
		page_FlightFinder.set_FromPort(fromPort);
		page_FlightFinder.set_ToPort(toPort);
		page_FlightFinder.set_FirstClass();
		page_FlightFinder.click_Continue();
		
		//STEP : 'Select Flight Page' : Title Validation
		currentTitle = driver.getTitle();
		if(currentTitle.equalsIgnoreCase(ExpectedTitle_SelectFlight)) 
		{
			extentTest.log(LogStatus.PASS, "Select Flight Page is Displayed");
		}
		else 
		{
			extentTest.log(LogStatus.FAIL, "Status = FAILED , Actual Title= '"+currentTitle+ "'  & Expected ="+ExpectedTitle_SelectFlight+"'");
			extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(utility_Object.CaptureScreenshot(driver, TestCaseID)));
			Assert.fail("Status: FAILED, Reason: Actual Page Title = "+currentTitle+" & Expected Page Title ="+ExpectedTitle_SelectFlight );
		}

		//	STEP 8 : 'Select Flight Page': Click the Continue button
		SelectFlightPage page_SelectFlight = new SelectFlightPage(driver);
		page_SelectFlight.click_Continue();
		
		//STEP : 'Book Flight Page' : Title Validation	
		currentTitle = driver.getTitle();
		if(currentTitle.equalsIgnoreCase(ExpectedTitle_BookFlight)) 
		{
			extentTest.log(LogStatus.PASS, "Book Flight Page is Displayed");
		}
		else 
		{
			extentTest.log(LogStatus.FAIL, "Status = FAILED , Actual Title= '"+currentTitle+ "' & Expected = '"+ExpectedTitle_BookFlight+"'");
			extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(utility_Object.CaptureScreenshot(driver, TestCaseID)));
			Assert.fail("Status: FAILED, Reason: Actual Page Title = "+currentTitle+" & Expected Page Title ="+ExpectedTitle_BookFlight );
		}
		
		
		//	Step9-13 : 'Book Flight Page': Enter Details & Click Secure Purchase button

		BookFlightPage page_BookFlight = new BookFlightPage(driver);
		page_BookFlight.set_FirstName(firstname);
		page_BookFlight.set_LastName(lastname);
		page_BookFlight.set_CreditCardNumber(cardnumber);
		page_BookFlight.click_TicketLessTravel();
		page_BookFlight.click_SecurePurchase();
		
		//	Step : 'Confirmation Page' title validation
		currentTitle = driver.getTitle();
		if(currentTitle.equalsIgnoreCase(ExpectedTitle_Confirmation)) 
		{
			extentTest.log(LogStatus.PASS, "Booking Confirmation Page is Displayed");
		}
		else 
		{
			extentTest.log(LogStatus.FAIL, "Status = FAILED , Actual Title= '"+currentTitle+ "' & Expected = '"+ExpectedTitle_Confirmation+ "'");
			extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(utility_Object.CaptureScreenshot(driver, TestCaseID)));
			Assert.fail("Status: FAILED, Reason: Actual Page Title = "+currentTitle+" & Expected Page Title ="+ExpectedTitle_Confirmation );
		}
		
		sAssert.assertAll();
	}

}
