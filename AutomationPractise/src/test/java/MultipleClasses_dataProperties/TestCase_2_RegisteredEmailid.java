package MultipleClasses_dataProperties;

import org.testng.annotations.Test;
import resources.Registerpage;

public class TestCase_2_RegisteredEmailid extends Testbase {
	@Test
	public void RegisteredEmail() throws InterruptedException {

		Registerpage r = new Registerpage(driver);
		r.getmyaccount().click();
		r.getemail().sendKeys(prop.getProperty("EmailAddress"));
		r.getpassword().sendKeys(prop.getProperty("Password"));
		Thread.sleep(5000);
		r.getregistercard().click();
		r.getregister().click();

		String Actual = r.getwarningmessage().getText();
		String Expected = " An account is already registered with your email address. Please login.";
		if (Actual.contains(Expected)) {
			System.out.println("RegisteredEmail Testcase is passed");

		} else {
			System.out.println("RegisteredEmail Testcase is failed");
		}
	}
}
