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

public class Existing_ID_Fileupload2 {
	
	static WebDriver driver;
	
	
	
	
  @Test
  public void Pic_Upload() throws Exception {
	  
	  
	  
	 // OpenBrowser();
	 // Login();
	 // EmployeDetails();
	 // Photoupload();
  }
	  
      
      public void OpenBrowser() throws Exception{
      
    	  driver=TestBrowser.OpenChromeBrowser();
          driver.get("https://opensource-demo.orangehrmlive.com/");  
      }
      
      public void Login() throws Exception{
    	  
    	  findElement(By.id("txtUsername")).sendKeys("Admin");
    	  findElement(By.id("txtPassword")).sendKeys("admin123");
    	  findElement(By.id("btnLogin")).click();
    	  
      
    	  
      }
      
      
      public void EmployeDetails() throws Exception{
      
    	  findElement(By.linkText("PIM")).click();
    	  findElement(By.linkText("Employee List")).click();
    	  findElement(By.id("empsearch_id")).sendKeys("0247");
    	  findElement(By.id("searchBtn")).click(); 
    	  
    	  Thread.sleep(1000);
    	  findElement(By.linkText("0247")).click();
    	  
    	  Thread.sleep(1000);
    	  
    	  
    	  //Scrolling//
    	 WebElement Element1 = findElement(By.id("btnAddAttachment"));
    	  
    	  JavascriptExecutor js = (JavascriptExecutor)driver;		    	         	  
          js.executeScript("arguments[0].scrollIntoView();", Element1);
          
          
          
          findElement(By.id("btnAddAttachment")).click();
          
    	  
          String str1="C:\\HTML Report\\EMP_Photos\\bsnl.txt";
		  Photoupload(str1);
    	  
    	
    	  
    	  WebElement FileUpload = findElement(By.xpath("//*[@id=\'ufile\']"));
			
			Actions actions = new Actions(driver);
			
			actions.moveToElement(FileUpload).click().build().perform();    	  
    	  
    	  Thread.sleep(1000);
   
      }
    	  
    	  public void Photoupload(String Path) throws Exception{
    		  
    		  
        	  StringSelection sel = new StringSelection(Path);
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
    			
              findElement(By.xpath("//*[@id=\'btnSaveAttachment\']")).click();
    			
    			

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
