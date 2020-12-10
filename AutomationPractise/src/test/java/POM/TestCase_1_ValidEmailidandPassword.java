package POM;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import resources.Registerpage;

public class TestCase_1_ValidEmailidandPassword {

	public WebDriver driver;
	public Properties prop;
@BeforeTest
	public void Setup() throws IOException {
		prop = new Properties();
		String genericPath = System.getProperty("user.dir");
		System.out.println(genericPath);
		FileInputStream file = new FileInputStream(genericPath + "\\src\\main\\java\\resources\\data2.properties");
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

		Registerpage r = new Registerpage(driver);
		r.getmyaccount().click();
		r.getemail().sendKeys(prop.getProperty("EmailAddress"));
		r.getpassword().sendKeys(prop.getProperty("Password"));
		Thread.sleep(5000);
		r.getregistercard().click();
		r.getregister().click();
		String Actual = r.getdashboardmessage().getText();
		String Expected = "edit your password and account details";
		if (Actual.contains(Expected)) {
			System.out.println("ValidEmailandPassword Testcase is passed");

		} else {
			System.out.println("ValidEmailandPassword Testcase is failed");
		}
	}

// Close browser
	@AfterTest
	public void TearDown() {
		driver.close();
	}
}

//driver.findElement(By.xpath("//form[@class='register']/p[2]/input")).sendKeys(Keys.ENTER);
