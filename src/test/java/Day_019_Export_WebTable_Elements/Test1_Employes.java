package Day_019_Export_WebTable_Elements;

import CommonUtil.*;

import ExcelUtil.ExcelApiTest4;
import java.awt.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import java.util.*;
public class Test1_Employes {
	
	static WebDriver driver;
	
  @Test
  public void Employes_List() throws Exception {
	  
	  Test1_Employes T1 = new Test1_Employes();
	  
	  T1.Browser();
	  T1.Login();
	  T1.Employes();
	  
	 
	  
  }
  
  public void Browser() throws Exception {
	  
	driver = TestBrowser.OpenChromeBrowser(); 
	driver.get("https://opensource-demo.orangehrmlive.com/");
	  
	  
  }
  
  
  
  public void Login() throws Exception {
	  
	  findElement(By.id("txtUsername")).sendKeys("Admin");
	  findElement(By.id("txtPassword")).sendKeys("admin123");
	  findElement(By.id("btnLogin")).click();	  
	  
  }
  
  
  
  public void Employes() throws Exception {
	  
	  Actions actions = new Actions(driver);
		 WebElement ele=findElement(By.id("menu_pim_viewPimModule"));
      actions.moveToElement(ele).click().perform();
	  
	
	  driver.findElement(By.id("menu_pim_viewEmployeeList")).click();
	  
	  
	  String EmployeColmns = "//*[@id=\"resultTable\"]/thead/tr/th[]";
	  List<WebElement> Coloumns =   driver.findElement(By.xpath(EmployeColmns));
	 
	  
	  
	  String EmployeRows = "//*[@id='resultTable']/tbody/tr/td[2]";
	  List<WebElement> Rows = driver.findElement(By.xpath(EmployeRows));
	 
	  
	  
	  ExcelApiTest4 T2 = new ExcelApiTest4();
	  
	  for(int i = 1; i<=Rows.size(); i++)
	  
	     {
		   for(int j = 2, k=0; j<= Coloumns.size(); j++,k++)
		   
		   {
			   String str = "//*[@id='resultTable']/tbody/tr["  + i +  "]"  + "/td" + "[" + j +"]";
		   
		   
		   
		   WebElement Ele = findElement(By.xpath(str));
		   
		   String WebElementText = Ele.getText();
		   
		   
		   if(WebElementText != null)
		   T2.PutCellData("\"C://HTML Report//OrangeHRM15//Employes List1.xlsx","Sheet1",i,k,WebElementText);
		   else
		   T2.PutCellData("\"C://HTML Report//OrangeHRM15//Employes List1.xlsx","Sheet1",i,k,"BlankData");
		   
		   }
		   
		   
	     }  
			   
 }		   
			   
		 		   
	 
		// Draws a red border around the found element. Does not set it back anyhow.
			public WebElement findElement(By by)throws Exception {
			    WebElement elem = driver.findElement(by);
			 
			    // draw a border around the found element
			    if (driver instanceof JavascriptExecutor) {
			        ((JavascriptExecutor)driver).executeScript("arguments[0].style.border='3px solid red'", elem);
			    } 
			    Thread.sleep(10);
			    
			    return elem;
			}
	 
	  
  }
  
  
  
  
  
  
  
  
  
  
  

