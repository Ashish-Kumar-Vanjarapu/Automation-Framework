package Refactor;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;


import io.github.bonigarcia.wdm.WebDriverManager;

public class TestCase_2_RegisteredEmailid {

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

	// Close browser
	public void TearDown() {
		driver.close();
	}

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		TestCase_2_RegisteredEmailid b = new TestCase_2_RegisteredEmailid();
		b.BrowserLaunch();
		b.WebsiteURLLaunch();
		b.RegisteredEmail();
		b.TearDown();
	}

}
