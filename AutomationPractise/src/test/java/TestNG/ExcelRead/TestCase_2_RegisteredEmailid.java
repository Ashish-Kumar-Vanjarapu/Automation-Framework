package TestNG.ExcelRead;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestCase_2_RegisteredEmailid {
	public WebDriver driver;
	XSSFWorkbook workbook;
	XSSFSheet sheet;
	XSSFCell cell;

	@BeforeMethod
	public void Setup() throws IOException {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("http://practice.automationtesting.in/");
		System.out.println(driver.getTitle());
		System.out.println(driver.getCurrentUrl());
	}

	@Test

	public void RegisteredEmail() throws InterruptedException, IOException {
		// Click on My Account Menu

		driver.findElement(By.xpath("//a[contains(text(),'My Account')]")).click();

		String genericPath = System.getProperty("user.dir");
		System.out.println(genericPath);

		File src = new File(genericPath + "\\Utilities\\Excel.xlsx");
		FileInputStream fis = new FileInputStream(src);
		workbook = new XSSFWorkbook(fis);
		sheet = workbook.getSheetAt(0);

		// total number of row
		int rowCount = sheet.getLastRowNum();
		System.out.println("Total no of rows are:" + rowCount);
		XSSFRow current_row = sheet.getRow(2);
		String username = current_row.getCell(0).getStringCellValue();
		System.out.println("Input Username is:" + username);
		driver.findElement(By.cssSelector("#reg_email")).sendKeys(username);
		String password = current_row.getCell(1).getStringCellValue();
		System.out.println("Input Password is:" + password);
		driver.findElement(By.xpath("//form[@class='register']/p[2]/input")).sendKeys(password);
		Thread.sleep(5000);

	
		// Click on Register button

		driver.findElement(By.xpath("//div[@id='content']")).click();
		driver.findElement(By.cssSelector("input[value='Register']")).click();

		//Registration must fail with a warning message

		String Actual = driver.findElement(By.xpath("//ul[@class='woocommerce-error']/li")).getText();
		String Expected = " An account is already registered with your email address. Please login.";
		if (Actual.contains(Expected)) {
			System.out.println("RegisteredEmail Testcase is passed");

		} else {
			System.out.println("RegisteredEmail Testcase is failed");
		}
	}

	@AfterMethod
	public void TearDown() {
		driver.close();
	}

}
