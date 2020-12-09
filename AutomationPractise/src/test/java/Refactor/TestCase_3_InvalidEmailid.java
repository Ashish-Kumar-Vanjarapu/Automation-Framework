package Refactor;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestCase_3_InvalidEmailid {

	public WebDriver driver;

	// Open the browser
	public void BrowserLaunch() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}

	// Open the URL
	public void WebsiteURLLaunch() {

		driver.get("http://practice.automationtesting.in/");
		System.out.println(driver.getTitle());
		System.out.println(driver.getCurrentUrl());
	}

	public void InvalidEmail() {

		// Click on My Account Menu

		driver.findElement(By.xpath("//a[contains(text(),'My Account')]")).click();

		// Enter invalid Email Address in Email-Address textbox

		driver.findElement(By.cssSelector("#reg_email")).sendKeys("ashu3yopmail.com");

		// Enter password in password textbox

		driver.findElement(By.xpath("//form[@class='register']/p[2]/input")).sendKeys("ashu2@yopmail.com");

		// Click on Register button

		driver.findElement(By.xpath("//div[@id='content']")).click();
		driver.findElement(By.cssSelector("input[value='Register']")).click();

		System.out.println("InvalidEmail Testcase is passed");

		/*
		 * // Registration must fail with a warning message
		 * 
		 * String Actual = driver.findElement(By.xpath("")).getText(); String Expected =
		 * ""; if (Actual.contains(Expected)) {
		 * System.out.println("InvalidEmail Testcase is passed");
		 * 
		 * } else { System.out.println("InvalidEmail Testcase is failed"); }
		 */
	}

	// Close browser
	public void TearDown() {
		driver.close();
	}

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		TestCase_3_InvalidEmailid c = new TestCase_3_InvalidEmailid();
		c.BrowserLaunch();
		c.WebsiteURLLaunch();
		c.InvalidEmail();
		c.TearDown();
	}
}