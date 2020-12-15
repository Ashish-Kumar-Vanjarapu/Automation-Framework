package MultipleClasses_Excel;

import org.testng.annotations.Test;
import resources.Registerpage;

public class TestCase_1_ValidEmailidandPassword extends Testbase {

	@Test

	public void ValidEmailandPassword() throws InterruptedException, Exception {

		String genericPath = System.getProperty("user.dir");
		System.out.println(genericPath);
		ExcelUtility er = new ExcelUtility(genericPath + "\\Utilities\\Excel.xlsx", "Sheet2");

		System.out.println(er.getRowCount());
		System.out.println(er.getColCount());

		Registerpage r = new Registerpage(driver);
		r.getmyaccount().click();
		String username = er.getCellDataString(1, 0);
		r.getemail().sendKeys(username);
		String password = er.getCellDataString(1, 1);
		r.getpassword().sendKeys(password);
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
