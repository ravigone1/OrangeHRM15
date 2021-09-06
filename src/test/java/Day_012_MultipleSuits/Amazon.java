package Day_012_MultipleSuits;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import CommonUtil.TestBrowser;

public class Amazon {
	
	WebDriver driver;
	
  @Test
  public void Browser() throws Exception {
	  
	    driver = TestBrowser.OpenChromeBrowser();
	  
	    driver.get("https://www.amazon.in/");
	  
	 
  }
}
