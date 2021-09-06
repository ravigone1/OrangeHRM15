package ABC_Demo0;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class Browser_Launch {
	
   WebDriver driver;
	
  @Test
  public void Chrome_Browser() {
	  
	  System.setProperty("webdriver.chrome.driver","C:\\chromedriver_win32\\chromedriver.exe");
		driver =new ChromeDriver();
		driver.manage().window().maximize() ;	
		driver.get("https://opensource-demo.orangehrmlive.com/");
		  
  }
  
  public void Firefox_Browser() {
	  
	  System.setProperty("webdriver.gecko.driver","C:\\FireFoxDriver\\geckodriver.exe");
		driver =new FirefoxDriver();
		driver.manage().window().maximize() ;	
		driver.get("https://opensource-demo.orangehrmlive.com/");
	    
  }
  
  public void Edge_browser() {
	  
	  System.setProperty("webdriver.edge.driver","C:\\EdgeDriver\\msedgedriver.exe");
		driver =new EdgeDriver();
		driver.manage().window().maximize() ;	
		driver.get("https://opensource-demo.orangehrmlive.com/");  

  
}
  
  
}




