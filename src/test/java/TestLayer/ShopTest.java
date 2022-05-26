package TestLayer;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


import Base.Testbase;
import Pages.MainPge;
import Pages.Shop;


public class ShopTest extends Testbase {
    public MainPge MainPgeobj;
	public Shop Shopobj;
	public String Username;
	public String Password;
	
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
	public ShopTest()
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
}
@Test (groups = { "booking_online"})
public void HomepageTitleTest()
{
	String shop_title = Shopobj.VerifyShopTitle();
	Assert.assertEquals(shop_title, "Products – Automation Practice Site","Title mismatched");
	
}
@AfterMethod
public void End()
{
	driver.close();
	driver.quit();
}
}