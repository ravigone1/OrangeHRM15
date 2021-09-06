package Day_007_DataProvider_LAB_3;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import CommonUtil.TestBrowser;
import ExcelUtil.ExcelApiTest4;
public class Excel_Qualifications2 {
	
	static WebDriver driver;
	
	
	@DataProvider(name = "Qualifications")
	public static Object[][] Authentication1() throws Exception 
	
	{
		
		ExcelApiTest4 eat = new ExcelApiTest4();
		Object[][] testObjArray = eat.getTableArray("C:\\HTML Report\\OrangeHRM15\\TC01_Qualifications_12.xlsx", "Sheet3");
		System.out.println(testObjArray.length);
		return (testObjArray);
			
	}
	
	 
  @Test (dataProvider = "Qualifications")    //Step2
 public void qualification_test(String Browser,String Test_URL, String UserName1,String Password1,String Qualification_text) throws Exception//Step3
 
  
  {
	 
	  
	  if(Browser.equalsIgnoreCase("Chrome"))
		{
		driver=TestBrowser.OpenChromeBrowser();
		
		}
		
		if(Browser.equalsIgnoreCase("FireFox"))
		{
		driver=TestBrowser.FirefoxBrowser();
		Thread.sleep(4000);
		}
		
		Excel_Qualifications2 T1 = new Excel_Qualifications2();
		T1.login(Test_URL,UserName1,Password1);
		T1.Qualifications(Qualification_text);
		T1.closeBrowser();
	  
	  
  }
	  
	  
	  
	  public  void login(String Test_URL1,String UserName1,String Password1 ) throws Exception
	  {
		  
		  driver.get(Test_URL1);
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

