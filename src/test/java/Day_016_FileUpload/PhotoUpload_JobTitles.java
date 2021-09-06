package Day_016_FileUpload;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import ExcelUtil.ExcelApiTest4;

import CommonUtil.*;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

public class PhotoUpload_JobTitles {
	
	static WebDriver driver;
	
	@DataProvider (name = "JobTitles")
    public static  Object[][] Authentication1() throws Exception{
		
		ExcelApiTest4 eat= new ExcelApiTest4();
        Object[][] testObjArray = eat.getTableArray("C://HTML Report//OrangeHRM6//Jobtitles.xlsx","Sheet1");
         System.out.println(testObjArray.length);
          return (testObjArray); 
	}
	
	
  @Test(dataProvider = "JobTitles")
  public void Pic_Upload(String UserName,String Password,String Title,String Description,String Path) throws Exception {
	  
	  
	  
	  OpenBrowser();
	  Login(UserName,Password);
	  JobDetails(Title,Description);
	  Photoupload(Path);
  }
	  
      
      public void OpenBrowser() throws Exception{
      
    	  driver=TestBrowser.OpenChromeBrowser();
          driver.get("https://opensource-demo.orangehrmlive.com/");  
      }
      
      public void Login(String UserName,String Password) throws Exception{
    	  
    	  findElement(By.id("txtUsername")).sendKeys(UserName);
    	  findElement(By.id("txtPassword")).sendKeys(Password);
    	  findElement(By.id("btnLogin")).click();
    	  
      
    	  
      }
      
      
      public void JobDetails(String JobTitle,String JobDesr) throws Exception{
      
    	  findElement(By.linkText("Admin")).click();
    	  findElement(By.id("menu_admin_Job")).click();
    	  findElement(By.id("menu_admin_viewJobTitleList")).click();
    	  findElement(By.id("btnAdd")).click();
    	  findElement(By.id("jobTitle_jobTitle")).sendKeys(JobTitle);
    	  findElement(By.id("jobTitle_jobDescription")).sendKeys(JobDesr);
    	  
    	
    	  
    	  WebElement Upload = findElement(By.xpath("//*[@id=\\'jobTitle_jobSpec\\']"));
			
			Actions actions = new Actions(driver);
			
			actions.moveToElement(Upload).click().build().perform();
    	  
    	  
    	  Thread.sleep(2000);
   
      }
    	  
    	  public void Photoupload(String PhotoPath) throws Exception{
    		  
    		  
        	  StringSelection sel = new StringSelection(PhotoPath);
     		 Toolkit.getDefaultToolkit().getSystemClipboard().setContents(sel,null);
     		 
     		 Thread.sleep(2000);
        	  
        	  
     		 Robot robot = new Robot();
     		 
     		 robot.keyPress(KeyEvent.VK_CONTROL);
    		 robot.keyPress(KeyEvent.VK_V);
        	  
    		 robot.keyRelease(KeyEvent.VK_CONTROL);
    		 robot.keyRelease(KeyEvent.VK_V);
    		 Thread.sleep(2000); 
    		 
    		 
    		 robot.keyPress(KeyEvent.VK_ENTER);
    		 robot.keyRelease(KeyEvent.VK_ENTER);
    		 
    		 
    		 Thread.sleep(1000);
    			
              findElement(By.id("btnSave")).click();
    			
    			

          }
    	  
    	  
    	
      
      public  WebElement findElement(By by)throws Exception {
  	    WebElement elem = driver.findElement(by);
  	 
  	    // draw a border around the found element
  	    if (driver instanceof JavascriptExecutor) {
  	        ((JavascriptExecutor)driver).executeScript("arguments[0].style.border='3px solid red'", elem);
  	    } 
  	    Thread.sleep(10);
  	    
  	    return elem;
  	}	
      
   
}
