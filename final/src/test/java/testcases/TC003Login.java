package testcases;


import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseClass;
import pages.Home;
import pages.Login;

public class TC003Login extends BaseClass {
	
	@Test(priority=1)
	public void verifyLogin1() {
		Home h2 = new Home(driver);
		Login l1 = new Login(driver);
		h2.doAccountClick();
		h2.doClickLogin();
		l1.Username();
		l1.doLogin();
		String Expectedmsg="Warning: No match for E-Mail Address and/or Password.";
	
		Assert.assertEquals(Expectedmsg, l1.Alert());
		
	}
	
	@Test(priority=2)
	public void verifyLogin2() {
		Home h2 = new Home(driver);
		Login l1 = new Login(driver);
		h2.doAccountClick();
		h2.doClickLogin();
		l1.Username();
		l1.doLogin();
		String Expectedmsg="Warning: No match for E-Mail Address and/or Password.";
		Assert.assertEquals(Expectedmsg, l1.Alert());
	}
	
	
	@Test(priority=3)
	public void verifyLogin() {
		Home h2 = new Home(driver);
		Login l1 = new Login(driver);
		h2.doAccountClick();
		h2.doClickLogin();
		l1.Username();
		l1.Password();
		l1.doLogin();
		
		
	}

}
