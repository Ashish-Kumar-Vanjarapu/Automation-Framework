package resources;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Registerpage {
	public WebDriver driver;

	public By Myaccount = By.xpath("//a[contains(text(),'My Account')]");
	public By Email = By.cssSelector("#reg_email");
	public By Password = By.xpath("//form[@class='register']/p[2]/input");
	public By Registercard=By.xpath("//div[@id='content']");
	public By Register = By.cssSelector("input[value='Register']");
	public By Dashboardmessage=By.xpath("//div[@class='woocommerce-MyAccount-content']/p[2]");
	public By Warningmessage=By.xpath("//ul[@class='woocommerce-error']/li");
	public By Warningmessage1=By.xpath("//div[@id='body']//li[1]");

	
	public Registerpage(WebDriver driver) {
		// TODO Auto-generated constructor stub

		this.driver = driver;

	}

	public WebElement getmyaccount() {
		return driver.findElement(Myaccount);
	}

	public WebElement getemail() {
		return driver.findElement(Email);
	}

	public WebElement getpassword() {

		return driver.findElement(Password);
	}

	public WebElement getregistercard() {
		return driver.findElement(Registercard);
	}
	public WebElement getregister() {
		return driver.findElement(Register);
	}
	
	public WebElement getdashboardmessage() {
		return driver.findElement(Dashboardmessage);
	
	}
	public WebElement getwarningmessage() {
		return driver.findElement(Warningmessage);
	
	}
	public WebElement getwarningmessage1() {
		return driver.findElement(Warningmessage1);
	}
}
