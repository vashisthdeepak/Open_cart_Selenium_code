package pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class Login_Page {
    
	//Username textbox
	@FindBy(xpath="//form//input[@name='username']")
	WebElement username;
	
	//Password textbox
	@FindBy(xpath="//form//input[@name='password']")
	WebElement password;
	
	//Login button
	@FindBy(xpath="//form//a[text()='Login']")
	WebElement submit;
	
	@FindBy(xpath=".//*[@id='content']/div[2]/div[1]/h1")
	WebElement Actual;
	
	@FindBy(xpath=".//*[@id='content']/div[2]/div[1]/h1")
	WebElement Expected;
	
		
	//To set username and password and login to application
	public void login(String uname, String pword) {
        
		username.sendKeys(uname);
		password.sendKeys(pword);
		submit.click();
		Assert.assertEquals(Actual, Expected, "Failure");
		
	}
	
}
