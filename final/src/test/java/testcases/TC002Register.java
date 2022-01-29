package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseClass;
import pages.Register;

public class TC002Register extends BaseClass {
	
	@Test(priority=2)
	public void verifyRegister1() {
		Register r1 = new Register(driver);
		r1.Clear();
		r1.doRegister("username", "username", "xyz@gmail.com", "123456789", "password", "password");
		r1.doDisagree();
		String Expected="Warning: You must agree to the Privacy Policy!";
		//String Actual=r1.checkText();
		System.out.println(r1.checkText());
		Assert.assertEquals(Expected, r1.checkText());
	}

	
	@Test(priority=1)
	public void verifyRegister() {
		Register r1 = new Register(driver);
		r1.doRegister("username", "username", "xxx1@gmail.com", "123456789", "password", "password");
		r1.doSubmit();
		String expectedAlert = "Warning: E-Mail Address is already registered!";
		System.out.println(r1.checkText());
		Assert.assertEquals(expectedAlert, r1.checkText());
	}

}
