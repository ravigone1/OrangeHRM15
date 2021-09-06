package Day_003_Locators;

import CommonUtil.*;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.*;

import CommonUtil.TestBrowser;

public class TC04_xpath {
	
	
	static WebDriver driver;
	
	
	//*[@id='txtUsername']
	//*[@id='txtPassword']
	//*[@id='btnLogin']
	//*[@id='menu_admin_viewAdminModule']/b
	//*[@id='menu_admin_Organization']
	//*[@id='menu_admin_viewOrganizationGeneralInformation']
	
	public static String  UserName="//*[@id='txtUsername']";
	public static String  Password="//*[@id='txtPassword']";
	public static String  Loginbutton="//*[@id='btnLogin']";
	public static String  Admin="//*[@id='menu_admin_viewAdminModule']/b";
	public static String  Organization="//*[@id='menu_admin_Organization']";
	public static String  Generalinformation="//*[@id='menu_admin_viewOrganizationGeneralInformation']";

	 
  @Test
  public  void Test_xpath() throws Exception {
	  
		  driver = TestBrowser.OpenChromeBrowser();	  
	  

    	  String Test_URL="https://opensource-demo.orangehrmlive.com/";
  		driver.get(Test_URL);
	  

    	  findElement(By.xpath(UserName)).sendKeys("Admin");
  		findElement(By.xpath(Password)).sendKeys("admin123");
  		findElement(By.xpath(Loginbutton)).click();
      
    	  findElement(By.xpath(Admin)).click();
  		findElement(By.xpath(Organization)).click();
  		findElement(By.xpath(Generalinformation)).click();
      
  }
  
  public  WebElement findElement(By by) throws Exception 
  {

  	WebElement elem = driver.findElement(by);  
  	
  	if (driver instanceof JavascriptExecutor) 
  	{
  	 ((JavascriptExecutor)driver).executeScript("arguments[0].style.border='3px solid red'", elem);
   
  	}
  	return elem;
}
}
