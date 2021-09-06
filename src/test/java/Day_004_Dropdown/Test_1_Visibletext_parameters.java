package Day_004_Dropdown;

import java.awt.List;



import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class Test_1_Visibletext_parameters {
	
	static WebDriver driver;
	
	String UserName="Admin",Password="admin123";
	String Test_URL="https://opensource-demo.orangehrmlive.com/";
	String Name ="Ravinder";
	String State ="Telanga";
	String Country ="India";
  @Test
  public void Drop_down() throws Exception
  {
	  
	  Test_1_Visibletext_parameters T12 = new Test_1_Visibletext_parameters();
	  T12.OpenChromeBroswer();
	  T12.OpenorangeHRM(Test_URL);
	  T12.login(UserName,Password);
	  T12.Admin();
	  T12.Details(Name,State);
	  T12.Country(Country);
  }
	  public  void OpenChromeBroswer() throws Exception
	  {
		  System.setProperty("webdriver.chrome.driver","C:\\chromedriver_win32\\chromedriver.exe");
			driver =new ChromeDriver();
			driver.manage().window().maximize() ;  
	  }
	  
	  
	  public void OpenorangeHRM(String Test_URL1) throws Exception
	  {
		  
			driver.get(Test_URL1);  
	  }
	  
	  
	  public void login(String UserName1,String Password1) throws Exception
	  {
		  findElement(By.id("txtUsername")).sendKeys(UserName1);
			findElement(By.id("txtPassword")).sendKeys(Password1);
			findElement(By.id("btnLogin")).click(); 
	  }

  
		public void Admin()throws Exception{
			
			findElement(By.linkText("Admin")).click();
			findElement(By.linkText("Organization")).click();
			findElement(By.linkText("Locations")).click();
			
			
			driver.findElement(By.id("btnAdd")).click();
		}
		
		
		
		public void Details(String Name1,String State1 ) throws Exception
		{
			findElement(By.id("location_name")).sendKeys(Name1);
			findElement(By.id("location_province")).sendKeys(State1);
		}
		
		public void Country(String Country1)throws Exception
		{
			Select dropdown = new Select(driver.findElement(By.id("location_country")));
			
			dropdown.selectByVisibleText("India");
			
			//List<WebElement> elements= dropdown.getOptions();
			
			//for(WebElement  element :elements)
				
		//	System.out.println(element.getText());	
			
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
