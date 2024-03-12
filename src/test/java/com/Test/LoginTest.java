package com.Test;

import org.testng.annotations.Test;
import org.testng.annotations.Test;

import com.Base.BaseTestClass;
import com.Pages.LoginPage;
import com.Properties.TestDataLoader;

public class LoginTest extends BaseTestClass{

	@Test
	public void loginWithValidUsernameAndValidPassword() {
		
		LoginPage loginPage = new LoginPage();
		
		loginPage.loginToApplication(TestDataLoader.getInstance().getUsername(), 
				TestDataLoader.getInstance().getPassword());
		
	}
}
