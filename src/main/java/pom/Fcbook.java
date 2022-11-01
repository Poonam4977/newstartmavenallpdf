package pom;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;



public class Fcbook {
	@FindBy(xpath = "//input[@id='email']") private WebElement email;
	@FindBy(xpath="//input[@id='pass']") private WebElement pass;
	@FindBy(xpath="//button[@type='submit']") private WebElement login;
	@FindBy(xpath="//a[text()='Forgotten password?']") private WebElement forgotpass;
public Fcbook(WebDriver driver)
{
	PageFactory.initElements(driver, this);

}
public void enterEmail(String eid)
{
	email.sendKeys(eid);
}
public void enterPass(String passw)
{
	pass.sendKeys(passw);
}
public void clickLogin(WebDriver driver) throws InterruptedException
{
	WebDriverWait wait=new WebDriverWait(driver,Duration.ofMillis(2000));
	wait.until(ExpectedConditions.visibilityOf(login));
	login.click();
	Thread.sleep(3000);
	
}
public void expectedTitle(WebDriver driver,String s3)
{
	WebDriverWait wait1=new WebDriverWait(driver,Duration.ofMillis(2000));
	wait1.until(ExpectedConditions.titleContains(s3));
	String s1=driver.getTitle();
	//Assert.assertEquals(s1,s3);
	SoftAssert as=new SoftAssert();
	as.assertEquals(s1, s3);
	}
public void forgotpas(WebDriver driver)
{
	FluentWait<WebDriver>wait=new FluentWait <WebDriver>(driver);
	wait.withTimeout(Duration.ofMillis(3000));
	wait.pollingEvery(Duration.ofMillis(200));
	wait.ignoring(Exception.class);
	wait.until(ExpectedConditions.visibilityOf(forgotpass));
	forgotpass.click();
}

}
