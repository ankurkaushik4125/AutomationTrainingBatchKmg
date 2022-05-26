package Pages;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Base.Testbase;
import Excelutility.Xls_Reader;
import Utility.Constant;
import Pages.Shop;
public class CheckoutPage extends Testbase {
	@FindBy(xpath = "//input[@id='username']")
	WebElement username;
	@FindBy(xpath = "//input[@id='password']")
	WebElement password;
	
	@FindBy(xpath = " //div[@id='customer_login']//div//form//p[3]//input[3]")
	WebElement loginbtn;
	
	@FindBy(id ="billing_first_name")
	WebElement firstname;
	
	@FindBy(id ="billing_last_name")
	WebElement lastname;
	
	@FindBy(id ="billing_company")
	WebElement companyname;
	
	@FindBy(id ="billing_email")
	WebElement email;
	
	@FindBy(id ="billing_phone")
	WebElement phonenumber;
	
	/*by default country is INDIA*/
	
	@FindBy(xpath ="select2-results-1")
	WebElement countrylist;
//	/*end of country drop down*/
	
	
	@FindBy(id ="billing_address_1")
	WebElement Adrress;
	
	@FindBy(id="billing_city")
	WebElement city;
	
//	/*STATE dropdown*/
//	/*clickstatebox*/
	@FindBy(xpath= "//div[@id='s2id_billing_state']")
	WebElement statebox;
	@FindBy(xpath= "//input[@id='s2id_autogen2_search']")
	WebElement statepass;
//	/*get state list*/
	@FindBy(xpath= "//div[@class='select2-drop select2-display-none select2-with-searchbox select2-drop-active']//ul")
	WebElement statelist;
//	/*End of state dropdown*/
	
	@FindBy(id ="billing_postcode")
	WebElement pincode;
//	/*payment mode*/
//	/*get state list*/
	@FindBy(xpath= "//div[@id='payment']//ul//li//label")
	List <WebElement> paymentlist;
//	/*End of state dropdown*/
	@FindBy(xpath="//div[@id='payment']//ul//li[3]//label")
	WebElement cashondelivery;
	
	@FindBy(xpath = "//div[@class='form-row place-order']//input[1]")
	WebElement placeorderbutton;
	
	@FindBy(xpath = "//a[text()='My Account']")
	WebElement myacc;

	@FindBy(xpath = "//ul[@class='woocommerce-thankyou-order-details order_details']//li[1]/strong")
	WebElement Order_id_wl;
	@FindBy(xpath = "//p[@class='woocommerce-thankyou-order-received']")
	WebElement Order_place_msg_wl;
	@FindBy(xpath="//a[text()='Logout']")
	WebElement logout;
	
	public String Username ;
	public String Password ;
			
