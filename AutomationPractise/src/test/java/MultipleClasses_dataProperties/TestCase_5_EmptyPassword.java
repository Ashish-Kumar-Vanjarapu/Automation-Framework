package MultipleClasses_dataProperties;

import org.testng.annotations.Test;
import resources.Registerpage;

public class TestCase_5_EmptyPassword extends Testbase {

	@Test
	public void EmptyPassword() {
		Registerpage r = new Registerpage(driver);
		r.getmyaccount().click();
		r.getemail().sendKeys(prop.getProperty("EmailAddress"));
		r.getregister().click();

		String Actual = r.getwarningmessage1().getText();
		String Expected = " Please enter an account password.";
		if (Actual.contains(Expected)) {
			System.out.println("EmptyPassword Testcase is passed");

		} else {
			System.out.println("EmptyPassword Testcase is failed");
		}
	}


}