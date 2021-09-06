package Day_005_DataProvider_LAB_1;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderSkills_NonStatic {
	
	static WebDriver driver;
	
	//Global variables  step1
	//String UserName="Admin",Password="admin123";
	//String Skills="Java";
	//String Test_URL="https://opensource-demo.orangehrmlive.com/";
	
	
	@DataProvider(name = "Student5") //Step1
	  public static Object[][] Test1() throws Exception {
	 
	        return new Object[][] { 
	        	{ "https://opensource-demo.orangehrmlive.com/","Admin", "admin123","java" },
	        	{ "https://opensource-demo.orangehrmlive.com/","Admin", "admin123","c" },
	        	{ "https://opensource-demo.orangehrmlive.com/","Admin", "admin123","python" }
	        	};
	  }

  @Test(dataProvider ="Student5")
 public void Static_Paramaters_test(String Test_URL,String UserName,String Password,String Skills) throws Exception
  {
	  
	  DataProviderSkills_NonStatic T1 = new DataProviderSkills_NonStatic();
	  T1.OpenChromeBroswer();
	  T1.OpenorangeHRM(Test_URL);
	  T1.login(UserName,Password);//step2
	  T1.Skills(Skills);//step2
	  T1.closeBrowser();
	  
  }
	  
	  
	  public  void OpenChromeBroswer() throws Exception
	  {
		  System.setProperty("webdriver.chrome.driver","C:\\chromedriver_win32\\chromedriver.exe");
			driver =new ChromeDriver();
			driver.manage().window().maximize() ;  
	  }
	  
	  
	  public  void OpenorangeHRM(String Test_URL1) throws Exception
	  {
		  driver.get(Test_URL1);  
	  }
	  
	  
	  public  void login(String UserName1,String Password1 ) throws Exception
	  {
		  findElement(By.id("txtUsername")).sendKeys(UserName1);//step3
			findElement(By.id("txtPassword")).sendKeys(Password1);
			findElement(By.id("btnLogin")).click();	  
	  }
	  
	  
	  public  void Skills (String Skills1 ) throws Exception
	  {
		  findElement(By.id("menu_admin_viewAdminModule")).click();
			findElement(By.id("menu_admin_Qualifications")).click();
			findElement(By.id("menu_admin_viewSkills")).click();			
			findElement(By.id("btnAdd")).click();
			findElement(By.id("skill_name")).sendKeys(Skills1);
			findElement(By.id("btnSave")).click();  
	  }
	  
	  
	  public  void closeBrowser() throws Exception
	  {
		driver.quit();  
	  }
	  	
	  public static WebElement findElement(By by) throws Exception 
		{

			WebElement elem = driver.findElement(by);  
			
			if (driver instanceof JavascriptExecutor) 
			{
			 ((JavascriptExecutor)driver).executeScript("arguments[0].style.border='3px solid red'", elem);
		 
			}
			return elem;
		}
		
		
  }

