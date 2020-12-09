package Refactor;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestCase_5_EmptyPassword {
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

	public void EmptyPassword() {

		// Click on My Account Menu

		driver.findElement(By.xpath("//a[contains(text(),'My Account')]")).click();

		// Enter valid Email Address in Email-Address textbox

		driver.findElement(By.cssSelector("#reg_email")).sendKeys("ashu3@yopmail.com");

		// Leave Password as empty in Password textbox

		// Click on Register button

		driver.findElement(By.cssSelector("input[value='Register']")).click();

		// Registration must fail with a warning message

		String Actual = driver.findElement(By.xpath("//div[@id='body']//li[1]")).getText();
		String Expected = " Please enter an account password.";
		if (Actual.contains(Expected)) {
			System.out.println("EmptyPassword Testcase is passed");

		} else {
			System.out.println("EmptyPassword Testcase is failed");
		}
	}

	// Close browser
	public void TearDown() {
		driver.close();

	}

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		TestCase_5_EmptyPassword e = new TestCase_5_EmptyPassword();
		e.BrowserLaunch();
		e.WebsiteURLLaunch();
		e.EmptyPassword();
		e.TearDown();

	}
}