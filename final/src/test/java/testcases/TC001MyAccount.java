package testcases;

import java.io.IOException;

import org.testng.annotations.Test;

import base.BaseClass;
import pages.Home;

public class TC001MyAccount extends BaseClass {
	
	@Test
	public void VerifyLogin() throws IOException {
		//driver=Initialize();
		Home h1 = new Home(driver);
		h1.doAccountClick();
		h1.doClickRegister();
	}

}
