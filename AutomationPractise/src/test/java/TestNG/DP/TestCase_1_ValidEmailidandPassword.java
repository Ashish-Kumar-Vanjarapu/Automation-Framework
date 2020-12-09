package TestNG.DP;

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

public class TestCase_1_ValidEmailidandPassword {
	public WebDriver driver;
	public Properties prop;

	@BeforeMethod
	public void Setup() throws IOException {
		prop = new Properties();
		String genericPath = System.getProperty("user.dir");
		System.out.println(genericPath);
		FileInputStream file = new FileInputStream(genericPath + "\\src\\main\\java\\resources\\data.properties");
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
	
	public void ValidEmailandPassword() throws InterruptedException {

		// Click on My Account Menu

		driver.findElement(By.xpath("//a[contains(text(),'My Account')]")).click();

		// Enter valid Email Address in Email-Address textbox

		driver.findElement(By.cssSelector("#reg_email")).sendKeys(prop.getProperty("EmailAddress"));

		// Enter password in password textbox

		driver.findElement(By.xpath("//form[@class='register']/p[2]/input")).sendKeys(prop.getProperty("Password"));
		Thread.sleep(5000);
		
		// Click on Register button

		driver.findElement(By.xpath("//div[@id='content']")).click();
		driver.findElement(By.cssSelector("input[value='Register']")).click();

		// User will be registered successfully and will be navigated to the Home page
		// message

		String Actual = driver.findElement(By.xpath("//div[@class='woocommerce-MyAccount-content']/p[2]")).getText();
		String Expected = "edit your password and account details";
		if (Actual.contains(Expected)) {
			System.out.println("ValidEmailandPassword Testcase is passed");

		} else {
			System.out.println("ValidEmailandPassword Testcase is failed");
		}
	}

	@AfterMethod
	public void TearDown() {
		driver.close();
	}


}

//driver.findElement(By.xpath("//form[@class='register']/p[2]/input")).sendKeys(Keys.ENTER);
