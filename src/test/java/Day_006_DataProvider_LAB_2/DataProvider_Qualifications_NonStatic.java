package Day_006_DataProvider_LAB_2;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProvider_Qualifications_NonStatic {
	
	static WebDriver driver;
	
	//Global variables  step1
	//String UserName="Admin",Password="admin123";
	//String Qualification_text="student";
	//String Test_URL="https://opensource-demo.orangehrmlive.com/";
	
	@DataProvider(name="Student1")
	 public Object[] myDataProvider() throws Exception {
	      
	     Object data[][]=  new Object[2][4];
	     // First student details
	     data[0][0]= "https://opensource-demo.orangehrmlive.com/"; 
	     data[0][1]= "Admin";
	     data[0][2]= "admin123";
	     data[0][3]= "10th";
	     
	      
	     // Second student details
	     data[1][0]= "https://opensource-demo.orangehrmlive.com/";
	     data[1][1]= "Admin";
	     data[1][2]= "admin123";
	     data[1][3]= "Inter";
	     
	     
	   
	     return data;
	      
	      
	 }
	 
	 
  @Test(dataProvider ="Student1") //Step2
 public void Static_Paramaters_test(String TestURL, String UserName,String Password,String Qualification_text) throws Exception//Step3
  {
	  DataProvider_Qualifications_NonStatic T1= new DataProvider_Qualifications_NonStatic();
	                                               
	                                                    //Non Static Method//
	  T1.OpenChromeBroswer(TestURL);
	  T1.login(UserName,Password);
	  T1.Qualifications(Qualification_text);
	  T1.closeBrowser();
	  
     }
	  
	  
	  public  void OpenChromeBroswer(String TestURL) throws Exception
	  {
		  System.setProperty("webdriver.chrome.driver","C:\\chromedriver_win32\\chromedriver.exe");
			driver =new ChromeDriver();
			driver.manage().window().maximize() ;
			driver.get(TestURL);
	  }
	  
	  
	  
	  public  void login(String UserName1,String Password1 ) throws Exception
	  {
		  findElement(By.id("txtUsername")).sendKeys(UserName1);//step3
			findElement(By.id("txtPassword")).sendKeys(Password1);
			findElement(By.id("btnLogin")).click();	  
	  }
	  
	  
	  public  void Qualifications (String Qualification_text1 ) throws Exception
	  {
		  findElement(By.id("menu_admin_viewAdminModule")).click();
			findElement(By.id("menu_admin_Qualifications")).click();
			findElement(By.id("menu_admin_viewEducation")).click();
			findElement(By.id("btnAdd")).click();
			findElement(By.id("education_name")).sendKeys(Qualification_text1);
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

