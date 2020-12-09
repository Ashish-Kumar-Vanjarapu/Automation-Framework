package Refactor;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestCase_6_EmptyEmailidandPassword {

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

	public void EmptyEmailidandPassword() {

		// Click on My Account Menu

		driver.findElement(By.xpath("//a[contains(text(),'My Account')]")).click();

		// Leave Email Address and Password as empty in textboxes

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

	// Close browser
	public void TearDown() {
		driver.close();

	}

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		TestCase_6_EmptyEmailidandPassword f = new TestCase_6_EmptyEmailidandPassword();
		f.BrowserLaunch();
		f.WebsiteURLLaunch();
		f.EmptyEmailidandPassword();
		f.TearDown();
		
	}

}
