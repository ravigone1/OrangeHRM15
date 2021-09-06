package ABC_Demo0;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Open_Browser_amazon_2 {
	
	WebDriver driver;
  @Test
  public void logintest01() {
	  
	  System.setProperty("webdriver.chrome.driver","C:\\chromedriver_win32\\chromedriver.exe");
		driver =new ChromeDriver();
		driver.manage().window().maximize() ;	
		driver.get("https://amazon.in/");
		
	
	  
	  
  }
}
