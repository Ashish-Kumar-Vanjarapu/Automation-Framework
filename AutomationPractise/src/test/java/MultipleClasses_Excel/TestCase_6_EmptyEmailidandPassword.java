package MultipleClasses_Excel;

import org.testng.annotations.Test;
import resources.Registerpage;

public class TestCase_6_EmptyEmailidandPassword extends Testbase {

	@Test

	public void EmptyEmailidandPassword() {

		Registerpage r = new Registerpage(driver);
		r.getmyaccount().click();
		r.getregister().click();

		String Actual = r.getwarningmessage1().getText();
		String Expected = " Please provide a valid email address.";
		if (Actual.contains(Expected)) {
			System.out.println("EmptyEmailidandPassword Testcase is passed");

		} else {
			System.out.println("EmptyEmailidandPassword Testcase is failed");
		}
	}
}
