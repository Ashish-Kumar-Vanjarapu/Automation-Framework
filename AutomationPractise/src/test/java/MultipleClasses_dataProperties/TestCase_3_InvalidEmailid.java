package MultipleClasses_dataProperties;

import org.testng.annotations.Test;
import resources.Registerpage;

public class TestCase_3_InvalidEmailid extends Testbase {

	@Test
	public void InvalidEmail() throws InterruptedException {

		Registerpage r = new Registerpage(driver);
		r.getmyaccount().click();
		r.getemail().sendKeys(prop.getProperty("EmailAddress"));
		r.getpassword().sendKeys(prop.getProperty("Password"));
		Thread.sleep(5000);
		r.getregistercard().click();
		r.getregister().click();

		System.out.println("InvalidEmail Testcase is passed");

	}
}

