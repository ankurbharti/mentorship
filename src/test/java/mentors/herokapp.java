package mentors;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;


public class herokapp {
	public WebDriver driver;
	
	@BeforeTest
	public void BT()
	{
		// setting up chrome driver from WDM.
				WebDriverManager.chromedriver().setup();
				// this line to open a chrome browser.
				 driver = new ChromeDriver();
				driver.manage().window().maximize();
				// i want to open URL
				//driver.get("https://opensource-demo.orangehrmlive.com/");
				driver.get("http://the-internet.herokuapp.com/");
				
	}
	@Test()
	public void servicedemo() throws InterruptedException
	{ 
		Thread.sleep(3000);
		//driver.findElement(By.linkText(href='/basic_auth').click();	
		Thread.sleep(3000);
		//driver.findElement(By.name("firstname")).sendKeys("ankur");
		Thread.sleep(3000);
		}
	
	@AfterTest
	public void AT()
	{
		driver.close();
		
    }
	

}
