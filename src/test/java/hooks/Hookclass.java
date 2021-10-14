package hooks;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.After;
import cucumber.api.java.Before;

public class Hookclass {
public static WebDriver driver;
	
	@Before
	public void initialization()
	{
		System.setProperty("webdriver.chrome.driver", "D:\\chromedriver_win32\\chromedriver.exe");
	    driver = new ChromeDriver();
		driver.get("http://realty-real-estatem1.upskills.in/my-profile/");
	}

	@After
	public void closedriver()
	{
		System.out.println("The browseris closing now");
		driver.quit();
	}
	
	}