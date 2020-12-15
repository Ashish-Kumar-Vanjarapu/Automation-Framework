package MultipleClasses_Excel;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Testbase  {
	public WebDriver driver;

	@BeforeMethod
	public void Setup() throws IOException {
		String genericPath = System.getProperty("user.dir");
		ExcelUtility er = new ExcelUtility(genericPath + "\\Utilities\\Excel.xlsx", "Sheet1");
		
		String browser = er.getCellDataString(1, 0);

		if (browser.contains("Chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();

		}

		else if (browser.equals("Firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		String URL = er.getCellDataString(1, 1);
		
		driver.get(URL);
		System.out.println(driver.getTitle());
		System.out.println(driver.getCurrentUrl());
	}


	@AfterMethod
	public void TearDown() {
		driver.close();
	}

}
