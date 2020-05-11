package com.myntra.generic;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BaseClass {
	 public static WebDriver driver;
		
		public static void openBrowser(String browser) throws InterruptedException  {
		   System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
		   System.setProperty("webdriver.gecko.driver", "F:\\selenium\\geckodriver-v0.26.0-win32\\geckodriver.exe");
	
			if (browser.equals("chrome")) {
				driver = new ChromeDriver();

			} else if (browser.equals("firefox")) {
				driver = new FirefoxDriver();
			}
		    driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//	driver.get("https://www.myntra.com/login/password?referer=https%3A%2F%2Fwww.myntra.com%2F&mobile=&show=true");
			driver.get("https://www.myntra.com/");
			
			//profile
//			WebElement ele = driver.findElement(By.className("desktop-user"));
//			Actions act = new Actions(driver);
//			act.moveToElement(ele).perform();
//			
//			//login
//			driver.findElement(By.className("desktop-linkButton")).click();
//			long i = System.currentTimeMillis()/1000;
////			System.out.println(num);
//			String a=String.valueOf(i);
//			System.out.println(a);
//			
//			driver.findElement(By.xpath("//input[@class='form-control mobileNumberInput']")).sendKeys(a);
//			driver.findElement(By.xpath("//div[@class='submitBottomOption']")).click();
//			driver.findElement(By.xpath("//div[contains(text(),'Log in using')]")).click();
//			
//			driver.findElement(By.id("mobileNumberPass")).clear();
//			driver.findElement(By.id("mobileNumberPass")).sendKeys("prashanthdonthurala56@gmail.com");
//			driver.findElement(By.xpath("//input[@type=\"password\"]")).sendKeys("Myntra@1234");
//			driver.findElement(By.xpath("//button[text()='LOGIN']")).click();
//			
//			//to handle prompt window		
			driver.manage().deleteAllCookies();
		}
		 
		public static void closeBrowser() {
			driver.quit();
		}
		
		public String getExcelData(String path, String sheetname, int row, int cell) throws EncryptedDocumentException, IOException
		{
			FileInputStream fis = new FileInputStream(path);
			Workbook w = WorkbookFactory.create(fis);
			String data = w.getSheet(sheetname).getRow(row).getCell(cell).getStringCellValue();
			return data;
		}
		
		public static String getExcelData1(String path, String sheetname, int row, int cell)
				throws EncryptedDocumentException, IOException {
			FileInputStream fis = new FileInputStream(path);
			Workbook wb = WorkbookFactory.create(fis);
			long i =  (long) wb.getSheet(sheetname).getRow(row).getCell(cell).getNumericCellValue();
			String s = String.valueOf(i);
			return s;
		}
}
