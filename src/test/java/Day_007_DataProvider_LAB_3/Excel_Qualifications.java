package Day_007_DataProvider_LAB_3;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import ExcelUtil.ExcelApiTest4;

public class Excel_Qualifications {
	
	static WebDriver driver;
	
	//Global variables  step1                          //Dataprovider works only for the programm with Parameters//
	//String UserName="Admin",Password="admin123";
	//String Qualification_text="student";
	//String Test_URL="https://opensource-demo.orangehrmlive.com/";
	
	@DataProvider(name = "Qualifications")
	public static Object[][] Authentication1() throws Exception 
	
	{
		
		ExcelApiTest4 eat = new ExcelApiTest4();
		Object[][] testObjArray = eat.getTableArray("C:\\HTML Report\\OrangeHRM15\\TC01_Qualifications_11.xlsx", "Sheet2");
		System.out.println(testObjArray.length);
		return (testObjArray);
			
	}
	 
	 
  @Test(dataProvider ="Qualifications") //Step2
 public void qualification_test(String Test_URL, String UserName1,String Password1,String Qualification_text) throws Exception//Step3
 
  
  {
	  Excel_Qualifications.OpenChromeBroswer();
	  Excel_Qualifications.OpenorangeHRM(Test_URL);
	  Excel_Qualifications.login(UserName1,Password1);
	  Excel_Qualifications.Qualifications(Qualification_text);
	  Excel_Qualifications.closeBrowser();
	  
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

