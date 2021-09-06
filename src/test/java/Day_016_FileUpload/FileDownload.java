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
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileDownload {
	
	static WebDriver driver;
	
	//public String DestinationFile;
	
	
  @Test
  public void DownloadFile() throws Exception {

  
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
          
          
          
       
       
       WebElement Element=findElement(By.xpath("//*[@id='tblAttachments']/tbody/tr/td[2]"));
          String frame = Element.getText();
          findElement(By.linkText(frame)).click();
          
          String SrcFile="C:\\Users\\Annnn\\Downloads\\"+frame;
		 	 String DestinationFile="C:\\HTML Report\\"+frame;
          
    	  Thread.sleep(1000);
    	  moveFile(SrcFile,DestinationFile);
    	
    	  
    	 
   
      }
    	  
    	  public static void moveFile(String Src,String Des) throws Exception{
    		  
    		Path result = null;
    		
    		try {
    			result =  Files.move(Paths.get(Src), Paths.get(Des));
 	           
 	           
 	           Thread.sleep(5000);
 	           
 	        } catch (IOException e) {
 	           System.out.println("Exception while moving file: " + e.getMessage());
 	        }
 	        if(result != null) {
 	           System.out.println("File moved successfully.");
 	        }else{
 	           System.out.println("File movement failed.");
 	        }  
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
