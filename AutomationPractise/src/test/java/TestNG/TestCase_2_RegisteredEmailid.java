package TestNG;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestCase_2_RegisteredEmailid {

	public WebDriver driver;
	@BeforeMethod
	public void Setup() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("http://practice.automationtesting.in/");
		System.out.println(driver.getTitle());
		System.out.println(driver.getCurrentUrl());
	}

	@Test

	public void RegisteredEmail() throws InterruptedException {

		// Click on My Account Menu
		driver.findElement(By.xpath("//a[contains(text(),'My Account')]")).click();

		// Enter valid Email Address in Email-Address textbox

		driver.findElement(By.cssSelector("#reg_email")).sendKeys("ashu84@yopmail.com");

		// Enter password in password textbox

		driver.findElement(By.xpath("//form[@class='register']/p[2]/input")).sendKeys("ashu4@yopmail.com");
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
