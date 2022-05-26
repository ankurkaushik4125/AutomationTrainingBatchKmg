package Utility;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;



import Base.Testbase;

public class Util extends Testbase {

	public static void CaptureScreenshot(WebDriver driver, String Screenshotpath) throws IOException{
		
	
	DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MMddyyyyHHmmss");
	LocalDateTime now = LocalDateTime.now();
	String time_now = (dtf.format(now));
	File source = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	FileHandler.copy(source,new File(Screenshotpath+File.separator+"_"+time_now+".png"));
}


		
	}


