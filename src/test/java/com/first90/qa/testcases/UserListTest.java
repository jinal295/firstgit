package com.first90.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.first90.qa.base.TestBase;
import com.first90.qa.pages.CreateClientPage;
import com.first90.qa.pages.CreateUserPage;
import com.first90.qa.pages.EnterUserDetailsPage;
import com.first90.qa.pages.SignInPage;
import com.first90.qa.pages.UserListPage;

public class UserListTest extends TestBase
{
	UserListPage List;
	CreateUserPage Create;
	EnterUserDetailsPage Data;
	SignInPage SignIn;
	CreateClientPage Client;

public UserListTest()
{
		super();
}
@BeforeMethod
public void setUp() throws InterruptedException
{
	 initialization();
	 List =new UserListPage();
	 Data =new EnterUserDetailsPage();
	 Create =new CreateUserPage();  // declare at class level	 
	 SignIn =new SignInPage();
	 Client= SignIn.Login(prop.getProperty("Email"), prop.getProperty("Password"));
	 Data=	Create.clickOnUserlink();
}

@Test(priority=1)
public void searchUserTest() throws InterruptedException
{
 Thread.sleep(10000);
 List.SearchUser("Jinal");
}
@AfterMethod
public void tearDown()
{
	 driver.quit();
}
}
