package Pages;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.poi.util.SystemOutLogger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import Base.Testbase;
import Excelutility.Xls_Reader;

public class Shop extends Testbase
{
	public String Username ;
	public String Password ;
	@FindBy(xpath = "//ul[@id='main-nav']//li[1]")
	WebElement shop_btn;
//	@FindBy(xpath ="//*[@id='content']//ul//li[3]//a[1]//img")
//	WebElement Thinkbook_click;
	@FindBy(xpath = "//*[@id='content']//ul//li//a//h3")
	List < WebElement > item_table;
	@FindBy(xpath = "//ul[@id='main-nav']//li[2]")
	WebElement myaccount;
	@FindBy(xpath="//div[@id='page-36']//div//div//nav//ul//li[6]//a")
	WebElement logout;
	public  MainPge MainPgeobj_1;
	public Shop shopobj;
	public Shop()
	{
		PageFactory.initElements(driver, this);
	
	}
	public String VerifyShopTitle()
	{
		String title_Shop = driver.getTitle();
		return title_Shop;
	}
	
	public  ThinkingPage Clickimg(String Username ,String Password) throws InterruptedException
	{
	shop_btn.click();
	int k;
	String before_xpath = "//*[@id='content']//ul//li[";
	String after_xpath = "]//a[1]//img";
//	MainPgeobj_1 = new MainPge();
//	MainPgeobj_1.credentials(Username, Password);
	String user = Username;
	System.out.println("User shop : "+ user);
	String pass = Password;
	System.out.println("Password shop : " +pass);
	String senario_name=null;
	
	 int rowCount= excel_reader.getRowCount(Login_Sheet_Name);
	 for (int i=1;i<rowCount;i++)
		{
		 	String user_status =excel_reader.getCellData( Login_Sheet_Name, "Username ", i);
		 	String pass_status =excel_reader.getCellData( Login_Sheet_Name, "Password ", i);
		 	if (user_status.equalsIgnoreCase(user) &&pass_status.equalsIgnoreCase(pass) )
		 	{
		 		senario_name=excel_reader.getCellData( Login_Sheet_Name, "Scenario_ID", i);
		 		System.out.println("Product: "+senario_name);
		 		
		 	}
		}
	 
	 int row_Count= excel_reader.getRowCount(Product_sheet_name);
	 for (int j=1;j<row_Count;j++)
		{
		 	String scenariostatus =excel_reader.getCellData( Product_sheet_name, "Scenario_ID", j);
		 	String productname = excel_reader.getCellData( Product_sheet_name, "Product_Name", j);
		 	if (scenariostatus.equalsIgnoreCase(senario_name))
		 	{ 
		 		System.out.println(productname);
		 		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		 		System.out.println("Size of item table " + item_table.size());
		 		System.out.println("Item table names : "+ item_table);
		 		
		 	
		
	            for(k=0;k<item_table.size();k++)
	         {
	            String heading =	item_table.get(k).getText();
	            	
	        	 if(productname.equalsIgnoreCase(heading))
	        	   {
	        		  // jse.executeScript("arguments[0].scrollIntoView(true)", productname);
	        		   String full_xpath = before_xpath +( k+1) + after_xpath;
	        		   Thread.sleep(1000l);
	        		   driver.findElement(By.xpath(full_xpath)).click();
	        		  
	        			 
	        			
	        	   }
	        	    
	          }
	         }
		}
//jse.executeScript("arguments[0].scrollIntoView(true)", Thinkbook_click);
//	Thinkbook_click.click();
//	 MainPgeobj_1 = new MainPge();
//	 MainPgeobj_1.LoginDetails(Username , Password);
	return null;
	
	 
	}
}
	
	


