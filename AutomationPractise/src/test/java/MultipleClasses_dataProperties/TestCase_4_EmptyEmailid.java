package MultipleClasses_dataProperties;

import org.testng.annotations.Test;

import resources.Registerpage;

public class TestCase_4_EmptyEmailid extends Testbase{
	
	@Test
	public void EmptyEmailid() throws InterruptedException {
		
		Registerpage r = new Registerpage(driver);
		r.getmyaccount().click();
		r.getpassword().sendKeys(prop.getProperty("Password"));
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
