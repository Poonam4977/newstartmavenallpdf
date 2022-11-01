package utility;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class ScreenShot {
	public static void tkScreenShot(WebDriver driver,String name) throws IOException
	{
		String d=ScreenShot.date();
		File source=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File dest=new File("C:\\Users\\admin\\eclipse-workspace\\Allpdfs\\ScreenShot\\"+name+d+".jpeg");
		FileHandler.copy(source, dest);
		
	}
	
	public static String date()
	{
		DateTimeFormatter dtf=DateTimeFormatter.ofPattern("YYYY-MM-dd-HH-mm-SS");
		LocalDateTime cur=LocalDateTime.now();
		String d=dtf.format(cur);
		return d;
	}

}
