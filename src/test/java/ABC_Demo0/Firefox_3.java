package ABC_Demo0;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.GeckoDriverInfo;
import org.testng.annotations.Test;

public class Firefox_3 {
	
	static WebDriver driver;
	
  @Test
  public void Browser() throws Exception{
	  
	  System.setProperty("webdriver.gecko.driver","C:\\FireFoxDriver\\geckodriver.exe");
	  driver = new FirefoxDriver();
	  driver.manage().window().maximize();
	 
	  
	  
	  
	  
  }
}
