package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Base.Testbase;

public class ThinkingPage extends Testbase 
{
	@FindBy(xpath="//div[@class='quantity']//input")
	WebElement quantity;
	
	@FindBy(xpath="//div[@id='content']//div//div[2]//form//button")
	WebElement Additem;
	
	@FindBy(xpath="//a[@class='button wc-forward']")
	WebElement ViewBasket;
	@FindBy(xpath = "//ul[@id='main-nav']//li[2]")
	WebElement myaccount;
	@FindBy(xpath="//div[@id='page-36']//div//div//nav//ul//li[6]//a")
	WebElement logout;
	public String Username ;
	public String Password ;
	@FindBy(xpath = "//div[@class='wc-proceed-to-checkout']//a")
	WebElement proceedcheckout;

	public ThinkingPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	
	
	public String VerifyThinkingPageTitle()
	{
		String title_ThinkingPage = driver.getTitle();
		return title_ThinkingPage;
	}



	public CheckoutPage addingelement(String Username ,String Password) 
	{
		// TODO Auto-generated method stub
		 /*Adding quantity of book */
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
			 	String productquant = excel_reader.getCellData( Product_sheet_name, "Product_Quantity", j);
			 	if (scenariostatus.equalsIgnoreCase(senario_name))
			 	{ 
			 		
			 		System.out.println(productquant);
			 		quantity.clear();
					quantity.sendKeys(productquant);
					Additem.click();
					/* go to basket*/
					ViewBasket.click();
					
					proceedcheckout.click();
//					myaccount.click();
//					logout.click();
					
			 	}
			}
		
		return null;
		
	
	}



	
	}


