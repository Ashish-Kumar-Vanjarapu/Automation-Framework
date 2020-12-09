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

public class TestCase_5_EmptyPassword {
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

	public void EmptyPassword() {

		// Click on My Account Menu

		driver.findElement(By.xpath(prop.getProperty("ClickMyAccount"))).click();

		// Enter valid Email Address in Email-Address textbox

		driver.findElement(By.cssSelector(prop.getProperty("Emailbox"))).sendKeys(prop.getProperty("EmailAddress1"));

		// Leave Password as empty in Password textbox

		// Click on Register button

		driver.findElement(By.cssSelector(prop.getProperty("Registerbutton1"))).click();

		// Registration must fail with a warning message

		String Actual = driver.findElement(By.xpath(prop.getProperty("Warningmessage1"))).getText();
		System.out.println(driver.findElement(By.xpath(prop.getProperty("Warningmessage1"))).getText());
		String Expected = " Please enter an account password.";
		if (Actual.contains(Expected)) {
			System.out.println("EmptyPassword Testcase is passed");

		} else {
			System.out.println("EmptyPassword Testcase is failed");
		}
	}

	@AfterMethod
	public void TearDown() {
		driver.close();

	}

}