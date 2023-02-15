package com.first90.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.first90.qa.base.TestBase;
import com.first90.qa.pages.CreateClientPage;
import com.first90.qa.pages.CreateUserPage;
import com.first90.qa.pages.EnterUserDetailsPage;
import com.first90.qa.pages.SignInPage;
public class CreateUserTest extends TestBase
{
CreateUserPage Create;
CreateClientPage Client;
SignInPage SignIn;
EnterUserDetailsPage Data;


public CreateUserTest()
{
	super();
}
@BeforeMethod
public void setUp() throws InterruptedException
{
	 initialization();
	 Create =new CreateUserPage(); 
	 Data =new EnterUserDetailsPage();  // declare at class level	 
	 SignIn =new SignInPage();
	 Client= SignIn.Login(prop.getProperty("Email"), prop.getProperty("Password"));
}
@Test(priority=1)
public void verifyuserlinkTest() throws InterruptedException
{   
	Create.clickOnUserlink();
	Thread.sleep(10000);
	Create.clickOnCreateLink();
	Thread.sleep(10000);
}

@AfterMethod
public void tearDown()
{
	 driver.quit();
}
}
