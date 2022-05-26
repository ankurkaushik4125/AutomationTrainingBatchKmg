package TestLayer;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Base.Testbase;
import Pages.MainPge;
import Pages.Shop;
import Pages.ThinkingPage;

public class ThinkingPageTest extends Testbase
{
	public MainPge MainPgeobj;
	public Shop Shopobj;
	public ThinkingPage ThinkingPage_obj;
	public String Username ;
	public String Password ;
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
	public ThinkingPageTest()
{
	super();
}
@BeforeMethod 
public void initializetest () throws InterruptedException 
{
	intitialize();
	MainPgeobj = new MainPge();
	MainPgeobj.LoginDetails(Username,Password,FirstName , LastName,CompanyName, Email, Phone, Country, Address, TownCity, StateCountry, PostcodeZIP,PaymentMode);
	
	Shopobj = new Shop();
	Shopobj.Clickimg(Username , Password);
	ThinkingPage_obj = new ThinkingPage();
	ThinkingPage_obj.addingelement(Username , Password);
}
@Test (groups = { "booking_online"})
public void ThinkingPageTitleTest()
{
	String think_title = ThinkingPage_obj.VerifyThinkingPageTitle();
	Assert.assertEquals(think_title, "Products – Automation Practice Site","Title mismatched");
}
@AfterMethod
public void End()
{
	driver.close();
	driver.quit();
}
}
