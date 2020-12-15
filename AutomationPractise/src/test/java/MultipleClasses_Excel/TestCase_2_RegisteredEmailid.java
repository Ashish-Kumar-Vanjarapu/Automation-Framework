package MultipleClasses_Excel;

import org.testng.annotations.Test;
import resources.Registerpage;

public class TestCase_2_RegisteredEmailid extends Testbase {
	@Test
	public void RegisteredEmail() throws InterruptedException {
		
		String genericPath = System.getProperty("user.dir");
		System.out.println(genericPath);
		ExcelUtility er = new ExcelUtility(genericPath+"\\Utilities\\Excel.xlsx", "Sheet2");

		Registerpage r = new Registerpage(driver);
		r.getmyaccount().click();
		String username = er.getCellDataString(2, 0);
		r.getemail().sendKeys(username);
		String password = er.getCellDataString(2, 1);
		r.getpassword().sendKeys(password);
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
