package test;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import pojo.BrowserOp;
import pom.Fcbook;
import utility.Excel;
import utility.ScreenShot;

public class FcbookLoginTest {
	WebDriver driver;
	
	@BeforeMethod
	public void launchBrowser()
	{
		 driver=BrowserOp.opening("https://www.facebook.com/");
	}
	
	@Test(priority=1)
	public void loginTest() throws InterruptedException, EncryptedDocumentException, IOException
	{
		Fcbook fc=new Fcbook(driver);
		String eid=Excel.getData("data", 0, 1);
		String pa=Excel.getData("data", 1, 1);
		fc.enterEmail(eid);
		fc.enterPass(pa);
		//fc.enterEmail("poonamjagdale95@gmail.com");
		//fc.enterPass("manngeet");
		fc.clickLogin(driver);
		fc.expectedTitle(driver,"Facebook" );
		
	}
	@Test(priority=2)
	public void loginForgotPassTest() throws InterruptedException
	{
		Fcbook fc=new Fcbook(driver);
		Thread.sleep(3000);
		fc.enterEmail("poonamjagdale95@gmail.com");
		fc.enterPass("   ");
		fc.forgotpas(driver);
		
	}
	@AfterMethod
	
	public void scrnShot() throws IOException
	{
		ScreenShot.tkScreenShot(driver,"twentyseventhoctober");
	}
	
	@Test 
	@Parameters({"i","j"})
	public void add(int a,int b)
	{
		System.out.println(a+b);
	}
	@Test
	public void trial()
	{
		System.out.println("did the change");
	}

}
