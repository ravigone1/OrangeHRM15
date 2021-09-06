package Day_010_TestNG_Parameters;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import CommonUtil.TestBrowser;
import ExcelUtil.ExcelApiTest4;

//import ExcelUtil.ExcelApiTest4;


public class Test1_Static_Paarameters {
	
	
	static WebDriver driver;
	
	
 
	@Parameters({"Browser","UserName","Password","Nationality"})
	@Test
	public void Login_Test(String Browser1,String UserName1,String Password1,String Nationality1  ) throws Exception{
		
	
	if(Browser1.equalsIgnoreCase("Chrome"))
	{
		System.setProperty("webdriver.chrome.driver","C:\\chromedriver_win32\\chromedriver.exe");
	 	driver =new ChromeDriver();
 	 	driver.manage().window().maximize() ;	
    }

	if(Browser1.equalsIgnoreCase("FireFox"))
	{
			driver = TestBrowser.OpenFirefoxBrowser();
			Thread.sleep(1000);
	}
		
		//Test1_Static_Paarameters.OpenChromeBrowser();
		Test1_Static_Paarameters.OpenOrangeHRM();
		Test1_Static_Paarameters.Login(UserName1,Password1);
		Test1_Static_Paarameters.AddNationalities(Nationality1);
	
	}
	
	public static  WebElement findElement(By by) throws Exception 
	{
				
		 WebElement elem = driver.findElement(by);    	    
		
		 
		if (driver instanceof JavascriptExecutor) 
		{
		 ((JavascriptExecutor)driver).executeScript("arguments[0].style.border='3px solid red'", elem);
	 
		}
		
		return elem;
	}
 
	
	
	
	//public static void OpenChromeBrowser() throws Exception
	//{
	//	System.setProperty("webdriver.chrome.driver","C:\\chromedriver_win32\\chromedriver.exe");
		//driver =new ChromeDriver();
		//driver.manage().window().maximize() ;	
	
//	}
	
	
	public static void OpenOrangeHRM() throws Exception
	{
		
		driver.get("https://opensource-demo.orangehrmlive.com/");
	}
	
	
	
	public static void Login(String UserName1,String Password1) throws Exception
	{
		
		findElement(By.name("txtUsername")).sendKeys(UserName1);
		findElement(By.name("txtPassword")).sendKeys(Password1);
		findElement(By.id("btnLogin")).click();
		
		
		
	}
	
	
	public static   void AddNationalities(String Nationality1) throws Exception
	{
		
		 
		findElement(By.linkText("Admin")).click();
		Thread.sleep(5000);
		findElement(By.linkText("Nationalities")).click();

		findElement(By.name("btnAdd")).click();
		findElement(By.id("nationality_name")).sendKeys(Nationality1);
		findElement(By.id("btnSave")).click();
		
		
		driver.quit();
	}
	
	
	
	
	
	

}
