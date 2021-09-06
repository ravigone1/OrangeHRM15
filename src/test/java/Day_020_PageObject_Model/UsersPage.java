package Day_020_PageObject_Model;

import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class UsersPage {
	
	static WebDriver driver;
	
	public void  Users(WebDriver driver) {
		this.driver = driver;
	}
  @Test
  public void AddUsers() throws Exception{
	  
	  FileInputStream file =new FileInputStream("C:\\HTML Report\\OrangeHRM15\\UserList.xlsx");		
		XSSFWorkbook wb =new XSSFWorkbook(file);
		XSSFSheet sheet = wb.getSheet("Sheet1");
		
		int rowcount = sheet.getLastRowNum();
		 for(int i =1; i<= rowcount; i++);
		 {
			 
			XSSFRow row = sheet.getRow(rowcount);
			
		  
		String EmployeName = row.getCell(0).getStringCellValue();		
		String UserName = row.getCell(1).getStringCellValue();
		String Password = row.getCell(2).getStringCellValue();
		String ConfirmPassword = row.getCell(3).getStringCellValue();
		
	  
	  
	  
	  findElement(By.id("menu_admin_viewAdminModule")).click();
	  
	  WebElement UserManagement = findElement(By.id("menu_admin_UserManagement"));
	  WebElement Users =findElement(By.id("menu_admin_viewSystemUsers"));
	  
	  Actions actions = new Actions(driver);
	  actions.moveToElement(UserManagement).
	  moveToElement(Users).click().build().perform();
	  
	  findElement(By.id("btnAdd")).click();
	  
	  Select dropdown = new Select(findElement(By.id("systemUser_userType")));
	  dropdown.selectByValue("1");
	  
	  findElement(By.id("systemUser_employeeName_empName")).sendKeys(EmployeName);
	  findElement(By.id("systemUser_userName")).sendKeys(UserName);
	  
	  Select dropdown1 = new Select(findElement(By.id("systemUser_status")));
	  dropdown1.selectByVisibleText("Enabled");
	  
	  
	  findElement(By.id("systemUser_password")).sendKeys(Password);
	  findElement(By.id("systemUser_confirmPassword")).sendKeys(ConfirmPassword);
	  findElement(By.id("btnSave")).click();
	  
	  
  
		 }  
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
