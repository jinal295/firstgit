package com.first90.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.first90.qa.base.TestBase;
import com.first90.qa.pages.CreateClientPage;
import com.first90.qa.pages.CreateUserPage;
import com.first90.qa.pages.EnterUserDetailsPage;
import com.first90.qa.pages.SignInPage;

public class EnterUserDetailsTest extends TestBase
{
	CreateUserPage Create;
	EnterUserDetailsPage Data;
	SignInPage SignIn;
	CreateClientPage Client;
	//TestUtil testUtil;
	//String sheetName = "UserLists";


public EnterUserDetailsTest()
{
		super();
}

@BeforeMethod
public void setUp() throws InterruptedException
{
	initialization();
		 Data =new EnterUserDetailsPage();
		 Create =new CreateUserPage();  // declare at class level	 
		 SignIn =new SignInPage();
		 Client= SignIn.Login(prop.getProperty("Email"), prop.getProperty("Password"));
		 Data=	Create.clickOnUserlink();
		 Data=Create.clickOnCreateLink();

}
/*@DataProvider
public Object[][] getCRMTestData(){
	Object data[][] = TestUtil.getTestData(sheetName);
	return data;
}*/
@Test(priority=1)
	public void DetailsTest() throws Exception 
	{
	    Create.clickOnCreateLink();
	    Data.EnterUserData("Jinal","Gajjar","jinal@gmail.com","a@abc.com","1234567","1234567");
		
	}

@AfterMethod
public void tearDown()
{
	 driver.quit();
}
}
