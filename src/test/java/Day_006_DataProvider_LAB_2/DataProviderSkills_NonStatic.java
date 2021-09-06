package Day_006_DataProvider_LAB_2;

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
	//String Skull Desr="Java Desr";
	//String Test_URL="https://opensource-demo.orangehrmlive.com/";
	
	
	                                                                     //step1 copy the syntax //
		 @DataProvider(name="Student1")
		 public Object[] myDataProvider() throws Exception {
		      
		     Object data[][]=  new Object[2][5];
		     // First student details
		     data[0][0]= "https://opensource-demo.orangehrmlive.com/"; 
		     data[0][1]= "Admin";
		     data[0][2]= "admin123";
		     data[0][3]= "Java";
		     data[0][4]= "Java descr";
		      
		     // Second student details
		     data[1][0]= "https://opensource-demo.orangehrmlive.com/";
		     data[1][1]= "Admin";
		     data[1][2]= "admin123";
		     data[1][3]= "python";
		     data[1][4]= "python descr";
		     
		     
		     return data;
		      
		      
		 }

  @Test(dataProvider ="Student1")                               //step2 connecting the data provider//
 public void Static_Paramaters_test(String TestURL,String UserName,String Password,String Skill,String Skill_Desr) throws Exception    //step3 used to declare parameters in Method signature//
  {
	  
	  DataProviderSkills_NonStatic T1 = new DataProviderSkills_NonStatic();
	  
	  T1.OpenChromeBroswer(TestURL);	  
	  T1.login(UserName,Password);
	  T1.Add_Skills(Skill,Skill_Desr);
	  T1.closeBrowser();
	  
  }
	  
	  
	  public  void OpenChromeBroswer( ) throws Exception
	  {
		  System.setProperty("webdriver.chrome.driver","C:\\chromedriver_win32\\chromedriver.exe");
			driver =new ChromeDriver();
			driver.manage().window().maximize() ;
			
	  }
	  
	  
	  public  void OpenChromeBroswer(String TestURL ) throws Exception{
		 
		  driver.get(TestURL);
	  }
	  
	  
	  public  void login(String UserName1,String Password1 ) throws Exception
	  {
		  findElement(By.id("txtUsername")).sendKeys(UserName1);//step3
			findElement(By.id("txtPassword")).sendKeys(Password1);
			findElement(By.id("btnLogin")).click();	  
	  }
	  
	  
	  public  void Add_Skills (String Skill1, String Skill_Desr1 ) throws Exception
	  {
		  findElement(By.id("menu_admin_viewAdminModule")).click();
			findElement(By.id("menu_admin_Qualifications")).click();
			findElement(By.id("menu_admin_viewSkills")).click();			
			findElement(By.id("btnAdd")).click();
			findElement(By.id("skill_name")).sendKeys(Skill1);
			findElement(By.id("skill_description")).sendKeys(Skill_Desr1);
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