	public CheckoutPage()
	{
		PageFactory.initElements(driver, this);
	}
	public String VerifyCheckoutPageTitleTest()
	{
		String title_CheckoutPage = driver.getTitle();
		return title_CheckoutPage;
	}


	
	public String putdata(String Username , String Password ,String FirstName ,String LastName,String CompanyName,String Email,String Phone,String Country,String Address,String TownCity,String StateCountry,String PostcodeZIP,String PaymentMode) throws InterruptedException 
	{
		String Order_Place_text_Str = null;
		String payment_before_xpath = "//div[@id='payment']//ul//li[";
		String payment_after_xpath = "]//label";
		Actions action = new Actions(driver);
		JavascriptExecutor jse = (JavascriptExecutor)driver;
			
			
		
		Xls_Reader excel_reader = new Xls_Reader(Constant.SHEETURL);
	 	
		String senario_name=null;
	 	String user = Username;
		System.out.println("User shop : "+ user);
		String pass = Password;
		System.out.println("Password shop : " +pass);
		
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
		 int row_Count= excel_reader.getRowCount(Data_Sheet_Name);
		 for (int j=1;j<row_Count;j++)
	 		 			  {
		 		 	String scenariostatus =excel_reader.getCellData( Data_Sheet_Name, "Scenario_ID", j);
		 		 	if (scenariostatus.equalsIgnoreCase(senario_name))
		 		 	{ 
		 		 		System.out.println("text 2 "+senario_name);
	 		 		
	

		 		 		/*first name */
		 		 		FirstName=excel_reader.getCellData( Data_Sheet_Name, "First Name", j);
	 		 		    
						System.out.println("First name "+FirstName);
						firstname.clear();
						firstname.sendKeys(FirstName);
		
						/*last name*/
						 	LastName=excel_reader.getCellData( Data_Sheet_Name, "Last Name", j);
		 		 		    System.out.println(LastName);
							 		 		    
							lastname.clear();
							lastname.sendKeys(LastName);
		
							/*company name*/
								CompanyName=excel_reader.getCellData( Data_Sheet_Name, "Company Name", j);
			 		 		    System.out.println(CompanyName);
								companyname.clear();
								companyname.sendKeys(CompanyName);
	
								/*email address*/
								 	Email=excel_reader.getCellData( Data_Sheet_Name, "EmaiL Address", j);
				 		 		    System.out.println(Email);
				 		 		    
									email.clear();
									email.sendKeys(Email);
									
									/*email address*/
									 Phone=excel_reader.getCellData( Data_Sheet_Name, "Phone", j);
					 		 		    System.out.println(Phone);
											phonenumber.clear();
											phonenumber.sendKeys(Phone);
		
											jse.executeScript("arguments[0].scrollIntoView(true)", Adrress);
											Country=excel_reader.getCellData( Data_Sheet_Name, "Country", j);
						 		 		    System.out.println(Country);
						 		 		    /*Address*/
							 		 		  Address=excel_reader.getCellData( Data_Sheet_Name, "Last Name", j);
							 		 		    System.out.println(Address);									
										    	Adrress.clear();
												Adrress.sendKeys(Address);
		
												jse.executeScript("arguments[0].scrollIntoView(true)", city);
		
												/*City*/
												TownCity=excel_reader.getCellData( Data_Sheet_Name, "TownCity", j);
							 		 		    System.out.println(TownCity);										
												city.clear();
												city.sendKeys(TownCity);

												/*state dropdown*/
												 StateCountry=excel_reader.getCellData( Data_Sheet_Name, "StateCountry", j);
								 		 		    System.out.println(StateCountry);
								 		 		    statebox.click();
													Thread.sleep(2000);
													statepass.clear();
													statepass.sendKeys(StateCountry);
													Thread.sleep(2000);
												
												    List <WebElement> dynamicstateList = driver.findElements(By.xpath("//div[@class='select2-drop select2-display-none select2-with-searchbox select2-drop-active']//ul"));
												    
												    int Sizelist = dynamicstateList.size();
												    System.out.println("List of states size " +Sizelist);
													  for( int sizelist = 0 ; sizelist <= Sizelist-1 ; sizelist++) 
													  {
														  WebElement statewbel = dynamicstateList.get(sizelist);
														  
														  String typestate = statewbel.getText();
														  System.out.println("States list : "+typestate);
														  if(typestate.contains(StateCountry))
														  {
															  
															  //action.sendKeys(statewbel, Keys.ENTER).build().perform();
															  statewbel.click();
															  break;
														  }
														  
													  }
													  /*end of state dropdown*/
													  Thread.sleep(2000);
													  /*City*/
													  PostcodeZIP=excel_reader.getCellData( Data_Sheet_Name, "PostcodeZIP", j);
									 		 		    System.out.println(PostcodeZIP);
														pincode.clear();
														pincode.sendKeys(PostcodeZIP); 
														
														/*end of pin code*/
	
														 PaymentMode = excel_reader.getCellData(Data_Sheet_Name, "Payment_Mode", j);
														driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
														System.out.println("payment list size" +paymentlist.size());
														for(int k=0 ; k<paymentlist.size();k++)
														{
															String paymentmode =  paymentlist.get(k).getText();
															System.out.println("Pament modes"+paymentmode);
															if(paymentmode.equalsIgnoreCase(PaymentMode))
															{
																String fullpayment_xpath = payment_before_xpath+(k+1)+payment_after_xpath;
																//driver.findElement(By.xpath(fullpayment_xpath)).click();
																action.moveToElement(driver.findElement(By.xpath(fullpayment_xpath))).click().build().perform();
																break;
																
															}
														}

													driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
													action.sendKeys(placeorderbutton, Keys.ENTER).build().perform();
													Thread.sleep(2000l);
													 String Orderid = Order_id_wl.getText();
												excel_reader.setCellData( Data_Sheet_Name, "Order ID",j+1 ,Orderid);;
												
												 Order_Place_text_Str = Order_place_msg_wl.getText();
												 System.out.println(Order_Place_text_Str); 		
                                         

                 }
		 		 			 
             }
		   
		 return Order_Place_text_Str;
	}
	 		 			  
	public MainPge logout() throws InterruptedException
	{
		Actions action = new Actions(driver);
		WebDriverWait wait = new WebDriverWait(driver,8);
		try {
			 Thread.sleep(3000);
		//	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			action.sendKeys(myacc, Keys.ENTER).click().build().perform();
		 //   myacc.click();
		} catch (Exception e) {
			
			e.printStackTrace();
			System.out.println(" Something went wrong");
		}
		try {
			 Thread.sleep(3000);
		//	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			logout.click();
		} catch (Exception e) {
			
			e.printStackTrace();
			System.out.println(" Something went wrong");
		}
		
		
			
		return null;

	}
	
}

