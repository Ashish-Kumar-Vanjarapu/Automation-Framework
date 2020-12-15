package MultipleClasses_Excel;

import org.testng.annotations.Test;

import resources.Registerpage;

public class TestCase_4_EmptyEmailid extends Testbase{
	
	@Test
	public void EmptyEmailid() throws InterruptedException {
		String genericPath = System.getProperty("user.dir");
		System.out.println(genericPath);
		ExcelUtility er = new ExcelUtility(genericPath+"\\Utilities\\Excel.xlsx", "Sheet2");

		Registerpage r = new Registerpage(driver);
		r.getmyaccount().click();
		String password = er.getCellDataString(4, 1);
		r.getpassword().sendKeys(password);
		Thread.sleep(5000);
		r.getregistercard().click();
		r.getregister().click();

		String Actual = r.getwarningmessage1().getText();
		String Expected = " Please provide a valid email address.";
		if (Actual.contains(Expected)) {
			System.out.println("EmptyEmailid Testcase is passed");

		} else {
			System.out.println("EmptyEmailid Testcase is failed");
		}
	}
}
