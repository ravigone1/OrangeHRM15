package Day_009_ExtentReports;

import CommonUtil.*;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Extent_Nationality {
	
	static WebDriver driver;
	
	ExtentTest logger;
	ExtentReports extent;
	String screenShotPath;
	
	public static String TestScriptName = "Test1_Nationality";
	public static String TestName;
	
  @Test
  public void Extent_ReportTest() throws Exception {
	  
	  System.setProperty("webdriver.chrome.driver","C:\\chromedriver_win32\\chromedriver.exe");
		driver =new ChromeDriver();
		driver.manage().window().maximize() ;
	  
	  
		// step3 start here - ExtendsHtmlReport starts
		 SimpleDateFormat sdfDate = new SimpleDateFormat("yyyy_MMM_dd_h_mm_ss_SSS_a");
		 Date now = new Date();
		 String strDate = sdfDate.format(now);
				 
		 TestName=TestScriptName+"_"+strDate+".html";
		 TestScriptName=TestScriptName+"_"+strDate;
		 String TestHtmlName="C:/HTML Report/test-output/ExtentReportScreenShots/"+ TestScriptName +"/"+TestName;
				  
		//String TestHtmlName=TestName;
		 ExtentHtmlReporter reporter=new ExtentHtmlReporter(TestHtmlName);
				 
		 System.out.println("Html Report path is : "+TestHtmlName);
				 
		 extent=new ExtentReports();
		 extent.attachReporter(reporter);
		 logger=extent.createTest(TestName);
				//step3 ends here ExtendsHtmlReport ends
				 
				 
		 String TestURL = "https://opensource-demo.orangehrmlive.com/";
			 driver.get(TestURL); 
				 
			driver.findElement(By.id("txtUsername")).sendKeys("Admin");
			screenShotPath = ExtentReport.capture(driver,TestScriptName);
			logger.pass("Login Page- Enter Username",MediaEntityBuilder.createScreenCaptureFromPath(screenShotPath).build());
			
			driver.findElement(By.id("txtPassword")).sendKeys("admin123");
			screenShotPath = ExtentReport.capture(driver,TestScriptName);
			logger.pass("Login Page- Enter Password",MediaEntityBuilder.createScreenCaptureFromPath(screenShotPath).build());
			
			
			driver.findElement(By.id("btnLogin")).click();
			screenShotPath = ExtentReport.capture(driver,TestScriptName);
			logger.pass("Login Page- Clicked on Loggin",MediaEntityBuilder.createScreenCaptureFromPath(screenShotPath).build());
			
			
			
			driver.findElement(By.linkText("Admin")).click();
			screenShotPath = ExtentReport.capture(driver,TestScriptName);
			logger.pass("Admin Page- Clicked on Admin",MediaEntityBuilder.createScreenCaptureFromPath(screenShotPath).build());
			
			
			driver.findElement(By.id("menu_admin_nationality")).click();
			screenShotPath = ExtentReport.capture(driver,TestScriptName);
			logger.pass("Admin Page- Clicked on Nationality",MediaEntityBuilder.createScreenCaptureFromPath(screenShotPath).build());
			
			
			driver.findElement(By.id("btnAdd")).click();
			screenShotPath = ExtentReport.capture(driver,TestScriptName);
			logger.pass("Admin Page- Clicked on Addbtn",MediaEntityBuilder.createScreenCaptureFromPath(screenShotPath).build());
			
			
			
			driver.findElement(By.id("nationality_name")).sendKeys("American");
			screenShotPath = ExtentReport.capture(driver,TestScriptName);
			logger.pass("Admin Page- Add nationality",MediaEntityBuilder.createScreenCaptureFromPath(screenShotPath).build());
			
			
			
			extent.flush();
			
			
			driver.close();
			
	}
	
	
	// Draws a red border around the found element. Does not set it back anyhow.
	public  WebElement findElement(By by) throws Exception 
	{
				
		 WebElement elem = driver.findElement(by);    	    
		// draw a border around the found element
		 
		if (driver instanceof JavascriptExecutor) 
		{
		 ((JavascriptExecutor)driver).executeScript("arguments[0].style.border='3px solid red'", elem);
	 
		}
		
		return elem;
	}
			
		
	  
  }

