package com.first90.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.first90.qa.base.TestBase;

public class SignInPage extends TestBase
{
//PageFactory
	@FindBy(name="email")
	WebElement Email;
	
	@FindBy(name="Password")
	WebElement Pass;
	
    @FindBy(xpath="//button[contains(text(),'Go')]")
    WebElement Go;
    //Initializing the page objects
    public SignInPage()
    {
    	PageFactory.initElements(driver,this);
    }
    //Actions
    
    //heloo
    
    public CreateClientPage Login(String email,String password) throws InterruptedException
	{
		Email.sendKeys(email);
		Pass.sendKeys(password);
		Go.click();
		Thread.sleep(10000);
        return new CreateClientPage();
	}
}

