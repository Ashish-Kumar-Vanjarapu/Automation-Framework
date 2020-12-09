package Sample;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;


import io.github.bonigarcia.wdm.WebDriverManager;

public class ValidEmailidandPasswordTestcase {

	public static void main(String[] args) throws InterruptedException {


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
		
		// Enter valid Email Address in Email-Address textbox
		
		driver.findElement(By.cssSelector("#reg_email")).sendKeys("ashu9@yopmail.com");
		
		// Enter password in password textbox
		
		driver.findElement(By.xpath("//form[@class='register']/p[2]/input")).sendKeys("ashu4@yopmail.com");
		Thread.sleep(5000);
		
		
		// Click on Register button
		
		driver.findElement(By.xpath("//div[@id='content']")).click();
		driver.findElement(By.cssSelector("input[value='Register']")).click();
	
		//User will be registered successfully and will be navigated to the Home page message
		
				String Actual = driver.findElement(By.xpath("//div[@class='woocommerce-MyAccount-content']/p[2]")).getText();
				String Expected = "edit your password and account details";
				if (Actual.contains(Expected)) {
					System.out.println("Testcase is passed");

				} else {
					System.out.println("Testcase is failed");
				}
				
				//Close browser
				driver.close();

}
}




//driver.findElement(By.xpath("//form[@class='register']/p[2]/input")).sendKeys(Keys.ENTER);
