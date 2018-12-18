package pages;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;

import pages.Login_Page;
import pages.ConfigReader;
import pages.ExcelReader;

public class baseclass 
{
	public static WebDriver driver;
	
	@BeforeSuite
	public void validtest()
	{		
		ConfigReader read=new ConfigReader();
		
	  //  System.setProperty("webdriver.gecho.driver" , "C:\\Users\\Mohit\\Desktop\\Selenium\\geckodriver.exe");
	  driver =new FirefoxDriver();
	  
//	  System.setProperty("webdriver.chrome.driver" , read.getChrome());
//	  driver = new ChromeDriver();
//	  driver = new HtmlUnitDriver();
	  driver.get(read.ApplicationUrl());
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  Login_Page obj=PageFactory.initElements(driver, Login_Page.class);
      obj.login("admin", "passwd");
}
	 
	 
	/*@AfterMethod()
	public void teardown(ITestResult result) throws IOException
	{
		if(ITestResult.FAILURE==result.getStatus())
		{
		TakeScreenShoot.TakeScreenshot(result.getName().toString().trim());
		}	
	}
	

    @AfterMethod
	//To take screenshot on fail of test methods
	public void TestOnFail(ITestResult result) throws IOException {
		  	if(ITestResult.FAILURE==result.getStatus()) {
		  		String methodName = result.getName().toString().trim();
		  		TakeScreenshot(methodName);
		  		webelement_Category obj=PageFactory.initElements(driver, webelement_Category.class);
		  		obj.Take_Screen_Shot_Data_Tab();
		  		TakeScreenshot(methodName +"Data");
		  		obj.Take_Screen_Shot_Design_Tab();
		  		TakeScreenshot(methodName +"Design");
		  		System.out.println(methodName + ":Screenshot taken");
		  		//obj.Errors();
		  	}
}*/
	
	@AfterSuite()
	public void browserclose()
	{
		driver.close();
		
	}
	
	//login credintials
	@DataProvider(name="logincredintials")
	public Object[][] loginvalues()
	{
		ExcelReader load = new ExcelReader();
		int rowdetails=load.getrowcount(0);		
		Object[][] data =new Object[rowdetails][2];
		for(int i=0;i<rowdetails;i++)
		{			
			data[i][0]=	load.getsheetnumber(0, i, 0);
			data[i][1]=	load.getsheetnumber(0, i, 1);
		}
		return data;
			
	}
	
}
