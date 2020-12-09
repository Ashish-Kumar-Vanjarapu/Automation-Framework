package TestNG.Locators.dataproperties;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestCase_3_InvalidEmailid {
	public WebDriver driver;
	public Properties prop;

	@BeforeMethod
	public void Setup() throws IOException {
		prop = new Properties();
		String genericPath = System.getProperty("user.dir");
		System.out.println(genericPath);
		FileInputStream file = new FileInputStream(genericPath + "\\src\\main\\java\\resources\\data1.properties");
		prop.load(file);

		if (prop.getProperty("browser").contains("Chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();

		}

		else if (prop.getProperty("browser").equals("Firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get(prop.getProperty("websiteurl"));
		System.out.println(driver.getTitle());
		System.out.println(driver.getCurrentUrl());
	}

	@Test
	public void InvalidEmail() throws InterruptedException {

		// Click on My Account Menu

		driver.findElement(By.xpath(prop.getProperty("ClickMyAccount"))).click();

		// Enter invalid Email Address in Email-Address textbox

		driver.findElement(By.cssSelector(prop.getProperty("Emailbox"))).sendKeys(prop.getProperty("InvalidEmaiAddress"));

		// Enter password in password textbox

		driver.findElement(By.xpath(prop.getProperty("Passwordbox"))).sendKeys(prop.getProperty("Password"));
		Thread.sleep(5000);

		// Click on Register button

		driver.findElement(By.xpath(prop.getProperty("RegisterCardClick"))).click();
		driver.findElement(By.cssSelector(prop.getProperty("Registerbutton"))).click();
		System.out.println("InvalidEmail Testcase is passed");


	}

	@AfterMethod
	public void TearDown() {
		driver.close();
	}

}