package  Day_023_TestNG_Groups;
import CommonUtil.*;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.By;
import org.testng.annotations.*;
public class AllTests
{
	
	
	@Test(groups = { "checkintest" })
	public void OrangeHRM() throws Exception {
		
		WebDriver driver;
		
		
		driver = TestBrowser.OpenChromeBrowser();
		
		
		driver.get("https://opensource-demo.orangehrmlive.com/");
		
		driver.findElement(By.name("txtUsername")).sendKeys("Admin");
		driver.findElement(By.name("txtPassword")).sendKeys("admin123");
		
		driver.close();
	}
	
	
	@Test(groups = { "functest" })
	public void Mercury() throws Exception {
		
		WebDriver driver;
		
		
		driver = TestBrowser.OpenChromeBrowser();
		
		
		driver.get("http://newtours.demoaut.com/");

		
		driver.findElement(By.xpath(OR.MLPage_UserNameTextbox)).sendKeys("mercury");
		driver.findElement(By.xpath(OR.MLPage_PasswordTextbox)).sendKeys("mercury");
		
				
		driver.close();
	}
	
	
	
	
	@Test(groups = { "functest","GoogleGroup" })
	public void Google() throws Exception {
		
		WebDriver driver;
		
		
		driver = TestBrowser.OpenChromeBrowser();
		
		
		driver.get("https://www.google.co.in/?gws_rd=ssl");

		
	
		
				
		driver.close();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}                                                  












