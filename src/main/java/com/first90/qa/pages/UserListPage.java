package com.first90.qa.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.first90.qa.base.TestBase;

public class UserListPage extends TestBase
{
	//@FindBy(xpath="//body/app-root[1]/admin-main[1]/main[1]/div[1]/div[1]/div[2]/admin-user-page[1]/div[1]/nav[1]/div[1]/a[1]")
	//WebElement List;
	@FindBy(xpath="//body/app-root[1]/admin-main[1]/main[1]/div[1]/div[1]/div[2]/admin-user-page[1]/div[1]/admin-user-list[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/input[1]")
	WebElement Search;
	@FindBy(xpath="//tbody/tr[6]/td[4]/button[1]")
	WebElement View;
	
	public UserListPage()
	 {
	    PageFactory.initElements(driver,this);
	 }
	/*public void ListUsersClick()
	{
		 List.click();

	}*/
	 public void SearchUser(String name) throws InterruptedException 
	 {
		 Thread.sleep(10000);
		 Search.sendKeys(name);
		 Search.sendKeys(Keys.RETURN);
		 Thread.sleep(10000);
		 View.click();
		 Thread.sleep(10000);
	 }
}
