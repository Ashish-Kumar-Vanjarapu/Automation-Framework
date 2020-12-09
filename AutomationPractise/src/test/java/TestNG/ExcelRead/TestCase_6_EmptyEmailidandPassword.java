package TestNG.ExcelRead;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestCase_6_EmptyEmailidandPassword {
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

	public void EmptyEmailidandPassword() throws IOException {
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
		
		// Click on Register button
		driver.findElement(By.cssSelector("input[value='Register']")).click();

		// Registration must fail with a warning message

		String Actual = driver.findElement(By.xpath("//div[@id='body']//li[1]")).getText();
		String Expected = " Please provide a valid email address.";
		if (Actual.contains(Expected)) {
			System.out.println("EmptyEmailidandPassword Testcase is passed");

		} else {
			System.out.println("EmptyEmailidandPassword Testcase is failed");
		}
	}

	@AfterMethod
	public void TearDown() {
		driver.close();

	}

}
