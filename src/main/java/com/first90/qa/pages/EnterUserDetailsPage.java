package com.first90.qa.pages;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.first90.qa.base.TestBase;

public class EnterUserDetailsPage extends TestBase 
{
	 @FindBy(name="firstName")
	 WebElement fname;
	 @FindBy(name="lastName")
	 WebElement lname;
	 @FindBy(name="email")
	 WebElement Email;
	 @FindBy(name="accessLevel")
	 WebElement Access;
	 @FindBy(name="clientId")
	 WebElement Client;
	 @FindBy(xpath="//input[@name='managerEmail']")
	 WebElement manageEmail;
	 @FindBy(name="password")
	 WebElement Pass;
	 @FindBy(xpath="//input[@name='password']")
	 WebElement CPass;
	 @FindBy(xpath="//button[contains(text(),'Save user')]")
	 WebElement Save;
		
public EnterUserDetailsPage()
{
   PageFactory.initElements(driver,this);
}

public UserListPage EnterUserData(String Fname,String Lname,String email,String ManageEmail,String pass,String cpass) throws Exception
{	
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	fname.sendKeys(Fname);
	lname.sendKeys(Lname);
	Email.sendKeys(email);
	manageEmail.sendKeys(ManageEmail);
	Select select =new Select(Access);
	select.selectByVisibleText("Client Admin");
	Select select1 =new Select(Client);
	select1.selectByVisibleText("Microblink");
	Pass.sendKeys(pass);
	CPass.sendKeys(cpass);
	Save.click();
	return new UserListPage();
}
}
