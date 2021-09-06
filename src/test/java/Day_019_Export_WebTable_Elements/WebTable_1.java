package Day_019_Export_WebTable_Elements;

import CommonUtil.*;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebTable_1
{
	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException, IOException
	{
		
		File file = new File("C://HTML Report//OrangeHRM15//Gold List.xlsx");
		XSSFWorkbook wb = new XSSFWorkbook();
		XSSFSheet sh = wb.createSheet("Gold");

		System.setProperty("webdriver.chrome.driver","C:\\chromedriver_win32\\chromedriver.exe");
		driver =new ChromeDriver();
		driver.manage().window().maximize() ;	
		driver.get("https://www.livechennai.com/gold_silverrate.asp");
		Thread.sleep(1000);

		
		WebElement table =	 driver.findElement(By.xpath("(//table[@class='table-price'])[2]"));
		List<WebElement> totalRows = table.findElements(By.tagName("tr"));
		for(int row=0; row<totalRows.size(); row++)
		{
			XSSFRow rowValue = sh.createRow(row);
			List<WebElement> totalColumns = totalRows.get(row).findElements(By.tagName("td"));
			for(int col=0; col<totalColumns.size(); col++)
			{
				String cellValue = totalColumns.get(col).getText();
				System.out.print(cellValue + "\t");
				rowValue.createCell(col).setCellValue(cellValue);
			}
			System.out.println();
		}
		FileOutputStream fos = new FileOutputStream(file);
		wb.write(fos);
		wb.close();
	}
	
}