package tests;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import pages.Login_Page;

import pages.baseclass;
//import test.baseclass.BaseClass;

public class Login extends baseclass
{
    @Test(dataProvider="logincredintials")
	public void validtest(String uname ,String pwd)
	{
    	
    	Login_Page obj=PageFactory.initElements(driver, Login_Page.class);
		obj.login(uname, pwd);
	}
	
}
