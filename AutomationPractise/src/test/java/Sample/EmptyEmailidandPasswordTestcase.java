package Sample;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class EmptyEmailidandPasswordTestcase {

	public static void main(String[] args) throws InterruptedException {

		String genericPath = System.getProperty("user.dir");
		System.out.println(genericPath);

		// Open the browser
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		//Open the URL
		
		driver.get("http://practice.automationtesting.in/");
		System.out.println(driver.getTitle());
		System.out.println(driver.getCurrentUrl());

		//Click on My Account Menu
		
		driver.findElement(By.xpath("//a[contains(text(),'My Account')]")).click();
		
		//Leave Email Address and Password as empty in textboxes
		
		//Click on Register button
		driver.findElement(By.cssSelector("input[value='Register']")).click();
		
		//Registration must fail with a warning message
		
		String Actual = driver.findElement(By.xpath("//div[@id='body']//li[1]")).getText();
		String Expected = " Please provide a valid email address.";
		if (Actual.contains(Expected)) {
			System.out.println("Testcase is passed");

		} else {
			System.out.println("Testcase is failed");
		}
		
		
		//Close browser
		driver.close();
	}

}
