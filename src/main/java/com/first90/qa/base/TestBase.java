package com.first90.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.HasAuthentication;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.events.WebDriverListener;

import com.first90.qa.util.WebEventListeners;

public class TestBase 
{
	public static WebDriver driver;
	public static Properties prop;
	public  static EventFiringWebDriver e_driver;
	public static WebEventListeners eventListener;

	public TestBase()    //Constructor
	
	{
		try 
		{
			prop =new Properties();
			FileInputStream ip = new FileInputStream(
					System.getProperty("user.dir")+ "/src/main/java/com/first90/qa/config/config.properties");
			prop.load(ip);
			
		}catch(FileNotFoundException e)
		{
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}
		
	}
	@SuppressWarnings("deprecation")
	public static void initialization() throws InterruptedException
	{
		String  browserName = prop.getProperty("browser");
		if(browserName.equals("chrome")) 
		{
			 System.setProperty("webdriver.chrome.driver", "C:\\Users\\abc\\eclipse\\java-2022-09\\eclipse\\chromedriver_win32 (1)\\chromedriver.exe");
			 driver = new ChromeDriver();
		}
		WebDriver e_driver = new EventFiringWebDriver(driver);
		// Now create object of EventListerHandler to register it with EventFiringWebDriver
		eventListener = new WebEventListeners();
		((EventFiringWebDriver) e_driver).register(eventListener);
		driver = e_driver;
		
	     driver.manage().window().maximize();
	     driver.manage().deleteAllCookies();
	     driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	     driver.get(prop.getProperty("url"));
	     Thread.sleep(10000);
	}
}
