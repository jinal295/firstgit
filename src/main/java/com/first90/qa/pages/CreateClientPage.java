package com.first90.qa.pages;

import java.time.Duration;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.first90.qa.base.TestBase;

public class CreateClientPage extends TestBase
{

@FindBy(xpath="//body/app-root[1]/admin-main[1]/main[1]/div[1]/div[1]/div[2]/admin-client-page[1]/div[1]/nav[1]/div[1]/a[2]")
WebElement Create;
@FindBy(xpath="//body/app-root[1]/admin-main[1]/main[1]/div[1]/div[1]/div[2]/admin-client-page[1]/div[1]/admin-client-update[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/admin-client-form[1]/form[1]/div[1]/div[5]/div[1]/input[1]")
WebElement Name;
@FindBy(name="tagLine")
WebElement tagLine;
@FindBy(name="signupEmail")
WebElement signupEmail;
@FindBy(xpath="//button[contains(text(),'Save client')]")
WebElement Save;
@FindBy(partialLinkText="List clien")
WebElement ListClient;
@FindBy(xpath="//body/app-root[1]/admin-main[1]/main[1]/div[1]/div[1]/div[2]/admin-client-page[1]/div[1]/admin-client-list[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/input[1]")
WebElement Search;
@FindBy(partialLinkText="View")
WebElement view;
@FindBy(linkText="Users")
WebElement CreateUser;

public CreateClientPage()
{
	PageFactory.initElements(driver,this);

}
public void EnterDetails(String name,String tagline,String SignupEmail) throws Exception 
{
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	Create.click();
	Name.sendKeys(name);
	tagLine.sendKeys(tagline);
	signupEmail.sendKeys(SignupEmail);
	Save.click();
	ListClient.click();

}
public CreateUserPage SearchClient(String name) throws InterruptedException
{
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	Search.sendKeys(name);
	Search.sendKeys(Keys.RETURN);
	view.click();
	return new CreateUserPage();
}
public void clickOnNewUsersLink() 
{
    CreateUser.click();	
	
}
}
