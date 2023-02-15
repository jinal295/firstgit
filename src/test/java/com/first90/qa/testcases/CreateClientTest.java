package com.first90.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.first90.qa.base.TestBase;
import com.first90.qa.pages.CreateClientPage;
import com.first90.qa.pages.SignInPage;

public class CreateClientTest extends TestBase
{
CreateClientPage Client;
SignInPage SignIn;
public CreateClientTest()
{
	super();
}
@BeforeMethod
public void setUp() throws InterruptedException
{
	 initialization();
	 SignIn =new SignInPage();
	 Client= SignIn.Login(prop.getProperty("Email"), prop.getProperty("Password"));
	 Client =new CreateClientPage();  // declare at class level	 
}

@Test(priority=1)
public void ClientDetailsTest() throws Exception
{
	Client.EnterDetails("AutomationTest", "abcd","abd@g.com");
	Thread.sleep(10000);
}
@Test(priority=2)
public void listClient() throws Exception 
{
	Thread.sleep(10000);
	Client.SearchClient("AutomationTest");
}
@AfterMethod
public void tearDown()
{
	 driver.quit();
}
}