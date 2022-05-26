package Base;

import java.util.Iterator;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import Excelutility.Xl_Reader;
import Excelutility.Xls_Reader;
import Utility.Constant;
import Utility.WebEventListner;


public class Testbase {
	public static WebDriver driver;
	public  static EventFiringWebDriver e_driver;
	public static WebEventListner eventListener;
	public static WebElement element;
	/*public static String Username;
	public static String Password;
	
	
	public static String FirstName;
	public static String LastName;
	public static String CompanyName;
	public static String Email;
	public static String Phone;
	public static String Country;
	public static String Address;
	public static String TownCity;
	public static String StateCountry;
	public static String PostcodeZIP;
	public static String PaymentMode;
	*/
public static Xls_Reader excel_reader = new Xls_Reader(Constant.SHEETURL);
	
	public static String Master_Sheet_Name="MasterSheet";
	
	public static String Browser_Sheet_Name="Browser";
	
	public static String URL_Sheet_Name="URL";
	public static String Product_sheet_name = "Product";
	public static String Login_Sheet_Name="Login";
	public static String Data_Sheet_Name="Details";
	
public static String GetSenario()
{
	Xls_Reader excel_reader = new Xls_Reader(Constant.SHEETURL);
	String senario_name=null;
	int rowCount= excel_reader.getRowCount(Master_Sheet_Name);
	for (int i=1;i<=rowCount;i++)
	{
     String execute_status =excel_reader.getCellData( Master_Sheet_Name, "Execute", i);
     if (execute_status.equalsIgnoreCase("Y"))
      {
         senario_name=excel_reader.getCellData( Master_Sheet_Name, "Scenario_ID", i);
	     System.out.println(senario_name);
	    break;
      }
   }
	return senario_name;
}
	
	
public static String GetBrowser()
{
	Xls_Reader excel_reader = new Xls_Reader(Constant.SHEETURL);
	String browser_name=null;
	int rowCount= excel_reader.getRowCount(Browser_Sheet_Name);
	for (int i=1;i<=rowCount;i++)
	{
      String execute_status =excel_reader.getCellData( Browser_Sheet_Name, "Execute", i);
      if (execute_status.equalsIgnoreCase("Y"))
      {
    	  browser_name=excel_reader.getCellData( Browser_Sheet_Name, "BrowserName", i);
    	  System.out.println(browser_name);
    	  break;
      }
   }
return browser_name;
}

	
public static String GetURL()
{
	Xls_Reader excel_reader = new Xls_Reader(Constant.SHEETURL);
	String url=null;
	int rowCount= excel_reader.getRowCount(URL_Sheet_Name);
	for (int i=1;i<=rowCount;i++)
	{
      String execute_status =excel_reader.getCellData( URL_Sheet_Name, "Execute", i);
      if (execute_status.equalsIgnoreCase("Y"))
      	{
			 url=excel_reader.getCellData( URL_Sheet_Name, "Environment", i);
			 System.out.println(url);
			 break;
      	}
	}	
return url;
}


/*public static String LoginDetails()
{ 
	Xls_Reader excel_reader = new Xls_Reader(Constant.SHEETURL);
	
	String senario_name1=null;
	String senario_name = null;
    int rowCount= excel_reader.getRowCount(Master_Sheet_Name);
     int row_Count= excel_reader.getRowCount(Login_Sheet_Name);
	
 	  for (int i=1;i<=rowCount;i++)
		{
		 	String execute_status =excel_reader.getCellData( Master_Sheet_Name, "Execute", i); 
		 	
		 	if (execute_status.equalsIgnoreCase("Y"))
		 	{
		 		senario_name=excel_reader.getCellData( Master_Sheet_Name, "Scenario_ID", i); 
		 		System.out.println("lOGIN : " + senario_name);
		 		break;
		 	}
		}
		 		
		 		for (int j=1;j<=row_Count;j++)
				{
				    String scenariostatus =excel_reader.getCellData( Login_Sheet_Name, "Scenario_ID", j); 
				 	String executestatus =excel_reader.getCellData( Login_Sheet_Name, "Execute",j);
				 	if (scenariostatus.equalsIgnoreCase(senario_name) && (executestatus.equalsIgnoreCase("Y")) )
				 	{
				 		Username=excel_reader.getCellData( Login_Sheet_Name, "Username", j);
				 		System.out.println("LOGIN"+ Username);
				 		Password=excel_reader.getCellData( Login_Sheet_Name, "Password", j);
				 		System.out.println("LOGIN"+ Password);
			 		break;
			 	 }
		} 
	
	return Username;
}*/

