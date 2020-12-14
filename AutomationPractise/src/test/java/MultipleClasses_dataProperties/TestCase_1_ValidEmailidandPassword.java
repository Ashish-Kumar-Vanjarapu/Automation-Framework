package MultipleClasses_dataProperties;

import org.testng.annotations.Test;
import resources.Registerpage;

public class TestCase_1_ValidEmailidandPassword extends Testbase {

	@Test

	public void ValidEmailandPassword() throws InterruptedException {

		Registerpage r = new Registerpage(driver);
		r.getmyaccount().click();
		r.getemail().sendKeys(prop.getProperty("EmailAddress"));
		r.getpassword().sendKeys(prop.getProperty("Password"));
		Thread.sleep(5000);
		r.getregistercard().click();
		r.getregister().click();
		String Actual = r.getdashboardmessage().getText();
		String Expected = "edit your password and account details";
		if (Actual.contains(Expected)) {
			System.out.println("ValidEmailandPassword Testcase is passed");

		} else {
			System.out.println("ValidEmailandPassword Testcase is failed");
		}
	}

}
