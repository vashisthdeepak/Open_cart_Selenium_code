package pages;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ConfigReader 
{
	Properties pro;
	public ConfigReader()
	{
		try 
		{   File src=new File("/home/baba/eclipse-workspace/POC/Configuration/Config.property");
			FileInputStream fis = new FileInputStream(src);
			pro = new Properties();
			pro.load(fis);
	    } 
	    catch (Exception e) 
		
	    {
		   e.printStackTrace();
		 } 
	}
	
	 public String getChrome()
    {
	   String path=pro.getProperty("ChromeDriver");
	   return path;
	}

    public String ApplicationUrl()
	      {
	    	  return pro.getProperty("URL");	  
	      }
	      
	      public String getexcelsheet()
	      {
	    	  return pro.getProperty("ExcelPath");
	      }
}
