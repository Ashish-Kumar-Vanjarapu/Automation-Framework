package MultipleClasses_Excel;

import org.testng.annotations.Test;
import resources.Registerpage;

public class TestCase_3_InvalidEmailid extends Testbase {

	@Test
	public void InvalidEmail() throws InterruptedException {

		String genericPath = System.getProperty("user.dir");
		System.out.println(genericPath);
		ExcelUtility er = new ExcelUtility(genericPath+"\\Utilities\\Excel.xlsx", "Sheet2");

		Registerpage r = new Registerpage(driver);
		r.getmyaccount().click();
		String username = er.getCellDataString(3, 0);
		r.getemail().sendKeys(username);
		String password = er.getCellDataString(3, 1);
		r.getpassword().sendKeys(password);
		Thread.sleep(5000);
		r.getregistercard().click();
		r.getregister().click();

		System.out.println("InvalidEmail Testcase is passed");

	}
}

