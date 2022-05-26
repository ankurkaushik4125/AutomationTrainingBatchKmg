package TestLayer;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Base.Testbase;
import Excelutility.Xls_Reader;

import Pages.CheckoutPage;
import Pages.MainPge;

import Pages.Shop;
import Pages.ThinkingPage;
import Utility.Constant;

public class CheckoutPageTest extends Testbase {
	
		public MainPge MainPgeobj;
		public Shop Shopobj;
		public ThinkingPage ThinkingPage_obj;
		
		public CheckoutPage CheckoutPage_obj;
		
		
		@FindBy(id ="billing_first_name")
		WebElement firstname;
		public String FirstName;
		public String LastName;
		public String CompanyName;
		public String Email;
		public String Phone;
		public String Country;
		public String Address;
		public String TownCity;
		public String StateCountry;
		public String PostcodeZIP;
		public String PaymentMode;
		public String Username ;
		public String Password ;
		public CheckoutPageTest()
	{
		super();
	}
	
	
	@BeforeTest 
	public void initializetest () throws InterruptedException 
	{
		intitialize();
		MainPgeobj = new MainPge();
		Thread.sleep(2000);
		MainPgeobj.LoginDetails(Username , Password,FirstName , LastName,CompanyName, Email, Phone, Country, Address, TownCity, StateCountry, PostcodeZIP,PaymentMode);
		Thread.sleep(2000);
		Shopobj = new Shop();
		Shopobj.Clickimg(Username , Password);
		Thread.sleep(2000);
		ThinkingPage_obj = new ThinkingPage();
		Thread.sleep(2000);
		ThinkingPage_obj.addingelement(Username , Password);
		Thread.sleep(2000);
		CheckoutPage_obj = new CheckoutPage();
	}
 @Test (groups = { "booking"})
	public void CheckoutPageTest() throws InterruptedException
{
	 
	String OrderPalce_msg=	CheckoutPage_obj.putdata(Username, Password, FirstName, LastName, CompanyName, Email, Phone, Country, Address, TownCity, StateCountry, PostcodeZIP, PaymentMode);
	Assert.assertEquals(OrderPalce_msg,"Thank you. Your order has been received.","Order is not placed");	
	CheckoutPage_obj.logout();

}
	@AfterTest
	public void End()
	{
		driver.close();
		driver.quit();
	}

}


























//String checkout_title = CheckoutPage_obj.VerifyCheckoutPageTitleTest();
//Assert.assertEquals(checkout_title, "Checkout – Automation Practice Site","Title mismatched");
//@Test (groups = { "booking"})
//
//	public  void CreatebookingTest() throws InterruptedException 
//	{
//		 /* 
		//  First get the data from Excel with the help of ExcelUtility or DataProvider and then call the function from page layer of checkout page
//		  */
//	 
//	 
//	 	Xls_Reader excel_reader = new Xls_Reader(Constant.SHEETURL);
//	 	String senario_name=null;
//	 	String user = Username;
//		System.out.println("User shop : "+ user);
//		String pass = Password;
//		System.out.println("Password shop : " +pass);
		
		
//		 int rowCount= excel_reader.getRowCount(Login_Sheet_Name);
//		 for (int i=1;i<rowCount;i++)
//			{
//			 	String user_status =excel_reader.getCellData( Login_Sheet_Name, "Username ", i);
//			 	String pass_status =excel_reader.getCellData( Login_Sheet_Name, "Password ", i);
//			 	if (user_status.equalsIgnoreCase(user) &&pass_status.equalsIgnoreCase(pass) )
//			 	{
//			 		senario_name=excel_reader.getCellData( Login_Sheet_Name, "Scenario_ID", i);
//			 		System.out.println("Product: "+senario_name);
//			 		
//			 	}
////			}
//		 int row_Count= excel_reader.getRowCount(Data_Sheet_Name);
//		 for (int j=1;j<=row_Count;j++)
//	 		 			  {
//		 		 	String scenariostatus =excel_reader.getCellData( Data_Sheet_Name, "Scenario_ID", j);
//		 		 	if (scenariostatus.equalsIgnoreCase(senario_name))
//		 		 	{ 
//		 		 		System.out.println("text 2 "+senario_name);
	 		 		
//	 		 			FirstName=excel_reader.getCellData( Data_Sheet_Name, "First Name", j);
//	 		 		    System.out.println(FirstName);
	 		 		    
//	 		 		    LastName=excel_reader.getCellData( Data_Sheet_Name, "Last Name", j);
//	 		 		    System.out.println(LastName);
//	 		 		    
//	 		 		   CompanyName=excel_reader.getCellData( Data_Sheet_Name, "Company Name", j);
//	 		 		    System.out.println(CompanyName);
	 		 		    
//	 		 		   Email=excel_reader.getCellData( Data_Sheet_Name, "EmaiL Address", j);
//	 		 		    System.out.println(Email);
	 		 		    
//	 		 		   Phone=excel_reader.getCellData( Data_Sheet_Name, "Phone", j);
//	 		 		    System.out.println(Phone);
//	 		 		    
//	 		 		   Country=excel_reader.getCellData( Data_Sheet_Name, "Country", j);
//	 		 		    System.out.println(Country);
	 		 		    
//	 		 		   Address=excel_reader.getCellData( Data_Sheet_Name, "Last Name", j);
//	 		 		    System.out.println(Address);
	 		 		    
//	 		 		   TownCity=excel_reader.getCellData( Data_Sheet_Name, "TownCity", j);
//	 		 		    System.out.println(TownCity);
//	 		 		    
//	 		 		   StateCountry=excel_reader.getCellData( Data_Sheet_Name, "StateCountry", j);
//	 		 		    System.out.println(StateCountry);
//	 		 		    
//	 		 		   PostcodeZIP=excel_reader.getCellData( Data_Sheet_Name, "PostcodeZIP", j);
//	 		 		    System.out.println(PostcodeZIP);
	 		 		    
	 		 		  //  PaymentMode = excel_reader.getCellData(Data_Sheet_Name, "Payment_Mode", j);
//	 		 		  CheckoutPage_obj.putdata(Username,Password,FirstName, LastName, CompanyName, Email, Phone, Country, Address, TownCity, StateCountry, PostcodeZIP, PaymentMode);
//	 		 		  CheckoutPage_obj.logout();
//	 		 		  
//	 		 	}
//		 		//	break;
//	 		}	
//	 		 	}
//	 		 		
	  	





//}