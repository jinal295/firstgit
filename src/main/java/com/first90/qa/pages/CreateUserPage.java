package com.first90.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.first90.qa.base.TestBase;

public class CreateUserPage extends TestBase
{
	
@FindBy(linkText="Users")
WebElement User;
@FindBy(partialLinkText="Create a new us")
WebElement Create;
	 
		
public CreateUserPage()
{
  PageFactory.initElements(driver,this);
}
		
public EnterUserDetailsPage clickOnUserlink() throws InterruptedException
{
	User.click();
	return new EnterUserDetailsPage();

}	
public EnterUserDetailsPage clickOnCreateLink() throws InterruptedException
{
	Create.click();
	return new EnterUserDetailsPage();
}


}
	