		/*for (int j=1;j<=row_Count;j++)
			{
			    String scenariostatus =excel_reader.getCellData( Login_Sheet_Name, "Scenario_ID", i); 
			 	String executestatus =excel_reader.getCellData( Login_Sheet_Name, "Execute",i);
			 	if (scenariostatus.equalsIgnoreCase(senario_name) && (executestatus.equalsIgnoreCase("Y")) )
			 	{
			 		Username=excel_reader.getCellData( Login_Sheet_Name, "Username", i);
			 		System.out.println("LOGIN"+ Username);
			 		Password=excel_reader.getCellData( Login_Sheet_Name, "Password", i);
			 		System.out.println("LOGIN"+ Password);
			 	/*	break;*/
 	
	
	         


	
	
//	   int rowcount= excel_reader.getRowCount(Master_Sheet_Name);
//	  for (int i=1;i<=rowcount;i++)
//	  {
//		 String execute_status =excel_reader.getCellData( Master_Sheet_Name, "Execute", i);
//		 if (execute_status.equalsIgnoreCase("Y") && senario_name1 != senario_name )
//		 	{
//		 		senario_name1=excel_reader.getCellData( Master_Sheet_Name, "Scenario_ID", i);
//		 		System.out.println("lOGIN : " + senario_name1);
//		 	} 
//		 int rowCount1= excel_reader.getRowCount(Login_Sheet_Name);
//		 for (int j=1;j<=rowCount1;j++)
//			{
//			 	String scenariostatus =excel_reader.getCellData( Login_Sheet_Name, "Scenario_ID", j);
//			 	if (scenariostatus.equalsIgnoreCase(senario_name) || scenariostatus.equalsIgnoreCase(senario_name1))
//			 	{ 
//			 		String executestatus =excel_reader.getCellData( Login_Sheet_Name, "Execute", j);
//			 		if(executestatus.equalsIgnoreCase("Y"))
//			 		{
//			 		Username=excel_reader.getCellData( Login_Sheet_Name, "Username", j);
//			 		System.out.println("LOGIN"+ Username);
//			 		
//			 		}
//			 		if(executestatus.equalsIgnoreCase("Y"))
//			 		{
//			 		Password=excel_reader.getCellData( Login_Sheet_Name, "Password", j);
//			 		System.out.println("LOGIN"+ Password);
//			 		break;
//			 		}
//			 		
//			 	}
//
		


/*
 public static String GetDetails()

{
	 Xl_Reader excel_reader = new Xl_Reader(Constant.SHEETURL);
	String senario_name=null;
	 
	 int rowCount= excel_reader.getRowCount(Master_Sheet_Name);
	 for (int i=1;i<=rowCount;i++)
		{
		 	String execute_status =excel_reader.getCellData( Master_Sheet_Name, "Execute", i);
		 	if (execute_status.equalsIgnoreCase("Y"))
		 	{
		 		senario_name=excel_reader.getCellData( Master_Sheet_Name, "Scenario_ID", i);
		 		System.out.println(senario_name);
		 		break;
		 	} 
		}
	 int row_Count= excel_reader.getRowCount(Data_Sheet_Name);
	 for (int j=1;j<=row_Count;j++)
		{
		 	String scenariostatus =excel_reader.getCellData( Data_Sheet_Name, "Scenario_ID", j);
		 	if (scenariostatus.equalsIgnoreCase(senario_name))
		 	{ 
		 		String executestatus =excel_reader.getCellData( Data_Sheet_Name, "Execute", j);
		 		if(executestatus.equalsIgnoreCase("Y"))
	 
		 		{
		 			FirstName=excel_reader.getCellData( Data_Sheet_Name, "First Name", j);
		 		    System.out.println(FirstName);
		 		    
		 		    LastName=excel_reader.getCellData( Data_Sheet_Name, "Last Name", j);
		 		    System.out.println(LastName);
		 		    
		 		   CompanyName=excel_reader.getCellData( Data_Sheet_Name, "Company Name", j);
		 		    System.out.println(CompanyName);
		 		    
		 		   Email=excel_reader.getCellData( Data_Sheet_Name, "EmaiL Address", j);
		 		    System.out.println(Email);
		 		    
		 		   Phone=excel_reader.getCellData( Data_Sheet_Name, "Phone", j);
		 		    System.out.println(Phone);
		 		    
		 		   Country=excel_reader.getCellData( Data_Sheet_Name, "Country", j);
		 		    System.out.println(Country);
		 		    
		 		   Address=excel_reader.getCellData( Data_Sheet_Name, "Last Name", j);
		 		    System.out.println(LastName);
		 		    
		 		   TownCity=excel_reader.getCellData( Data_Sheet_Name, "TownCity", j);
		 		    System.out.println(TownCity);
		 		    
		 		   StateCountry=excel_reader.getCellData( Data_Sheet_Name, "StateCountry", j);
		 		    System.out.println(StateCountry);
		 		    
		 		   PostcodeZIP=excel_reader.getCellData( Data_Sheet_Name, "PostcodeZIP", j);
		 		    System.out.println(PostcodeZIP);
		 		    
		 		    PaymentMode = excel_reader.getCellData(Data_Sheet_Name, "Payment_Mode", j);
		 		    System.out.println(PaymentMode);
		 		     
		 		break;
		 	}

		
		}	
		}
	return senario_name;
	
}
	 */
public  void intitialize()
	{	
		String Browser_execute = Testbase.GetBrowser();
		String URL_execute = Testbase.GetURL();
		
		if(Browser_execute.equalsIgnoreCase("chrome"))
		{
			
			String RootPath=System.getProperty("user.dir");
			
			
			
			System.setProperty("webdriver.chrome.driver", RootPath+Constant.ChromeDriverPath);	
			driver = new ChromeDriver(); 
			
		}
		
		else if(Browser_execute.equalsIgnoreCase("Firefox"))
		{
			System.setProperty("webdriver.gecko.driver", "F:\\Browser\\Firefox\\geckodriver.exe");	
			driver = new FirefoxDriver(); 
		}
		
		else if(Browser_execute.equalsIgnoreCase("Edge"))
		{
			System.getProperty("user.dir");
			System.setProperty("webdriver.edge.driver" , "F:\\Browser\\Edge\\msedgedriver.exe");	
			driver = new EdgeDriver(); 
		
		}
		
	
        e_driver = new EventFiringWebDriver(driver);
		
		// Now create object of EventListerHandler to register it with EventFiringWebDriver
		eventListener = new WebEventListner();
		e_driver.register(eventListener);
		driver = e_driver;
		
		driver.get(URL_execute);
		driver.manage().window().maximize();
		//driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(Constant.PAGE_LOAD_TIME, TimeUnit.SECONDS);
	
	}

/*public void Login(WebDriver driver, String username, String password)
{
	String login_details =  Testbase.LoginDetails();
	
}*/

//public  void getdetails(String FirstName ,String LastName,String CompanyName,String Email,String Phone,String Country,String Address,String TownCity,String StateCountry,String PostcodeZIP, String PaymentMode )
//{	
//	String Get_Details = 	Testbase.GetDetails();
//	
//
//}
}



