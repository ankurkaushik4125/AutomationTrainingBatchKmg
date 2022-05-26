package Pages;

import java.util.ArrayList;
import java.util.List;

import org.apache.batik.util.gui.MemoryMonitor.Usage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Base.Testbase;
import Excelutility.Xls_Reader;
import Utility.Constant;

public class MainPge extends Testbase
{
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
	public Shop Shopobj_1;
	public ThinkingPage ThinkingPageobj_1;

	public CheckoutPage CheckoutPageobj_1;
	
	
	
	public MainPge()
	{
		PageFactory.initElements(driver, this);
	
	}
	public String VerifyMainPgeTitle()
	{
		String title_MainPge = driver.getTitle();
		return title_MainPge;
	}
	
	
	public Shop  LoginDetails(String Username, String Password ,String FirstName ,String LastName,String CompanyName,String Email,String Phone,String Country,String Address,String TownCity,String StateCountry,String PostcodeZIP,String PaymentMode ) throws InterruptedException
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
						
//						myaccount.click();
//						logout.click();
						Shopobj_1 = new Shop();
			 			Shopobj_1.Clickimg(Username,Password);
			 			ThinkingPageobj_1 = new ThinkingPage();
		 			ThinkingPageobj_1.addingelement(Username, Password);
			 			CheckoutPageobj_1 = new  CheckoutPage();
			 			CheckoutPageobj_1.putdata(Username, Password,FirstName,LastName,CompanyName,Email,Phone,Country,Address,TownCity,StateCountry,PostcodeZIP,PaymentMode);
			 			CheckoutPageobj_1.logout();
			 		}
		 		  }
		}
		return null;
					
	}


}			
			 			
	

	
			 		
		
