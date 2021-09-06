package Day_005_DataProvider_LAB_1;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProvider_Qualifications_Static {
	
	static WebDriver driver;
	
	//Global variables  step1                          //Dataprovider works only for the programm with Parameters//
	//String UserName="Admin",Password="admin123";
	//String Qualification_text="student";
	//String Test_URL="https://opensource-demo.orangehrmlive.com/";
	
	@DataProvider(name = "Student") //Step1
	  public static Object[][] Test1() throws Exception {
	 
	        return new Object[][] { 
	        	{ "https://opensource-demo.orangehrmlive.com/","Admin", "admin123","10th" },
	        	{ "https://opensource-demo.orangehrmlive.com/","Admin", "admin123","Inter" },
	        	{ "https://opensource-demo.orangehrmlive.com/","Admin", "admin123","Degree" }
	        	};
	  }
	 
	 
  @Test(dataProvider ="Student") //Step2
 public void Static_Paramaters_test(String Test_URL, String UserName,String Password,String Qualification_text) throws Exception//Step3
  {
	  DataProvider_Qualifications_Static.OpenChromeBroswer();
	  DataProvider_Qualifications_Static.OpenorangeHRM(Test_URL);
	  DataProvider_Qualifications_Static.login(UserName,Password);
	  DataProvider_Qualifications_Static.Qualifications(Qualification_text);
	  DataProvider_Qualifications_Static.closeBrowser();
	  
  }
	  
	  
	  public static void OpenChromeBroswer() throws Exception
	  {
		  System.setProperty("webdriver.chrome.driver","C:\\chromedriver_win32\\chromedriver.exe");
			driver =new ChromeDriver();
			driver.manage().window().maximize() ;  
	  }
	  
	  
	  public static void OpenorangeHRM(String Test_URL1) throws Exception
	  {
		  driver.get(Test_URL1);  
	  }
	  
	  
	  public static void login(String UserName1,String Password1 ) throws Exception
	  {
		  findElement(By.id("txtUsername")).sendKeys(UserName1);//step3
			findElement(By.id("txtPassword")).sendKeys(Password1);
			findElement(By.id("btnLogin")).click();	  
	  }
	  
	  
	  public static void Qualifications (String Qualification_text1 ) throws Exception
	  {
		  findElement(By.id("menu_admin_viewAdminModule")).click();
			findElement(By.id("menu_admin_Qualifications")).click();
			findElement(By.id("menu_admin_viewEducation")).click();
			findElement(By.id("btnAdd")).click();
			findElement(By.id("education_name")).sendKeys(Qualification_text1);
			findElement(By.id("btnSave")).click();  
	  }
	  
	  
	  public static void closeBrowser() throws Exception
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

