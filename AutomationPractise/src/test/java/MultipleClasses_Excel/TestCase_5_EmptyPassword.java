package MultipleClasses_Excel;

import org.testng.annotations.Test;
import resources.Registerpage;

public class TestCase_5_EmptyPassword extends Testbase {

	@Test
	public void EmptyPassword() {
		String genericPath = System.getProperty("user.dir");
		System.out.println(genericPath);
		ExcelUtility er = new ExcelUtility(genericPath+"\\Utilities\\Excel.xlsx", "Sheet2");

		Registerpage r = new Registerpage(driver);
		r.getmyaccount().click();
		String username = er.getCellDataString(5, 0);
		r.getemail().sendKeys(username);
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