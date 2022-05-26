package TestLayer;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Base.Testbase;
import Excelutility.Xls_Reader;
import Pages.MainPge;
import Utility.Constant;
import Utility.TestUtil;


public class MainPgeTest extends Testbase 
{
	public static String Username;
	public  String Password;
	public  MainPge MainPgeobj;
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
	@FindBy(xpath = "//ul[@id='main-nav']//li[2]")
	WebElement myaccount;
	@FindBy(xpath = "//input[@id='username']")
	WebElement username;
	@FindBy(xpath = "//input[@id='password']")
	WebElement password;
	@FindBy(xpath = " //div[@id='customer_login']//div//form//p[3]//input[3]")
	WebElement loginbtn;
	@FindBy(xpath="//div[@id='page-36']//div//div//nav//ul//li[6]//a")
	WebElement logout;
	
	
	
	public MainPgeTest()
{
	super();
}
		
	@BeforeMethod 
	public void initializetest () throws InterruptedException 
	{
		intitialize();
		MainPgeobj = new MainPge();
		//MainPgeobj.LoginDetails(Username,Password,FirstName , LastName,CompanyName, Email, Phone, Country, Address, TownCity, StateCountry, PostcodeZIP,PaymentMode);
	}
	
//	@DataProvider
//	public Iterator<Object[]> getTestdata()
//	{
//		ArrayList<Object[]> testData = TestUtil.getDataFromExcel();
//		return testData.iterator();
//		
//	}
//	@DataProvider
//	public Iterator<Object[]> getTestdata2()
//	{
//		ArrayList<Object[]> testData2 = TestUtil.getDataFromExcel2();
//		return testData2.iterator();
//		
//	}
 
	@Test (groups = { "booking_online"})
	
	public void MainTitleTest(String Username , String Password) throws InterruptedException
	{
		MainPgeobj.LoginDetails(Username,Password,FirstName , LastName,CompanyName, Email, Phone, Country, Address, TownCity, StateCountry, PostcodeZIP,PaymentMode);
//		String main_title = MainPgeobj.VerifyMainPgeTitle();
//		Assert.assertEquals(main_title, "My Account – Automation Practice Site","Title mismatched");
	/*	
	 * (dataProvider = "getTestdata" )
	  public void MainTitleTest(String Username , String Password) throws InterruptedException
	{
	Xls_Reader excel_reader = new Xls_Reader(Constant.SHEETURL);
		String senario_name = null;
		List <String> scnr = new ArrayList<String>();
		
		 
		 int rowCount= excel_reader.getRowCount(Master_Sheet_Name);   
		 int row_Count= excel_reader.getRowCount(Login_Sheet_Name);
		
		 for (int i=1;i<rowCount;i++)
			{
		 		
			 	String execute_status =excel_reader.getCellData( Master_Sheet_Name, "Execute", i);
			 	if (execute_status.equalsIgnoreCase("Y"))
			 	{
			 		senario_name=excel_reader.getCellData( Master_Sheet_Name, "Scenario_ID", i);
			 		scnr.add(senario_name);
			 		
			 		
			 	}
			 	else if(execute_status.equalsIgnoreCase(""))
			 	{
			 		System.out.println("test data for senario ++ ");
			 		continue;
			 		
			 	}
			 	
			}
		 			int arrayscn = scnr.size();
			 		System.out.println("Size of array scn :"+arrayscn);
			 		System.out.println("All : "+scnr);
			 		//myaccount.click();
			 		myaccount.click();
					
			 		
			 		for (int arr=0;arr<scnr.size() ;arr++)	
			 		{
			 			System.out.println("Text "+scnr.get(arr));
			 			
			 			for (int j=1;j<row_Count;j++)
			 			  {
		 		 	String scenariostatus =excel_reader.getCellData( Login_Sheet_Name, "Scenario_ID", j);
		 		 	if (scenariostatus.equalsIgnoreCase(scnr.get(arr)))
		 		 	{ 
		 		 		System.out.println("text 2 "+scnr.get(arr));
		 		 		Username=excel_reader.getCellData( Login_Sheet_Name, "Username", j);
				 		System.out.println("LOGIN"+ Username);
				 		Password=excel_reader.getCellData( Login_Sheet_Name, "Password", j);
				 		System.out.println("LOGIN"+ Password);
				 		
				 		username.sendKeys(Username);
						password.sendKeys(Password);
						
						loginbtn.click();
						
						myaccount.click();
						logout.click();
		 		 	}
			}
			 		}*/
	}
	@AfterMethod
	public void End()
	{
		driver.close();
		driver.quit();
	}
}


