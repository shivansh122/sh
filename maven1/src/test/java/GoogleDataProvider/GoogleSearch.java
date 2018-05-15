package GoogleDataProvider;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class GoogleSearch 
{
	
	FirefoxDriver driver;
	
	@BeforeClass
	public void open()
	{
		System.setProperty("webdriver.gecko.driver", "d:\\geckodriver.exe");
		driver=new FirefoxDriver();

		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("http://www.google.com");
	}
	
	@DataProvider(name="dp1")
	public String[] testdata()
	{
		return new String[] {"java","selenium","QTp"};
	}

	@Test(dataProvider="dp1")
	public void search(String sear) throws Exception
	{
		
		driver.findElement(By.id("lst-ib")).sendKeys(sear);
		driver.findElement(By.name("btnK")).click();
		Thread.sleep(5000);
		driver.navigate().back();
	}
	@AfterClass
	public void close()
	{
		driver.quit();
	}
}
