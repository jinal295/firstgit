package com.first90.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.first90.qa.base.TestBase;
import com.first90.qa.pages.CreateClientPage;
import com.first90.qa.pages.SignInPage;

public class SignInPageTest extends TestBase
{  
	SignInPage SignIn;   //so we can user throughoutclass
	CreateClientPage createclient;
	public SignInPageTest()
	{
		super();
	}
 @BeforeMethod
 public void setUp() throws InterruptedException
 {
	 initialization();
	 SignIn =new SignInPage();  // declare at class level	 
}
@Test(priority =1)
public void SignInTest() throws InterruptedException
{
	createclient = SignIn.Login(prop.getProperty("Email"), prop.getProperty("Password"));
	Thread.sleep(1000);
}
 
 @AfterMethod
 public void tearDown()
 {
	 driver.quit();
 }
}
